package postApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProfileGUIThree extends JFrame {

	public static JPanel TotalPanel = new JPanel();
	public static JLabel Title = new JLabel("Personal information");
	public static JLabel Volunteer = new JLabel("6.Volunteer hour");
	public static JLabel VolunteerProblem = new JLabel("Do you 40 volunteer hours?");
	public static JLabel Yes = new JLabel("Yes");
	public static JLabel No = new JLabel("No");
	public static JButton choiceYes = new JButton();
	public static JButton choiceNo = new JButton();
	public JButton save = new JButton("Save");
	public JButton ViewAll = new JButton("View All");
	public static JLabel Award = new JLabel("7.Award");
	public static JLabel ActionType = new JLabel("Action name");
	public static JLabel Description = new JLabel("Description");
	public static JLabel Date = new JLabel("<html>Date<br/>E.x 2020/01/01<br/>should be <br/>200101");
	public static JLabel AwardIncomplete = new JLabel("The information isn't filled out.");
	public static JLabel WrongeDateType = new JLabel("Wrong Date Type.");
	public static JLabel WrongDate = new JLabel("Wrong Date type.");
	public static JLabel AwardInfo = new JLabel(
			"<html> Some universies like Waterloo <br/>really pay their attention on applicants awards.");
	public static JLabel UncompleteChoiceWarning;
	public static JLabel UncompleteRequiredCourseWarning;
	public static JLabel UncompleteCourseOrMarkWarning;
	private JTextField[] AwardBox = new JTextField[3];
	public JButton Submit = new JButton("Submit");
	public JButton back = new JButton("Back");
	public JButton AwardInformation = new JButton();
	public JButton close = new JButton("CLOSE");
	public static Boolean volunteerHourChoice = null;
	public static ArrayList<String> AwardActionName = new ArrayList<String>();
	public static ArrayList<String> AwardDescription = new ArrayList<String>();
	public static ArrayList<String> AwardDate = new ArrayList<String>();
	public Boolean RequiredCourseBoolean[] = new Boolean[5];
	public static Boolean DateType = null;
	private Map<String, Integer> CourseAndMark;

	public ProfileGUIThree() {

		setBounds(360, 60, 832, 500);
		setTitle("Profile Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		TotalPanel.setLayout(null);
		TotalPanel.setBounds(50, 50, 200, 30);
		TotalPanel.setBackground(Color.white);
		TotalPanel.setVisible(true);
		add(TotalPanel);

		for (int x = 0; x < 3; x++)
			AwardBox[x] = new JTextField(10);

		Title.setFont(new Font("Serif", Font.PLAIN, 20));
		Title.setBounds(20, 10, 200, 30);
		Volunteer.setFont(new Font("Serif", Font.PLAIN, 16));
		Volunteer.setBounds(40, 45, 200, 30);
		VolunteerProblem.setFont(new Font("Serif", Font.BOLD, 16));
		VolunteerProblem.setBounds(173, 73, 300, 30);
		Yes.setFont(new Font("Serif", Font.PLAIN, 16));
		Yes.setBounds(200, 100, 200, 30);
		No.setFont(new Font("Serif", Font.PLAIN, 16));
		No.setBounds(300, 100, 200, 30);
		Award.setFont(new Font("Serif", Font.PLAIN, 16));
		Award.setBounds(40, 130, 200, 30);
		ActionType.setFont(new Font("Serif", Font.PLAIN, 10));
		ActionType.setBounds(70, 160, 200, 30);
		Description.setFont(new Font("Serif", Font.PLAIN, 10));
		Description.setBounds(230, 160, 200, 30);
		Date.setFont(new Font("Serif", Font.PLAIN, 10));
		Date.setBounds(480, 90, 200, 130);
		AwardBox[0].setBounds(60, 190, 70, 20);
		AwardBox[1].setBounds(127, 190, 348, 20);
		AwardBox[2].setBounds(472, 190, 100, 20);

		ViewAll.setBounds(40, 240, 190, 40);
		ViewAll.setFont(new Font("Impact", Font.PLAIN, 40));
		ViewAll.setForeground(new Color(255, 127, 80));
		ViewAll.setBorderPainted(false);
		ViewAll.setMargin(new Insets(0, 0, 0, 0));
		ViewAll.setIconTextGap(0);
		ViewAll.setBorderPainted(false);
		ViewAll.setBorder(null);
		ViewAll.setFocusPainted(false);
		ViewAll.setContentAreaFilled(false);
		ViewAll.setVisible(true);

		close.setBounds(680, 90, 100, 70);
		close.setFont(new Font("Impact", Font.PLAIN, 20));
		close.setForeground(new Color(255, 127, 80));
		close.setBorderPainted(false);
		close.setMargin(new Insets(0, 0, 0, 0));// set the distance between margin to zero
		close.setIconTextGap(0);// set the distance between Icon and text to zero
		close.setBorderPainted(false);// don't print the margin
		close.setBorder(null);// delete the margin
		close.setFocusPainted(false);// delete the frame for focus
		close.setContentAreaFilled(false);
		close.setVisible(true);

		Submit.setBounds(650, 400, 200, 50);
		Submit.setFont(new Font("Impact", Font.PLAIN, 35));
		Submit.setForeground(new Color(255, 127, 80));
		Submit.setBorderPainted(false);
		Submit.setMargin(new Insets(0, 0, 0, 0));
		Submit.setIconTextGap(0);
		Submit.setBorderPainted(false);
		Submit.setBorder(null);
		Submit.setFocusPainted(false);
		Submit.setContentAreaFilled(false);
		Submit.setVisible(true);

		back.setBounds(30, 400, 100, 50);
		back.setFont(new Font("Impact", Font.PLAIN, 35));
		back.setForeground(new Color(255, 127, 80));
		back.setBorderPainted(false);
		back.setMargin(new Insets(0, 0, 0, 0));
		back.setIconTextGap(0);
		back.setBorderPainted(false);
		back.setBorder(null);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);
		back.setVisible(true);

		AwardInformation.setBounds(100, 130, 25, 25);
		AwardInformation.setIcon(new ImageIcon("Images/Info.png"));
		AwardInformation.setMargin(new Insets(0, 0, 0, 0));
		AwardInformation.setIconTextGap(0);
		AwardInformation.setBorderPainted(false);
		AwardInformation.setBorder(null);
		AwardInformation.setFocusPainted(false);
		AwardInformation.setContentAreaFilled(false);
		AwardInformation.setVisible(true);

		choiceYes.setBounds(230, 110, 12, 15);
		choiceYes.setIcon(new ImageIcon("Images/choice.png"));
		choiceYes.setBorderPainted(false);
		choiceYes.setMargin(new Insets(0, 0, 0, 0));// set the distance between margin to zero
		choiceYes.setIconTextGap(0);// set the distance between Icon and text to zero
		choiceYes.setBorderPainted(false);// don't print the margin
		choiceYes.setBorder(null);// delete the margin
		choiceYes.setFocusPainted(false);// delete the frame for focus
		choiceYes.setContentAreaFilled(false);
		choiceYes.setVisible(true);

		choiceNo.setBounds(330, 110, 12, 15);
		choiceNo.setIcon(new ImageIcon("Images/choice.png"));
		choiceNo.setBorderPainted(false);
		choiceNo.setMargin(new Insets(0, 0, 0, 0));// set the distance between margin to zero
		choiceNo.setIconTextGap(0);// set the distance between Icon and text to zero
		choiceNo.setBorderPainted(false);// don't print the margin
		choiceNo.setBorder(null);// delete the margin
		choiceNo.setFocusPainted(false);// delete the frame for focus
		choiceNo.setContentAreaFilled(false);
		choiceNo.setVisible(true);

		save.setBounds(500, 240, 100, 40);
		save.setFont(new Font("Impact", Font.PLAIN, 40));
		save.setForeground(new Color(255, 127, 80));
		save.setBorderPainted(false);
		save.setMargin(new Insets(0, 0, 0, 0));
		save.setIconTextGap(0);
		save.setBorderPainted(false);
		save.setBorder(null);
		save.setFocusPainted(false);
		save.setContentAreaFilled(false);
		save.setVisible(true);

		AwardIncomplete.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		AwardIncomplete.setForeground(Color.RED);
		AwardIncomplete.setBounds(60, 204, 300, 30);

		AwardIncomplete.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		AwardIncomplete.setForeground(Color.RED);
		AwardIncomplete.setBounds(60, 204, 300, 30);

		AwardInfo.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		AwardInfo.setForeground(new Color(255, 250, 250));
		AwardInfo.setBounds(500, 30, 300, 90);

		WrongeDateType.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		WrongeDateType.setForeground(Color.RED);
		WrongeDateType.setBounds(300, 204, 300, 30);

		TotalPanel.add(Title);
		TotalPanel.add(Volunteer);
		TotalPanel.add(VolunteerProblem);
		TotalPanel.add(Yes);
		TotalPanel.add(No);
		TotalPanel.add(choiceYes);
		TotalPanel.add(choiceNo);
		TotalPanel.add(Award);
		TotalPanel.add(ActionType);
		TotalPanel.add(Description);
		TotalPanel.add(Date);
		TotalPanel.add(AwardBox[0]);
		TotalPanel.add(AwardBox[1]);
		TotalPanel.add(AwardBox[2]);
		TotalPanel.add(ViewAll);
		TotalPanel.add(Submit);
		TotalPanel.add(back);
		TotalPanel.add(AwardInformation);
		TotalPanel.add(AwardIncomplete);
		TotalPanel.add(save);
		TotalPanel.add(WrongeDateType);
		TotalPanel.add(AwardInfo);
		TotalPanel.add(close);

		close.setVisible(false);
		AwardInfo.setVisible(false);
		WrongeDateType.setVisible(false);
		AwardIncomplete.setVisible(false);

		setContentPane(TotalPanel);
		TotalPanel.setOpaque(false);

		init();

		UncompleteChoiceWarning = new JLabel("You haven't fill up your choices.");
		UncompleteChoiceWarning.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		UncompleteChoiceWarning.setForeground(new Color(255, 250, 250));
		UncompleteChoiceWarning.setBounds(500, 300, 300, 90);
		TotalPanel.add(UncompleteChoiceWarning);
		UncompleteChoiceWarning.setVisible(false);

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				dispose();
				new ProfileGUITwo();
				close.setVisible(false);

				if (ProfileGUITwo.EarlyAccpetanceChoice != null) {
					if (ProfileGUITwo.EarlyAccpetanceChoice == true) {
						ProfileGUITwo.choiceYes.setIcon(new ImageIcon("Images/choices.png"));
					} else {
						ProfileGUITwo.choiceNo.setIcon(new ImageIcon("Images/choices.png"));
					}
				}

				if (ProfileGUITwo.CitzenshipChoice != null) {
					if (ProfileGUITwo.CitzenshipChoice == true) {
						ProfileGUITwo.choiceYes2.setIcon(new ImageIcon("Images/choices.png"));
					} else {
						ProfileGUITwo.choiceNo2.setIcon(new ImageIcon("Images/choices.png"));
					}
				}

				if (ProfileGUITwo.CoopChoice != null) {
					if (ProfileGUITwo.CoopChoice == true) {
						ProfileGUITwo.choiceYes3.setIcon(new ImageIcon("Images/choices.png"));
					} else {
						ProfileGUITwo.choiceNo3.setIcon(new ImageIcon("Images/choices.png"));
					}
				}

			}

		});

		AwardInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				close.setVisible(true);
				AwardInfo.setVisible(true);

			}

		});
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				close.setVisible(false);
				AwardInfo.setVisible(false);

			}

		});

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				if (DateType(AwardBox[2].getText()) == false) {

					WrongeDateType.setVisible(true);

					DateType = false;

				} else {
					DateType = true;
					WrongeDateType.setVisible(false);

				}

				if (AwardBox[0].getText().isEmpty() || AwardBox[1].getText().isEmpty()
						|| AwardBox[2].getText().isEmpty()) {

					AwardIncomplete.setVisible(true);

				} else {

					if (DateType == true) {
						AwardActionName.add(AwardBox[0].getText());
						AwardDescription.add(AwardBox[1].getText());
						AwardDate.add(AwardBox[2].getText());

						AwardBox[0].setText(null);
						AwardBox[1].setText(null);
						AwardBox[2].setText(null);
					}

					AwardIncomplete.setVisible(false);
				}

			}

		});
		choiceYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				choiceNo.setIcon(new ImageIcon("Images/choice.png"));
				choiceYes.setIcon(new ImageIcon("Images/choices.png"));
				volunteerHourChoice = true;

			}

		});
		choiceNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				choiceYes.setIcon(new ImageIcon("Images/choice.png"));
				choiceNo.setIcon(new ImageIcon("Images/choices.png"));
				volunteerHourChoice = false;

			}

		});
		ViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				new AwardViewAllGUI();

			}

		});

		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				if (RequiredCourse(ProfileGUIOne.CodeCollect, "ENG4U") == true)
					RequiredCourseBoolean[0] = true;
				else
					RequiredCourseBoolean[0] = false;
				if (RequiredCourse(ProfileGUIOne.CodeCollect, "SCH4U") == true)
					RequiredCourseBoolean[1] = true;
				else
					RequiredCourseBoolean[1] = false;
				if (RequiredCourse(ProfileGUIOne.CodeCollect, "MHF4U") == true)
					RequiredCourseBoolean[2] = true;
				else
					RequiredCourseBoolean[2] = false;
				if (RequiredCourse(ProfileGUIOne.CodeCollect, "MCV4U") == true)
					RequiredCourseBoolean[3] = true;
				else
					RequiredCourseBoolean[3] = false;
				if (RequiredCourse(ProfileGUIOne.CodeCollect, "SPH4U") == true)
					RequiredCourseBoolean[4] = true;
				else
					RequiredCourseBoolean[4] = false;

				for (int x = 0; x < 6; x++) {
					if (ProfileGUIOne.CodeCollect[x].isEmpty() == true) {
						// warning(0, "You haven't fill up your courses.(6 mark total)");
						break;
					}
				}

				for (int x = 0; x < 6; x++) {
					if (ProfileGUIOne.MarkCollect[x].isEmpty() == true) {
						// warning(12, "You haven't fill up your course marks.(6 mark total)");
						break;
					}
				}

				if (ProfileGUITwo.EarlyAccpetanceChoice == null
						|| ProfileGUITwo.CoopChoice == null
						|| ProfileGUITwo.CitzenshipChoice == null || volunteerHourChoice == null) {

					UncompleteChoiceWarning.setVisible(true);

				}

				if (RequiredCourseDetermine(RequiredCourseBoolean, false) == true) {

					String missingCourse = "You are still missing ";
					if (RequiredCourseBoolean[0] == false)
						missingCourse = missingCourse + " ENG4U ";
					if (RequiredCourseBoolean[1] == false)
						missingCourse = missingCourse + " SCH4U ";
					if (RequiredCourseBoolean[2] == false)
						missingCourse = missingCourse + " MHF4U ";
					if (RequiredCourseBoolean[3] == false)
						missingCourse = missingCourse + " MCV4U ";
					if (RequiredCourseBoolean[4] == false)
						missingCourse = missingCourse + " SPH4U ";

					// warning(4, missingCourse);

				} else {

					CourseAndMark = new HashMap<String, Integer>();

					int sum = 0;

					for (int x = 0; x < 6; x++) {

						CourseAndMark.put(ProfileGUIOne.CodeCollect[x],
								Integer.parseInt(ProfileGUIOne.MarkCollect[x]));

						sum = sum + Integer.parseInt(ProfileGUIOne.MarkCollect[x]);

					}

					Initialize.user.setMarks(CourseAndMark);
                    Initialize.user.setEarlyAcceptance(ProfileGUITwo.EarlyAccpetanceChoice);
                    Initialize.user.setExtracurricularActionType(ProfileGUITwo.ExtracurricularActionType);
                    Initialize.user.setExtracurricularDescription(ProfileGUITwo.ExtracurricularDescription);
                    Initialize.user.setExtracurricularStarDate(ProfileGUITwo.ExtracurricularStarDate);
                    Initialize.user.setExtracurricularEndDate(    ProfileGUITwo.ExtracurricularEndDate);
                    Initialize.user.setCitzenship(ProfileGUITwo.CitzenshipChoice);
                    Initialize.user.setCoop(ProfileGUITwo.CoopChoice);
                    Initialize.user.setVolunteer(ProfileGUIThree.volunteerHourChoice);
                    Initialize.user.setAwardActionType(ProfileGUIThree.AwardActionName);
                    Initialize.user.setAwardDescription(ProfileGUIThree.AwardDescription);
                    Initialize.user.setAwardDate(ProfileGUIThree.AwardDate);
                    Initialize.user.setAverageMark((double)sum/6);

                    dispose();

                    UniversityQuiz quiz = new UniversityQuiz();

                    quiz.frame.setVisible(true);

				}
			}

		});

	}

	public static boolean RequiredCourse(String[] array, String course) {
		return Arrays.asList(array).contains(course);
	}

	public static boolean RequiredCourseDetermine(Boolean[] array, Boolean course) {
		return Arrays.asList(array).contains(course);
	}

	public Boolean DateType(String s) {

		if (s.length() != 6)
			return false;

		int firstTwoDigits = Integer.parseInt(s.substring(0, 2));
		int ThirdFourthDigits = Integer.parseInt(s.substring(2, 4));
		int LastDigits = Integer.parseInt(s.substring(4));

		if (firstTwoDigits < 0 || firstTwoDigits > 20 || ThirdFourthDigits < 1 || ThirdFourthDigits > 12
				|| LastDigits < 1 || LastDigits > 32)
			return false;

		return true;

	}

	public void init() {

		ImageIcon img = new ImageIcon("Images/background.PNG");
		JLabel imgLabel = new JLabel(img);
		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));// add the background to the LayeredPane
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// set the location of the background
	}
}
