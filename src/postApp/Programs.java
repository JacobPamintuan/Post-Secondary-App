package postApp;

public class Programs {
	
	String school;
	String program;
	int schoolID;
	int programID;
	String link;
	
	
	public Programs(String school, String program, int schoolID, int programID, String link) {
		super();
		this.school = school;
		this.program = program;
		this.schoolID = schoolID;
		this.programID = programID;
		this.link = link;
	}
	
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public int getSchoolID() {
		return schoolID;
	}
	public void setSchoolID(int schoolID) {
		this.schoolID = schoolID;
	}
	public int getProgramID() {
		return programID;
	}
	public void setProgramID(int programID) {
		this.programID = programID;
	}
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Programs [school=" + school + ", program=" + program + ", schoolID=" + schoolID + ", programID="
				+ programID + ", link=" + link + "]";
	}

	
	
	
	
	

}
