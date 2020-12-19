package postApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessingInformation {

	public static ArrayList<School> programList = new ArrayList<School>();
	public static ArrayList<School> universityList = new ArrayList<School>();
	public static ArrayList<CudoData> b1Data = new ArrayList<CudoData>();
	public static ArrayList<CudoData> f1aData = new ArrayList<CudoData>();
	public static ArrayList<CudoData> f1bData = new ArrayList<CudoData>();
	public static ArrayList<SurveyInfo> survey = new ArrayList<SurveyInfo>();

	public ProcessingInformation() {
		setupBinarySearch();
	}

	public void setupBinarySearch() {

		Scanner input;
		Scanner inputb1;
		Scanner inputUni;
		Scanner inputf1a;
		Scanner inputf1b;
		Scanner inputSur;

		try {
			int index = 0;
			
			// Program, school
			input = new Scanner(new File("files/universityProgramList.txt"));
			input.useDelimiter(",");

			while (input.hasNext()) {
				programList.add(new School(index, input.next().replaceAll("\n", "").replaceAll("\r", ""), input.next().replaceAll("\n", "").replaceAll("\r", "")));
				++index;
			}
			
			
			// universityList
			inputUni = new Scanner(new File("files/UniversityList.txt"));
			inputUni.useDelimiter(",");

			while (inputUni.hasNext()) {
				universityList.add(new School(inputUni.next().replaceAll("\n", "").replaceAll("\r", "")));
			}

			// B1 data
			// University,95+,Between 90 and 94,Between 85 and 89,Between 80 and 84,Between 75 and 79,Between 70 and 74,Below 70,Overall Average,
			inputb1 = new Scanner(new File("files/b1data.txt"));
			inputb1.useDelimiter(",");
			while (inputb1.hasNext()) {
				b1Data.add(new CudoData(inputb1.next().replaceAll("\n", "").replaceAll("\r", ""), 
						inputb1.nextDouble(),
						inputb1.nextDouble(), inputb1.nextDouble(), inputb1.nextDouble(), inputb1.nextDouble(), inputb1.nextDouble(),
						inputb1.nextDouble(), inputb1.nextDouble()));
			}

			// F1a - 2017 data
			// University,Excellent,Good,Fair,Poor
			inputf1a = new Scanner(new File("files/f1a2017.txt"));
			inputf1a.useDelimiter(",");
			while (inputf1a.hasNext()) {
				f1aData.add(new CudoData(inputf1a.next().replaceAll("\n", "").replaceAll("\r", ""), inputf1a.nextDouble(),
						inputf1a.nextDouble(), inputf1a.nextDouble(), inputf1a.nextDouble()));
			}

			// F1b - 2017 data
			inputf1b = new Scanner(new File("files/f1b2017.txt"));
			inputf1b.useDelimiter(",");
			while (inputf1a.hasNext()) {
				f1aData.add(new CudoData(inputf1b.next().replaceAll("\n", "").replaceAll("\r", ""), inputf1b.nextDouble(),
						inputf1b.nextDouble(), inputf1b.nextDouble(), inputf1b.nextDouble(), index));
			}
			
			// Survey Information
			inputSur = new Scanner(new File("files/SurveyInfoList.txt"));
			inputSur.useDelimiter(",");
			while (inputSur.hasNext()) {
				survey.add(new SurveyInfo(inputSur.next().replaceAll("\n", "").replaceAll("\r", ""),
						inputSur.next().replaceAll("\n", "").replaceAll("\r", ""),
						inputSur.next().replaceAll("\n", "").replaceAll("\r", ""),
						inputSur.next().replaceAll("\n", "").replaceAll("\r", ""),
						inputSur.next().replaceAll("\n", "").replaceAll("\r", "")));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File Error");
		}
	
	// Check!
		System.out.println(programList.toString());
		System.out.println(universityList.toString());
		System.out.println(b1Data.toString());
		System.out.println(f1aData.toString());
		System.out.println(f1bData.toString());
		System.out.println(survey.toString());
	
	}
}
