package postApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
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

	private JLabel lblFirstNameError;
	private JLabel lblLastNameError;
	private JLabel lblUsernameError;
	private JLabel lblPasswordError;
	private JLabel lblConfirmPasswordError;
	private JLabel lblSuccessOrError;

	private JToggleButton tglbtnShowhide;

	private JButton btnLoginInstead;
	private JButton btnCreateAccount;
	private JButton btnHOME;
	private JButton btnSetupProfile;

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		// JLabel Signup - Title
		lblSignUp = new JLabel(
				"<html><div style='text-align: center;'><html>Sign-Up for The Engineering<br>Program Finder</div></html>");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setBounds(213, 40, 211, 100);
		frame.add(lblSignUp);

		// JLabel First name
		lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(163, 141, 88, 16);
		frame.add(lblFirstName);

		firstName_txt = new JTextField();
		firstName_txt.setBounds(159, 159, 288, 26);
		frame.add(firstName_txt);
		firstName_txt.setColumns(10);

		// JLabel last name
		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(163, 187, 88, 16);
		frame.add(lblLastName);

		lastName_txt = new JTextField();
		lastName_txt.setColumns(10);
		lastName_txt.setBounds(159, 205, 288, 26);
		frame.add(lastName_txt);

		// JLabel Username
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(163, 243, 88, 16);
		frame.add(lblUsername);

		username_txt = new JTextField();
		username_txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validateUsername(username_txt.getText());
			}
		});
		username_txt.setColumns(10);
		username_txt.setBounds(159, 261, 288, 26);
		frame.add(username_txt);

		// JLabel Username requirements
		lblUsernameReq = new JLabel("At least 5 characters long");
		lblUsernameReq.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblUsernameReq.setBounds(169, 295, 169, 16);
		frame.add(lblUsernameReq);

		// JLabel Password
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(163, 321, 88, 16);
		frame.add(lblPassword);

		password_ptxt = new JPasswordField();
		password_ptxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validatePassword(password_ptxt.getText());
			}
		});
		password_ptxt.setColumns(10);
		password_ptxt.setBounds(159, 339, 288, 26);
		frame.add(password_ptxt);

		// JLabel Confirm password
		lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(163, 377, 165, 16);
		frame.add(lblConfirmPassword);

		confirmPassword_ptxt = new JPasswordField();
		confirmPassword_ptxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				isPasswordsSame(password_ptxt.getText(), confirmPassword_ptxt.getText());

			}
		});
		confirmPassword_ptxt.setColumns(10);
		confirmPassword_ptxt.setBounds(159, 395, 288, 26);
		frame.add(confirmPassword_ptxt);

		// JLabel Passowrd Requirements
		lblPasswordReq = new JLabel("<html>Use 6 or more characters." + "<br>Must include:" + "<br>1 UPPERCASE letter,"
				+ "<br>1 lowercase letter, and" + "<br>1 number");
		lblPasswordReq.setVerticalAlignment(SwingConstants.TOP);
		lblPasswordReq.setBounds(163, 433, 165, 97);
		frame.add(lblPasswordReq);

		// JButton Login Instead
		// Exits Sign-up screen and returns to login screen
		btnLoginInstead = new JButton("Login Instead");
		btnLoginInstead.addActionListener(this); // ActionListener
		btnLoginInstead.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnLoginInstead.setBounds(159, 542, 117, 29);
		frame.add(btnLoginInstead);

		// JButton Create Account
		// Creates a new user/account if all entered information is valid
		btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(this); // ActionListener
		btnCreateAccount.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnCreateAccount.setBounds(330, 541, 117, 29);
		frame.add(btnCreateAccount);

		// JButton HOME
		// Takes user to Home page (only enabled after account creation)
		btnHOME = new JButton("HOME");
		btnHOME.addActionListener(this); // ActionListener
		btnHOME.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnHOME.setBounds(159, 611, 117, 29);
		btnHOME.setEnabled(false);
		frame.add(btnHOME);

		// JButton Set-up profile
		// Takes user to profile setup screen
		btnSetupProfile = new JButton("Setup Profile");
		btnSetupProfile.addActionListener(this); // ActionListener
		btnSetupProfile.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnSetupProfile.setBounds(330, 610, 117, 29);
		btnSetupProfile.setEnabled(false);
		frame.add(btnSetupProfile);

		// JLabel - Error Messages
		// First Name Error
		lblFirstNameError = new JLabel("Please Enter Your First Name");
		lblFirstNameError.setForeground(Color.RED);
		lblFirstNameError.setBounds(474, 164, 188, 16);
		lblFirstNameError.setVisible(false);
		frame.add(lblFirstNameError);

		// Last Name Error
		lblLastNameError = new JLabel("Please Enter Your Last Name");
		lblLastNameError.setForeground(Color.RED);
		lblLastNameError.setBounds(474, 210, 188, 16);
		lblLastNameError.setVisible(false);
		frame.add(lblLastNameError);

		// Username Error
		lblUsernameError = new JLabel("Please Enter A Username");
		lblUsernameError.setForeground(Color.RED);
		lblUsernameError.setBounds(474, 266, 188, 16);
		lblUsernameError.setVisible(false);
		frame.add(lblUsernameError);

		// Password Error
		lblPasswordError = new JLabel("Please Enter A Password");
		lblPasswordError.setForeground(Color.RED);
		lblPasswordError.setBounds(474, 344, 188, 16);
		lblPasswordError.setVisible(false);
		frame.add(lblPasswordError);

		// Confirm Password Error
		lblConfirmPasswordError = new JLabel("Passwords do not match");
		lblConfirmPasswordError.setForeground(Color.RED);
		lblConfirmPasswordError.setBounds(474, 400, 220, 16);
		lblConfirmPasswordError.setVisible(false);
		frame.add(lblConfirmPasswordError);

		// Success or Error Label
		lblSuccessOrError = new JLabel("SUCESS/ERROR");
		lblSuccessOrError.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuccessOrError.setBounds(179, 583, 255, 16);
		lblSuccessOrError.setVisible(false);
		frame.add(lblSuccessOrError);

		// JToggleButton - Show/Hide
		// Shows the password if button is selected, hides and replaces with '*'
		// otherwise
		tglbtnShowhide = new JToggleButton("Show/Hide");
		tglbtnShowhide.addActionListener(this); // ActionListener
		tglbtnShowhide.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		tglbtnShowhide.setBounds(338, 373, 96, 29);
		frame.add(tglbtnShowhide);

		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLoginInstead) {
			LoginGUI login = new LoginGUI();
			login.frame.setVisible(true);
			frame.setVisible(false);
		} else if (e.getSource() == btnCreateAccount) {
			if (isAllVaild()) {
				// Create new user object
				// Person person = new Person();
				Initialize.user.setFirstName(firstName_txt.getText());
				Initialize.user.setLastName(lastName_txt.getText());
				Initialize.user.setUsername(username_txt.getText().toLowerCase());
				Initialize.user.setPassword(password_ptxt.getText());
				
				try {
					UserKeys.addUser(username_txt.getText(), password_ptxt.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				System.out.println(Initialize.user.displayBasicUser());

				btnHOME.setEnabled(true);
				btnSetupProfile.setEnabled(true);
			}
		} else if (e.getSource() == btnHOME) {

		} else if (e.getSource() == btnSetupProfile) {
			// ProfileScreenGUIScreenOne setUp = new ProfileScreenGUIScreenOne();
			UniversityQuiz quiz = new UniversityQuiz();
			quiz.frame.setVisible(true);

			System.out.println("\nGo to profile screen");
			frame.setVisible(false);
		} else if (e.getSource() == tglbtnShowhide) {
			// If state is selected, characters can be seen
			if (tglbtnShowhide.isSelected()) {
				password_ptxt.setEchoChar((char) 0);
				confirmPassword_ptxt.setEchoChar((char) 0);
				// If state is non-selected, characters hidden and replaced with '*'
			} else {
				password_ptxt.setEchoChar('*');
				confirmPassword_ptxt.setEchoChar('*');

			}
		}

	}

	private boolean isPasswordsSame(String pswd, String confirm) {
		if (pswd.isEmpty()) {
			lblConfirmPasswordError.setText("Enter password above");
			lblConfirmPasswordError.setForeground(Color.RED);
			lblConfirmPasswordError.setVisible(true);
			return false;

		} else if (!validatePassword(pswd)) {
			lblConfirmPasswordError.setText("Please enter valid password above");
			lblConfirmPasswordError.setForeground(Color.RED);
			lblConfirmPasswordError.setVisible(true);
			return false;
		} else if (!pswd.equals(confirm)) {
			lblConfirmPasswordError.setText("Passwords Do not Match");
			lblConfirmPasswordError.setForeground(Color.RED);
			lblConfirmPasswordError.setVisible(true);
			return false;
		}
		lblConfirmPasswordError.setText("Passwords Match");
		lblConfirmPasswordError.setForeground(Color.GREEN);
		lblConfirmPasswordError.setVisible(true);
		return true;
	}

	// Checks if any of the text fields are blank
	// Displays an error message beside blank fields by enabling and/or setting
	// JLabels
	// Returns boolean
	private boolean isInfoEmpty(String first, String last, String user, String pswd, String pswdConfirm) {
		boolean anyEmpty = false;

		if (first.isEmpty()) {
			lblFirstNameError.setVisible(true);
			anyEmpty = true;
		} else
			lblFirstNameError.setVisible(false);

		if (last.isEmpty()) {
			lblLastNameError.setVisible(true);
			anyEmpty = true;
		} else
			lblLastNameError.setVisible(false);

		if (user.isEmpty()) {
			lblUsernameError.setVisible(true);
			anyEmpty = true;
		} else
			lblUsernameError.setVisible(false);

		if (pswd.isEmpty()) {
			lblPasswordError.setVisible(true);
			anyEmpty = true;
		} else
			lblPasswordError.setVisible(false);

		if (pswdConfirm.isEmpty()) {
			lblConfirmPasswordError.setText("Enter your Password again");
			lblConfirmPasswordError.setVisible(true);
			anyEmpty = true;
		} else
			lblConfirmPasswordError.setVisible(false);

		return anyEmpty;
	}

	// Validates username (At least 5 characters, not already taken)
	// Displays message accordingly
	// Returns boolean
	private boolean validateUsername(String user) {
		if (UserKeys.checkUsername(user)) {
			lblUsernameError.setText("Username already taken");
			lblUsernameError.setForeground(Color.RED);
			lblUsernameError.setVisible(true);

			return false;
		} else if (user.isEmpty()) {
			lblUsernameError.setText("Please Enter a Username");
			lblUsernameError.setForeground(Color.RED);
			lblUsernameError.setVisible(true);

			return false;

		} else if (user.length() < 5) {
			lblUsernameError.setText("Username too short");
			lblUsernameError.setForeground(Color.RED);
			lblUsernameError.setVisible(true);
			return false;
		}
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
		boolean isValid = true;
		String upperCaseChars = "(.*[A-Z].*)"; // Upper case
		String lowerCaseChars = "(.*[a-z].*)"; // Lower case
		String numbers = "(.*[0-9].*)"; // Numbers

		if (pass.isEmpty()) {
			isValid = false;
			lblPasswordError.setText("Please Enter a Password");
		} else if (pass.length() < 6) {
			isValid = false;
		} else if (!pass.matches(upperCaseChars)) {
			isValid = false;
		} else if (!pass.matches(lowerCaseChars)) {
			isValid = false;
		} else if (!pass.matches(numbers)) {
			isValid = false;
		} else {
			lblPasswordError.setText("Password valid");
			lblPasswordError.setForeground(Color.GREEN);
		}

		if (!isValid && !pass.isEmpty()) {
			lblPasswordError.setText("Password Invalid");
			lblPasswordError.setForeground(Color.RED);
		}
		lblPasswordError.setVisible(true);

		if (!isValid)
			lblPasswordReq.setForeground(Color.BLUE);

		return isValid;
	}

	// Validates all information entered
	// Displays message accordingly
	// Disables all previous buttons and fields if successful
	// Returns boolean
	private boolean isAllVaild() {
		boolean success = true;
		if ((isInfoEmpty(firstName_txt.getText(), lastName_txt.getText(), username_txt.getText(),
				password_ptxt.getText(), confirmPassword_ptxt.getText()))) {
			lblSuccessOrError.setText("Please fill out the form properly");
			lblSuccessOrError.setForeground(Color.RED);
			lblSuccessOrError.setVisible(true);
			success = false;
		}
		if (!validateUsername(username_txt.getText())) {
			lblSuccessOrError.setText("Please fill out the form properly");
			lblSuccessOrError.setForeground(Color.RED);
			lblSuccessOrError.setVisible(true);
			success = false;
		}
		if (!validatePassword(password_ptxt.getText())) {
			lblSuccessOrError.setText("Please fill out the form properly");
			lblSuccessOrError.setForeground(Color.RED);
			lblSuccessOrError.setVisible(true);
			success = false;
		}
		if (!isPasswordsSame(password_ptxt.getText(), confirmPassword_ptxt.getText())) {
			lblSuccessOrError.setText("Please fill out the form properly");
			lblSuccessOrError.setForeground(Color.RED);
			lblSuccessOrError.setVisible(true);
			success = false;
		}
		if (success) {
			lblSuccessOrError.setText("SUCCESS! ACCOUNT CREATED");
			lblSuccessOrError.setForeground(Color.GREEN);
			lblSuccessOrError.setVisible(true);
			disableAll();
			
			
//			System.out.println("Account Created: ");
//			System.out.println("First: " + firstName_txt.getText()); // user.toString();
//			System.out.println("Last: " + lastName_txt.getText());
//			System.out.println("User: " + username_txt.getText());
//			System.out.println("Pass: " + password_ptxt.getText());

		}

		return success;
	}

	// Disables specified buttons
	private void disableAll() {
		firstName_txt.setEnabled(false);
		lastName_txt.setEnabled(false);
		username_txt.setEnabled(false);
		password_ptxt.setEnabled(false);
		confirmPassword_ptxt.setEnabled(false);
		btnCreateAccount.setEnabled(false);
		btnLoginInstead.setEnabled(false);
		tglbtnShowhide.setEnabled(false);
	}
}
