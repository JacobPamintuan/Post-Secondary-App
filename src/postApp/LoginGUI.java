package postApp;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class LoginGUI extends JFrame implements ActionListener, KeyListener{

	// Fields
	
	JFrame frame;
	private JPanel screen;
		
	private JLabel welcomeLbl;
	private JLabel loginLbl;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel errorMessage;

	private JTextField textUsername;

	private JButton btnNewUsersignUp;
	private JButton btnLogIn;

	// Preset error messages
	private String emptyError = "Please enter your username/password";
	private String loginError = "<html><div style='text-align: center;'><html>The username or password <br>you entered is incorrect</div></html>";

	private JToggleButton tglbtnShowHide;
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
		frame.setSize(700,700); // sets the size of the frame
		frame.setTitle("Login");
		frame.setBounds(0,0,700,700);
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
		screen.setBounds(0,0,700,700);
		screen.setLayout(null);

		//Creates welcome label
//		welcomeLbl = new JLabel("<html><div style='text-align: center;'><html>Welcome To the <br>Engineering Program Finder" + "</div></html>");	
		welcomeLbl = new JLabel(new ImageIcon("images/WelcomeLogin.png"));
		
		welcomeLbl.setBounds(0, 32, 700, 200);
		screen.add(welcomeLbl);

		// Login Label
		loginLbl = new JLabel("Log into Program Finder");
		loginLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		loginLbl.setBounds(170, 291, 205, 16);
		screen.add(loginLbl);

		// Username label
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(170, 319, 205, 16);
		screen.add(lblUsername);

		// Username textfield - where user inputs username
		textUsername = new JTextField();
		textUsername.setBounds(170, 347, 189, 26);
		screen.add(textUsername);
		textUsername.addKeyListener(this);
		textUsername.setColumns(10);

		// Password label
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(170, 391, 205, 16);
		screen.add(lblPassword);
		 
		// Password passwordField - where user inputs Password
		// Text can be hidden or displayed
		passwordField = new JPasswordField();
		passwordField.setBounds(170, 419, 189, 26);
		passwordField.addKeyListener(this);
		screen.add(passwordField);

		// Error message - invisible unless error occurs
		errorMessage = new JLabel();
		errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		errorMessage.setText("\"ERROR\"");
		errorMessage.setForeground(new Color(153, 0, 255));
		errorMessage.setBounds(170, 471, 312, 49);
		screen.add(errorMessage);
		errorMessage.setVisible(false);

		// JButton new user/signup - takes user to signup page
		btnNewUsersignUp = new JButton("New User/Sign Up");
		btnNewUsersignUp.addActionListener(this);
		btnNewUsersignUp.setBounds(170, 535, 174, 29);
		screen.add(btnNewUsersignUp);

		// JButton Login
		// Validates username and password,
			//	Displays error message or redirects to home page
		btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(this);
		btnLogIn.setBounds(365, 535, 117, 29);
		screen.add(btnLogIn);
		
		// JToggleButton - hides and shows password		
		tglbtnShowHide = new JToggleButton("Show/Hide");
		tglbtnShowHide.addActionListener(this);
		tglbtnShowHide.setBounds(365, 419, 117, 29);
		screen.add(tglbtnShowHide);
		
		screen.setBackground(Color.lightGray);
				
		frame.repaint();
	}
	
	
	// ActionPerformed - if any button is clicked
	public void actionPerformed(ActionEvent event){
		
		//If btnNewUserSignup is clicked, user is "redirected" to signup screen
		if(event.getSource()==btnNewUsersignUp) { 
			SignUp signUp = new SignUp(); // Creates new screen
			frame.setVisible(false); // Hides current screen
		}
		// If btnLogIn is clicked, information is validated, then user is "redirected" to main screen
		else if(event.getSource()==btnLogIn) {
			try {
				// Checks if username exists and if the password matches the username
				if(LoadUserKeys.checkUsername(username.toLowerCase())&&LoadUserKeys.checkPassword(username.toLowerCase(), password)) {
					System.out.println("Welcome");
//					new MainScreen();
					frame.setVisible(false); // Hides current screen
				}
				// Checks if the username or password is empty, displays error message
				else if(username.length()==0||password.length()==0) {
					errorMessage.setText(emptyError);
					errorMessage.setVisible(true);
				}
				// Else - login was unsuccessful, display error message
				else {
					errorMessage.setText(loginError);
					errorMessage.setVisible(true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		}
		// If tglbtnShowHide is clicked - shows or hides password
		else if(event.getSource()==tglbtnShowHide) {
			// If state is selected, characters can be seen
			if(tglbtnShowHide.isSelected())
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
		username = textUsername.getText().toLowerCase();
		password = passwordField.getText();
		System.out.println(username +" "+password);
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}