//Dev Punjabi

package postApp;

public class CudoData {
	
	//B1
	private int p95; 
	private int p90to94; 
	private int p85to89; 
	private int p80to84; 
	private int p75o79; 

	private int p70to74; 
	private int p70under; 
	private int pOverall; 
	
	//f1a
	private int excellent;
	private int good;
	private int fair;
	private int poor;
	
	//f1b
	private int defYes;
	private int proYes;
	private int proNo;
	private int defNo;
	
	private int index;
	private String university;
	
	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}
	
	//Constructor to set data for b3
	public CudoData(String university,int p95, int p90to94, int p85to89, int p80to84, int p75o79, int p70to74, int p70under, int pOverall) {
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
	public CudoData(String university, int defYes, int proYes, int proNo, int defNo, int index) {
		this.defYes = defYes;
		this.proYes = proYes;
		this.proNo = proNo;
		this.defNo = defNo;
		this.university = university;
		this.index = index;
	}
	
	//Constructor to set data for f1b
	public CudoData(String university, int excellent, int good, int fair, int poor) {
		this.excellent = excellent;
		this.good = good;
		this.fair = fair;
		this.poor = poor;
		this.university = university;
	}
	
	//Getters and setters
	public int getP95() {
		return p95;
	}

	public void setP95(int p95) {
		this.p95 = p95;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getP90to94() {
		return p90to94;
	}

	public void setP90to94(int p90to94) {
		this.p90to94 = p90to94;
	}

	public int getP85to89() {
		return p85to89;
	}

	public void setP85to89(int p85to89) {
		this.p85to89 = p85to89;
	}

	public int getP80to84() {
		return p80to84;
	}

	public void setP80to84(int p80to84) {
		this.p80to84 = p80to84;
	}

	public int getP75o79() {
		return p75o79;
	}

	public void setP75o79(int p75o79) {
		this.p75o79 = p75o79;
	}

	public int getP70to74() {
		return p70to74;
	}

	public void setP70to74(int p70to74) {
		this.p70to74 = p70to74;
	}

	public int getP70under() {
		return p70under;
	}

	public void setP70under(int p70under) {
		this.p70under = p70under;
	}

	public int getpOverall() {
		return pOverall;
	}

	public void setpOverall(int pOverall) {
		this.pOverall = pOverall;
	}

	public int getExcellent() {
		return excellent;
	}

	public void setExcellent(int excellent) {
		this.excellent = excellent;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public int getFair() {
		return fair;
	}

	public void setFair(int fair) {
		this.fair = fair;
	}

	public int getPoor() {
		return poor;
	}

	public void setPoor(int poor) {
		this.poor = poor;
	}

	public int getDefYes() {
		return defYes;
	}

	public void setDefYes(int defYes) {
		this.defYes = defYes;
	}

	public int getProYes() {
		return proYes;
	}

	public void setProYes(int proYes) {
		this.proYes = proYes;
	}

	public int getProNo() {
		return proNo;
	}

	public void setProNo(int proNo) {
		this.proNo = proNo;
	}

	public int getDefNo() {
		return defNo;
	}

	public void setDefNo(int defNo) {
		this.defNo = defNo;
	}
}
