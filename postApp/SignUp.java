package postApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp {

	private JFrame frame;
	private JTextField textField_FirstName;
	private JTextField textField_LastName;
	private JLabel lblUsername;
	private JTextField textField_Username;
	private JLabel lblUsernameReq;
	private JTextField textField_Password;
	private JLabel lblConfirmPassword;
	private JTextField textField_ConfirmPassword;
	private JLabel lblPasswordRequirements;
	private JButton btnCheckValidity;
	private JButton btnLoginInstead;
	private JButton btnCreateAccount;
	private JButton btnHOME;
	private JButton btnCheckValidity_4;
	private JLabel lblFirstNameError;
	private JLabel lblLastNameError;
	private JLabel lblUsernameError;
	private JLabel lblPasswordError;
	private JLabel lblConfirmPasswordError;
	private JLabel lblSuccesOrError;
	private JLabel lblSignUp;

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
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.RED);
		frame.setBounds(0, 0, 700, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblSignUp = new JLabel("<html><div style='text-align: center;'><html>Sign-Up for The Engineering<br>Program Finder</div></html>");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setBounds(213, 40, 211, 100);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(163, 141, 88, 16);
		frame.getContentPane().add(lblFirstName);
		
		textField_FirstName = new JTextField();
		textField_FirstName.setBounds(159, 159, 288, 26);
		frame.getContentPane().add(textField_FirstName);
		textField_FirstName.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(163, 187, 88, 16);
		frame.getContentPane().add(lblLastName);

		textField_LastName = new JTextField();
		textField_LastName.setColumns(10);
		textField_LastName.setBounds(159, 205, 288, 26);
		frame.getContentPane().add(textField_LastName);

		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(163, 243, 88, 16);
		frame.getContentPane().add(lblUsername);

		textField_Username = new JTextField();
		textField_Username.setColumns(10);
		textField_Username.setBounds(159, 261, 288, 26);
		frame.getContentPane().add(textField_Username);

		lblUsernameReq = new JLabel("At least 5 characters long");
		lblUsernameReq.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblUsernameReq.setBounds(169, 295, 169, 16);
		frame.getContentPane().add(lblUsernameReq);

		JButton btnCheckAvailability = new JButton("Check Availability");
		btnCheckAvailability.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnCheckAvailability.setBounds(330, 290, 117, 29);
		frame.getContentPane().add(btnCheckAvailability);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(163, 321, 88, 16);
		frame.getContentPane().add(lblPassword);

		textField_Password = new JTextField();
		textField_Password.setColumns(10);
		textField_Password.setBounds(159, 339, 288, 26);
		frame.getContentPane().add(textField_Password);

		lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(163, 377, 165, 16);
		frame.getContentPane().add(lblConfirmPassword);

		textField_ConfirmPassword = new JTextField();
		textField_ConfirmPassword.setColumns(10);
		textField_ConfirmPassword.setBounds(159, 395, 288, 26);
		frame.getContentPane().add(textField_ConfirmPassword);

		lblPasswordRequirements = new JLabel(
				"<html>Use 6 or more characters.<br>Must include:<br>1 UPPERCASE letter,<br>1 lowercase letter, and<br>1 number");
		lblPasswordRequirements.setVerticalAlignment(SwingConstants.TOP);
		lblPasswordRequirements.setBounds(163, 433, 165, 97);
		frame.getContentPane().add(lblPasswordRequirements);

		btnCheckValidity = new JButton("Check Validity");
		btnCheckValidity.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnCheckValidity.setBounds(330, 428, 117, 29);
		frame.getContentPane().add(btnCheckValidity);

		btnLoginInstead = new JButton("Login Instead");
		btnLoginInstead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI login = new LoginGUI();
				login.frame.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnLoginInstead.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnLoginInstead.setBounds(159, 542, 117, 29);
		frame.getContentPane().add(btnLoginInstead);

		btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnCreateAccount.setBounds(330, 541, 117, 29);
		frame.getContentPane().add(btnCreateAccount);

		btnHOME = new JButton("HOME");
		btnHOME.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnHOME.setBounds(159, 611, 117, 29);
		frame.getContentPane().add(btnHOME);

		btnCheckValidity_4 = new JButton("Setup Profile");
		btnCheckValidity_4.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnCheckValidity_4.setBounds(330, 610, 117, 29);
		frame.getContentPane().add(btnCheckValidity_4);

		lblFirstNameError = new JLabel("Please Enter Your First Name");
		lblFirstNameError.setForeground(Color.RED);
		lblFirstNameError.setBounds(474, 164, 188, 16);
		frame.getContentPane().add(lblFirstNameError);

		lblLastNameError = new JLabel("Please Enter Your Last Name");
		lblLastNameError.setForeground(Color.RED);
		lblLastNameError.setBounds(474, 210, 188, 16);
		frame.getContentPane().add(lblLastNameError);

		lblUsernameError = new JLabel("Please Enter A Username");
		lblUsernameError.setForeground(Color.RED);
		lblUsernameError.setBounds(474, 266, 188, 16);
		frame.getContentPane().add(lblUsernameError);

		lblPasswordError = new JLabel("Please Enter A Password");
		lblPasswordError.setForeground(Color.RED);
		lblPasswordError.setBounds(474, 344, 188, 16);
		frame.getContentPane().add(lblPasswordError);

		lblConfirmPasswordError = new JLabel("Passwords do not match");
		lblConfirmPasswordError.setForeground(Color.RED);
		lblConfirmPasswordError.setBounds(474, 400, 188, 16);
		frame.getContentPane().add(lblConfirmPasswordError);

		lblSuccesOrError = new JLabel("SUCESS/ERROR");
		lblSuccesOrError.setBounds(213, 583, 188, 16);
		frame.getContentPane().add(lblSuccesOrError);

		frame.getContentPane().add(lblSignUp);
		frame.setVisible(true);
	}
}
