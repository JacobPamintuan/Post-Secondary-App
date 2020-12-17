package postApp;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class UniversityQuiz implements ActionListener {
	//Fields
	
	JFrame frame;

	JLabel[] lblNotImportant;
	JLabel[] lblVeryImportant;
	JSlider[] factor;

	private JLabel lblFactorImportance;
	private JLabel lblUniQuiz;
	private JLabel lblTuitionCostQ;
	private JLabel lblCoopQ;
	private JLabel lblWhatClassSize;
	private JLabel lblCampusType;
	private JLabel lblDistance;
	private JLabel lblEngType;
	private JLabel lblAverage;
	private JLabel lblExtracurriculars;
	private JLabel lblNotAtAll;
	private JLabel lblVery;

	private JRadioButton rdbtnTuitonY;
	private JRadioButton rdbtnTuitonN;
	private JRadioButton rdbtnCoopY;
	private JRadioButton rdbtnCoopN;
	private JRadioButton rdbtnClassSizeS;
	private JRadioButton rdbtnClassSizeL;
	private JRadioButton rdbtnCampusT;
	private JRadioButton rdbtnCampusC;
	private JRadioButton rdbtnClose;
	private JRadioButton rdbtnFar;
	private JRadioButton rdbtnGeneral;
	private JRadioButton rdbtnSpecialized;

	private ButtonGroup tuition;
	private ButtonGroup coop;
	private ButtonGroup gradReview;
	private ButtonGroup classSize;
	private ButtonGroup campusType;
	private ButtonGroup distance;
	private ButtonGroup engType;

	private AbstractButton aTuition;
	private AbstractButton aCoop;
	private AbstractButton aGraduate;
	private AbstractButton aClass;
	private AbstractButton aCampus;
	private AbstractButton aDistance;
	private AbstractButton aEngType;

	JButton btnChooseUni;
	JButton btnHOME;
	private JLabel lblError;

	private JLabel lblGraduateReviews;
	private JRadioButton rdbtnGraduateY;
	private JRadioButton rdbtnGraduateN;

	private ActionListener tuitionAction;
	private ActionListener coopAction;
	private ActionListener gradAction;
	private ActionListener classAction;
	private ActionListener campusAction;
	private ActionListener distanceAction;
	private ActionListener engAction;

	private JSlider sliderECs;

//	private JLabel logos = new JLabel(new ImageIcon(
//			"/Users/jacobpamintuan/Desktop/ICS4U1/Post-Secondary-App/Post-Secondary-App/images/UniLogos.png"));
	private JLabel logos = new JLabel(new ImageIcon("images/UniLogos.png"));

	private Map<String, Integer> importance;

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
		// Initialize JFrame
		frame = new JFrame();
		frame.setBounds(0, 0, 1290, 745);
		frame.getContentPane().setBackground(Color.lightGray); // sets background color
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Set bounds of logos image
		logos.setBounds(790, 0, 500, 725);
		frame.getContentPane().add(logos);

		// Initializes JLabel arrays; lblNotImportant, lblVeryImportant
		// Initializes JSlider array; factor
		lblNotImportant = new JLabel[7];
		lblVeryImportant = new JLabel[7];
		factor = new JSlider[7];

		// Creates sliders for all question
		// Sets them to visible false until user selects a radiobutton
		for (int i = 0; i < lblNotImportant.length; i++) {
			// Creates the Labels and sets text
			// HTML used to format text in centre and adds breaklines
			lblNotImportant[i] = new JLabel("<html><div style='text-align: center;'><html>Not at all<br>important</div></html>");
			lblVeryImportant[i] = new JLabel("<html><div style='text-align: center;'><html>Very<br>important</div></html>");
			
			// Creates new sliders
			factor[i] = new JSlider();
			
			// Sets bounds of JLabels
			lblNotImportant[i].setBounds(395, (60 * i + 112), 60, 35);
			lblVeryImportant[i].setBounds(658, (60 * i + 112), 60, 35);
			
			// Adds tick marks to factor slider
			factor[i].setPaintTicks(true);
			factor[i].setMajorTickSpacing(10);
			factor[i].setMinorTickSpacing(5);
			// Sets bounds of factor slider
			factor[i].setBounds(456, (60 * i + 120), 190, 30);
			// Sets slider default value to 0
			factor[i].setValue(0);

			// Adds labels and slider to frame
			frame.getContentPane().add(lblNotImportant[i]);
			frame.getContentPane().add(lblVeryImportant[i]);
			frame.getContentPane().add(factor[i]);

			// Sets labels and slider to invisible
			sliderVisible(i, false);

		}

		// JLabel factor question
		lblFactorImportance = new JLabel("How important is this factor?");
		lblFactorImportance.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblFactorImportance.setBounds(442, 89, 235, 16);
		frame.getContentPane().add(lblFactorImportance);

		// JLabel Title - Image Icon
		lblUniQuiz = new JLabel(new ImageIcon(
				"/Users/jacobpamintuan/Desktop/ICS4U1/Post-Secondary-App/Post-Secondary-App/images/UniQuizTitle.png"));
//		lblUniQuiz = new JLabel(new ImageIcon("images/UniQuizTitle.png"));
		lblUniQuiz.setBounds(45, 25, 325, 50);
		frame.getContentPane().add(lblUniQuiz);

		// Tuition Cost
		lblTuitionCostQ = new JLabel("Is cost of tuition an important factor?*");
		lblTuitionCostQ.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTuitionCostQ.setBounds(45, 100, 325, 25);
		frame.getContentPane().add(lblTuitionCostQ);
		// RadioButtons - Yes/No
		rdbtnTuitonY = new JRadioButton("Yes");
		rdbtnTuitonY.setBounds(45, 125, 62, 23);
		frame.getContentPane().add(rdbtnTuitonY);

		rdbtnTuitonN = new JRadioButton("No");
		rdbtnTuitonN.setBounds(145, 125, 62, 23);
		frame.getContentPane().add(rdbtnTuitonN);
		// Group Radio Buttons
		tuition = new ButtonGroup();
		tuition.add(rdbtnTuitonY);
		tuition.add(rdbtnTuitonN);
		// ActionListener for radiobuttons
		tuitionAction = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				aTuition = (AbstractButton) actionEvent.getSource();
				if (aTuition.equals(rdbtnTuitonY))
					sliderVisible(0, true);
				else
					sliderVisible(0, false);
			}
		};
		// Add actionlistener to radiobuttons
		rdbtnTuitonN.addActionListener(tuitionAction);
		rdbtnTuitonY.addActionListener(tuitionAction);

		// Coop
		lblCoopQ = new JLabel("Are you interested in co-op?*");
		lblCoopQ.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblCoopQ.setBounds(45, 160, 325, 25);
		frame.getContentPane().add(lblCoopQ);
		// RadioButtons - Yes/No
		rdbtnCoopY = new JRadioButton("Yes");
		rdbtnCoopY.setBounds(45, 185, 62, 23);
		frame.getContentPane().add(rdbtnCoopY);

		rdbtnCoopN = new JRadioButton("No");
		rdbtnCoopN.setBounds(145, 185, 62, 23);
		frame.getContentPane().add(rdbtnCoopN);
		// Group Radio Buttons
		coop = new ButtonGroup();
		coop.add(rdbtnCoopY);
		coop.add(rdbtnCoopN);
		// ActionListener for radiobuttons
		coopAction = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				aCoop = (AbstractButton) actionEvent.getSource();
				if (aCoop.equals(rdbtnCoopY))
					sliderVisible(1, true);
				else
					sliderVisible(1, false);
			}
		};
		// Add actionlistener to radiobuttons
		rdbtnCoopY.addActionListener(coopAction);
		rdbtnCoopN.addActionListener(coopAction);

		// Graduate Reviews
		lblGraduateReviews = new JLabel("Do graduate reviews matter to you?*");
		lblGraduateReviews.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblGraduateReviews.setBounds(45, 220, 325, 25);
		frame.getContentPane().add(lblGraduateReviews);
		// RadioButtons - Yes/No
		rdbtnGraduateY = new JRadioButton("Yes");
		rdbtnGraduateY.setBounds(45, 245, 88, 23);
		frame.getContentPane().add(rdbtnGraduateY);

		rdbtnGraduateN = new JRadioButton("No");
		rdbtnGraduateN.setBounds(145, 245, 113, 23);
		frame.getContentPane().add(rdbtnGraduateN);
		// Group Radio Buttons
		gradReview = new ButtonGroup();
		gradReview.add(rdbtnGraduateY);
		gradReview.add(rdbtnGraduateN);
		// ActionListener for radiobuttons
		gradAction = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				aGraduate = (AbstractButton) actionEvent.getSource();
				if (aGraduate.equals(rdbtnGraduateY))
					sliderVisible(2, true);
				else
					sliderVisible(2, false);
			}
		};
		// Add actionlistener to radiobuttons
		rdbtnGraduateY.addActionListener(gradAction);
		rdbtnGraduateN.addActionListener(gradAction);

		// Class sizes
		lblWhatClassSize = new JLabel("What class size do you prefer?*");
		lblWhatClassSize.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblWhatClassSize.setBounds(45, 280, 325, 25);
		frame.getContentPane().add(lblWhatClassSize);
		// Radio Buttons - Smaller/Larger
		rdbtnClassSizeS = new JRadioButton("Smaller");
		rdbtnClassSizeS.setBounds(45, 305, 88, 23);
		frame.getContentPane().add(rdbtnClassSizeS);

		rdbtnClassSizeL = new JRadioButton("Larger");
		rdbtnClassSizeL.setBounds(145, 305, 99, 23);
		frame.getContentPane().add(rdbtnClassSizeL);
		// Group Radio Buttons
		classSize = new ButtonGroup();
		classSize.add(rdbtnClassSizeS);
		classSize.add(rdbtnClassSizeL);
		// ActionListener for radiobuttons
		classAction = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				aClass = (AbstractButton) actionEvent.getSource();
				sliderVisible(3, true);
			}
		};
		// Add actionlistener to radiobuttons
		rdbtnClassSizeS.addActionListener(classAction);
		rdbtnClassSizeL.addActionListener(classAction);

		// Campus Type
		lblCampusType = new JLabel("Which type of campus do you prefer?*");
		lblCampusType.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblCampusType.setBounds(45, 340, 325, 25);
		frame.getContentPane().add(lblCampusType);
		// RadioButtons - Town/City
		rdbtnCampusT = new JRadioButton("Town");
		rdbtnCampusT.setBounds(45, 365, 88, 23);
		frame.getContentPane().add(rdbtnCampusT);

		rdbtnCampusC = new JRadioButton("City");
		rdbtnCampusC.setBounds(145, 365, 99, 23);
		frame.getContentPane().add(rdbtnCampusC);
		// Group Radio Buttons
		campusType = new ButtonGroup();
		campusType.add(rdbtnCampusT);
		campusType.add(rdbtnCampusC);
		// ActionListener for radiobuttons
		campusAction = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				aCampus = (AbstractButton) actionEvent.getSource();
				sliderVisible(4, true);
			}
		};
		// Add actionlistener to radiobuttons
		rdbtnCampusT.addActionListener(campusAction);
		rdbtnCampusC.addActionListener(campusAction);

		// Distance
		lblDistance = new JLabel("How close to home do you want to live?*");
		lblDistance.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblDistance.setBounds(45, 400, 325, 25);
		frame.getContentPane().add(lblDistance);
		// RadioButtons - Close/Far
		rdbtnClose = new JRadioButton("Close");
		rdbtnClose.setBounds(45, 425, 88, 23);
		frame.getContentPane().add(rdbtnClose);

		rdbtnFar = new JRadioButton("Far");
		rdbtnFar.setBounds(145, 425, 99, 23);
		frame.getContentPane().add(rdbtnFar);
		// Group Radio Buttons
		distance = new ButtonGroup();
		distance.add(rdbtnClose);
		distance.add(rdbtnFar);
		// ActionListener for radiobuttons
		distanceAction = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				aDistance = (AbstractButton) actionEvent.getSource();
				sliderVisible(5, true);
			}
		};
		// Add actionlistener to radiobuttons
		rdbtnClose.addActionListener(distanceAction);
		rdbtnFar.addActionListener(distanceAction);

		// First Year Eng Type
		lblEngType = new JLabel("Which type of engineering first year?*");
		lblEngType.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEngType.setBounds(45, 460, 325, 25);
		frame.getContentPane().add(lblEngType);
		// RadioButtons - General/Specialized
		rdbtnGeneral = new JRadioButton("General");
		rdbtnGeneral.setBounds(45, 485, 88, 23);
		frame.getContentPane().add(rdbtnGeneral);

		rdbtnSpecialized = new JRadioButton("Specialized");
		rdbtnSpecialized.setBounds(145, 485, 113, 23);
		frame.getContentPane().add(rdbtnSpecialized);
		// Group Radio Buttons
		engType = new ButtonGroup();
		engType.add(rdbtnGeneral);
		engType.add(rdbtnSpecialized);
		// ActionListener for radiobuttons
		engAction = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				aEngType = (AbstractButton) actionEvent.getSource();
				sliderVisible(6, true);
			}
		};
		// Add actionlistener to radiobuttons
		rdbtnGeneral.addActionListener(engAction);
		rdbtnSpecialized.addActionListener(engAction);

		// Displays average based on calculation form profile setup
		lblAverage = new JLabel("Your average: " + String.format("%.2f",Initialize.user.getAverageMark()));
		lblAverage.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblAverage.setBounds(45, 561, 162, 25);
		frame.getContentPane().add(lblAverage);

		// Involvement in EC's - slider
		lblExtracurriculars = new JLabel("How involved are you with extracurriculars?*");
		lblExtracurriculars.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblExtracurriculars.setBounds(45, 598, 325, 25);
		frame.getContentPane().add(lblExtracurriculars);

		// EC slider
		sliderECs = new JSlider();
		sliderECs.setPaintTicks(true);
		sliderECs.setBounds(87, 635, 190, 29);
		sliderECs.setMajorTickSpacing(10);
		frame.getContentPane().add(sliderECs);

		// Labels for EC slider
		lblNotAtAll = new JLabel("<html><div style='text-align: center;'><html>Not at all<br>involved</div></html>");
		lblNotAtAll.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotAtAll.setBounds(25, 628, 60, 35);
		frame.getContentPane().add(lblNotAtAll);

		lblVery = new JLabel("<html><div style='text-align: center;'><html>Very<br>involved</div></html>");
		lblVery.setHorizontalAlignment(SwingConstants.CENTER);
		lblVery.setBounds(289, 628, 60, 35);
		frame.getContentPane().add(lblVery);

		// JButton - calculates which uni
		btnChooseUni = new JButton("Get Result");
		btnChooseUni.addActionListener(this);//
		btnChooseUni.setBounds(427, 635, 117, 29);
		frame.getContentPane().add(btnChooseUni);

		// Error if user does not fill out quiz
		lblError = new JLabel("*Please answer all questions.*");
		lblError.setForeground(Color.RED);
		lblError.setBounds(471, 676, 190, 16);
		frame.getContentPane().add(lblError);
		lblError.setVisible(false);

		// JButton - Redirects to home page
		btnHOME = new JButton("HOME");
		btnHOME.addActionListener(this);
		btnHOME.setBounds(587, 635, 117, 29);
		frame.getContentPane().add(btnHOME);
		btnHOME.setEnabled(false);

	}

	// Checks if every question has been answered
	// Returns true if complete
	// Returns false if any incomplete
	public boolean isComplete() {
		if (tuition.getSelection() == null || coop.getSelection() == null || gradReview.getSelection() == null
				|| classSize.getSelection() == null || campusType.getSelection() == null
				|| distance.getSelection() == null || engType.getSelection() == null)
			return false;
		return true;
	}

	// Displays slider when respective radio button is selected
	public void sliderVisible(int i, boolean vis) {
		lblNotImportant[i].setVisible(vis);
		lblVeryImportant[i].setVisible(vis);
		factor[i].setVisible(vis);
		factor[i].setEnabled(vis);
	}

	// Calcuates which university is best based on the inputs
	public void chooseUni(int[] arr) {
		int tuition = arr[0], coop = arr[1], gradRev = arr[2], size = arr[3], campus = arr[4], distance = arr[5],
				eng = arr[6], ec = arr[7];

		int waterloo, uoft, western, carleton, windsor, queens, ryerson, guelph, lakehead, york, ontarioTech, mcmaster,
				laurier, uOttawa;

//		waterloo=tuition+coop+gradRev

		
		
		//JOptionPane.showMessageDialog(null, "Waterloo");
		JOptionPane.showMessageDialog(frame, "Waterloo","University Quiz",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("images/WelcomeLogin.png"));
//		JOptionPane.showMessageDialog(parentComponent, message, title, messageType, icon);
//		JOptionPane.showMessageDialog(parentComponent, message, title, messageType);
		
	}

	// ActionPerformed
	@Override
	public void actionPerformed(ActionEvent e) {
		// if HOME button clicked
		if (e.getSource() == btnHOME) {
//frame.setVisible(false);
// new home
		} else if (e.getSource() == btnChooseUni) {
			if (isComplete()) { // Validates if all information is filled out

				int[] vals = new int[8];
				for (int i = 0; i < 7; i++) {
					vals[i] = factor[i].getValue();
				}
				vals[7] = sliderECs.getValue();

				// Initializes new HashMap
				importance = new HashMap<String, Integer>();

				// Put data in map importance
				importance.put("Tuition", factor[0].getValue());
				importance.put("Coop", factor[1].getValue());
				importance.put("GradRev", factor[2].getValue());
				importance.put("Size", factor[3].getValue());
				importance.put("Campus", factor[4].getValue());
				importance.put("Distance", factor[5].getValue());
				importance.put("Engineering", factor[6].getValue());

				importance.put("Extracurriculars", sliderECs.getValue());

				chooseUni(vals);
				
				// Saves data to user
				Initialize.user.setImportance(importance);
				System.out.println(importance.toString());

//				System.out.printf("Tuition: %s, %d\n", aTuition.getText(), factor[0].getValue());
//				System.out.printf("Coop: %s, %d\n", aCoop.getText(), factor[1].getValue());
//				System.out.printf("GradRev: %s, %d\n", aGraduate.getText(), factor[2].getValue());
//				System.out.printf("Size: %s, %d\n", aClass.getText(), factor[3].getValue());
//				System.out.printf("Campus: %s, %d\n", aCampus.getText(), factor[4].getValue());
//				System.out.printf("Distance: %s, %d\n", aDistance.getText(), factor[5].getValue());
//				System.out.printf("Engineering: %s, %d\n", aEngType.getText(), factor[6].getValue());
//				System.out.printf("Extracurriculars: %d\n", sliderECs.getValue());

				// System.out.println();
				btnHOME.setEnabled(true);
				lblError.setVisible(false);
			} else // Error message if any information missing
				lblError.setVisible(true);
		}

	}
}
