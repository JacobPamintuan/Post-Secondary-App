package postApp;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class UniversityQuiz {

	JFrame frame;

	/**
	 * Create the application.
	 */
	public UniversityQuiz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1920, 1080);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
