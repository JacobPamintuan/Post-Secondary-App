package postApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class test {

	public static ArrayList<School> programList = new ArrayList<School>();
	public static ArrayList<School> universityList = new ArrayList<School>();
	public static ArrayList<CudoData> b1Data = new ArrayList<CudoData>();
	public static ArrayList<CudoData> f1aData = new ArrayList<CudoData>();
	public static ArrayList<CudoData> f1bData = new ArrayList<CudoData>();

	public test() {
		setupBinarySearch();
	}
	
	public static void main(String[] args) {
		new test();
	}

	public void setupBinarySearch() {

		Scanner input;
		Scanner inputb1;
		Scanner inputUni;
		Scanner inputf1a;
		Scanner inputf1b;

		try {

			// Program, school
			input = new Scanner(new File("files/universityProgramList.txt"));
			input.useDelimiter(",");

			int index = 0;

			while (input.hasNext()) {
				programList.add(new School(index, input.next().replaceAll("\n", "").replaceAll("\r", ""),
						input.next().replaceAll("\n", "").replaceAll("\r", "")));
				++index;

			}

			
			// universityList
			inputUni = new Scanner(new File("files/UniversityList.txt"));
			inputUni.useDelimiter(",");

			while (inputUni.hasNext()) {
				universityList.add(new School(input.next().replaceAll("\n", "").replaceAll("\r", "")));
			}

			// B1 data
			// University,95+,Between 90 and 94,Between 85 and 89,Between 80 and 84,Between 75 and 79,Between 70 and 74,Below 70,Overall Average,
			inputb1 = new Scanner(new File("files/b1data.txt"));
			inputb1.useDelimiter(",");
			while (inputb1.hasNext()) {
				b1Data.add(new CudoData(input.next().replaceAll("\n", "").replaceAll("\r", ""), input.nextInt(),
						input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(),
						input.nextInt(), input.nextInt()));
			}

			// F1a - 2017 data
			// University,Excellent,Good,Fair,Poor
			inputf1a = new Scanner(new File("files/f1a2017.txt"));
			inputf1a.useDelimiter(",");
			while (inputf1a.hasNext()) {
				f1aData.add(new CudoData(input.next().replaceAll("\n", "").replaceAll("\r", ""), input.nextInt(),
						input.nextInt(), input.nextInt(), input.nextInt()));
			}

			// F1b - 2017 data
			inputf1b = new Scanner(new File("files/f1b2017.txt"));
			inputf1b.useDelimiter(",");
			while (inputf1a.hasNext()) {
				f1aData.add(new CudoData(input.next().replaceAll("\n", "").replaceAll("\r", ""), input.nextInt(),
						input.nextInt(), input.nextInt(), input.nextInt(), index));
			}

		} catch (FileNotFoundException e) {
			System.out.println("File Error");
		}
	}

}
