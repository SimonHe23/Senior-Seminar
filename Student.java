import java.util.ArrayList;
import java.util.List;

/**
 * student information
 *
 */
public class Student {//class
	private Integer id;
	private String name;// student name
	private ArrayList<Integer> presentationIds = new ArrayList<Integer>();// Students are not allowed to repeat a presentation if they have already participated in the presentation ID
	private ArrayList<Integer> periodIds = new ArrayList<Integer>();// Presentation ID for student participation
	private ArrayList<Period> periods = new ArrayList<Period>();// session presentation that student enter
	private ArrayList<Integer> preferences = new ArrayList<Integer>();// preference ID

	public Student() {
	}

	public Student(Integer id, String name, ArrayList<Integer> presentationIds, ArrayList<Integer> periodIds, ArrayList<Period> periods, ArrayList<Integer> preferences) {//constructor
		this.id = id;
		this.name = name;
		this.presentationIds = presentationIds;
		this.periodIds = periodIds;
		this.periods = periods;
		this.preferences = preferences;
	}//close constructor

	public Integer getId() {//method
		return id;
	}//close method

	public void setId(Integer id) {//method
		this.id = id;
	}//close method

	public String getName() {//method
		return name;
	}//close method

	public void setName(String name) {//method
		this.name = name;
	}//close method

	public ArrayList<Integer> getPresentationIds() {//method
		return presentationIds;
	}//close method

	public void setPresentationIds(ArrayList<Integer> presentationIds) {//method
		this.presentationIds = presentationIds;
	}//close method

	public ArrayList<Integer> getPeriodIds() {//method
		return periodIds;
	}//close method

	public void setPeriodIds(ArrayList<Integer> periodIds) {//method
		this.periodIds = periodIds;
	}//close method

	public ArrayList<Period> getPeriods() {//method
		return periods;
	}//close method

	public void setPeriods(ArrayList<Period> periods) {//method
		this.periods = periods;
	}//close method

	public ArrayList<Integer> getPreferences() {//method
		return preferences;
	}//close method

	public void setPreferences(ArrayList<Integer> preferences) {//method
		this.preferences = preferences;
	}//close method
}//close class
