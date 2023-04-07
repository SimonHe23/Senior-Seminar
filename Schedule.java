import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Schedule
 * The main program is here
 */
public class Schedule {//class
    private ArrayList<Presentation> presentations = new ArrayList<Presentation>();// presentation array list
    private ArrayList<Student> students = new ArrayList<Student>();// student array list
    private ArrayList<Period> periods = new ArrayList<Period>();// presentation information (assigned)
    private ArrayList<Integer> dispatchs = null;// each peroid assigned student

    //read presentation csv file
    public ArrayList<Presentation> readPresentationCSV(){
        try {
            String csvFile = "/Users/shengzehe/Desktop/demo9/Presenter.csv";
            Presentation presentation = null;
            File file = new File(csvFile);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                // Use comma to split lines
                String[] values = s.split(",");
                presentation = new Presentation();
                //define variable and strore them
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
    }

    /**
     * read the student csv file
     *
     * @return
     */
    private ArrayList<Student> readStudentCSV() { 
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
                    // Use comma to split lines
                    String[] values = line.split(",");
                    Student student = new Student();
					//store
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
    }
    
    public void countAndSort(ArrayList<Presentation> ps, ArrayList<Student> ss){ //here is to sort student's preference and I will use bubble sort here
		//will continue because I was sick on April 6.
		
	}
    
}//close class
