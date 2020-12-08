package postApp;

import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LoginGUI {

	private JFrame frame;
	private JTextField textUsername;
	private JTextField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frame = new JFrame();
		frame.setBounds(700, 700, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel welcomeLbl = new JLabel("<html><div style='text-align: center;'>" + "<html>Welcome To the <br>Engineering Program Finder" +  "</div></html>");
		welcomeLbl.setBounds(269, 32, 167, 100);
		frame.getContentPane().add(welcomeLbl);
		
		JLabel loginLbl = new JLabel("Log into Program Finder");
		loginLbl.setBounds(177, 136, 205, 16);
		frame.getContentPane().add(loginLbl);
		
		JLabel usernameLbl = new JLabel("Username:");
		usernameLbl.setBounds(177, 164, 205, 16);
		frame.getContentPane().add(usernameLbl);
		
		textUsername = new JTextField();
		textUsername.setBounds(177, 192, 189, 26);
		frame.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(177, 236, 205, 16);
		frame.getContentPane().add(lblPassword);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(177, 265, 189, 26);
		frame.getContentPane().add(textPassword);
		
		JLabel errorMessage = new JLabel("The username or password you entered is incorrect.");
		errorMessage.setBounds(189, 331, 336, 16);
		frame.getContentPane().add(errorMessage);
		
		JButton btnNewUsersignUp = new JButton("New User/Sign Up");
		btnNewUsersignUp.setBounds(155, 380, 174, 29);
		frame.getContentPane().add(btnNewUsersignUp);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(416, 380, 117, 29);
		frame.getContentPane().add(btnLogIn);
	}
}
