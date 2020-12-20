package postApp;
import java.io.*;
import java.util.*;
import java.time.*;
import audio.MusicPlayer;

public class Initialize {
	
	public static String universityList[] = new String[15];
	public static String programList[] = new String[24];
	public static School universities[]  =new School[15];
	public static ArrayList<String> recommendedUniversityList = new ArrayList<String>();
	
	
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static Person user;
	
	public static boolean isReturningUser=false;
	public static boolean isSurveyCompleted= false;
	
	public static int surveyAnswers[]= new int [15];

	
	//screen dimensions
	public final static int WIDTH = 960;
	public final static int HEIGHT = 540;
	
	public Initialize() throws Exception {
		user = new Person();
		Arrays.fill(surveyAnswers, -1);
		loadUniversityList();
		loadProgramList();
		loadSchools();
		
//		for(int i =0;i<universities.length;i++) {
//			System.out.println(universities[i].toString());
//		}
		
		
		playTunes();
//		new DistanceBetweenAddresses();
		new LoadImages();
		new UserKeys();
		new LoginGUI();
		
		
		
		
	}

	private void playTunes() {
		Calendar calendar = Calendar.getInstance(); // creates a new calendar instance
		int time = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
		if(time>20||time<6)
			MusicPlayer.playAudio("Audio/BGM/NightBGM.wav"); // late music
		else
			MusicPlayer.playAudio("Audio/BGM/BGM.wav"); // music
		
	}

	private void loadUniversityList() throws IOException {
		BufferedReader br = new BufferedReader(new java.io.FileReader(new File("Files/UniversityList.txt")));
		
		int index=0;
		String line;
		while((line=br.readLine())!=null) {
			universityList[index++] = line;
			recommendedUniversityList.add(line);
		}
		br.close();
		
	}
	
	private void loadProgramList() throws IOException {
		BufferedReader br = new BufferedReader(new java.io.FileReader(new File("Files/ProgramList.txt")));
		
		int index = 0;
		String line;
		while((line=br.readLine())!=null) {
			programList[index++] = line;
		}
		br.close();
		
	}
	
	private void loadSchools() throws IOException {
		BufferedReader br = new BufferedReader(new java.io.FileReader(new File("Files/UniversityProgramList.txt")));
		
		int id = -1;
		String previousSchool = "null";
		String line;
		while((line=br.readLine())!=null) {
			String str[] = line.trim().split(",");
			if(!str[0].equals(previousSchool)) {
				id++;
				universities[id] = new School(id,str[0]);
			}
			universities[id].getPrograms().add(str[1]);
			universities[id].getProgramLinks().add(str[2]);
			previousSchool = str[0];
		}
		br.close();
		
	}
	
}
