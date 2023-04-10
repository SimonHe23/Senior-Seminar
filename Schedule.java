import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Schedule
 */
public class Schedule {
    private ArrayList<Presentation> presentations = new ArrayList<Presentation>();// presentation array list
    private ArrayList<Student> students = new ArrayList<Student>();// student array list
    private ArrayList<Period> periods = new ArrayList<Period>();// presentation information (assigned)
    private ArrayList<Integer> dispatchs = null;// each peroid assigned student

    //read presentation csv file
    public ArrayList<Presentation> readPresentationCSV() {//method for read presentation file
        try {
            String csvFile = "/Users/shengzehe/Desktop/demo9/Presenter.csv";
            Presentation presentation = null;
            File file = new File(csvFile);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                // Use comma separator to split lines
                String[] values = s.split(",");
                presentation = new Presentation();
                //add variable into arraylist
                presentation.setName(values[0]);
                presentation.setId(Integer.valueOf(values[1]));
                presentation.setDescription(values[2]);
                presentations.add(presentation);
                // Iterate through the array to print each value
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("an error occurred");
            e.printStackTrace();
        }

        return presentations;
    }//close method

    /**
     * read the student csv file
     *
     * @return
     */
    private ArrayList<Student> readStudentCSV() {//method for read student file
        try {
            String csvFile = "/Users/shengzehe/Desktop/demo9/SrSeminar_RawData.csv";
            File file = new File(csvFile);
            Scanner scanner = new Scanner(file);
            int n = 0;
            while (scanner.hasNextLine()) {
                //do not read the first line
                if (n == 0) {
                    n++;
                    continue;
                } else {
                    String line = scanner.nextLine();
                    // Use comma separator to split lines
                    String[] values = line.split(",");
                    Student student = new Student();
					//add variable into arraylist
                    ArrayList<Integer> preferences = student.getPreferences();
                    student.setId(n);
                    student.setName(values[0]);
                    preferences.add(Integer.valueOf(values[1]));
                    preferences.add(Integer.valueOf(values[2]));
                    preferences.add(Integer.valueOf(values[3]));
                    preferences.add(Integer.valueOf(values[4]));
                    preferences.add(Integer.valueOf(values[5]));
                    students.add(student);
                    n++;
                }

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("an error occurred");
            e.printStackTrace();
        }
        return students;
    }//close method

    // Count all students' favor and rank them in order of the most popular presentation topics
    public void countAndSort(ArrayList<Presentation> ps, ArrayList<Student> ss) { //method for
        for (Presentation presentation : ps) { //for each loop
            presentation.setCount(0);//everytime(for the 17 presentations), the count of the presentation count should be set to 0 and then go to next presentation
            presentation.setSids(new ArrayList<Integer>());
            for (Student student : ss) {//for each loop
                if (student.getPreferences().contains(presentation.getId())) { //if student's preference is match with the presentation ID
                    Integer count = presentation.getCount(); //presentation's count is adding up
                    count++;
                    presentation.setCount(count);
                    ArrayList<Integer> sids = presentation.getSids();
                    sids.add(student.getId());
                }//close if
            }//close for each loop
        }// close for each loop
        
        // Bubble sort, sort the presentation respect to count
        int n = ps.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Presentation p1 = ps.get(j);
                Presentation p2 = ps.get(j + 1);
                if (p1.getCount() < p2.getCount()) {
                    // swap between two element that near each other
                    ps.set(j, p2);
                    ps.set(j + 1, p1);
                }
            }
        }
    }


    public boolean doDispatch(ArrayList<Presentation> ps, ArrayList<Student> ss, ArrayList<Presentation> newPs,
                                     ArrayList<Student> newSs, int i, int j) {
        Presentation presentation = null;
        int current = 0;
        //this for loop only run once
        for (int n = 0; n < ps.size(); n++) {// Fetch the n th arrangement
            presentation = ps.get(n);
            if (presentation.getPeriods().size() < 2) {// Check each speech no more than twice
                Period period = new Period();
                period.setId(periods.size());
                period.setIndex(i);
                period.setPeriodName("Period" + (i + 1));
                period.setClassRoom("ClassRoom" + (j + 1));
                period.setPresentations(presentation);
                periods.add(period);
                presentation.getPeriods().add(period.getId());
                //Save unscheduled presentations
                for (int a = 0; a < ps.size(); a++) {
                    if (a != n) {
                        newPs.add(ps.get(a));// Remaining unscheduled presentations
                    }
                }

                // Assign class time to students who enjoy the presentation.5 preference
                for (int m = 0; m < 5; m++) {
                    // Assigned according to preference weighting
                    for (Student student : ss) {
                        // Students not scheduled for the current presentation period
                        if (current >= 16) {
                            // Maximum 16 people per classroom
                            break;
                        }
                        // Break whether the student has already participated in the presentation. Students cannot repeat a presentation
                        if (!student.getPeriodIds().contains(i) && !student.getPresentationIds().contains(presentation.getId())) {
                            if (student.getPreferences().get(m) == presentation.getId() && student.getPresentationIds().size() < 5) {
                                student.getPresentationIds().add(presentation.getId());
                                student.getPeriodIds().add(i);
                                student.getPeriods().add(period);
                                period.getSids().add(student.getId());
                                dispatchs.add(student.getId());
                                current++;
                            }
                        }
                    }
                }
                for (Student student : ss) {// Students not scheduled for the current class period
                    if (!dispatchs.contains(student.getId())) {
                        newSs.add(student);
                    }
                }
                //One arrangement only
                return true;// The classroom is scheduled for that session, then return to true
            }
        }
        return false;
    }

    public void dispatch() {
        ArrayList<Presentation> oldPs = null;// Store the lecture before the current class assignment
        ArrayList<Student> oldSs = null;// Store the students before the current lesson allocation


        ArrayList<Presentation> newPs = null;// Store unassigned lectures for the current class period
        ArrayList<Student> newSs = null;// Store students who are not assigned to the current class period


        for (int i = 0; i < 5; i++) {// 5 hours in total, according to the current optimal allocation
            newPs = presentations;
            newSs = students;// Ensure that every student is placed on a daily basis
            dispatchs = new ArrayList<Integer>();// Students already placed in the lesson time slot
            for (int j = 0; j < 5; j++) {// 5 classrooms [for the first session, in the first classroom, the lecture with the most preferences is arranged, in the second classroom, the session with the most preferences of the remaining students is arranged, and so on]
                if (newPs == null) {
                    oldPs = presentations;
                } else {
                    oldPs = newPs;
                }
                oldSs = newSs;
                newPs = new ArrayList<Presentation>();
                newSs = new ArrayList<Student>();
                countAndSort(oldPs, oldSs);
                // Count all students' hobbies and rank them in order of most popular presentation topics
                doDispatch(oldPs, oldSs, newPs, newSs, i, j);
            }
            System.out.println("time slot" + i + "--number of student who do not get assigned：" + newSs.size());
            // Not assigning students who are not assigned to that class period according to preference
            for (Student student : newSs) {
                for (Period period : periods) {
                    if (period.getIndex() == i && period.getSids().size() < 16
                            && !student.getPresentationIds().contains(period.getPresentations().getId())) {
                        student.getPresentationIds().add(period.getPresentations().getId());
                        student.getPeriodIds().add(i);
                        student.getPeriods().add(period);
                        period.getSids().add(student.getId());
                        break;
                    }
                }
            }
        }
    }

    private void saveCSV() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Period Name,ClassRoom,Presentation,Presentation ID,Presentation Description");
        for (Period period : periods) {
            System.out.println(period.getPeriodName() + "," + period.getClassRoom() + "," + period.getPresentations().getName() + ","
                    + period.getPresentations().getId() + "," + period.getPresentations().getDescription());
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Student Name,Times,Period Name,ClassRoom,Presentation,Presentation ID,Presentation Description");

        for (Student student : students) {
            for (Period period : student.getPeriods()) {
                System.out.println(student.getName() + "," + student.getPeriods().size() + "," + period.getPeriodName() + ","
                        + period.getClassRoom() + "," + period.getPresentations().getName() + "," + period.getPresentations().getId() + ","
                        + period.getPresentations().getDescription());
            }
        }
    }

    public static void main(String[] args) {// entrance of the program
        // Retrieve the presentation topic data
        System.out.println("Hi, welcome to the Sr program, This program will help you assign the student's schedule to the presentation based on their preference.");
        System.out.println();
        System.out.println();
        System.out.println();
        
        try {
			
			
			Schedule sh=new Schedule();    
			System.out.println("Start reading data on the topic of the presentation...");
            sh.presentations = sh.readPresentationCSV();
           
            System.out.println("Start reading student information...");
            sh.students = sh.readStudentCSV();
            System.out.println("Distribution of presentations...");
            sh.dispatch();
            System.out.println("Save file...");
            sh.saveCSV();
            System.out.println("End of processing...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  }
 
