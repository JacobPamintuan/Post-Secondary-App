package postApp;

/**
 * ExtraBoardImages holds the other images used in the game
 */

import javax.swing.*;

public class LoadImages {

	// The array containing backgrounds for the login GUI
	public static ImageIcon loginGUIImages[] = new ImageIcon[3];
	public static ImageIcon signUpImages[] = new ImageIcon[8];
	public static ImageIcon surveyGUIImages[] = new ImageIcon[6];
	public static ImageIcon searchGUIImages[] = new ImageIcon[4];
	public static ImageIcon programLabels[] = new ImageIcon[24];
	public static ImageIcon universityLabels[] = new ImageIcon[15];
	public static ImageIcon at;


	// Constructor
	public LoadImages() {
		loadImages();

	}

	// Load all other images used in the game
	private void loadImages() {

		for(int i =0;i<3;i++) {
			loginGUIImages[i] = new ImageIcon(
					new ImageIcon(String.format("ScreenImages/LoginGUI%d.png",i)).getImage().getScaledInstance(Initialize.WIDTH, Initialize.HEIGHT, 0));
		}
		
		for(int i =0;i<8;i++) {
			signUpImages[i] = new ImageIcon(
					new ImageIcon(String.format("ScreenImages/SignUp%d.png",i)).getImage().getScaledInstance(Initialize.WIDTH, Initialize.HEIGHT, 0));
		}
		
		for(int i =0;i<6;i++) {
			surveyGUIImages[i] = new ImageIcon(
					new ImageIcon(String.format("ScreenImages/SurveyGUI%d.png",i)).getImage().getScaledInstance(Initialize.WIDTH, Initialize.HEIGHT, 0));
		}
		for(int i =0;i<4;i++) {
			searchGUIImages[i] = new ImageIcon(
					new ImageIcon(String.format("ScreenImages/SearchGUI%d.png",i)).getImage().getScaledInstance(Initialize.WIDTH, Initialize.HEIGHT, 0));
		}
		
		for(int i =0;i<24;i++) {
			programLabels[i] = new ImageIcon(
					new ImageIcon(String.format("SearchLabels/Program%d.png",i)).getImage().getScaledInstance(190, 30, 0));
		}
		for(int i =0;i<15;i++) {
			universityLabels[i] = new ImageIcon(
					new ImageIcon(String.format("SearchLabels/Universities%d.png",i)).getImage().getScaledInstance(190, 30, 0));
		}
		
		at= new ImageIcon(new ImageIcon("SearchLabels/At.png").getImage().getScaledInstance(100, 30, 0));
		
	}
}
