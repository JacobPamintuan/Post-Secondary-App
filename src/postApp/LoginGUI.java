package postApp;

import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class LoginGUI {

	JFrame frame;

	private JLabel welcomeLbl;
	private JLabel loginLbl;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel errorMessage;

	private JTextField textUsername;

	private JButton btnNewUsersignUp;
	private JButton btnLogIn;

	private String emptyError = "Please enter your username/password";
	private String loginError = "The username or password you entered is incorrect.";
	private JToggleButton tglbtnShowhide;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginGUI window = new LoginGUI();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Login");
		frame.setBounds(0, 0, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//Creates welcome label
		welcomeLbl = new JLabel("<html><div style='text-align: center;'>"
				+ "<html>Welcome To the <br>Engineering Program Finder" + "</div></html>");
		welcomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLbl.setBounds(269, 32, 167, 100);
		frame.getContentPane().add(welcomeLbl);

		// Login Label
		loginLbl = new JLabel("Log into Program Finder");
		loginLbl.setBounds(177, 136, 205, 16);
		frame.getContentPane().add(loginLbl);

		// Username label
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(177, 164, 205, 16);
		frame.getContentPane().add(lblUsername);

		// Username textfield - where user inputs username
		textUsername = new JTextField();
		textUsername.setBounds(177, 192, 189, 26);
		frame.getContentPane().add(textUsername);
		textUsername.setColumns(10);

		// Password label
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(177, 236, 205, 16);
		frame.getContentPane().add(lblPassword);
		 
		// Password passwordField - where user inputs Password
		// Text can be hidden or displayed
		passwordField = new JPasswordField();
		passwordField.setBounds(177, 264, 189, 26);
		frame.getContentPane().add(passwordField);

		// Error message - invisible unless error occurs
		errorMessage = new JLabel();
		errorMessage.setForeground(Color.RED);
		errorMessage.setBounds(177, 331, 336, 16);
		frame.getContentPane().add(errorMessage);
		errorMessage.setVisible(false);

		// JButton new user/signup - takes user to signup page
		btnNewUsersignUp = new JButton("New User/Sign Up");
		btnNewUsersignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signUp = new SignUp();
				frame.setVisible(false);
			}
		});
		btnNewUsersignUp.setBounds(155, 380, 174, 29);
		frame.getContentPane().add(btnNewUsersignUp);

		// JButton Login
		// Validates username and password,
		//		Displays error message or redirects to home page
		btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isLoginEmpty(textUsername.getText(), passwordField.getText())) {
					errorMessage.setText(emptyError);
					errorMessage.setVisible(true);
				} else if (validate(textUsername.getText(), passwordField.getText())) {
					System.out.println(textUsername.getText() + "\n" + passwordField.getText());
				} else {
					errorMessage.setText(loginError);
					errorMessage.setVisible(true);
				}

			}
		});
		btnLogIn.setBounds(416, 380, 117, 29);
		frame.getContentPane().add(btnLogIn);
		
		// JToggleButton - hides and shows password		
		tglbtnShowhide = new JToggleButton("Show/Hide");
		tglbtnShowhide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If state is selected, characters can be seen
				if(tglbtnShowhide.isSelected()) {
					passwordField.setEchoChar((char)0);
				// If state is non-selected, characters hidden and replaced with '*'
				} else {
					passwordField.setEchoChar('*');
				}
			}
		});
		tglbtnShowhide.setBounds(372, 264, 161, 29);
		frame.getContentPane().add(tglbtnShowhide);
	}

	// Checks if either user or password is empty
	private boolean isLoginEmpty(String user, String pswd) {
		if (user.isEmpty() || pswd.isEmpty())
			return true;
		return false;
	}

	// Validates if username exists, validates if password matches
	private boolean validate(String user, String pswd) {
		return false;

	}
}
