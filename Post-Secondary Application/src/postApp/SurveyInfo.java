package postApp;

public class SurveyInfo {
	
	String radio1;
	String radio2;
	String radio3;
	String radio4;
	String radio5;
	
	public SurveyInfo(String radio1, String radio2, String radio3, String radio4, String radio5) {
		super();
		this.radio1 = radio1;
		this.radio2 = radio2;
		this.radio3 = radio3;
		this.radio4 = radio4;
		this.radio5 = radio5;
	}

	@Override
	public String toString() {
		return "SurveyInfo [radio1=" + radio1 + ", radio2=" + radio2 + ", radio3=" + radio3 + ", radio4=" + radio4
				+ ", radio5=" + radio5 + "]";
	}

}
