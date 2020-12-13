package postApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class UniversityQuiz {

	JFrame frame;

	JLabel[] less;
	JLabel[] more;
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
	private ButtonGroup classSize;
	private ButtonGroup campusType;
	private ButtonGroup distance;
	private ButtonGroup engType;

	private AbstractButton aTuition;
	private AbstractButton aCoop;
	private AbstractButton aClass;
	private AbstractButton aCampus;
	private AbstractButton aDistance;
	private AbstractButton aEngType;

	JButton btnDoSomething;
	
	/**
	 * Create the application.
	 */
	public UniversityQuiz() {
		initialize();
	}

	public void sliderVisible(int i, boolean vis) {
		less[i].setVisible(vis);
		more[i].setVisible(vis);
		factor[i].setVisible(vis);
		factor[i].setEnabled(vis);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 900, 625);
//		frame.setBounds(0,0,1920,1080);
//		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		less = new JLabel[6];
		more = new JLabel[6];
		factor = new JSlider[6];

		for (int i = 0; i < 6; i++) {
			less[i] = new JLabel("<html><div style='text-align: center;'><html>Not at all<br>important</div></html>");
			more[i] = new JLabel("<html><div style='text-align: center;'><html>Very<br>important</div></html>");
			factor[i] = new JSlider();

			less[i].setBounds(445, (60 * i + 112), 60, 35);
			more[i].setBounds(708, (60 * i + 112), 60, 35);
			factor[i].setPaintTicks(true);
			factor[i].setMajorTickSpacing(10);
			factor[i].setMinorTickSpacing(5);
			factor[i].setBounds(506, (60 * i + 120), 190, 30);
			
			int slide = i;
			
			factor[i].addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					int val = factor[slide].getValue();
				}
			});

			frame.getContentPane().add(less[i]);
			frame.getContentPane().add(more[i]);
			frame.getContentPane().add(factor[i]);

			sliderVisible(i, false);

		}

		lblFactorImportance = new JLabel("How important is this factor?");
		lblFactorImportance.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblFactorImportance.setBounds(492, 89, 235, 16);
		frame.getContentPane().add(lblFactorImportance);
		
		// Title
		lblUniQuiz = new JLabel("University Quiz");
		lblUniQuiz.setFont(new Font("Lucida Grande", Font.PLAIN, 41));
		lblUniQuiz.setBounds(45, 25, 325, 49);
		frame.getContentPane().add(lblUniQuiz);

		// Tuition Cost
		lblTuitionCostQ = new JLabel("Is cost of tuition an important factor?");
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

		ActionListener tuitionAction = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				aTuition = (AbstractButton) actionEvent.getSource();
				if (aTuition.equals(rdbtnTuitonY))
					sliderVisible(0, true);
				else
					sliderVisible(0, false);
			}
		};

		rdbtnTuitonN.addActionListener(tuitionAction);
		rdbtnTuitonY.addActionListener(tuitionAction);

		// Coop
		lblCoopQ = new JLabel("Are you interested in co-op?");
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

		ActionListener coopAction = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				aCoop = (AbstractButton) actionEvent.getSource();
				if (aCoop.equals(rdbtnCoopY))
					sliderVisible(1, true);
				else
					sliderVisible(1, false);
			}
		};

		rdbtnCoopY.addActionListener(coopAction);
		rdbtnCoopN.addActionListener(coopAction);

		// Class sizes
		lblWhatClassSize = new JLabel("What class size do you prefer?");
		lblWhatClassSize.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblWhatClassSize.setBounds(45, 220, 325, 25);
		frame.getContentPane().add(lblWhatClassSize);
		// Radio Buttons - Smaller/Larger
		rdbtnClassSizeS = new JRadioButton("Smaller");
		rdbtnClassSizeS.setBounds(45, 245, 88, 23);
		frame.getContentPane().add(rdbtnClassSizeS);

		rdbtnClassSizeL = new JRadioButton("Larger");
		rdbtnClassSizeL.setBounds(145, 245, 99, 23);
		frame.getContentPane().add(rdbtnClassSizeL);
		// Group Radio Buttons
		classSize = new ButtonGroup();
		classSize.add(rdbtnClassSizeS);
		classSize.add(rdbtnClassSizeL);

		ActionListener classAction = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				aClass = (AbstractButton) actionEvent.getSource();
				sliderVisible(2, true);
			}
		};

		rdbtnClassSizeS.addActionListener(classAction);
		rdbtnClassSizeL.addActionListener(classAction);

		// Campus Type
		lblCampusType = new JLabel("Which type of campus do you prefer?");
		lblCampusType.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblCampusType.setBounds(45, 280, 325, 25);
		frame.getContentPane().add(lblCampusType);
		// RadioButtons - Town/City
		rdbtnCampusT = new JRadioButton("Town");
		rdbtnCampusT.setBounds(45, 305, 88, 23);
		frame.getContentPane().add(rdbtnCampusT);

		rdbtnCampusC = new JRadioButton("City");
		rdbtnCampusC.setBounds(145, 305, 99, 23);
		frame.getContentPane().add(rdbtnCampusC);
		// Group Radio Buttons
		campusType = new ButtonGroup();
		campusType.add(rdbtnCampusT);
		campusType.add(rdbtnCampusC);

		ActionListener campusAction = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				aCampus = (AbstractButton) actionEvent.getSource();
				sliderVisible(3, true);
			}
		};

		rdbtnCampusT.addActionListener(campusAction);
		rdbtnCampusC.addActionListener(campusAction);

		// Distance
		lblDistance = new JLabel("How close to home do you want to live?");
		lblDistance.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblDistance.setBounds(45, 340, 325, 25);
		frame.getContentPane().add(lblDistance);
		// RadioButtons - Close/Far
		rdbtnClose = new JRadioButton("Close");
		rdbtnClose.setBounds(45, 355, 88, 23);
		frame.getContentPane().add(rdbtnClose);

		rdbtnFar = new JRadioButton("Far");
		rdbtnFar.setBounds(145, 355, 99, 23);
		frame.getContentPane().add(rdbtnFar);
		// Group Radio Buttons
		distance = new ButtonGroup();
		distance.add(rdbtnClose);
		distance.add(rdbtnFar);

		ActionListener distanceAction = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				aDistance = (AbstractButton) actionEvent.getSource();
				sliderVisible(4, true);
			}
		};

		rdbtnClose.addActionListener(distanceAction);
		rdbtnFar.addActionListener(distanceAction);

		// First Year Eng Type
		lblEngType = new JLabel("Which type of engineering first year?");
		lblEngType.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEngType.setBounds(45, 400, 325, 25);
		frame.getContentPane().add(lblEngType);
		// RadioButtons - General/Specialized
		rdbtnGeneral = new JRadioButton("General");
		rdbtnGeneral.setBounds(45, 425, 88, 23);
		frame.getContentPane().add(rdbtnGeneral);

		rdbtnSpecialized = new JRadioButton("Specialized");
		rdbtnSpecialized.setBounds(145, 425, 113, 23);
		frame.getContentPane().add(rdbtnSpecialized);
		// Group Radio Buttons
		engType = new ButtonGroup();
		engType.add(rdbtnGeneral);
		engType.add(rdbtnSpecialized);

		ActionListener engAction = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				aEngType = (AbstractButton) actionEvent.getSource();
				sliderVisible(5, true);
			}
		};

		rdbtnGeneral.addActionListener(engAction);
		rdbtnSpecialized.addActionListener(engAction);

		EngineeringApp.user.setAverage(99.3);

		// Displays average based on calculation form profile setup
		lblAverage = new JLabel("Your average: " + EngineeringApp.user.getAverage());
		lblAverage.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblAverage.setBounds(45, 460, 162, 25);
		frame.getContentPane().add(lblAverage);

		// Involvment in EC's - slider
		lblExtracurriculars = new JLabel("How involved are you with extracurriculars?");
		lblExtracurriculars.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblExtracurriculars.setBounds(45, 497, 325, 25);
		frame.getContentPane().add(lblExtracurriculars);

		JSlider sliderECs = new JSlider();
		sliderECs.setPaintTicks(true);
		sliderECs.setBounds(87, 534, 190, 29);
		sliderECs.setMajorTickSpacing(10);
		frame.getContentPane().add(sliderECs);

		lblNotAtAll = new JLabel("<html><div style='text-align: center;'><html>Not at all<br>involved</div></html>");
		lblNotAtAll.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotAtAll.setBounds(25, 527, 60, 35);
		frame.getContentPane().add(lblNotAtAll);

		lblVery = new JLabel("<html><div style='text-align: center;'><html>Very<br>involved</div></html>");
		lblVery.setHorizontalAlignment(SwingConstants.CENTER);
		lblVery.setBounds(289, 527, 60, 35);
		frame.getContentPane().add(lblVery);

		btnDoSomething = new JButton("Do Something");
		btnDoSomething.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<6;i++) {
					if(factor[i].isEnabled())
						System.out.println(factor[i].getValue());
					else
						System.out.println(0);
				}
			}
		});
		btnDoSomething.setBounds(428, 534, 117, 29);
		frame.getContentPane().add(btnDoSomething);

//		JSlider sliderECs_1 = new JSlider();
//		sliderECs_1.setPaintTicks(true);
//		sliderECs_1.setMajorTickSpacing(10);
//		sliderECs_1.setMinorTickSpacing(5);
//		sliderECs_1.setBounds(506, 119, 190, 29);
//		frame.getContentPane().add(sliderECs_1);
//
//		JLabel lblNotAtAll_1 = new JLabel(
//				"<html><div style='text-align: center;'><html>Not at all<br>important</div></html>");
//		lblNotAtAll_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNotAtAll_1.setBounds(444, 112, 60, 35);
//		frame.getContentPane().add(lblNotAtAll_1);
//
//		JLabel lblVery_1 = new JLabel("<html><div style='text-align: center;'><html>Very<br>important</div></html>");
//		lblVery_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblVery_1.setBounds(708, 112, 60, 35);
//		frame.getContentPane().add(lblVery_1);
//
//		JSlider sliderECs_1_1_1 = new JSlider();
//		sliderECs_1_1_1.setPaintTicks(true);
//		sliderECs_1_1_1.setMinorTickSpacing(5);
//		sliderECs_1_1_1.setMajorTickSpacing(10);
//		sliderECs_1_1_1.setBounds(506, 299, 190, 29);
//		frame.getContentPane().add(sliderECs_1_1_1);
//
//		JLabel lblNotAtAll_1_1_1 = new JLabel(
//				"<html><div style='text-align: center;'><html>Not at all<br>involved</div></html>");
//		lblNotAtAll_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNotAtAll_1_1_1.setBounds(444, 292, 60, 35);
//		frame.getContentPane().add(lblNotAtAll_1_1_1);
//
//		JLabel lblVery_1_1_1 = new JLabel("<html><div style='text-align: center;'><html>Very<br>involved</div></html>");
//		lblVery_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblVery_1_1_1.setBounds(708, 292, 60, 35);
//		frame.getContentPane().add(lblVery_1_1_1);
//
//		JSlider sliderECs_1_1 = new JSlider();
//		sliderECs_1_1.setPaintTicks(true);
//		sliderECs_1_1.setMinorTickSpacing(5);
//		sliderECs_1_1.setMajorTickSpacing(10);
//		sliderECs_1_1.setBounds(506, 179, 190, 29);
//		frame.getContentPane().add(sliderECs_1_1);
//
//		JLabel lblNotAtAll_1_1 = new JLabel(
//				"<html><div style='text-align: center;'><html>Not at all<br>involved</div></html>");
//		lblNotAtAll_1_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNotAtAll_1_1.setBounds(444, 172, 60, 35);
//		frame.getContentPane().add(lblNotAtAll_1_1);
//
//		JLabel lblVery_1_1 = new JLabel("<html><div style='text-align: center;'><html>Very<br>involved</div></html>");
//		lblVery_1_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblVery_1_1.setBounds(708, 172, 60, 35);
//		frame.getContentPane().add(lblVery_1_1);
//
//		JLabel lblNotAtAll_1_2 = new JLabel(
//				"<html><div style='text-align: center;'><html>Not at all<br>involved</div></html>");
//		lblNotAtAll_1_2.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNotAtAll_1_2.setBounds(444, 232, 60, 35);
//		frame.getContentPane().add(lblNotAtAll_1_2);
//
//		JSlider sliderECs_1_2 = new JSlider();
//		sliderECs_1_2.setPaintTicks(true);
//		sliderECs_1_2.setMinorTickSpacing(5);
//		sliderECs_1_2.setMajorTickSpacing(10);
//		sliderECs_1_2.setBounds(506, 239, 190, 29);
//		frame.getContentPane().add(sliderECs_1_2);
//
//		JLabel lblVery_1_2 = new JLabel("<html><div style='text-align: center;'><html>Very<br>involved</div></html>");
//		lblVery_1_2.setHorizontalAlignment(SwingConstants.CENTER);
//		lblVery_1_2.setBounds(708, 232, 60, 35);
//		frame.getContentPane().add(lblVery_1_2);
//
//		JLabel lblNotAtAll_1_1_2 = new JLabel(
//				"<html><div style='text-align: center;'><html>Not at all<br>involved</div></html>");
//		lblNotAtAll_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNotAtAll_1_1_2.setBounds(444, 412, 60, 35);
//		frame.getContentPane().add(lblNotAtAll_1_1_2);
//
//		JSlider sliderECs_1_1_2 = new JSlider();
//		sliderECs_1_1_2.setPaintTicks(true);
//		sliderECs_1_1_2.setMinorTickSpacing(5);
//		sliderECs_1_1_2.setMajorTickSpacing(10);
//		sliderECs_1_1_2.setBounds(506, 419, 190, 29);
//		frame.getContentPane().add(sliderECs_1_1_2);
//
//		JLabel lblVery_1_1_2 = new JLabel("<html><div style='text-align: center;'><html>Very<br>involved</div></html>");
//		lblVery_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
//		lblVery_1_1_2.setBounds(708, 412, 60, 35);
//		frame.getContentPane().add(lblVery_1_1_2);
//
//		JLabel lblNotAtAll_1_3 = new JLabel(
//				"<html><div style='text-align: center;'><html>Not at all<br>involved</div></html>");
//		lblNotAtAll_1_3.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNotAtAll_1_3.setBounds(444, 352, 60, 35);
//		frame.getContentPane().add(lblNotAtAll_1_3);
//
//		JSlider sliderECs_1_3 = new JSlider();
//		sliderECs_1_3.addChangeListener(new ChangeListener() {
//			public void stateChanged(ChangeEvent e) {
//			}
//		});
//		sliderECs_1_3.setPaintTicks(true);
//		sliderECs_1_3.setMinorTickSpacing(5);
//		sliderECs_1_3.setMajorTickSpacing(10);
//		sliderECs_1_3.setBounds(506, 359, 190, 29);
//		frame.getContentPane().add(sliderECs_1_3);
//
//		JLabel lblVery_1_3 = new JLabel("<html><div style='text-align: center;'><html>Very<br>involved</div></html>");
//		lblVery_1_3.setHorizontalAlignment(SwingConstants.CENTER);
//		lblVery_1_3.setBounds(708, 352, 60, 35);
//		frame.getContentPane().add(lblVery_1_3);
//	
	}
}
