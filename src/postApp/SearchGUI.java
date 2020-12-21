package postApp;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class SearchGUI extends JFrame implements ActionListener, KeyListener{
	
	public final static int NUM_SCHOOLS = 15;
	public final static int NUM_PROGRAMS = 24;
	private JFrame frame;
	private JPanel screen;
	private JLabel surveyScreen;
	
	private JTextField searchBar;
	private String search = "";
	
	public static JButton[] schoolTags = new JButton[NUM_SCHOOLS];	
	public static boolean addedSchools[] = new boolean[NUM_SCHOOLS];
	public static JButton[] programTags = new JButton[NUM_PROGRAMS];	
	public static boolean addedPrograms[] = new boolean[NUM_PROGRAMS];
	
	private JButton backButton;
	private JButton searchButton;
	

	/**
	 * Create the application.
	 */
	public SearchGUI() {
		Arrays.fill(addedSchools, false);
		Arrays.fill(addedPrograms, false);
		search="";
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
		
		
		// Username textfield - where user inputs username
		searchBar = new JTextField();
		searchBar.setBounds(303, 100, 354, 40);
		searchBar.addKeyListener(this);
		searchBar.setBackground(Color.DARK_GRAY);
		searchBar.setForeground(Color.WHITE);
		searchBar.setColumns(10);
		searchBar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		screen.add(searchBar);

		// load school buttons
		int schoolIndex=0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 8-i; j++) { //j-i since second row only has 8
				schoolTags[schoolIndex] = new JButton();
				schoolTags[schoolIndex].addActionListener(this);
				schoolTags[schoolIndex].setBounds(55 + 190 * i, 210 + 30 * j, 180, 24); // location moves so labels don't overlap
				// the imagesArr index corresponds with the value on the board

				schoolTags[schoolIndex].setOpaque(false); //The following three lines make the button completely invisible
				schoolTags[schoolIndex].setContentAreaFilled(false);
				
				// creates a border around the buttons.
				if(addedSchools[schoolIndex])
					schoolTags[schoolIndex].setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));

				else
					schoolTags[schoolIndex].setBorder(BorderFactory.createLineBorder(new java.awt.Color(47, 47, 47), 3));

				screen.add(schoolTags[schoolIndex]);
				schoolIndex++;
			}
		}
		

		int programIndex=0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 8; j++) {
				programTags[programIndex] = new JButton();
				programTags[programIndex].addActionListener(this);
				programTags[programIndex].setBounds(535 + 127 * i, 210 + 30 * j, 117, 24); // location moves so labels don't overlap
				

				programTags[programIndex].setOpaque(false); //The following three lines make the button completely invisible
				programTags[programIndex].setContentAreaFilled(false);
				
				// creates a border around the buttons.
				if(addedPrograms[programIndex])
					programTags[programIndex].setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));

				else
					programTags[programIndex].setBorder(BorderFactory.createLineBorder(new java.awt.Color(47, 47, 47), 3));

				screen.add(programTags[programIndex]);
				programIndex++;
			}
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
		surveyScreen.setIcon(LoadImages.searchGUIImages[0]);
		surveyScreen.setVisible(true);
		screen.add(surveyScreen);
		
		frame.repaint();
	}
	
	private void panelUpdate(boolean flag) {
		
		for(int i =0;i<NUM_SCHOOLS;i++) {
			// creates a border around the buttons.
			if(addedSchools[i])
				schoolTags[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));

			else
				schoolTags[i].setBorder(BorderFactory.createLineBorder(new java.awt.Color(47, 47, 47), 3));
		}
		
		for(int i =0;i<NUM_PROGRAMS;i++) {
			// creates a border around the buttons.
			if(addedPrograms[i])
				programTags[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));

			else
				programTags[i].setBorder(BorderFactory.createLineBorder(new java.awt.Color(47, 47, 47), 3));
		}

		if(flag) {
			//change screen (show/hide error)
			if (!checkEmptyInfo())
				surveyScreen.setIcon(LoadImages.searchGUIImages[0]);
			
			else 
				surveyScreen.setIcon(LoadImages.searchGUIImages[1]);
		}
		
		frame.repaint();
	}
	


	// Checks if any of the text fields are blank
	// Displays an error message beside blank fields by enabling and/or setting JLabels
	// Returns boolean
	private boolean checkEmptyInfo() {
		// Default set to false
		// If any of the following fields are empty, anyEmpty set to true
		boolean isEmpty = true;
		
		for (int i = 0; i < NUM_SCHOOLS; i++) {
			if (addedSchools[i])
				isEmpty=false;
		}
		for (int i = 0; i < NUM_PROGRAMS; i++) {
			if (addedPrograms[i])
				isEmpty=false;
		}
		
		//all fields are empty
		if(search.trim().length()==0&&isEmpty)
			return true;
		
		return false;
	}



	
	// ActionPerformed - when user clicks any button
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == backButton) { // If user clicked loginButton
			new MainGUI(); // Create new login screen (redirect back to login)
			frame.setVisible(false); // Make current screen (signup) invisible
			
		} 
		else if (event.getSource() == searchButton) { // if user clicked continueButton
			panelUpdate(true);
			if (!checkEmptyInfo()) { // Calls validation method to check if all information entered is valid
				new SearchResults(search, addedSchools,addedPrograms);
				frame.setVisible(false);

			}
		}
		for (int i = 0; i < NUM_SCHOOLS; i++) {
			if (event.getSource() == schoolTags[i])
				addedSchools[i]= !addedSchools[i];
				
		}
		for (int i = 0; i < NUM_PROGRAMS; i++) {
			if (event.getSource() == programTags[i])
				addedPrograms[i]= !addedPrograms[i];
				
		}
		
		panelUpdate(false);
		repaint();

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		search = searchBar.getText();
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
