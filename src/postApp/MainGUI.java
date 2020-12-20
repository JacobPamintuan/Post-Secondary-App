package postApp;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;

import audio.MusicPlayer;

public class MainGUI  extends JFrame implements ActionListener {
	//gui stuff
	public static JFrame frame;
	public static JPanel screen;
	private static JLabel mainScreen;
	public static JButton buttons[][];
	public static JLabel time;
	
	//menubar stuff
	private static JMenuBar mb = new JMenuBar();
	private static JMenu menu = new JMenu();
	private static JMenuItem saveAndExit;
	private static JMenuItem music;
	private static boolean playingMusic = true;
	
	
	// constructor method
	public MainGUI(){
		// Initialize
		buttons = new JButton[2][2];
		frame = new JFrame();
		screen = new JPanel();
		time = new JLabel();
		mainScreen=new JLabel();
		// Set up Menu Bar
		menuBar();
		// Set up the frame
		frameSetup();
		// Set up panel/labels/buttons
		panelDesign();
		// Update the panel

	}


	// sets up the JFrame
	private void frameSetup() {
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // program will end when exited
		frame.setSize(1000, 600); // sets the size of the frame
		frame.setTitle("Post Secondary Application"); // The window name
		frame.setBounds(0, 0, 965,590);
		frame.setLayout(null);
		frame.setResizable(false); // can't resize
		frame.add(screen); // add panel to the frame
		frame.validate();
		frame.repaint();
		frame.setVisible(true); // Visible
	}
	
	
	// creates menubar
	private void menuBar() {
		mb = new JMenuBar();
		menu = new JMenu("Menu");

		// menu items
		music = new JMenuItem("Toggle Music");
		saveAndExit = new JMenuItem("Save and Exit");

		// add to action listener for the menu items
		music.addActionListener(this);
		saveAndExit.addActionListener(this);

		frame.setJMenuBar(mb); // add menu bar
		mb.add(menu); // add menu to menubar
		menu.add(music); // add items
		menu.add(saveAndExit);

	}
	private void panelDesign() {

		// Set up the panel
		screen.setBorder(null);
//		screen.setBackground(new java.awt.Color(47, 47, 47));
		screen.setBounds(0, 0, 960, 540);
		screen.setLayout(null);
		
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].addActionListener(this);
				buttons[i][j].setBounds(50 + 320 * j, 180 + 140 * i, 220, 100); // location moves so labels don't overlap
				buttons[i][j].setOpaque(false); //The following three lines make the button completely invisible
				buttons[i][j].setContentAreaFilled(false);
				buttons[i][j].setBorderPainted(false);

				screen.add(buttons[i][j]);
			}

		}
		
		
		
		mainScreen.setBounds(0, 0, 960, 540);
		mainScreen.setIcon(new ImageIcon(new ImageIcon("Images/SmallMainGUI.png").getImage().getScaledInstance(960, 540, 0)));
		mainScreen.setVisible(true);
		screen.add(mainScreen);
		

		frame.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		//exits the program and saves
		if (event.getSource() == saveAndExit) {
			new Save();
			System.exit(0);
		}

		// toggle the music
		if (event.getSource() == music) {
			if (playingMusic)
				MusicPlayer.pauseMusic();
			else
				MusicPlayer.unpauseMusic();
			playingMusic = !playingMusic;
		}
		
		if (event.getSource() == buttons[0][0]) {
			Arrays.fill(Initialize.surveyAnswers,-1);
			new SurveyGUI1();
			frame.setVisible(false);
		}
		
		else if (event.getSource() == buttons[0][1]) {
			new SearchGUI();
			frame.setVisible(false);
		}
		
		else if (event.getSource() == buttons[1][0]) {
			new UniversityQuiz();
			frame.setVisible(false);
		}
		
		else if (event.getSource() == buttons[1][1]) {
//			new ProfileGUIOne();
			frame.setVisible(false);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
