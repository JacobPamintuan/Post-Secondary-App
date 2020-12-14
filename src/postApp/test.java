package postApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class test {
	public static ArrayList<School> programList = new ArrayList<School>();

	public test() {
		setupBinarySearch();
	}
	
	public static void main(String[] args) {
		new test();
	}

	private void setupBinarySearch() {
		Scanner input;

		try {
			input = new Scanner(new File("files/universityProgramList.txt"));
			input.useDelimiter(",");

			int index = 0;

			while (input.hasNext()) {
				programList.add(new School(index, input.next().replaceAll("\n", "").replaceAll("\r", ""),
						input.next().replaceAll("\n", "").replaceAll("\r", "")));
				++index;
				// if (programName == school.getProgram() || (" " + programName) ==
				// school.getProgram()) {

				// }
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Error");
		}

		// check
		for (int x = 0; x < 64; x++) {
			System.out.println(programList.get(x).toString());
		}
	}

}
