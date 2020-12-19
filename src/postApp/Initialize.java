package postApp;
import java.io.*;
import java.util.*;
import java.time.*;
import audio.MusicPlayer;

public class Initialize {
	
	public static ArrayList<String> universityList = new ArrayList<String>();
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
		
		String line;
		while((line=br.readLine())!=null) {
			universityList.add(line);
			recommendedUniversityList.add(line);
		}
		br.close();
		
	}
}
