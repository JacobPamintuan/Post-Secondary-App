package postApp;
//Dev Punjabi

public class CudoData {
	
	//B1
	private double p95; 
	private double p90to94; 
	private double p85to89; 
	private double p80to84; 
	private double p75o79; 

	private double p70to74; 
	private double p70under; 
	private double pOverall; 
	
	//f1a
	private double excellent;
	private double good;
	private double fair;
	private double poor;
	
	//f1b
	private double defYes;
	private double proYes;
	private double proNo;
	private double defNo;
	
	private double index;
	private String university;
	
	
	//Constructor to set data for b3
	public CudoData(String university,double p95, double p90to94, double p85to89, double p80to84, double p75o79, double p70to74, double p70under, double pOverall) {
		this.p95 = p95;
		this.p90to94 = p90to94;
		this.p85to89 = p85to89;
		this.p80to84 = p80to84;
		this.p75o79 = p75o79;
		this.p70to74 = p70to74;
		this.p70under = p70under;
		this.pOverall = pOverall;
		this.university = university;
	}
	
	//Constructor to set data for f1a
	public CudoData(String university, double defYes, double proYes, double proNo, double defNo, double index) {
		this.defYes = defYes;
		this.proYes = proYes;
		this.proNo = proNo;
		this.defNo = defNo;
		this.university = university;
		this.index = index;
	}
	
	//Constructor to set data for f1b
	public CudoData(String university, double excellent, double good, double fair, double poor) {
		this.excellent = excellent;
		this.good = good;
		this.fair = fair;
		this.poor = poor;
		this.university = university;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	//Getters and setters
	public double getP95() {
		return p95;
	}

	public void setP95(double p95) {
		this.p95 = p95;
	}
	
	public double getIndex() {
		return index;
	}

	public void setIndex(double index) {
		this.index = index;
	}

	public double getP90to94() {
		return p90to94;
	}

	public void setP90to94(double p90to94) {
		this.p90to94 = p90to94;
	}

	public double getP85to89() {
		return p85to89;
	}

	public void setP85to89(double p85to89) {
		this.p85to89 = p85to89;
	}

	public double getP80to84() {
		return p80to84;
	}

	public void setP80to84(double p80to84) {
		this.p80to84 = p80to84;
	}

	public double getP75o79() {
		return p75o79;
	}

	public void setP75o79(double p75o79) {
		this.p75o79 = p75o79;
	}

	public double getP70to74() {
		return p70to74;
	}

	public void setP70to74(double p70to74) {
		this.p70to74 = p70to74;
	}

	public double getP70under() {
		return p70under;
	}

	public void setP70under(double p70under) {
		this.p70under = p70under;
	}

	public double getpOverall() {
		return pOverall;
	}

	public void setpOverall(double pOverall) {
		this.pOverall = pOverall;
	}

	public double getExcellent() {
		return excellent;
	}

	public void setExcellent(double excellent) {
		this.excellent = excellent;
	}

	public double getGood() {
		return good;
	}

	public void setGood(double good) {
		this.good = good;
	}

	public double getFair() {
		return fair;
	}

	public void setFair(double fair) {
		this.fair = fair;
	}

	public double getPoor() {
		return poor;
	}

	public void setPoor(double poor) {
		this.poor = poor;
	}

	public double getDefYes() {
		return defYes;
	}

	public void setDefYes(double defYes) {
		this.defYes = defYes;
	}

	public double getProYes() {
		return proYes;
	}

	public void setProYes(double proYes) {
		this.proYes = proYes;
	}

	public double getProNo() {
		return proNo;
	}

	public void setProNo(double proNo) {
		this.proNo = proNo;
	}

	public double getDefNo() {
		return defNo;
	}

	public void setDefNo(double defNo) {
		this.defNo = defNo;
	}

	@Override
	public String toString() {
		return "CudoData [p95=" + p95 + ", p90to94=" + p90to94 + ", p85to89=" + p85to89 + ", p80to84=" + p80to84
				+ ", p75o79=" + p75o79 + ", p70to74=" + p70to74 + ", p70under=" + p70under + ", pOverall=" + pOverall
				+ ", excellent=" + excellent + ", good=" + good + ", fair=" + fair + ", poor=" + poor + ", defYes="
				+ defYes + ", proYes=" + proYes + ", proNo=" + proNo + ", defNo=" + defNo + ", index=" + index
				+ ", university=" + university + "]";
	}
	
	
}
