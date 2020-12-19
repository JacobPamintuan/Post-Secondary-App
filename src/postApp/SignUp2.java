package postApp;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignUp2 extends JFrame implements ActionListener, KeyListener {
	
	private JFrame frame;
	private JPanel screen;
	private JLabel signUpScreen;
	
	// Fields
	private JTextField textfields[] = new JTextField[4];
	
	private JLabel errorLabel[] = new JLabel[4];

	private JButton loginButton;
	private JButton continueButton;
	

	/**
	 * Create the application.
	 */
	public SignUp2() {
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
		frame.addKeyListener(this);
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void panelDesign() {
		
		screen.setBorder(null);
		screen.setBounds(0,0,Initialize.WIDTH,Initialize.HEIGHT);
		screen.setLayout(null);


		// JTextField First name - user enters first name
		for(int i =0;i<4;i++) {
			textfields[i] = new JTextField();
			textfields[i].setBounds(320, 165+60*i, 160, 26);
			textfields[i].setBackground(Color.DARK_GRAY);
			textfields[i].setForeground(Color.WHITE);
			textfields[i].setFont(new Font("Segoe UI", Font.PLAIN, 16));
			textfields[i].setColumns(10);
			screen.add(textfields[i]);
		}


		// JButton Login Instead
		// Exits Sign-up screen and returns to login screen
		loginButton = new JButton();
		loginButton.addActionListener(this);
		loginButton.setBounds(250, 420, 140, 30);
		loginButton.setOpaque(false); 
		loginButton.setContentAreaFilled(false);
		loginButton.setBorderPainted(false);
		screen.add(loginButton);

		// JButton Continue
		// Continues to the next sign up step if all entered information is valid
		continueButton = new JButton();
		continueButton.addActionListener(this);
		continueButton.setBounds(590, 420, 100, 30);
		continueButton.setOpaque(false); 
		continueButton.setContentAreaFilled(false);
		continueButton.setBorderPainted(false);
		screen.add(continueButton);
		
		
		signUpScreen=new JLabel();
		signUpScreen.setBounds(0, 0,Initialize.WIDTH,Initialize.HEIGHT);
		signUpScreen.setIcon(LoadImages.signUpImages[6]);
		signUpScreen.setVisible(true);
		screen.add(signUpScreen);
		
		frame.repaint();
	}
	
	private void panelUpdate() {
		
		if (checkEmptyInfo())
			signUpScreen.setIcon(LoadImages.signUpImages[6]);
		
		else 
			signUpScreen.setIcon(LoadImages.signUpImages[7]);
		
		frame.repaint();
	}
	

	

	// Checks if any of the text fields are blank
	// Displays an error message beside blank fields by enabling and/or setting JLabels
	// Returns boolean
	private boolean checkEmptyInfo() {
		// Default set to false
		// If any of the following fields are empty, anyEmpty set to true
		boolean anyEmpty = false;
		
		for(int i =0;i<4;i++) {
			if (textfields[i].getText().isEmpty())
				anyEmpty = true;
		}
		
		// Return boolean
		return anyEmpty;
	}



	
	// ActionPerformed - when user clicks any button
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == loginButton) { // If user clicked loginButton
			LoginGUI login = new LoginGUI(); // Create new login screen (redirect back to login)
//				login.frame.setVisible(true); // Set new login screen to visible TMP
			frame.setVisible(false); // Make current screen (signup) invisible
		} 
		else if (event.getSource() == continueButton) { // if user clicked continueButton
			panelUpdate();
			if (! checkEmptyInfo()) { // Calls validation method to check if all information entered is valid

				// Saves information to user
				Initialize.user.setStreetNumber(textfields[0].getText().trim());
				Initialize.user.setStreetName(textfields[1].getText().trim());
				Initialize.user.setCity(textfields[2].getText().trim());
				Initialize.user.setProvince(textfields[2].getText().trim());
				Initialize.user.setCountry("Canada");
				
				// Saves username and password to the username/passwords textfile
				new MainGUI();
				Initialize.isReturningUser=true;
				frame.setVisible(false);

			}
		}
		
		repaint();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
