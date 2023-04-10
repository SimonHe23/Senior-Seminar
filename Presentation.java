import java.util.ArrayList;
import java.util.List;

/**
 * presentation management
 */
public class Presentation {//class
	private Integer id;//presentation ID
	private String name;// presentation name
	private String description;// the description on the presentation 
	private ArrayList<Integer> periods = new ArrayList<Integer>();// Scheduled presentation
	private ArrayList<Integer> sids = new ArrayList<Integer>();// An array of student IDs who prefer this presentation
	private Integer count = 0;// Statistics on the number of student hobbies

	public Presentation() {
	}

	public Presentation(Integer id, String name, String description, ArrayList<Integer> periods, ArrayList<Integer> sids, Integer count) { //constructor
		this.id = id;
		this.name = name;
		this.description = description;
		this.periods = periods;
		this.sids = sids;
		this.count = count;
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

	public String getDescription() {//method
		return description;
	}//close method

	public void setDescription(String description) {//method
		this.description = description;
	}//close method

	public ArrayList<Integer> getPeriods() {//method
		return periods;
	}//close method

	public void setPeriods(ArrayList<Integer> periods) {//method
		this.periods = periods;
	}//close method

	public ArrayList<Integer> getSids() {//method
		return sids;
	}//close method

	public void setSids(ArrayList<Integer> sids) {//method
		this.sids = sids;
	}//close method

	public Integer getCount() {//method
		return count;
	}//close method

	public void setCount(Integer count) {
		this.count = count;
	}//close method
}//class
