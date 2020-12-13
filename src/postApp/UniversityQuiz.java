package postApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;

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
		frame.setBounds(0, 0, 400, 625);
//		frame.setBounds(0,0,1920,1080);
//		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Title
		JLabel lblUniiQuiz = new JLabel("University Quiz");
		lblUniiQuiz.setFont(new Font("Lucida Grande", Font.PLAIN, 41));
		lblUniiQuiz.setBounds(45, 25, 325, 49);
		frame.getContentPane().add(lblUniiQuiz);

		// Tuition Cost
		JLabel lblTuitionCostQ = new JLabel("Is cost of tuition an important factor?");
		lblTuitionCostQ.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTuitionCostQ.setBounds(45, 100, 325, 25);
		frame.getContentPane().add(lblTuitionCostQ);
		// RadioButtons - Yes/No
		JRadioButton rdbtnTuitonY = new JRadioButton("Yes");
		rdbtnTuitonY.setBounds(45, 125, 62, 23);
		frame.getContentPane().add(rdbtnTuitonY);

		JRadioButton rdbtnTuitonN = new JRadioButton("No");
		rdbtnTuitonN.setBounds(145, 125, 62, 23);
		frame.getContentPane().add(rdbtnTuitonN);
		// Group Radio Buttons
		ButtonGroup tuition = new ButtonGroup();
		tuition.add(rdbtnTuitonY);
		tuition.add(rdbtnTuitonN);

		// Coop
		JLabel lblCoopQ = new JLabel("Are you interested in co-op?");
		lblCoopQ.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblCoopQ.setBounds(45, 160, 325, 25);
		frame.getContentPane().add(lblCoopQ);
		// RadioButtons - Yes/No
		JRadioButton rdbtnCoopY = new JRadioButton("Yes");
		rdbtnCoopY.setBounds(45, 185, 62, 23);
		frame.getContentPane().add(rdbtnCoopY);

		JRadioButton rdbtnCoopN = new JRadioButton("No");
		rdbtnCoopN.setBounds(145, 185, 62, 23);
		frame.getContentPane().add(rdbtnCoopN);
		// Group Radio Buttons
		ButtonGroup coop = new ButtonGroup();
		coop.add(rdbtnCoopY);
		coop.add(rdbtnCoopN);

		// Class sizes
		JLabel lblWhatClassSize = new JLabel("What class size do you prefer?");
		lblWhatClassSize.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblWhatClassSize.setBounds(45, 220, 325, 25);
		frame.getContentPane().add(lblWhatClassSize);
		// Radio Buttons - Smaller/Larger
		JRadioButton rdbtnClassSizeS = new JRadioButton("Smaller");
		rdbtnClassSizeS.setBounds(45, 245, 88, 23);
		frame.getContentPane().add(rdbtnClassSizeS);

		JRadioButton rdbtnClassSizeL = new JRadioButton("Larger");
		rdbtnClassSizeL.setBounds(145, 245, 99, 23);
		frame.getContentPane().add(rdbtnClassSizeL);
		// Group Radio Buttons
		ButtonGroup classSize = new ButtonGroup();
		classSize.add(rdbtnClassSizeS);
		classSize.add(rdbtnClassSizeL);

		// Campus Type
		JLabel lblCampusType = new JLabel("Which type of campus do you prefer?");
		lblCampusType.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblCampusType.setBounds(45, 280, 325, 25);
		frame.getContentPane().add(lblCampusType);
		// RadioButtons - Town/City
		JRadioButton rdbtnCampusT = new JRadioButton("Town");
		rdbtnCampusT.setBounds(45, 305, 88, 23);
		frame.getContentPane().add(rdbtnCampusT);

		JRadioButton rdbtnCampusC = new JRadioButton("City");
		rdbtnCampusC.setBounds(145, 305, 99, 23);
		frame.getContentPane().add(rdbtnCampusC);
		// Group Radio Buttons
		ButtonGroup campusType = new ButtonGroup();
		campusType.add(rdbtnCampusT);
		campusType.add(rdbtnCampusC);

		// Distance
		JLabel lblDistance = new JLabel("How close to home do you want to live?");
		lblDistance.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblDistance.setBounds(45, 340, 325, 25);
		frame.getContentPane().add(lblDistance);
		// RadioButtons - Close/Far
		JRadioButton rdbtnClose = new JRadioButton("Close");
		rdbtnClose.setBounds(45, 365, 88, 23);
		frame.getContentPane().add(rdbtnClose);

		JRadioButton rdbtnFar = new JRadioButton("Far");
		rdbtnFar.setBounds(145, 365, 99, 23);
		frame.getContentPane().add(rdbtnFar);
		// Group Radio Buttons
		ButtonGroup distance = new ButtonGroup();
		distance.add(rdbtnClose);
		distance.add(rdbtnFar);

		// First Year Eng Type
		JLabel lblEngType = new JLabel("Which type of engineering first year?");
		lblEngType.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEngType.setBounds(45, 400, 325, 25);
		frame.getContentPane().add(lblEngType);
		// RadioButtons - General/Specialized
		JRadioButton rdbtnGeneral = new JRadioButton("General");
		rdbtnGeneral.setBounds(45, 425, 88, 23);
		frame.getContentPane().add(rdbtnGeneral);

		JRadioButton rdbtnSpecialized = new JRadioButton("Specialized");
		rdbtnSpecialized.setBounds(145, 425, 113, 23);
		frame.getContentPane().add(rdbtnSpecialized);
		// Group Radio Buttons
		ButtonGroup engType = new ButtonGroup();
		engType.add(rdbtnGeneral);
		engType.add(rdbtnSpecialized);

		
		EngineeringApp.user.setAverage(99.3);		
		
		// Displays average based on calculation form profile setup
		JLabel lblAverage = new JLabel("Your average: " + EngineeringApp.user.getAverage());
		lblAverage.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblAverage.setBounds(45, 460, 162, 25);
		frame.getContentPane().add(lblAverage);

		// Involvment in EC's - slider
		JLabel lblExtracurriculars = new JLabel("How involved are you with extracurriculars?");
		lblExtracurriculars.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblExtracurriculars.setBounds(45, 497, 325, 25);
		frame.getContentPane().add(lblExtracurriculars);

		JSlider sliderECs = new JSlider();
		sliderECs.setPaintTicks(true);
		sliderECs.setBounds(87, 534, 190, 29);
		sliderECs.setMajorTickSpacing(10);
		frame.getContentPane().add(sliderECs);

		JLabel lblNotAtAll = new JLabel(
				"<html><div style='text-align: center;'><html>Not at all<br>involved</div></html>");
		lblNotAtAll.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotAtAll.setBounds(25, 527, 61, 36);
		frame.getContentPane().add(lblNotAtAll);

		JLabel lblVery = new JLabel("<html><div style='text-align: center;'><html>Very<br>involved</div></html>");
		lblVery.setHorizontalAlignment(SwingConstants.CENTER);
		lblVery.setBounds(289, 527, 61, 36);
		frame.getContentPane().add(lblVery);
	}
}
