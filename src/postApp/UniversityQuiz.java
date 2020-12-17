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
	// Fields

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
	private JLabel lblAverage;
	private JLabel lblExtracurriculars;
	private JLabel lblNotAtAll;
	private JLabel lblVery;

	private JRadioButton rdbtnTuitonY;
	private JRadioButton rdbtnTuitonN;
	private JRadioButton rdbtnCoopY;
	private JRadioButton rdbtnCoopN;
	private JRadioButton rdbtnClassSizeY;
	private JRadioButton rdbtnClassSizeN;
	private JRadioButton rdbtnCampusY;
	private JRadioButton rdbtnCampusN;
	private JRadioButton rdbtnDistanceY;
	private JRadioButton rdbtnDistanceN;

	private ButtonGroup tuition;
	private ButtonGroup coop;
	private ButtonGroup gradReview;
	private ButtonGroup classSize;
	private ButtonGroup campusType;
	private ButtonGroup distance;

	private AbstractButton aTuition;
	private AbstractButton aCoop;
	private AbstractButton aGraduate;
	private AbstractButton aClass;
	private AbstractButton aCampus;
	private AbstractButton aDistance;

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
		lblNotImportant = new JLabel[6];
		lblVeryImportant = new JLabel[6];
		factor = new JSlider[6];

		// Creates sliders for all question
		// Sets them to visible false until user selects a radiobutton
		for (int i = 0; i < lblNotImportant.length; i++) {
			// Creates the Labels and sets text
			// HTML used to format text in centre and adds breaklines
			lblNotImportant[i] = new JLabel(
					"<html><div style='text-align: center;'><html>Not at all<br>important</div></html>");
			lblVeryImportant[i] = new JLabel(
					"<html><div style='text-align: center;'><html>Very<br>important</div></html>");

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
				else {
					sliderVisible(0, false);
					factor[0].setValue(0);
				}
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
				else {
					sliderVisible(1, false);
					factor[1].setValue(0);
				}
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
				else {
					sliderVisible(2, false);
					factor[2].setValue(0);
				}
			}
		};
		// Add actionlistener to radiobuttons
		rdbtnGraduateY.addActionListener(gradAction);
		rdbtnGraduateN.addActionListener(gradAction);

		// Class sizes
		lblWhatClassSize = new JLabel("Does class size matter to you?");
		lblWhatClassSize.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblWhatClassSize.setBounds(45, 280, 325, 25);
		frame.getContentPane().add(lblWhatClassSize);
		// Radio Buttons - Smaller/Larger
		rdbtnClassSizeY = new JRadioButton("Yes");
		rdbtnClassSizeY.setBounds(45, 305, 88, 23);
		frame.getContentPane().add(rdbtnClassSizeY);

		rdbtnClassSizeN = new JRadioButton("No");
		rdbtnClassSizeN.setBounds(145, 305, 99, 23);
		frame.getContentPane().add(rdbtnClassSizeN);
		// Group Radio Buttons
		classSize = new ButtonGroup();
		classSize.add(rdbtnClassSizeY);
		classSize.add(rdbtnClassSizeN);
		// ActionListener for radiobuttons
		classAction = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				aClass = (AbstractButton) actionEvent.getSource();
				if (aClass.equals(rdbtnClassSizeY))
					sliderVisible(3, true);
				else {
					sliderVisible(3, false);
					factor[3].setValue(0);
				}
			}
		};
		// Add actionlistener to radiobuttons
		rdbtnClassSizeY.addActionListener(classAction);
		rdbtnClassSizeN.addActionListener(classAction);

		// Campus Type
		lblCampusType = new JLabel("Does campus size matter to you?");
		lblCampusType.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblCampusType.setBounds(45, 340, 325, 25);
		frame.getContentPane().add(lblCampusType);
		// RadioButtons - Town/City
		rdbtnCampusY = new JRadioButton("Yes");
		rdbtnCampusY.setBounds(45, 365, 88, 23);
		frame.getContentPane().add(rdbtnCampusY);

		rdbtnCampusN = new JRadioButton("No");
		rdbtnCampusN.setBounds(145, 365, 99, 23);
		frame.getContentPane().add(rdbtnCampusN);
		// Group Radio Buttons
		campusType = new ButtonGroup();
		campusType.add(rdbtnCampusY);
		campusType.add(rdbtnCampusN);
		// ActionListener for radiobuttons
		campusAction = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				aCampus = (AbstractButton) actionEvent.getSource();
				if (aCampus.equals(rdbtnCampusY))
					sliderVisible(4, true);
				else {
					sliderVisible(4, false);
					factor[4].setValue(0);
				}
			}
		};
		// Add actionlistener to radiobuttons
		rdbtnCampusY.addActionListener(campusAction);
		rdbtnCampusN.addActionListener(campusAction);

		// Distance
		lblDistance = new JLabel("Does distance matter to you?");
		lblDistance.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblDistance.setBounds(45, 400, 325, 25);
		frame.getContentPane().add(lblDistance);
		// RadioButtons - Close/Far
		rdbtnDistanceY = new JRadioButton("Yes");
		rdbtnDistanceY.setBounds(45, 425, 88, 23);
		frame.getContentPane().add(rdbtnDistanceY);

		rdbtnDistanceN = new JRadioButton("No");
		rdbtnDistanceN.setBounds(145, 425, 99, 23);
		frame.getContentPane().add(rdbtnDistanceN);
		// Group Radio Buttons
		distance = new ButtonGroup();
		distance.add(rdbtnDistanceY);
		distance.add(rdbtnDistanceN);
		// ActionListener for radiobuttons
		distanceAction = new ActionListener() {

			public void actionPerformed(ActionEvent actionEvent) {
				aDistance = (AbstractButton) actionEvent.getSource();
				if (aDistance.equals(rdbtnDistanceY))
					sliderVisible(5, true);
				else {
					sliderVisible(5, false);
					factor[5].setValue(0);
				}
			}

		};
		// Add actionlistener to radiobuttons
		rdbtnDistanceY.addActionListener(distanceAction);
		rdbtnDistanceN.addActionListener(distanceAction);

		// Displays average based on calculation form profile setup
		lblAverage = new JLabel("Your average: " + String.format("%.2f", Initialize.user.getAverageMark()));
		lblAverage.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblAverage.setBounds(44, 460, 162, 25);
		frame.getContentPane().add(lblAverage);

		// Involvement in EC's - slider
		lblExtracurriculars = new JLabel("How involved are you with extracurriculars?*");
		lblExtracurriculars.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblExtracurriculars.setBounds(44, 497, 325, 25);
		frame.getContentPane().add(lblExtracurriculars);

		// EC slider
		sliderECs = new JSlider();
		sliderECs.setPaintTicks(true);
		sliderECs.setBounds(86, 534, 190, 29);
		sliderECs.setMajorTickSpacing(10);
		frame.getContentPane().add(sliderECs);

		// Labels for EC slider
		lblNotAtAll = new JLabel("<html><div style='text-align: center;'><html>Not at all<br>involved</div></html>");
		lblNotAtAll.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotAtAll.setBounds(24, 527, 60, 35);
		frame.getContentPane().add(lblNotAtAll);

		lblVery = new JLabel("<html><div style='text-align: center;'><html>Very<br>involved</div></html>");
		lblVery.setHorizontalAlignment(SwingConstants.CENTER);
		lblVery.setBounds(288, 527, 60, 35);
		frame.getContentPane().add(lblVery);

		// JButton - calculates which uni
		btnChooseUni = new JButton("Get Result");
		btnChooseUni.addActionListener(this);//
		btnChooseUni.setBounds(426, 534, 117, 29);
		frame.getContentPane().add(btnChooseUni);

		// Error if user does not fill out quiz
		lblError = new JLabel("*Please answer all questions.*");
		lblError.setForeground(Color.RED);
		lblError.setBounds(472, 577, 190, 16);
		frame.getContentPane().add(lblError);
		lblError.setVisible(false);

		// JButton - Redirects to home page
		btnHOME = new JButton("HOME");
		btnHOME.addActionListener(this);
		btnHOME.setBounds(586, 534, 117, 29);
		frame.getContentPane().add(btnHOME);
		btnHOME.setEnabled(false);

	}

	// Checks if every question has been answered
	// Returns true if complete
	// Returns false if any incomplete
	public boolean isComplete() {
		if (tuition.getSelection() == null || coop.getSelection() == null || gradReview.getSelection() == null
				|| classSize.getSelection() == null || campusType.getSelection() == null
				|| distance.getSelection() == null)
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
			
		// Creates an array of UniversityWeights objects
		UniversityWeights unis[] = new UniversityWeights[14];
		
		// Initializes each school with their respective weights per catagory
		// Ranges from 1-14, 14 being the highest, 1 being the lowest
		// Refer to UniversityWeights class
		unis[0]= new UniversityWeights("Waterloo",1,14,12,14,10,14,14,95); 
		unis[1]= new UniversityWeights("University of Toronto",2,14,12,14,10,14,14,93); // NEED TO PUT PROPER NUMBERS
		unis[2]= new UniversityWeights("Western University",3,14,12,14,10,14,14,88); 
		unis[3]= new UniversityWeights("Carleton",4,14,12,14,10,14,14,80); 
		unis[4]= new UniversityWeights("Windsor",5,14,12,14,10,14,14,75); 
		unis[5]= new UniversityWeights("Queens",6,14,12,14,10,14,14,89); 
		unis[6]= new UniversityWeights("Ryerson",7,14,12,14,10,14,14,85); 
		unis[7]= new UniversityWeights("Guelph",8,14,12,14,10,14,14,80);  
		unis[8]= new UniversityWeights("Lakehead",9,14,12,14,10,14,14,70); 
		unis[9]= new UniversityWeights("York University",10,14,12,14,10,14,14,70); 
		unis[10]= new UniversityWeights("Ontario Tech University",11,14,12,14,10,14,14,70); 
		unis[11]= new UniversityWeights("McMaster",12,14,12,14,10,14,14,80);
		unis[12]= new UniversityWeights("Laurier",13,14,12,14,10,14,14,85); 
		unis[13]= new UniversityWeights("UOttawa",14,14,12,14,10,14,14,90); 
		
		// Gets users mark
		double mark = Initialize.user.getAverageMark();
		// Casts user mark to int
		int grade = (int)mark;
		
		// Calculate how well of a fit each university is - refer to .calculateCompatability in UniversityWeights class 
		for(int i=0;i<14;i++) {
			unis[i].calculateCompatability(arr, grade);
		}
		
		// Sorts universities - most to least compatible
		Arrays.sort(unis,new uniComparator());
		
		for(int i=0;i<14;i++) {
			System.out.println(unis[i].getName()+" "+unis[i].compatability);
		}

		// Pop-up message displaying most compatible university
		JOptionPane.showMessageDialog(frame, unis[0].getName()+"!", "Your University:", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("images/" +unis[0].getName()+"Logo.png"));


	}

	// ActionPerformed
	@Override
	public void actionPerformed(ActionEvent e) {
		// if HOME button clicked
		if (e.getSource() == btnHOME) { // BRYAN
//frame.setVisible(false);
// new home
		} else if (e.getSource() == btnChooseUni) {
			if (isComplete()) { // Validates if all information is filled out

				lblError.setVisible(false);
				
				int[] vals = new int[7];
				for (int i = 0; i < 6; i++) {
					vals[i] = factor[i].getValue();
				}
				vals[6] = sliderECs.getValue();

				// Initializes new HashMap
				importance = new HashMap<String, Integer>();

				// Put data in map importance
				importance.put("Tuition", factor[0].getValue());
				importance.put("Coop", factor[1].getValue());
				importance.put("GradRev", factor[2].getValue());
				importance.put("Size", factor[3].getValue());
				importance.put("Campus", factor[4].getValue());
				importance.put("Distance", factor[5].getValue());

				importance.put("Extracurriculars", sliderECs.getValue());

				

				// Saves data to user
				Initialize.user.setImportance(importance);
				System.out.println(importance.toString());

				System.out.printf("Tuition: %s, %d\n", aTuition.getText(), factor[0].getValue());
				System.out.printf("Coop: %s, %d\n", aCoop.getText(), factor[1].getValue());
				System.out.printf("GradRev: %s, %d\n", aGraduate.getText(), factor[2].getValue());
				System.out.printf("Size: %s, %d\n", aClass.getText(), factor[3].getValue());
				System.out.printf("Campus: %s, %d\n", aCampus.getText(), factor[4].getValue());
				System.out.printf("Distance: %s, %d\n", aDistance.getText(), factor[5].getValue());
				System.out.printf("Extracurriculars: %d\n", sliderECs.getValue());
				chooseUni(vals);
				// System.out.println();
				btnHOME.setEnabled(true);
				
			} else // Error message if any information missing
				lblError.setVisible(true);
		}

	}
	
}


class uniComparator implements Comparator<UniversityWeights>{
	public int compare(UniversityWeights a, UniversityWeights b) {
		return Integer.compare(b.compatability, a.compatability);
	}
}