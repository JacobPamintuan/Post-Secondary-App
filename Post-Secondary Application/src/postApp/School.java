package postApp;

public class School {
	
	private String program;
	private String school;
	public int index;
	
	public String[] general = new String[8];
	public String[] civil = new String[4];
	public String manufacturing; 
	public String[] electrical = new String[5];
	public String areospace;
	public String[] biomedical = new String[5];
	
	
	//sets program university data
	public School(int index, String program,String school ) {
		this.index = index;
		this.school = school;
		this.program = program;
	}
	
	//sets school data
	public School(String school) {
		this.school = school;
	}
	
	public School(int index, String School) {
		
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	@Override
	public String toString() {
		return "[program=" + program + ", school=" + school + ", index=" + index + "]";
	}
	
	
}
