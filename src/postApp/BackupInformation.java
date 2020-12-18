package postApp;

import java.util.ArrayList;

public class BackupInformation {
	
	private String searchResults;
	public String[][] programList = new String[28][9];
	private String results;
	
	private int index;
	private int numSchools;
	
	public ArrayList<String> programs = new ArrayList<String>();

	public BackupInformation(String searchResults) {
		super();
		this.searchResults = searchResults;
		setUpBackupSearch();
	}
	
	private void setUpBackupSearch() {

		programs.add("General Engineering");
		programs.add("Civil Engineering");
		programs.add("Manufacturing Engineering");
		programs.add("Electrical Engineering");
		programs.add("Aerospace Engineering");
		programs.add("Biomedical Engineering");
		programs.add("Mechanical Engineering");
		programs.add("Nuclear Engineering");
		programs.add("Automotive Engineering");
		programs.add("Computer Engineering");
		programs.add("Environmental Engineering");
		programs.add("Water Resources Engineering");
		programs.add("Engineering Systems and Computing");
		programs.add("Biological Engineering");
		programs.add("Chemical Engineering");
		programs.add("Mining Engineering");
		programs.add("Software Engineering");
		programs.add("Architectural Engineering");
		programs.add("Geological Engineering");
		programs.add("Management Engineering");
		programs.add("Mechatronics Engineering");
		programs.add("Nanotechnology Engineering");
		programs.add("Systems Design Engineering");
		programs.add("Industrial Engineering");
		programs.add("Materials Engineerin");
		programs.add("Aerospace Engineering");
		programs.add("Engineering Science");
		
		int x = 0;
		
		//General Engineering
		programList[x][1] = "Lakehead University";
		programList[x][2] = "Laurentian University";
		programList[x][3] = "McMaster University";
		programList[x][4] = "Ontario Tech University";
		programList[x][5] = "Queen's University";
		programList[x][6] = "Western University";
		programList[x][7] = "York University";
		programList[x][8] = "University of Windsor";
		x++;
		
		//Civil Engineering
		programList[x][1] = "University of Ottawa";
		programList[x][2] = "Ryerson University";
		programList[x][3] = "University of Waterloo";
		programList[x][4] = "University of Windsor";
		programList[x][5] = "University of Toronto";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//Manufacturing Engineering
		programList[x][1] = "Ontario Tech University";
		programList[x][2] = "";
		programList[x][3] = "";
		programList[x][4] = "";
		programList[x][5] = "";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//Electrical Engineering
		programList[x][1] = "Ontario Tech University";
		programList[x][2] = "University of Ottawa";
		programList[x][3] = "Ryerson University";
		programList[x][4] = "University of Waterloo";
		programList[x][5] = "University of Windsor";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//Aerospace Engineering
		programList[x][1] = "Ryerson University";
		programList[x][2] = "";
		programList[x][3] = "";
		programList[x][4] = "";
		programList[x][5] = "";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//BioMedical Engineering
		programList[x][1] = "University of Guelph";
		programList[x][2] = "University of Ottawa";
		programList[x][3] = "Ryerson University";
		programList[x][4] = "University of Waterloo";;
		programList[x][5] = "";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//Mechanical Engineering
		programList[x][1] = "Algoma University";
		programList[x][2] = "University of Guelph";
		programList[x][3] = "University of Toronto";
		programList[x][4] = "Laurentian University";
		programList[x][5] = "Ontario Tech University";
		programList[x][6] = "University of Ottawa";
		programList[x][7] = "Ryerson University";
		programList[x][8] = "University of Waterloo";
		x++;
		
		//Nuclear Engineering
		programList[x][1] = "Ontario Tech University";
		programList[x][2] = "";
		programList[x][3] = "";
		programList[x][4] = "";
		programList[x][5] = "";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//Automotive Engineering
		programList[x][1] = "Ontario Tech University";
		programList[x][2] = "";
		programList[x][3] = "";
		programList[x][4] = "";
		programList[x][5] = "";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//Computer Engineering
		programList[x][1] = "University of Guelph";
		programList[x][2] = "University of Ottawa";
		programList[x][3] = "Ryerson University";
		programList[x][4] = "University of Waterloo";
		programList[x][5] = "University of Toront";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//Environmental Engineering
		programList[x][1] = "University of Guelph";
		programList[x][2] = "University of Waterloo";
		programList[x][3] = "University of Windsor";
		programList[x][4] = "";
		programList[x][5] = "";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//Water Resources Engineering
		programList[x][1] = "University of Guelp";
		programList[x][2] = "";
		programList[x][3] = "";
		programList[x][4] = "";
		programList[x][5] = "";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//Engineering Systems and Computing
		programList[x][1] = "University of Guelph";
		programList[x][2] = "";
		programList[x][3] = "";
		programList[x][4] = "";
		programList[x][5] = "";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//Biological Engineering
		programList[x][1] = "University of Guelph";
		programList[x][2] = "";
		programList[x][3] = "";
		programList[x][4] = "";
		programList[x][5] = "";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//Chemical Engineering 
		programList[x][1] = "Algoma University";
		programList[x][2] = "University of Guelph";
		programList[x][3] = "Laurentian University";
		programList[x][4] = "University of Ottawa";
		programList[x][5] = "Ryerson University";
		programList[x][6] = "University of Waterloo";
		programList[x][7] = "University of Toronto";
		programList[x][8] = "";
		x++;
		
		//Mining Engineering
		programList[x][1] = "Algoma University";
		programList[x][2] = "University of Guelph";
		programList[x][3] = "Laurentian University";
		programList[x][4] = "University of Guelph";
		programList[x][5] = "University of Ottawa";
		programList[x][6] = "Ontario Tech University";
		programList[x][7] = "University of Waterloo";
		programList[x][8] = "Ryerson University";
		x++;
		
		//Architectural Engineering
		programList[x][1] = "University of Waterloo";
		programList[x][2] = "";
		programList[x][3] = "";
		programList[x][4] = "";
		programList[x][5] = "";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//Geological Engineering
		programList[x][1] = "University of Waterloo";
		programList[x][2] = "";
		programList[x][3] = "";
		programList[x][4] = "";
		programList[x][5] = "";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//Management Engineering
		programList[x][1] = "University of Waterloo";
		programList[x][2] = "";
		programList[x][3] = "";
		programList[x][4] = "";
		programList[x][5] = "";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//Mechatronics Engineering
		programList[x][1] = "University of Waterloo";
		programList[x][2] = "";
		programList[x][3] = "";
		programList[x][4] = "";
		programList[x][5] = "";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//Nanotechnology Engineering
		programList[x][1] = "University of Waterloo";
		programList[x][2] = "";
		programList[x][3] = "";
		programList[x][4] = "";
		programList[x][5] = "";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//Systems Design Engineering
		programList[x][1] = "University of Waterloo";
		programList[x][2] = "";
		programList[x][3] = "";
		programList[x][4] = "";
		programList[x][5] = "";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//Industrial Engineering
		programList[x][1] = "Ryerson University";
		programList[x][2] = "University of Windsor";
		programList[x][3] = "University of Toronto";
		programList[x][4] = "";
		programList[x][5] = "";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//Materials Engineering
		programList[x][1] = "University of Toronto";
		programList[x][2] = "";
		programList[x][3] = "";
		programList[x][4] = "";
		programList[x][5] = "";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//AeroSpace Engineering
		programList[x][1] = "Ryerson University";
		programList[x][2] = "";
		programList[x][3] = "";
		programList[x][4] = "";
		programList[x][5] = "";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		//Engineering Science 
		programList[x][1] = "University of Waterloo";
		programList[x][2] = "University of Western";
		programList[x][3] = "University of Toronto";
		programList[x][4] = "University of McMaster";
		programList[x][5] = "";
		programList[x][6] = "";
		programList[x][7] = "";
		programList[x][8] = "";
		x++;
		
		
		setIndex();
		
	}
	
	private void setIndex() {
		for (int x = 0; x < 27; x++) {
			if (searchResults.equals(programs.get(x)) == true) {
				index = x;
			}
		}
	}

	public int getIndex() {
		return index;
	}
	
}
