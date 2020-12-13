package postApp;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class LoginGUI extends JFrame implements ActionListener, KeyListener{

	private JFrame frame;
	private JPanel screen;
	
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
	
	private String username="";
	private String password="";
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public LoginGUI() {
		frameSetup();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void frameSetup() {
		frame = new JFrame();
		screen = new JPanel();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //program will end when exited
		frame.setSize(700,700); // sets the size of the frame
		frame.setTitle("Login");
		frame.setBounds(0,0,700,700);
		frame.setLayout(null);
		frame.setResizable(false); // can't resize
		frame.add(screen); // add panel to the frame
		frame.validate();
		frame.repaint();
		frame.setVisible(true); 
		frame.addKeyListener(this);
		
	}
	private void initialize() {
		
		screen.setBorder(null);
		screen.setBounds(0,0,700,700);
		screen.setLayout(null);

		//Creates welcome label
		welcomeLbl = new JLabel("<html><div style='text-align: center;'>"
				+ "<html>Welcome To the <br>Engineering Program Finder" + "</div></html>");
		welcomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLbl.setBounds(269, 32, 167, 100);
		screen.add(welcomeLbl);

		// Login Label
		loginLbl = new JLabel("Log into Program Finder");
		loginLbl.setBounds(177, 136, 205, 16);
		screen.add(loginLbl);

		// Username label
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(177, 164, 205, 16);
		screen.add(lblUsername);

		// Username textfield - where user inputs username
		textUsername = new JTextField();
		textUsername.setBounds(177, 192, 189, 26);
		screen.add(textUsername);
		textUsername.addKeyListener(this);
		textUsername.setColumns(10);

		// Password label
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(177, 236, 205, 16);
		screen.add(lblPassword);
		 
		// Password passwordField - where user inputs Password
		// Text can be hidden or displayed
		passwordField = new JPasswordField();
		passwordField.setBounds(177, 264, 189, 26);
		passwordField.addKeyListener(this);
		screen.add(passwordField);

		// Error message - invisible unless error occurs
		errorMessage = new JLabel();
		errorMessage.setForeground(Color.RED);
		errorMessage.setBounds(177, 331, 336, 16);
		screen.add(errorMessage);
		errorMessage.setVisible(false);

		// JButton new user/signup - takes user to signup page
		btnNewUsersignUp = new JButton("New User/Sign Up");
		btnNewUsersignUp.addActionListener(this);
		btnNewUsersignUp.setBounds(155, 380, 174, 29);
		screen.add(btnNewUsersignUp);

		// JButton Login
		// Validates username and password,
			//	Displays error message or redirects to home page
		btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(this);
		btnLogIn.setBounds(416, 380, 117, 29);
		screen.add(btnLogIn);
		
		// JToggleButton - hides and shows password		
		tglbtnShowhide = new JToggleButton("Show/Hide");
		tglbtnShowhide.addActionListener(this);
		tglbtnShowhide.setBounds(372, 264, 161, 29);
		screen.add(tglbtnShowhide);
		frame.repaint();
	}
	
	
	public void actionPerformed(ActionEvent event){
		if(event.getSource()==btnNewUsersignUp) {
//			SignUp signUp = new SignUp();
			frame.setVisible(false);
		}
		else if(event.getSource()==btnLogIn) {
			try {
				if(UserKeys.checkUsername(username)&&UserKeys.checkPassword(username, password)) {
					System.out.println("Welcome");
//					new MainScreen();
					frame.setVisible(false);
				}
				else if(username.length()==0||password.length()==0) {
					errorMessage.setText(emptyError);
					errorMessage.setVisible(true);
				}
				else {
					errorMessage.setText(loginError);
					errorMessage.setVisible(true);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		else if(event.getSource()==tglbtnShowhide) {
			// If state is selected, characters can be seen
			if(tglbtnShowhide.isSelected())
				passwordField.setEchoChar((char)0);
			// If state is non-selected, characters hidden and replaced with '*'
			else
				passwordField.setEchoChar('*');
				
		}
		
		
	}
	

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		username = textUsername.getText();
		password = passwordField.getText();
		System.out.println(username +" "+password);
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
