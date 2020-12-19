package postApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI extends JFrame implements ActionListener, KeyListener{

	// Fields
	
	JFrame frame;
	private JPanel screen;
	private JLabel logInScreen;	

	private JButton signUpButton;
	private JButton logInButton;
	private JToggleButton showHidePassword;
	private JTextField textUsername;
	private JPasswordField passwordField;
	
	private String username="";
	private String password="";


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
	private void initialize() {
		
		screen.setBorder(null);
		screen.setBounds(0,0,Initialize.WIDTH,Initialize.HEIGHT);
		screen.setLayout(null);

		// Username textfield - where user inputs username
		textUsername = new JTextField();
		textUsername.setBounds(390, 255, 220, 26);
		textUsername.addKeyListener(this);
		textUsername.setBackground(Color.DARK_GRAY);
		textUsername.setForeground(Color.WHITE);
		textUsername.setColumns(10);
		textUsername.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textUsername.setText("   ");
		screen.add(textUsername);

		
		// Password passwordField - where user inputs Password
		// Text can be hidden or displayed
		passwordField = new JPasswordField();
		passwordField.setBounds(390, 345, 220, 26);
		passwordField.addKeyListener(this);
		passwordField.setBackground(Color.DARK_GRAY);
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		passwordField.setForeground(Color.WHITE);
		screen.add(passwordField);

		
		
		// JButton new user/signup - takes user to signup page
		signUpButton = new JButton();
		signUpButton.addActionListener(this);
		signUpButton.setBounds(270, 420, 90, 30);
		signUpButton.setOpaque(false); 
		signUpButton.setContentAreaFilled(false);
		signUpButton.setBorderPainted(false);
		screen.add(signUpButton);

		// JButton Login
		// Validates username and password,
			//	Displays error message or redirects to home page
		logInButton = new JButton();
		logInButton.addActionListener(this);
		logInButton.setBounds(600, 420, 80, 30);
		logInButton.setOpaque(false); 
		logInButton.setContentAreaFilled(false);
		logInButton.setBorderPainted(false);
		screen.add(logInButton);
		
		// JToggleButton - hides and shows password		
		showHidePassword = new JToggleButton();
		showHidePassword.addActionListener(this);
		showHidePassword.setBounds(240, 350, 30, 20);
		showHidePassword.setOpaque(false); 
		showHidePassword.setContentAreaFilled(false);
		showHidePassword.setBorderPainted(false);
		screen.add(showHidePassword);
		
		logInScreen=new JLabel();
		logInScreen.setBounds(0, 0,Initialize.WIDTH,Initialize.HEIGHT);
		logInScreen.setIcon(LoadImages.loginGUIImages[0]);
		logInScreen.setVisible(true);
		screen.add(logInScreen);
		
				
		frame.repaint();
	}
	
	
	// ActionPerformed - if any button is clicked
	public void actionPerformed(ActionEvent event){
		
		//If btnNewUserSignup is clicked, user is "redirected" to signup screen
		if(event.getSource()==signUpButton) { 
			new SignUp(); // Creates new screen
			frame.setVisible(false); // Hides current screen
		}
		
		// If logInButton is clicked, information is validated, then user is "redirected" to main screen
		else if(event.getSource()==logInButton) { 
			try {
				// Checks if username exists and if the password matches the username
				if(UserKeys.checkUsername(username)&&UserKeys.checkPassword(username, password)) {
					new MainGUI();
					Initialize.isReturningUser=true;
					frame.setVisible(false); // Hides current screen
				}
				// Checks if the username or password is empty, displays error message
				else if(username.length()==0||password.length()==0) {
					logInScreen.setIcon(LoadImages.loginGUIImages[1]);
					frame.repaint();
				}
				// Else - login was unsuccessful, display error message
				else {
					logInScreen.setIcon(LoadImages.loginGUIImages[2]);
					frame.repaint();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		}
		// If showHidePassword is clicked - shows or hides password
		else if(event.getSource()==showHidePassword) {
			// If state is selected, characters can be seen
			if(showHidePassword.isSelected())
				passwordField.setEchoChar((char)0);
			// If state is non-selected, characters hidden and replaced with '*'
			else
				passwordField.setEchoChar('*');
				
		}
		
		
	}
	

	// KeyListeners
	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		username = textUsername.getText().trim().toLowerCase();
		password = passwordField.getText().trim();
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}