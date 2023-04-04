import java.util.ArrayList;
import java.util.List;

/**
 * peroid information
 */
public class Period {
	private Integer id; //presentation ID
	private Integer index;//peroid number Index
	private String periodName;
	private String classRoom;//class room
	private Presentation presentations;//name of the presentation
	private ArrayList<Integer> sids=new ArrayList<Integer>();//student already assigned in the presentation

	public Period() {
	}

	public Period(Integer id, Integer index, String periodName, String classRoom, Presentation presentations, ArrayList<Integer> sids) {  //constructor
		this.id = id;
		this.index = index;
		this.periodName = periodName;
		this.classRoom = classRoom;
		this.presentations = presentations;
		this.sids = sids;
	}//close constructor

	public Integer getId() { //method
		return id;
	}//close method

	public void setId(Integer id) { //method
		this.id = id;
	}//close method

	public Integer getIndex() { //method
		return index;
	}//close method

	public void setIndex(Integer index) { //method
		this.index = index;
	}//close method

	public String getPeriodName() { //method
		return periodName;
	}//close method

	public void setPeriodName(String periodName) { //method
		this.periodName = periodName;
	}//close method

	public String getClassRoom() { //method
		return classRoom;
	}//close method

	public void setClassRoom(String classRoom) { //method
		this.classRoom = classRoom;
	}//close method

	public Presentation getPresentations() { //method
		return presentations;
	}//close method

	public void setPresentations(Presentation presentations) { //method
		this.presentations = presentations;
	}//close method

	public ArrayList<Integer> getSids() { //method
		return sids;
	}//close method

	public void setSids(ArrayList<Integer> sids) { //method
		this.sids = sids;
	}//close method
}//close class
