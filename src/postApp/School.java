package postApp;

public class School {
	
	private String program;
	private String school;
	public int index;
	
	public School(int index, String program,String school ) {
		this.index = index;
		this.school = school;
		this.program = program;
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
