package postApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
	
	public static ArrayList<School> programList = new ArrayList<School>();
	
	String programName;
	private School school;
	
	public Program(String programName) {
		this.programName = programName;
	}

	public String setupBinarySearch(String programName) {
		
		Scanner input;

		try {
			input = new Scanner(new File("files/universityProgramList.txt"));
			input.useDelimiter(",");

			int index = 0;

			while (input.hasNext()) {
				programList.add(new School(index, input.next().replaceAll("\n", "").replaceAll("\r", ""),
						input.next().replaceAll("\n", "").replaceAll("\r", "")));
				++index;
				 if (programName.equals(school.getProgram()) || (" " + programName).equals(school.getProgram())) {
					 return school.getSchool();
				 }
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Error");
		}
		return "final";

		// check
//		for (int x = 0; x < 64; x++) {
//			System.out.println(programList.get(x).toString());
		}
	}


