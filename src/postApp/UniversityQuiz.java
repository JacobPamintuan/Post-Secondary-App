package postApp;

import java.util.*;
import java.awt.desktop.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Desktop;

public class UniversityQuiz implements ActionListener {
	// Fields

	JFrame frame;

	JLabel[] lblLess;
	JLabel[] lblMore;
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
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Set bounds of logos image
		logos.setBounds(790, 0, 500, 725);
		frame.getContentPane().add(logos);

		// Initializes JSlider array; factor
		lblLess = new JLabel[6];
		lblMore = new JLabel[6];
		factor = new JSlider[6];

		// Labels for distance
		lblLess[5] = new JLabel("<html><div style='text-align: center;'><html>Close</div></html>");
		lblMore[5] = new JLabel("<html><div style='text-align: center;'><html>Far</div></html>");

		// Initializes JLabel arrays; lblLess, lblMore
		// Creates sliders for all question
		// Sets them to visible false until user selects a radiobutton
		for (int i = 0; i < lblLess.length; i++) {

			// Creates Labels and sets text
			// HTML used to format text in centre and adds breaklines
			if (i != 5) {
				lblLess[i] = new JLabel(
						"<html><div style='text-align: center;'><html>Not at all<br>important</div></html>");
				lblMore[i] = new JLabel("<html><div style='text-align: center;'><html>Very<br>important</div></html>");
			}

			// Creates new sliders
			factor[i] = new JSlider();

			// Sets bounds of JLabels
			lblLess[i].setBounds(395, (60 * i + 112), 62, 35);
			lblMore[i].setBounds(658, (60 * i + 112), 62, 35);

			// Adds tick marks to factor slider
			factor[i].setPaintTicks(true);
			factor[i].setMajorTickSpacing(10);
			factor[i].setMinorTickSpacing(5);
			// Sets bounds of factor slider
			factor[i].setBounds(456, (60 * i + 120), 190, 30);
			// Sets slider default value to 0
			factor[i].setValue(0);

			// Adds labels and slider to frame
			frame.getContentPane().add(lblLess[i]);
			frame.getContentPane().add(lblMore[i]);
			frame.getContentPane().add(factor[i]);

			// Sets labels and slider to invisible
			sliderVisible(i, false);

		}

		// JLabel factor question
		lblFactorImportance = new JLabel("How important is this factor?*");
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
		lblTuitionCostQ = new JLabel("Is cost of tuition an important factor?**");
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
		lblCoopQ = new JLabel("Are you interested in co-op?**");
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
		lblGraduateReviews = new JLabel("Do graduate reviews matter to you?**");
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
		lblWhatClassSize = new JLabel("Do you want a small class size?*");
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
		lblCampusType = new JLabel("Do you want a large campus?*");
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
		lblDistance = new JLabel("Do you want to live far away?*");
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
		lblExtracurriculars = new JLabel("How involved are you with extracurriculars?**");
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
		lblError.setForeground(new Color(153, 0, 225));
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
		lblLess[i].setVisible(vis);
		lblMore[i].setVisible(vis);
		factor[i].setVisible(vis);
		factor[i].setEnabled(vis);
	}

	// Calcuates which university is best based on the inputs
	public void chooseUni(int[] arr) {

		// Creates an array of UniversityWeights objects
		UniversityWeights unis[] = new UniversityWeights[14];

		// Initializes each school with their respective weights per category
		// Ranges from 1-14, 14 being the highest, 1 being the lowest (Admission average
		// is the only different)
		// Refer to UniversityWeights class
		// Name, tuition,coop,graduate reviews, class size, campus size, distance,
		// extracurriculars, admission average
		int xx=0;
		unis[0] = new UniversityWeights("Waterloo", 1, 14, 9, 1, 10, xx, 6, 93, "https://uwaterloo.ca/engineering/");
		unis[1] = new UniversityWeights("University of Toronto", 2, 13, 6, 2, 14, xx, 6, 93,
				"https://www.engineering.utoronto.ca"); // NEED TO PUT PROPER NUMBERS
		unis[2] = new UniversityWeights("Western University", 3, 6, 10, 13, 9, xx, 5, 90, "https://www.eng.uwo.ca");
		unis[3] = new UniversityWeights("Carleton", 4, 8, 8, 14, 5, xx, 5, 84,
				"https://carleton.ca/engineering-design/");
		unis[4] = new UniversityWeights("Windsor", 5, 4, 4, 9, 3, xx, 4, 85, "https://www.uwindsor.ca/engineering/");
		unis[5] = new UniversityWeights("Queens", 6, 1, 14, 11, 6, xx, 4, 91, "https://engineering.queensu.ca/");
		unis[6] = new UniversityWeights("Ryerson", 7, 10, 5, 4, 12, xx, 4, 86,
				"https://www.ryerson.ca/engineering-architectural-science/");
		unis[7] = new UniversityWeights("Guelph", 8, 9, 11, 5, 17, xx, 4, 87, "https://www.uoguelph.ca/engineering/");
		unis[8] = new UniversityWeights("Lakehead", 9, 3, 3, 8, 1, xx, 4, 82,
				"https://www.lakeheadu.ca/programs/faculties/engineering/");
		unis[9] = new UniversityWeights("York University", 10, 5, 1, 10, 13, xx, 4, 84, "https://lassonde.yorku.ca");
		unis[10] = new UniversityWeights("Ontario Tech University", 11, 2, 7, 3, 2, xx, 4, 81,
				"https://engineering.ontariotechu.ca");
		unis[11] = new UniversityWeights("McMaster", 12, 12, 12, 7, 8, xx, 4, 91, "https://www.eng.mcmaster.ca");
		unis[12] = new UniversityWeights("Laurier", 13, 7, 13, 12, 4, xx, 1, 70, "https://www.wlu.ca/programs/");
		unis[13] = new UniversityWeights("UOttawa", 14, 11, 2, 6, 11, xx, 4, 85, "https://engineering.uottawa.ca");

		// Gets users mark
		double mark = Initialize.user.getAverageMark();
		// Casts user mark to int
		int grade = (int) mark;

		// Calculate how well of a fit each university is - refer to
		// .calculateCompatability in UniversityWeights class
		for (int i = 0; i < 14; i++) {
			unis[i].calculateCompatability(arr, grade);
		}

		// Sorts universities - most to least compatible
		Arrays.sort(unis, new uniComparator());

		for (int i = 0; i < 14; i++) {
			System.out.println(unis[i].getName() + " " + unis[i].compatability);
		}
		System.out.println();

		// Pop-up message displaying most compatible university
		JLabel link = new JLabel("<html><u>Link to " + unis[0].getName() + "'s website<u><html>"); // JLabel - Link with
																									// underlined text
		link.setForeground(Color.BLUE); // Set color to blue (resembles hyperlink)

		// Mouse listener - if JLabel link is clicked
		link.addMouseListener(new MouseAdapter() { // Turns JLabel link into hyperlink

			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					Desktop.getDesktop().browse(new URI(unis[0].getLink())); // Opens link

				} catch (IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});

		JOptionPane.showMessageDialog(frame, link, "Your University:", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("images/" + unis[0].getName() + "Logo.png"));

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

// Class uniComparator
// Compares universities to each other based on compatibility
class uniComparator implements Comparator<UniversityWeights> {
	public int compare(UniversityWeights a, UniversityWeights b) {
		return Integer.compare(b.compatability, a.compatability);
	}
}