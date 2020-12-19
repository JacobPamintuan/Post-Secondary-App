package postApp;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener, KeyListener {
	
	private JFrame frame;
	private JPanel screen;
	private JLabel signUpScreen;
	
	// Fields
	private JTextField textfields[] = new JTextField[3];
	private JPasswordField passwordFields[] = new JPasswordField[2];
	
	private JLabel errorLabel[] = new JLabel[4];

	private JToggleButton showHidePassword;

	private JButton loginButton;
	private JButton continueButton;
	
	private static String username="";
	private static String password="";
	private static String confirmPassword="";

	/**
	 * Create the application.
	 */
	public SignUp() {
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
		for(int i =0;i<3;i++) {
			textfields[i] = new JTextField();
			textfields[i].setBounds(320, 165+60*i, 160, 26);
			textfields[i].setBackground(Color.DARK_GRAY);
			textfields[i].setForeground(Color.WHITE);
			textfields[i].setFont(new Font("Segoe UI", Font.PLAIN, 16));
			textfields[i].setColumns(10);
			screen.add(textfields[i]);
		}

		textfields[2].addKeyListener(this);

		
		for(int i =0;i<2;i++) {
			passwordFields[i] = new JPasswordField();
			passwordFields[i].setBounds(320+430*i, 350, 160, 26);
			passwordFields[i].setBackground(Color.DARK_GRAY);
			passwordFields[i].setForeground(Color.WHITE);
			passwordFields[i].setFont(new Font("Segoe UI", Font.PLAIN, 16));
			passwordFields[i].setColumns(10);
			passwordFields[i].addKeyListener(this);
			screen.add(passwordFields[i]);
		}
		
		for(int i =0;i<4;i++) {
			errorLabel[i]=new JLabel();
			errorLabel[i].setBounds(130, 165+60*i, 20, 20);
			//makes it blend in with the background instead of setting visible false
			errorLabel[i].setBackground(new java.awt.Color(47, 47, 47)); 
			errorLabel[i].setOpaque(true);
			errorLabel[i].setVisible(true);
			screen.add(errorLabel[i]);
		}


		// JToggleButton - Show/Hide
		// Shows the password if button is selected, hides and replaces with '*'
		// otherwise
		// JToggleButton - hides and shows password		
		showHidePassword = new JToggleButton();
		showHidePassword.addActionListener(this);
		showHidePassword.setBounds(160, 350, 30, 20);
		showHidePassword.setOpaque(false); 
		showHidePassword.setContentAreaFilled(false);
		showHidePassword.setBorderPainted(false);
		screen.add(showHidePassword);

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
		signUpScreen.setIcon(LoadImages.signUpImages[0]);
		signUpScreen.setVisible(true);
		screen.add(signUpScreen);
		
		frame.repaint();
	}
	
	private void panelUpdate() {
		
		for(int i =0;i<3;i++) {
			if (textfields[i].getText().isEmpty())
				errorLabel[i].setBackground(new java.awt.Color(118, 16, 16));
			else
				errorLabel[i].setBackground(new java.awt.Color(47, 47, 47));
		}
		
		if (passwordFields[0].getText().isEmpty()||passwordFields[1].getText().isEmpty())
			errorLabel[3].setBackground(new java.awt.Color(118, 16, 16));
		else
			errorLabel[3].setBackground(new java.awt.Color(47, 47, 47));
		
		
		//error label 3
		if(!checkPassword()) {
			errorLabel[3].setBackground(new java.awt.Color(118, 16, 16));
		}
		
		if (!password.equals(confirmPassword)) {
			signUpScreen.setIcon(LoadImages.signUpImages[2]);
			errorLabel[3].setBackground(new java.awt.Color(118, 16, 16));
		}
		
		// Checks if password valid, displays appropriate error message
		if (!isValidPassword()) {
			signUpScreen.setIcon(LoadImages.signUpImages[4]);
			errorLabel[3].setBackground(new java.awt.Color(118, 16, 16));
		}
				
		// Validates if username already taken
		if(UserKeys.checkUsername(username)) {
			signUpScreen.setIcon(LoadImages.signUpImages[3]);
			errorLabel[2].setBackground(new java.awt.Color(118, 16, 16));
		}
		
		// Checks if username valid, displays appropriate error message
		if (!isValidUsername()) {
			signUpScreen.setIcon(LoadImages.signUpImages[5]);
			errorLabel[2].setBackground(new java.awt.Color(118, 16, 16));
		}
		
		// Checks if any info empty, displays appropriate error message
		if (checkEmptyInfo()) {
			signUpScreen.setIcon(LoadImages.signUpImages[1]);
		}
		
		frame.repaint();
	}
	

	

	// Validation method - checks if the password and confirm password are the same
	// Returns false if password filed is empty or they do not match
	private boolean checkPassword() {
		
		// Checks if password text field is empty, displays appropriate error message, returns false
		if (password.isEmpty()||!isValidPassword()||!password.equals(confirmPassword)) { 
			return false;
		}
		// If all the above is false, passwords match
		// Returns true
		return true;
	}

	// Checks if any of the text fields are blank
	// Displays an error message beside blank fields by enabling and/or setting JLabels
	// Returns boolean
	private boolean checkEmptyInfo() {
		// Default set to false
		// If any of the following fields are empty, anyEmpty set to true
		boolean anyEmpty = false;
		
		for(int i =0;i<3;i++) {
			if (textfields[i].getText().isEmpty()) { 
				anyEmpty = true;
			} 
		}
		
		if (passwordFields[0].getText().isEmpty()||passwordFields[1].getText().isEmpty()) { 
			anyEmpty = true;
		} 

		// Return boolean
		return anyEmpty;
	}

	// Validates username (At least 5 characters, not already taken)
	// Displays message accordingly
	// Returns boolean
	private boolean isValidUsername() {
		// Validates the length of the username
		return username.length() > 5;
	}

	// Validates password (At least 6 characters, includes 1 lower, 1 upper, 1
	// number
	// Displays message accordingly
	// Returns boolean
	private boolean isValidPassword() {
		// Boolean value default set to true
		// If any of the following fail, isValid set to false
		String upperCaseChars = "(.*[A-Z].*)"; // Upper case letters
		String lowerCaseChars = "(.*[a-z].*)"; // Lower case letters
		String numbers = "(.*[0-9].*)"; // Numbers

		// Checks if the password field is empty
		if(password.length()<6||!password.matches(upperCaseChars)||
				!password.matches(lowerCaseChars)||!password.matches(numbers))
			return false;
		
		return true;
	}

	// Validates all information entered
	// Displays message accordingly
	// Disables all previous buttons and fields if successful
	// Returns boolean
	private boolean checkValid() {
		// Boolean value default set to true
		// If any of the below evaluate, success set to false
		
		//sets background in reverse priority order
		//low priority errors are set first, so that high priority errors
		//are set last and ultimately displayed
		
		// Checks if passwords match, displays appropriate error message 
		// Checks if password valid, displays appropriate error message
		// Validates if usernamea already taken
		// Checks if username valid, displays appropriate error message
		if (!password.equals(confirmPassword)||!isValidPassword()||
				UserKeys.checkUsername(username)||!isValidUsername()||checkEmptyInfo()) {
			return false;
		}

		return true;
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
			if (checkValid()) { // Calls validation method to check if all information entered is valid

				// Saves information to user
				Initialize.user.setFirstName(textfields[0].getText());
				Initialize.user.setLastName(textfields[1].getText());
				Initialize.user.setUsername(textfields[2].getText().trim());
				Initialize.user.setPassword(passwordFields[0].getText().trim());
				
				// Saves username and password to the username/passwords textfile
				try {
					UserKeys.addUser(textfields[2].getText().trim(), passwordFields[0].getText().trim());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				new SignUp2();
				frame.setVisible(false);

			}
		}
		// If state is selected, characters can be seen
		if (showHidePassword.isSelected()) {
			for(int i =0;i<2;i++)
				passwordFields[i].setEchoChar((char) 0);
		// If state is non-selected, characters hidden and replaced with '*'
		} else {
			for(int i =0;i<2;i++)
				passwordFields[i].setEchoChar('*');

		}
		
		repaint();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		username=textfields[2].getText().trim();
		password = passwordFields[0].getText().trim();
		confirmPassword = passwordFields[1].getText().trim();
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
