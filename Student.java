import java.util.ArrayList;
import java.util.List;

/**
 * student information
 *
 */
public class Student {
	private Integer id;
	private String name;// student name
	private ArrayList<Integer> presentationIds = new ArrayList<Integer>();// Students are not allowed to repeat a presentation if they have already participated in the presentation ID
	private ArrayList<Integer> periodIds = new ArrayList<Integer>();// Presentation ID for student participation
	private ArrayList<Period> periods = new ArrayList<Period>();// session presentation that student enter
	private ArrayList<Integer> preferences = new ArrayList<Integer>();// preference ID

	public Student() {
	}

	public Student(Integer id, String name, ArrayList<Integer> presentationIds, ArrayList<Integer> periodIds, ArrayList<Period> periods, ArrayList<Integer> preferences) {
		this.id = id;
		this.name = name;
		this.presentationIds = presentationIds;
		this.periodIds = periodIds;
		this.periods = periods;
		this.preferences = preferences;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Integer> getPresentationIds() {
		return presentationIds;
	}

	public void setPresentationIds(ArrayList<Integer> presentationIds) {
		this.presentationIds = presentationIds;
	}

	public ArrayList<Integer> getPeriodIds() {
		return periodIds;
	}

	public void setPeriodIds(ArrayList<Integer> periodIds) {
		this.periodIds = periodIds;
	}

	public ArrayList<Period> getPeriods() {
		return periods;
	}

	public void setPeriods(ArrayList<Period> periods) {
		this.periods = periods;
	}

	public ArrayList<Integer> getPreferences() {
		return preferences;
	}

	public void setPreferences(ArrayList<Integer> preferences) {
		this.preferences = preferences;
	}
}
