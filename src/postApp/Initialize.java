package postApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Initialize {

	public static ArrayList<String> universityList = new ArrayList<String>();
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static Person user;

	public Initialize() throws Exception {
		user = new Person();
//		loadUniversityList();
		new LoadUserKeys();
//		user.setStreetNumber("622");
		user.setStreetName("Fred McLaren blvd.");
		user.setCity("Markham");
		user.setProvince("ON");
		user.setCountry("Canada");
		new LoginGUI();
		UniversityQuiz quiz = new UniversityQuiz();
		quiz.frame.setVisible(true);

	}

	private void loadUniversityList() throws IOException {
		BufferedReader br = new BufferedReader(new java.io.FileReader(new File("Files/UniversityList.txt")));

		String line;
		while ((line = br.readLine()) != null) {
			universityList.add(line);
		}
		br.close();

	}
}
