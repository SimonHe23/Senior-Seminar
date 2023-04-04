import java.util.ArrayList;
import java.util.List;

/**
 * presentation management
 */
public class Presentation {
	private Integer id;//presentation ID
	private String name;// presentation name
	private String description;// the description on the presentation 
	private ArrayList<Integer> periods = new ArrayList<Integer>();// Scheduled presentation
	private ArrayList<Integer> sids = new ArrayList<Integer>();// An array of student IDs who prefer this presentation
	private Integer count = 0;// Statistics on the number of student hobbies

	public Presentation() {
	}

	public Presentation(Integer id, String name, String description, ArrayList<Integer> periods, ArrayList<Integer> sids, Integer count) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.periods = periods;
		this.sids = sids;
		this.count = count;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Integer> getPeriods() {
		return periods;
	}

	public void setPeriods(ArrayList<Integer> periods) {
		this.periods = periods;
	}

	public ArrayList<Integer> getSids() {
		return sids;
	}

	public void setSids(ArrayList<Integer> sids) {
		this.sids = sids;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
