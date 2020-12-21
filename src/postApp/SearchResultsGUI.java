package postApp;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchResultsGUI extends JFrame implements ActionListener{
	
	private final static int NUM_SCHOOLS = 15;
	private final static int NUM_PROGRAMS = 24;
	public JFrame frame;
	private JPanel screen;
	private JLabel surveyScreen;
	
	private ArrayList<Programs> recommendedPrograms = new ArrayList<Programs>();
	private int numRecommendations;
	
	private JButton programButtons[];
	private JButton atButtons[];
	private JButton universityButtons[];
	private JButton mapButtons[];
	
	private JButton backButton;
	private JButton searchButton;
	

	/**
	 * Create the application.
	 */
	public SearchResultsGUI(ArrayList<Programs> recommendedPrograms) {
		this.recommendedPrograms = recommendedPrograms;
		numRecommendations = recommendedPrograms.size()<=10?recommendedPrograms.size():10;
		programButtons = new JButton[numRecommendations];
		atButtons = new JButton[numRecommendations];
		universityButtons = new JButton[numRecommendations];
		mapButtons  =new JButton[numRecommendations];
		
		frameSetup();
		panelDesign();
	}
	
	private void frameSetup() {
		frame = new JFrame();
		screen = new JPanel();
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //program will end when exited
		frame.setSize(Initialize.WIDTH,Initialize.HEIGHT); // sets the size of the frame
		frame.setTitle("Engineering Program Finder");
		frame.setBounds(0,0,Initialize.WIDTH+5,Initialize.HEIGHT+29);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false); // can't resize
		frame.getContentPane().add(screen); // add panel to the frame
		frame.validate();
		frame.repaint();
		frame.setVisible(true); 
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void panelDesign() {
		
		screen.setBorder(null);
		screen.setBounds(0,0,Initialize.WIDTH,Initialize.HEIGHT);
		screen.setLayout(null);
		
		for(int i =0;i<numRecommendations;i++) {
			programButtons[i] = new JButton();
			programButtons[i].addActionListener(this);
			programButtons[i].setBounds(240, 145 + 30 * i, 190, 30); // location moves so labels don't overlap
			programButtons[i].setIcon(LoadImages.programLabels[recommendedPrograms.get(i).getProgramID()]);
			programButtons[i].setOpaque(false); //The following three lines make the button completely invisible
			programButtons[i].setContentAreaFilled(false);
			programButtons[i].setBorderPainted(false);
			screen.add(programButtons[i]);
			
			atButtons[i] = new JButton();
			atButtons[i].addActionListener(this);
			atButtons[i].setBounds(430, 145 + 30 * i, 100, 30); // location moves so labels don't overlap
			atButtons[i].setIcon(LoadImages.at);
			atButtons[i].setOpaque(false); //The following three lines make the button completely invisible
			atButtons[i].setContentAreaFilled(false);
			atButtons[i].setBorderPainted(false);
			screen.add(atButtons[i]);
			
			universityButtons[i] = new JButton();
			universityButtons[i].addActionListener(this);
			universityButtons[i].setBounds(530, 145 + 30 * i, 190, 30); // location moves so labels don't overlap
			universityButtons[i].setIcon(LoadImages.universityLabels[recommendedPrograms.get(i).getSchoolID()]);
			universityButtons[i].setOpaque(false); //The following three lines make the button completely invisible
			universityButtons[i].setContentAreaFilled(false);
			universityButtons[i].setBorderPainted(false);
			screen.add(universityButtons[i]);
			
			mapButtons[i] = new JButton();
			mapButtons[i].addActionListener(this);
			mapButtons[i].setBounds(720, 145 + 30 * i, 63, 30); // location moves so labels don't overlap
			mapButtons[i].setIcon(LoadImages.map);
			mapButtons[i].setOpaque(false); //The following three lines make the button completely invisible
			mapButtons[i].setContentAreaFilled(false);
			mapButtons[i].setBorderPainted(false);
			screen.add(mapButtons[i]);
			
		}

		// JButton Login Instead
		// Exits Sign-up screen and returns to login screen
		backButton = new JButton();
		backButton.addActionListener(this);
		backButton.setBounds(190, 465, 100, 30);
		backButton.setOpaque(false); 
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		screen.add(backButton);

		// JButton Continue
		// Continues to the next sign up step if all entered information is valid
		searchButton = new JButton();
		searchButton.addActionListener(this);
		searchButton.setBounds(670, 465, 100, 30);
		searchButton.setOpaque(false); 
		searchButton.setContentAreaFilled(false);
		searchButton.setBorderPainted(false);
		screen.add(searchButton);
		
		
		surveyScreen=new JLabel();
		surveyScreen.setBounds(0, 0,Initialize.WIDTH,Initialize.HEIGHT);
		surveyScreen.setIcon(LoadImages.searchGUIImages[numRecommendations==0?3:2]);
		surveyScreen.setVisible(true);
		screen.add(surveyScreen);
		
		frame.repaint();
	}
	
	
	private void openWebBrowser(int index) {//this method opens the link on the buttons
		if (Desktop.isDesktopSupported()) {
			try {
				//opens hyperlink
				Desktop.getDesktop().browse(new URI(recommendedPrograms.get(index).getLink()));
				//browser
			} catch (IOException e1) {
				e1.printStackTrace();//if there is an error
			} catch (URISyntaxException e1) {
				e1.printStackTrace();// if there is a syntax error
			}
		}
	}
	
	// ActionPerformed - when user clicks any button
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == backButton) { // If user clicked loginButton
			new SearchGUI(); // Create new login screen (redirect back to login)
			frame.setVisible(false); // Make current screen (signup) invisible
			
		} 
		else if (event.getSource() == searchButton) { // if user clicked continueButton
			new MainGUI();
			frame.setVisible(false);

		}
		
		for(int i =0;i<numRecommendations;i++) {
			if(event.getSource()==programButtons[i]||event.getSource()==atButtons[i]||event.getSource()==universityButtons[i]) {
				openWebBrowser(i);
			}
			
			if(event.getSource()==mapButtons[i]) {
				try {
					new MapGUI(recommendedPrograms.get(i).getSchool(),recommendedPrograms);
					frame.setVisible(false);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
				
				
		}
		
		
		repaint();

	}
	
	


}
