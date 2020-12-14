package postApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SurveyGUI extends JFrame implements ActionListener {

	private JLabel[] questions = new JLabel[15];
	private JRadioButton[][] options = new JRadioButton[15][5];
	private JButton submitButton;
	private static JFrame frame;
	private static JPanel screen; // JPaneL

	private ButtonGroup group = new ButtonGroup();

	private int[] programs = new int[16];
	
	/*private final int MECHANICAL = 0;
	private final int COMPENG = 1;
	private final int COMPSCISOFTWARE = 2;
	private final int CHEMICAL = 3;
	private final int ELECTRICAL = 4;
	private final int CIVIL = 5;
	private final int BIOMEDICAL = 6;
	private final int AEROSPACE = 7;
	private final int ARCHITECTURAL = 8;
	private final int ENGSCI = 9;
	private final int GEOLOGICAL = 10;
	private final int ENVIRONMENTAL = 11;
	private final int MINING = 12;
	private final int MANAGEMENT = 13;
	private final int SYSTEMS = 14;
	private final int NANO = 15;*/


	public SurveyGUI() {
		frame = new JFrame();
		screen = new JPanel();
		frameSetup();
		panelDesign();

		for (int i : programs)
			programs[i] = 0;

	}

	private void panelDesign() {
		screen.setBorder(null);
		screen.setBackground(new java.awt.Color(47, 47, 47));
		screen.setBounds(0, 0, 1500, 1500);
		screen.setLayout(null);

		for (int i = 0; i < questions.length; i++) {

			questions[i] = new JLabel(i + 1 + ") " + assignQuestion()[i]);
			questions[i].setBounds(400, i * 20 + 50, 650, 30);// temp
			questions[i].setVisible(true);
			questions[i].setOpaque(true);
			screen.add(questions[i]);

		}

		frame.repaint();

		
		for (int r = 0; r < 15; r++) {

			for (int c = 0; c < 5; c++) {

				

				options[r][c] = new JRadioButton();

				options[r][c].setText(c + 1 + "");
				options[r][c].setBounds((30 + c * 45), r * 100 , 50, 30);
				options[r][c].addActionListener(this);
				options[r][c].setVisible(true);
				options[r][c].setOpaque(true);
				group.add(options[r][c]);
				screen.add(options[r][c]);

			}
			
			
			

		}

		frame.repaint();

		submitButton = new JButton("SUBMIT");
		submitButton.setBounds(500, 350, 50, 50);
		submitButton.addActionListener(this);
		submitButton.setVisible(true);
		submitButton.setOpaque(true);
		screen.add(submitButton);

	}

	// create the JFrame where the quiz will take place
	private void frameSetup() {
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // program will end when exited
		frame.setSize(300, 300); // sets the size of the frame
		frame.setTitle("Program Matcher"); // The window name
		frame.setBounds(0, 0, 1000, 1000);
		frame.setLayout(null);
		frame.setResizable(true);
		frame.add(screen); // add panel to the frame
		frame.validate();
		frame.repaint();
		frame.setVisible(true); // Visible
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

	public static void main(String[] args) {
		new SurveyGUI();
	}

}