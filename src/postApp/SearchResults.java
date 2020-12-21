package postApp;

import java.util.*;

import javax.swing.JLabel;

public class SearchResults {
	
	private static String search;
	private boolean addedSchools[];
	private boolean addedPrograms[];
	
	private ArrayList<String> chosenSchools = new ArrayList<String>();
	private ArrayList<Integer> chosenSchoolsID = new ArrayList<Integer>();
	private ArrayList<String> chosenPrograms = new ArrayList<String>();
	private ArrayList<Integer> chosenProgramsID = new ArrayList<Integer>();
	private ArrayList<Programs> recommendedPrograms = new ArrayList<Programs>();
	
	
	public SearchResults(String search, boolean[] addedSchools, boolean[] addedPrograms) {
		this.search=search.trim();
		this.addedSchools=addedSchools;
		this.addedPrograms=addedPrograms;
		findChosen();
		searchToTag();
		createPrograms();
		
		
		new SearchResultsGUI(recommendedPrograms);
		
	}

	

	private void findChosen() {
		for (int i = 0; i < 15; i++) {
			
			if (addedSchools[i]) {
				chosenSchools.add(Initialize.universityList[i]);
				chosenSchoolsID.add(i);
			}
				
		}
		for (int i = 0; i < 24; i++) {
			if (addedPrograms[i]) {
				chosenPrograms.add(Initialize.programList[i]);
				chosenProgramsID.add(i);
			}
				
		}
		
	}
	
	private void createPrograms() {
		
		for(int i =0;i<chosenSchools.size();i++) {
			for(int j =0;j<chosenPrograms.size();j++) {
				if(Initialize.universities[chosenSchoolsID.get(i)].getPrograms().contains(chosenPrograms.get(j))) {
					int tmp = Initialize.universities[chosenSchoolsID.get(i)].getPrograms().indexOf(chosenPrograms.get(j));
					recommendedPrograms.add(new Programs(chosenSchools.get(i),chosenPrograms.get(j),
							chosenSchoolsID.get(i),chosenProgramsID.get(j),Initialize.universities[chosenSchoolsID.get(i)].getProgramLinks().get(tmp)));
				}
			}
			
				
			
		}
		
	}
	
	
	//Could have used Least Common Subsequence to find the university/program that is 
	//closest to the search term
	private void searchToTag() {
		
		String searchTerms[] = search.split(" ");
		for(int i =0;i<searchTerms.length;i++) {
			if(searchTerms[i].toUpperCase().equals("ENGINEERING"))continue;
			
			for(int j =0;j<SearchGUI.NUM_SCHOOLS;j++) {
				if(Initialize.universityList[j].toUpperCase().equals(searchTerms[i].toUpperCase())&&!addedSchools[j]) {
					chosenSchools.add(Initialize.universityList[j]);
					chosenSchoolsID.add(j);
				}
				continue;
			}
			
			for(int j =0;j<SearchGUI.NUM_PROGRAMS;j++) {
				if(Initialize.programList[j].toUpperCase().equals(searchTerms[i].toUpperCase())&&!addedPrograms[j]) {
					chosenPrograms.add(Initialize.programList[j]);
					chosenProgramsID.add(j);
				}
				continue;
			}
		}
		
	}
	
}
