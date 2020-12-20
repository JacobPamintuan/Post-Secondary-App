package postApp;

import java.util.*;

public class School {
	
	int id;
	String School;
	ArrayList<String> programs;
	ArrayList<String> programLinks;
	
	
	public School(int id, String school) {
		super();
		this.id = id;
		School = school;
		programs=new ArrayList<String>();
		programLinks=new ArrayList<String>();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSchool() {
		return School;
	}
	public void setSchool(String school) {
		School = school;
	}
	public ArrayList<String> getPrograms() {
		return programs;
	}
	public void setPrograms(ArrayList<String> programs) {
		this.programs = programs;
	}
	

	public ArrayList<String> getProgramLinks() {
		return programLinks;
	}


	public void setProgramLinks(ArrayList<String> programLinks) {
		this.programLinks = programLinks;
	}


	@Override
	public String toString() {
		return "School [id=" + id + ", School=" + School + ", programs=" + programs + ", programLinks=" + programLinks
				+ "]";
	}

	
	
	
	
	

}
