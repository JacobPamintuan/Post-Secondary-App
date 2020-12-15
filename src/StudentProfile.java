import java.util.ArrayList;
import java.util.Arrays;

public class StudentProfile {
	
	private String Mark[]= new String[6];
	private String CourseCode[]= new String[6];
	private Boolean EarlyAcceptance;
	private ArrayList<String> ExtracurricularActionType= new ArrayList<String>();
	private ArrayList<String> ExtracurricularDescription= new ArrayList<String>();
	private ArrayList<String> ExtracurricularStarDate= new ArrayList<String>();
	private ArrayList<String> ExtracurricularEndDate= new ArrayList<String>();
	private Boolean Citzenship;
	private Boolean Coop;
	private Boolean volunteer;
	private ArrayList<String> AwardActionType= new ArrayList<String>();
	private ArrayList<String> AwardDescription= new ArrayList<String>();
	private ArrayList<String> AwardDate= new ArrayList<String>();
	
	public StudentProfile(String[] mark, String[] courseCode, Boolean earlyAcceptance,
			ArrayList<String> extracurricularActionType, ArrayList<String> extracurricularDescription,
			ArrayList<String> extracurricularStarDate, ArrayList<String> extracurricularEndDate, Boolean citzenship,
			Boolean coop, Boolean volunteer, ArrayList<String> awardActionType, ArrayList<String> awardDescription,
			ArrayList<String> awardDate) {
		super();
		Mark = mark;
		CourseCode = courseCode;
		EarlyAcceptance = earlyAcceptance;
		ExtracurricularActionType = extracurricularActionType;
		ExtracurricularDescription = extracurricularDescription;
		ExtracurricularStarDate = extracurricularStarDate;
		ExtracurricularEndDate = extracurricularEndDate;
		Citzenship = citzenship;
		Coop = coop;
		this.volunteer = volunteer;
		AwardActionType = awardActionType;
		AwardDescription = awardDescription;
		AwardDate = awardDate;
		
	}

	public String[] getMark() {
		return Mark;
	}

	public void setMark(String[] mark) {
		Mark = mark;
	}

	public String[] getCourseCode() {
		return CourseCode;
	}

	public void setCourseCode(String[] courseCode) {
		CourseCode = courseCode;
	}

	public Boolean getEarlyAcceptance() {
		return EarlyAcceptance;
	}

	public void setEarlyAcceptance(Boolean earlyAcceptance) {
		EarlyAcceptance = earlyAcceptance;
	}

	public ArrayList<String> getExtracurricularActionType() {
		return ExtracurricularActionType;
	}

	public void setExtracurricularActionType(ArrayList<String> extracurricularActionType) {
		ExtracurricularActionType = extracurricularActionType;
	}

	public ArrayList<String> getExtracurricularDescription() {
		return ExtracurricularDescription;
	}

	public void setExtracurricularDescription(ArrayList<String> extracurricularDescription) {
		ExtracurricularDescription = extracurricularDescription;
	}

	public ArrayList<String> getExtracurricularStarDate() {
		return ExtracurricularStarDate;
	}

	public void setExtracurricularStarDate(ArrayList<String> extracurricularStarDate) {
		ExtracurricularStarDate = extracurricularStarDate;
	}

	public ArrayList<String> getExtracurricularEndDate() {
		return ExtracurricularEndDate;
	}

	public void setExtracurricularEndDate(ArrayList<String> extracurricularEndDate) {
		ExtracurricularEndDate = extracurricularEndDate;
	}

	public Boolean getCitzenship() {
		return Citzenship;
	}

	public void setCitzenship(Boolean citzenship) {
		Citzenship = citzenship;
	}

	public Boolean getCoop() {
		return Coop;
	}

	public void setCoop(Boolean coop) {
		Coop = coop;
	}

	public Boolean getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(Boolean volunteer) {
		this.volunteer = volunteer;
	}

	public ArrayList<String> getAwardActionType() {
		return AwardActionType;
	}

	public void setAwardActionType(ArrayList<String> awardActionType) {
		AwardActionType = awardActionType;
	}

	public ArrayList<String> getAwardDescription() {
		return AwardDescription;
	}

	public void setAwardDescription(ArrayList<String> awardDescription) {
		AwardDescription = awardDescription;
	}

	public ArrayList<String> getAwardDate() {
		return AwardDate;
	}

	public void setAwardDate(ArrayList<String> awardDate) {
		AwardDate = awardDate;
	}

	@Override
	public String toString() {
		return "StudentProfile [Mark=" + Arrays.toString(Mark) + ", CourseCode=" + Arrays.toString(CourseCode)
				+ ", EarlyAcceptance=" + EarlyAcceptance + ", ExtracurricularActionType=" + ExtracurricularActionType
				+ ", ExtracurricularDescription=" + ExtracurricularDescription + ", ExtracurricularStarDate="
				+ ExtracurricularStarDate + ", ExtracurricularEndDate=" + ExtracurricularEndDate + ", Citzenship="
				+ Citzenship + ", Coop=" + Coop + ", volunteer=" + volunteer + ", AwardActionType=" + AwardActionType
				+ ", AwardDescription=" + AwardDescription + ", AwardDate=" + AwardDate + "]";
	}
	
	public double CourseAverage() {
		
		int sum=0;
		
		for(int x=0;x<6;x++)
			sum=sum+Integer.parseInt(Mark[x]);
			
		return sum/6;
		
		
	}

}
