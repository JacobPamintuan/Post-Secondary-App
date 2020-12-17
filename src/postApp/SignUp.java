package postApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SignUp implements ActionListener {

	// Fields

	private JFrame frame;
	private JTextField firstName_txt;
	private JTextField lastName_txt;
	private JTextField username_txt;

	private JPasswordField password_ptxt;
	private JPasswordField confirmPassword_ptxt;

	private JLabel lblSignUp;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblUsername;
	private JLabel lblUsernameReq;
	private JLabel lblPassword;
	private JLabel lblConfirmPassword;
	private JLabel lblPasswordReq;
	private JLabel lblStreetNum;
	private JLabel lblStreetName;
	private JLabel lblCity;
	private JLabel lblProvince;

	private JLabel lblFirstNameError;
	private JLabel lblLastNameError;
	private JLabel lblUsernameError;
	private JLabel lblPasswordError;
	private JLabel lblConfirmPasswordError;
	private JLabel lblSuccessOrError;

	private JToggleButton tglbtnShowHide;

	private JButton btnLoginInstead;
	private JButton btnCreateAccount;
	private JButton btnHOME;
	private JButton btnSetupProfile;
	private JTextField streetNum_txt;
	private JTextField streetName_txt;
	private JTextField city_txt;
	private JTextField province_txt;
	

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// JFrame
		frame = new JFrame();
		frame.setForeground(Color.RED);
		frame.setBounds(0, 0, 700, 1000);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.lightGray); // Sets background color
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// JLabel Signup - Title
//		lblSignUp = new JLabel("<html><div style='text-align: center;'><html>Sign-Up for The Engineering<br>Program Finder</div></html>");
//		lblSignUp = new JLabel(new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Post-Secondary-App/Post-Secondary-App/images/SignUpTitle.png"));
		lblSignUp = new JLabel(new ImageIcon("images/SignUpTitle.png"));
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setBounds(0, 0, 700, 200);
		frame.getContentPane().add(lblSignUp);

		// JLabel First name
		lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(184, 212, 88, 16);
		frame.getContentPane().add(lblFirstName);

		// JTextField First name - user enters first name
		firstName_txt = new JTextField();
		firstName_txt.setBounds(180, 230, 288, 26);
		frame.getContentPane().add(firstName_txt);
		firstName_txt.setColumns(10);

		// JLabel last name
		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(184, 258, 88, 16);
		frame.getContentPane().add(lblLastName);

		// JTextField last name - user enters last name
		lastName_txt = new JTextField();
		lastName_txt.setColumns(10);
		lastName_txt.setBounds(180, 276, 288, 26);
		frame.getContentPane().add(lastName_txt);

		// JLabel Username
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(184, 314, 88, 16);
		frame.getContentPane().add(lblUsername);

		// JTextField username - user enters username
		username_txt = new JTextField();
		username_txt.addKeyListener(new KeyAdapter() { // KeyLister that validates username as user types
			@Override
			public void keyReleased(KeyEvent e) {
				validateUsername(username_txt.getText()); // Calls validate method
			}
		});
		username_txt.setColumns(10);
		username_txt.setBounds(180, 332, 288, 26);
		frame.getContentPane().add(username_txt);

		// JLabel Username requirements
		lblUsernameReq = new JLabel("At least 5 characters long");
		lblUsernameReq.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblUsernameReq.setBounds(190, 366, 169, 16);
		frame.getContentPane().add(lblUsernameReq);

		// JLabel Password
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(184, 392, 88, 16);
		frame.getContentPane().add(lblPassword);

		// JPasswordField password- user enters password
		password_ptxt = new JPasswordField();
		password_ptxt.addKeyListener(new KeyAdapter() { // KeyLister that validates password as user types
			@Override
			public void keyReleased(KeyEvent e) {
				validatePassword(password_ptxt.getText()); // Calls validate method
			}
		});
		password_ptxt.setColumns(10);
		password_ptxt.setBounds(180, 410, 288, 26);
		frame.getContentPane().add(password_ptxt);

		// JLabel Confirm password
		lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(184, 448, 165, 16);
		frame.getContentPane().add(lblConfirmPassword);

		confirmPassword_ptxt = new JPasswordField();
		confirmPassword_ptxt.addKeyListener(new KeyAdapter() { // KeyLister that validates password confirmation as user types
			@Override
			public void keyReleased(KeyEvent e) {
				isPasswordsSame(password_ptxt.getText(), confirmPassword_ptxt.getText()); // Calls validate method

			}
		});
		confirmPassword_ptxt.setColumns(10);
		confirmPassword_ptxt.setBounds(180, 466, 288, 26);
		frame.getContentPane().add(confirmPassword_ptxt);

		// JLabel Passowrd Requirements
		lblPasswordReq = new JLabel("<html>Use 6 or more characters." + "<br>Must include:" + "<br>1 UPPERCASE letter,"
				+ "<br>1 lowercase letter, and" + "<br>1 number");
		lblPasswordReq.setVerticalAlignment(SwingConstants.TOP);
		lblPasswordReq.setBounds(184, 491, 165, 87);
		frame.getContentPane().add(lblPasswordReq);
		

		// JToggleButton - Show/Hide
		// Shows the password if button is selected, hides and replaces with '*'
		// otherwise
		tglbtnShowHide = new JToggleButton("Show/Hide");
		tglbtnShowHide.addActionListener(this); // ActionListener
		tglbtnShowHide.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		tglbtnShowHide.setBounds(359, 444, 96, 29);
		frame.getContentPane().add(tglbtnShowHide);

		// JButton Login Instead
		// Exits Sign-up screen and returns to login screen
		btnLoginInstead = new JButton("Login Instead");
		btnLoginInstead.addActionListener(this); // ActionListener
		btnLoginInstead.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnLoginInstead.setBounds(188, 855, 117, 29);
		frame.getContentPane().add(btnLoginInstead);

		// JButton Create Account
		// Creates a new user/account if all entered information is valid
		btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(this); // ActionListener
		btnCreateAccount.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnCreateAccount.setBounds(359, 854, 117, 29);
		frame.getContentPane().add(btnCreateAccount);

		// JButton HOME
		// Takes user to Home page (only enabled after account creation)
		btnHOME = new JButton("HOME");
		btnHOME.addActionListener(this); // ActionListener
		btnHOME.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnHOME.setBounds(188, 924, 117, 29);
		btnHOME.setEnabled(false);
		frame.getContentPane().add(btnHOME);

		// JButton Set-up profile
		// Takes user to profile setup screen
		btnSetupProfile = new JButton("Setup Profile");
		btnSetupProfile.addActionListener(this); // ActionListener
		btnSetupProfile.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnSetupProfile.setBounds(359, 923, 117, 29);
		btnSetupProfile.setEnabled(false);
		frame.getContentPane().add(btnSetupProfile);

		// JLabel - Error Messages
		// First Name Error
		lblFirstNameError = new JLabel("Please Enter Your First Name");
		lblFirstNameError.setForeground(Color.RED);
		lblFirstNameError.setBounds(495, 235, 188, 16);
		lblFirstNameError.setVisible(false);
		frame.getContentPane().add(lblFirstNameError);

		// Last Name Error
		lblLastNameError = new JLabel("Please Enter Your Last Name");
		lblLastNameError.setForeground(Color.RED);
		lblLastNameError.setBounds(495, 281, 188, 16);
		lblLastNameError.setVisible(false);
		frame.getContentPane().add(lblLastNameError);

		// Username Error
		lblUsernameError = new JLabel("Please Enter A Username");
		lblUsernameError.setForeground(Color.RED);
		lblUsernameError.setBounds(495, 337, 188, 16);
		lblUsernameError.setVisible(false);
		frame.getContentPane().add(lblUsernameError);

		// Password Error
		lblPasswordError = new JLabel("Please Enter A Password");
		lblPasswordError.setForeground(Color.RED);
		lblPasswordError.setBounds(495, 415, 188, 16);
		lblPasswordError.setVisible(false);
		frame.getContentPane().add(lblPasswordError);

		// Confirm Password Error
		lblConfirmPasswordError = new JLabel("Passwords do not match");
		lblConfirmPasswordError.setForeground(Color.RED);
		lblConfirmPasswordError.setBounds(495, 471, 220, 32);
		lblConfirmPasswordError.setVisible(false);
		frame.getContentPane().add(lblConfirmPasswordError);

		// Success or Error Label
		lblSuccessOrError = new JLabel("SUCESS/ERROR");
		lblSuccessOrError.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuccessOrError.setBounds(208, 896, 255, 16);
		lblSuccessOrError.setVisible(false);
		frame.getContentPane().add(lblSuccessOrError);
		
		lblStreetNum = new JLabel("Street Number: ");
		lblStreetNum.setBounds(188, 626, 145, 16);
		frame.getContentPane().add(lblStreetNum);
		
		streetNum_txt = new JTextField();
		streetNum_txt.setColumns(10);
		streetNum_txt.setBounds(184, 644, 101, 26);
		frame.getContentPane().add(streetNum_txt);
		
		lblStreetName = new JLabel("Street Name:");
		lblStreetName.setBounds(188, 672, 88, 16);
		frame.getContentPane().add(lblStreetName);
		
		streetName_txt = new JTextField();
		streetName_txt.setColumns(10);
		streetName_txt.setBounds(184, 690, 288, 26);
		frame.getContentPane().add(streetName_txt);
		
		lblCity = new JLabel("City: ");
		lblCity.setBounds(188, 728, 88, 16);
		frame.getContentPane().add(lblCity);
		
		city_txt = new JTextField();
		city_txt.setColumns(10);
		city_txt.setBounds(184, 746, 288, 26);
		frame.getContentPane().add(city_txt);
		
		lblProvince = new JLabel("Province:");
		lblProvince.setBounds(188, 784, 88, 16);
		frame.getContentPane().add(lblProvince);
		
		province_txt = new JTextField();
		province_txt.setColumns(10);
		province_txt.setBounds(184, 802, 288, 26);
		frame.getContentPane().add(province_txt);

		frame.setVisible(true);
	}

	// ActionPerformed - when user clicks any button
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLoginInstead) { // If user clicked btnLoginInstead
			LoginGUI login = new LoginGUI(); // Create new login screen (redirect back to login)
			login.frame.setVisible(true); // Set new login screen to visible
			frame.setVisible(false); // Make current screen (signup) invisible
		} else if (e.getSource() == btnCreateAccount) { // if user clicked btnCreateAccount
			if (isAllVaild()) { // Calls validation method to check if all information entered is valid

				// Disable old buttons and all input fields
				disableAll();
				
				// Saves information to user
				Initialize.user.setFirstName(firstName_txt.getText());
				Initialize.user.setLastName(lastName_txt.getText());
				Initialize.user.setUsername(username_txt.getText().toLowerCase());
				Initialize.user.setPassword(password_ptxt.getText());
				Initialize.user.setStreetNumber(streetNum_txt.getText());
				Initialize.user.setStreetName(streetName_txt.getText());
				Initialize.user.setCity(city_txt.getText());
				Initialize.user.setProvince(province_txt.getText());
				Initialize.user.setCountry("Canada");
				
				// Saves username and password to textfile
				try {
					LoadUserKeys.addUser(username_txt.getText(), password_ptxt.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				System.out.println(Initialize.user.displayBasicUser()); // Delete

				// Enables Home and Setup Profile buttons
				btnHOME.setEnabled(true);
				btnSetupProfile.setEnabled(true);
			}
		} else if (e.getSource() == btnHOME) { // If user clicked btnHOME
			// Create new Home screen (redirect)
//			frame.setVisible(false);  // Set signup to invisible
		} else if (e.getSource() == btnSetupProfile) { // If user clicked btnSetupProfile
			new ProfileScreenGUIScreenOne("Profile Setup"); // Create new screen (redirect)
			frame.setVisible(false); //Set current screen to invisible
		} else if (e.getSource() == tglbtnShowHide) { // If user clicked tglbtnShowHide
			// If state is selected, characters can be seen
			if (tglbtnShowHide.isSelected()) {
				password_ptxt.setEchoChar((char) 0);
				confirmPassword_ptxt.setEchoChar((char) 0);
			// If state is non-selected, characters hidden and replaced with '*'
			} else {
				password_ptxt.setEchoChar('*');
				confirmPassword_ptxt.setEchoChar('*');

			}
		}

	}

	// Validation method - checks if the password and confirm password are the same
	// Returns false if password filed is empty or they do not match
	private boolean isPasswordsSame(String pswd, String confirm) {
		// Checks if password text field is empty, displays appropriate error message, returns false
		if (pswd.isEmpty()) { 
			lblConfirmPasswordError.setText("Enter password above");
			lblConfirmPasswordError.setForeground(Color.RED);
			lblConfirmPasswordError.setVisible(true);
			return false;
		// Checks if the password entered is valid, displays appropriate error message, returns false
		} else if (!validatePassword(pswd)) {
			lblConfirmPasswordError.setText("<html>Please enter a valid <br>password above<html>");
			lblConfirmPasswordError.setForeground(Color.RED);
			lblConfirmPasswordError.setVisible(true);
			return false;
		// Checks if the two passwords are not the same, displays appropriate error message, returns false
		} else if (!pswd.equals(confirm)) {
			lblConfirmPasswordError.setText("Passwords Do not Match");
			lblConfirmPasswordError.setForeground(Color.RED);
			lblConfirmPasswordError.setVisible(true);
			return false;
		}
		// If all the above is false, passwords match
		// Displays success message
		// Returns true
		lblConfirmPasswordError.setText("Passwords Match");
		lblConfirmPasswordError.setForeground(Color.GREEN);
		lblConfirmPasswordError.setVisible(true);
		return true;
	}

	// Checks if any of the text fields are blank
	// Displays an error message beside blank fields by enabling and/or setting JLabels
	// Returns boolean
	private boolean isInfoEmpty(String first, String last, String user, String pswd, String pswdConfirm) {
		// Default set to false
		// If any of the following fields are empty, anyEmpty set to true
		boolean anyEmpty = false;
		
		

		// Checks if first name empty
		if (first.isEmpty()) { 
			lblFirstNameError.setVisible(true);
			anyEmpty = true;
		} else
			lblFirstNameError.setVisible(false);

		// Checks if last name empty
		if (last.isEmpty()) {
			lblLastNameError.setVisible(true);
			anyEmpty = true;
		} else
			lblLastNameError.setVisible(false);

		// Checks if username empty
		if (user.isEmpty()) {
			lblUsernameError.setVisible(true);
			anyEmpty = true;
		} else
			lblUsernameError.setVisible(false);

		// Checks if password empty
		if (pswd.isEmpty()) {
			lblPasswordError.setVisible(true);
			anyEmpty = true;
		} else
			lblPasswordError.setVisible(false);

		// Checks if password confirmation is empty
		if (pswdConfirm.isEmpty()) {
			lblConfirmPasswordError.setText("Enter your Password again");
			lblConfirmPasswordError.setVisible(true);
			anyEmpty = true;
		} else
			lblConfirmPasswordError.setVisible(false);

		// Return boolean
		return anyEmpty;
	}

	// Validates username (At least 5 characters, not already taken)
	// Displays message accordingly
	// Returns boolean
	private boolean validateUsername(String user) {
		// Validates if usernamea already taken
		if (LoadUserKeys.checkUsername(user)) {
			lblUsernameError.setText("Username already taken");
			lblUsernameError.setForeground(Color.RED);
			lblUsernameError.setVisible(true);

			return false;
			
		// Validates if textField is emtpy
		} else if (user.isEmpty()) {
			lblUsernameError.setText("Please Enter a Username");
			lblUsernameError.setForeground(Color.RED);
			lblUsernameError.setVisible(true);

			return false;

		// Validates the length of the username
		} else if (user.length() < 5) {
			lblUsernameError.setText("Username too short");
			lblUsernameError.setForeground(Color.RED);
			lblUsernameError.setVisible(true);
			return false;
		}
		
		// If everything above false - username is valid
		// Displays success message
		// Returns true
		lblUsernameError.setText("Username Valid");
		lblUsernameError.setForeground(Color.GREEN);
		lblUsernameError.setVisible(true);
		return true;
	}

	// Validates password (At least 6 characters, includes 1 lower, 1 upper, 1
	// number
	// Displays message accordingly
	// Returns boolean
	private boolean validatePassword(String pass) {
		// Boolean value default set to true
		// If any of the following fail, isValid set to false
		boolean isValid = true;
		String upperCaseChars = "(.*[A-Z].*)"; // Upper case letters
		String lowerCaseChars = "(.*[a-z].*)"; // Lower case letters
		String numbers = "(.*[0-9].*)"; // Numbers

		// Checks if the password field is empty
		if (pass.isEmpty()) {
			isValid = false;
			lblPasswordError.setText("Please Enter a Password");
			
		// Checks password length
		} else if (pass.length() < 6) {
			isValid = false;
			
		// Checks if password contains an upper case letter 
		} else if (!pass.matches(upperCaseChars)) {
			isValid = false;

		// Checks if password contains a lower case letter
		} else if (!pass.matches(lowerCaseChars)) {
			isValid = false;
		
		// Checks if password contains a number
		} else if (!pass.matches(numbers)) {
			isValid = false;
		// If all of the above fails, password is valid
		// Display success method
		} else {
			lblPasswordError.setText("Password valid");
			lblPasswordError.setForeground(Color.GREEN);
		}

		// If password is empty display error message
		if (!isValid && !pass.isEmpty()) {
			lblPasswordError.setText("Password Invalid");
			lblPasswordError.setForeground(Color.RED);
		}
		lblPasswordError.setVisible(true);

		// Set requirement colors to blue
		if (!isValid)
			lblPasswordReq.setForeground(Color.BLUE);

		return isValid;
	}

	// Validates all information entered
	// Displays message accordingly
	// Disables all previous buttons and fields if successful
	// Returns boolean
	private boolean isAllVaild() {
		// Boolean value default set to true
		// If any of the below evaluate, success set to false
		boolean success = true;
		
		// Checks if any info empty, displays appropriate error message
		if ((isInfoEmpty(firstName_txt.getText(), lastName_txt.getText(), username_txt.getText(),
				password_ptxt.getText(), confirmPassword_ptxt.getText()))) {
			lblSuccessOrError.setText("Please fill out the form properly");
			lblSuccessOrError.setForeground(Color.RED);
			lblSuccessOrError.setVisible(true);
			success = false;
		}
		
		// Checks if username valid, displays appropriate error message
		if (!validateUsername(username_txt.getText())) {
			lblSuccessOrError.setText("Please fill out the form properly");
			lblSuccessOrError.setForeground(Color.RED);
			lblSuccessOrError.setVisible(true);
			success = false;
		}
		
		// Checks if password valid, displays appropriate error message
		if (!validatePassword(password_ptxt.getText())) {
			lblSuccessOrError.setText("Please fill out the form properly");
			lblSuccessOrError.setForeground(Color.RED);
			lblSuccessOrError.setVisible(true);
			success = false;
		}
		// Checks if passwords match, displays appropriate error message 
		if (!isPasswordsSame(password_ptxt.getText(), confirmPassword_ptxt.getText())) {
			lblSuccessOrError.setText("Please fill out the form properly");
			lblSuccessOrError.setForeground(Color.RED);
			lblSuccessOrError.setVisible(true);
			success = false;
		}
		// If success is still true, display success method
		if (success) {
			lblSuccessOrError.setText("SUCCESS! ACCOUNT CREATED");
			lblSuccessOrError.setForeground(new Color(153, 0, 255));
			lblSuccessOrError.setVisible(true);
			
			
//			System.out.println("Account Created: ");
//			System.out.println("First: " + firstName_txt.getText()); // user.toString();
//			System.out.println("Last: " + lastName_txt.getText());
//			System.out.println("User: " + username_txt.getText());
//			System.out.println("Pass: " + password_ptxt.getText());

		}

		// Return boolean
		return success;
	}

	// Disables specified fields
	private void disableAll() {
		firstName_txt.setEnabled(false);
		lastName_txt.setEnabled(false);
		username_txt.setEnabled(false);
		password_ptxt.setEnabled(false);
		confirmPassword_ptxt.setEnabled(false);
		btnCreateAccount.setEnabled(false);
		btnLoginInstead.setEnabled(false);
		tglbtnShowHide.setEnabled(false);
	}
}
