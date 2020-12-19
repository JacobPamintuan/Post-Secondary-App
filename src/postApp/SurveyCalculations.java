package postApp;

public class SurveyCalculations {
	
	private String[] programs = new String[15];// The list of programs
	
	public SurveyCalculations() {
		Initialize.isSurveyCompleted = true;
		createProgramArray();
		calculateProgram();
	}
	
	private void createProgramArray() {
		programs[0] = "Mechanical Engineering/Mechatronics";
		programs[1] = "Nanotechnology Engineering";
		programs[2] = "Computer Engineering";
		programs[3] = "Electrical Engineering";
		programs[4] = "Software Engineering";
		programs[5] = "Biomedical Engineering";
		programs[6] = "Biomedical Engineering";
		programs[7] = "Chemical Engineering";
		programs[8] = "Civil Engineering";
		programs[9] = "Aerospace Engineering";
		programs[10] = "Geological Engineering/Mining Engineering";
		programs[11] = "Environmental Engineering";
		programs[12] = "Manufacturing Engineering";
		programs[13] = "Architectural Engineering/Management";
		programs[14] = "Undeclared Engineering";

	}

	private int calculateProgram() {

		final int HIGHEST = 5;
		int max = 0;
		int index = 0;

		for (int i = 0; i <15; i++) {

			if (Initialize.surveyAnswers[i]+1 == HIGHEST) {
				index = i;
				++max;
			}
			if(max>1) {
				index = 14;
				break;
			}
		}

		return index;

	}
	
	public String getRecommendation() {
		return programs[calculateProgram()];
	}
	
}
