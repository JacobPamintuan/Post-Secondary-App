package postApp;

import javax.swing.ImageIcon;

public class UniversityWeights {

	private String name;
	private int cost;
	private int coop;
	private int gradRev;
	private int size;
	private int campus;
	private int distance;
	private int EC;
	private int avg;
	private ImageIcon image;

	public int compatability=0;

	public UniversityWeights(String name, int cost, int coop, int gradRev, int size, int campus, int distance, int EC,int avg) {
		this.name=name;
		this.cost = cost;
		this.coop = coop;
		this.gradRev = gradRev;
		this.size = size;
		this.campus = campus;
		this.distance = distance;
		this.EC = EC;
		this.avg=avg;
	}

	public void calculateCompatability(int weights[], int average) {
		 compatability = weights[0] * cost + weights[1] * coop + weights[2] * gradRev + weights[3] * size + weights[4] * campus+ weights[5] * distance + weights[6] * EC + (average - avg) * 9;
		
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getCoop() {
		return coop;
	}

	public void setCoop(int coop) {
		this.coop = coop;
	}

	public int getGradRev() {
		return gradRev;
	}

	public void setGradRev(int gradRev) {
		this.gradRev = gradRev;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCampus() {
		return campus;
	}

	public void setCampus(int campus) {
		this.campus = campus;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getEC() {
		return EC;
	}

	public void setEC(int EC) {
		this.EC = EC;
	}
	
	public int getCompatability() {
		return compatability;
	}

	public void setCompatability(int compatability) {
		this.compatability = compatability;
	}

	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

}
