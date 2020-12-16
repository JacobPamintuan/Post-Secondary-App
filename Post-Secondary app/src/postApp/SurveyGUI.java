package postApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SurveyGUI extends JFrame implements ActionListener {

	private JLabel[] questions = new JLabel[15];
	private JRadioButton[][] options = new JRadioButton[15][5];
	private JButton submitButton;
	
	private static JFrame surveyFrame;

	private ButtonGroup group = new ButtonGroup();

	private int[] programs = new int[16];

	/*
	 * private final int MECHANICAL = 0; private final int COMPENG = 1; private
	 * final int COMPSCISOFTWARE = 2; private final int CHEMICAL = 3; private final
	 * int ELECTRICAL = 4; private final int CIVIL = 5; private final int BIOMEDICAL
	 * = 6; private final int AEROSPACE = 7; private final int ARCHITECTURAL = 8;
	 * private final int ENGSCI = 9; private final int GEOLOGICAL = 10; private
	 * final int ENVIRONMENTAL = 11; private final int MINING = 12; private final
	 * int MANAGEMENT = 13; private final int SYSTEMS = 14; private final int NANO =
	 * 15;
	 */

	public SurveyGUI() {
		surveyFrame = new JFrame();
		frameSetup();
		setFrame();

		for (int i : programs)
			programs[i] = 0;
	}

	private void setFrame() {
		

	}

	// create the JFrame where the quiz will take place
	private void frameSetup() {
		surveyFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // program will end when exited
		surveyFrame.setSize(300, 300); // sets the size of the frame
		surveyFrame.setTitle("Program Matcher"); // The window name
		surveyFrame.setLayout(null);
		surveyFrame.setResizable(true);
		surveyFrame.getContentPane().setBackground(new Color(194, 231, 245));
		surveyFrame.setSize(1920, 1080);
		surveyFrame.setLayout(null);

		for (int i = 0; i < questions.length; i++) {

			questions[i] = new JLabel(i + 1 + ") " + assignQuestion()[i]);
			questions[i].setBounds(400, i * 20 + 50, 650, 30);// temp
			questions[i].setVisible(true);
			questions[i].setOpaque(true);
			surveyFrame.add(questions[i]);

		}

		surveyFrame.repaint();

		int f = 0;
		int g = 0;
		
		for (int r = 0; r < 15; r++) {

			if (r == 5) {
				f = 480;
				g = 0;
			} else if (r == 10) {
				f = 960;
				g = 0;
			} 
			for (int c = 0; c < 5; c++) {

				options[r][c] = new JRadioButton();

				options[r][c].setText(c + 1 + "");
				options[r][c].setBounds((430 + 30 + c * 45 + f), r * 100, 50, 30);
				options[r][c].addActionListener(this);
				options[r][c].setVisible(true);
				options[r][c].setOpaque(true);
				group.add(options[r][c]);
				surveyFrame.add(options[r][c]);
				++g;

			}

		}

		surveyFrame.repaint();

		submitButton = new JButton("SUBMIT");
		submitButton.setBounds(500, 350, 100, 50);
		submitButton.addActionListener(this);
		submitButton.setVisible(true);
		submitButton.setOpaque(true);
		surveyFrame.add(submitButton);
		surveyFrame.validate();
		surveyFrame.repaint();
		surveyFrame.setVisible(true); // Visible
	}

	// create the JLabels of questions
	private String[] assignQuestion() {

		String[] questions = new String[15];

		questions[0] = "Do you enjoy working with groups of people to identify"
				+ " and solve complex problems and share your ideas?";
		questions[1] = "Do you like to be constantly active as opposed" + "to being in front of a computer screen?";
		questions[2] = "Build, test, and modify product prototypes using " + "working models or theoretical models?";
		questions[3] = "Test and verify hardware and support peripherals to ensure "
				+ "that they meet specifications and requirements, by recording and analyzing test data?";
		questions[4] = "Would you like to oversee and manage other engineers such as being a Project Manager?";
		questions[5] = "Would you want to work in the medical field and create advances in medical technology?";
		questions[6] = "Make sure chemical equipment and processes to identify ways "
				+ "to optimize performance or to ensure that safety and environmental regulations are followed?";
		questions[7] = "Create plans and procedures as well as keep track of progress?";
		questions[8] = "Work with automotive technologies such as cars and planes?";
		questions[9] = "Spend considerable time performing research to " + "write reports and come up with solutions?";
		questions[10] = "Work on improving the environment and focus on Earth’s resources such as minerals?";
		questions[12] = "Focus on the principles of engineering and the science and math behind them?";
		questions[11] = "Explore the design and manufacturing process of buildings?";
		questions[13] = "Constantly meeting with clients to discuss plans and show blueprints?";
		questions[14] = "How would you rate your time management and your critical thinking skills?";

		return questions;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(submitButton)) {

			System.out.print(calculateMatch());

		}

		for (int row = 0; row < 15; row++) {

			for (int column = 0; column < 5; column++) {

				if (e.getSource() == options[row][column]) {

				}

			}

		}

	}

	private int calculateMatch() {
		int winner = 0;
		return winner;
	}
}