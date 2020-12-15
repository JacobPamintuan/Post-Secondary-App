import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProfileScreenGUIScreenThree extends JFrame {

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
	public static JLabel Date = new JLabel("Date");
	public static JLabel AwardIncomplete = new JLabel("The information isn't filled out.");
	public static JLabel WrongeDateType = new JLabel("Wrong Date Type.");
	public static JLabel WrongDate = new JLabel("Wrong Date type.");
	private JTextField[] AwardBox = new JTextField[3];
	public JButton Submit = new JButton("Submit");
	public JButton back = new JButton("Back");
	public JButton AwardInformation = new JButton();
	public static Boolean volunteerHourChoice = null;
	public static ArrayList<String> AwardActionName = new ArrayList<String>();
	public static ArrayList<String> AwardDescription = new ArrayList<String>();
	public static ArrayList<String> AwardDate = new ArrayList<String>();
	public Boolean RequiredCourseBoolean[] = new Boolean[5];
	public static Boolean DateType = null;

	public ProfileScreenGUIScreenThree() {

		setBounds(360, 60, 600, 500);
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
		Date.setBounds(480, 160, 200, 30);
		AwardBox[0].setBounds(60, 190, 70, 20);
		AwardBox[1].setBounds(127, 190, 348, 20);
		AwardBox[2].setBounds(472, 190, 50, 20);
		ViewAll.setBounds(440, 220, 90, 20);
		save.setBounds(200, 140, 70, 15);

		Submit.setBounds(460, 420, 100, 30);
		back.setBounds(30, 420, 100, 30);

		AwardInformation.setBounds(110, 132, 25, 25);
		AwardInformation.setIcon(new ImageIcon("images/kk.png"));
		AwardInformation.setBorderPainted(false);
		AwardInformation.setVisible(true);

		choiceYes.setBounds(230, 110, 12, 15);
		choiceYes.setIcon(new ImageIcon("images/choice.png"));
		choiceYes.setBorderPainted(false);
		choiceYes.setVisible(true);

		choiceNo.setBounds(330, 110, 12, 15);
		choiceNo.setIcon(new ImageIcon("images/choice.png"));
		choiceNo.setBorderPainted(false);
		choiceNo.setVisible(true);

		AwardIncomplete.setFont(new Font("Serif", Font.PLAIN, 12));
		AwardIncomplete.setForeground(Color.RED);
		AwardIncomplete.setBounds(60, 204, 300, 30);

		AwardIncomplete.setFont(new Font("Serif", Font.PLAIN, 12));
		AwardIncomplete.setForeground(Color.RED);
		AwardIncomplete.setBounds(60, 204, 300, 30);

		WrongeDateType.setFont(new Font("Serif", Font.PLAIN, 12));
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
		WrongeDateType.setVisible(false);
		AwardIncomplete.setVisible(false);

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				dispose();
				new ProfileScreenGUIScreenTwo();

				if (ProfileScreenGUIScreenTwo.EarlyAccpetanceChoice != null) {
					if (ProfileScreenGUIScreenTwo.EarlyAccpetanceChoice == true) {
						ProfileScreenGUIScreenTwo.choiceYes.setIcon(new ImageIcon("images/choices.jpeg"));
					} else {
						ProfileScreenGUIScreenTwo.choiceNo.setIcon(new ImageIcon("images/choices.jpeg"));
					}
				}

				if (ProfileScreenGUIScreenTwo.CitzenshipChoice != null) {
					if (ProfileScreenGUIScreenTwo.CitzenshipChoice == true) {
						ProfileScreenGUIScreenTwo.choiceYes2.setIcon(new ImageIcon("images/choices.jpeg"));
					} else {
						ProfileScreenGUIScreenTwo.choiceNo2.setIcon(new ImageIcon("images/choices.jpeg"));
					}
				}

				if (ProfileScreenGUIScreenTwo.CoopChoice != null) {
					if (ProfileScreenGUIScreenTwo.CoopChoice == true) {
						ProfileScreenGUIScreenTwo.choiceYes3.setIcon(new ImageIcon("images/choices.jpeg"));
					} else {
						ProfileScreenGUIScreenTwo.choiceNo3.setIcon(new ImageIcon("images/choices.jpeg"));
					}
				}

			}

		});

		AwardInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				new Information();

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

				choiceNo.setIcon(new ImageIcon("images/choice.png"));
				choiceYes.setIcon(new ImageIcon("images/choices.jpeg"));
				volunteerHourChoice = true;

			}

		});
		choiceNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				choiceYes.setIcon(new ImageIcon("images/choice.png"));
				choiceNo.setIcon(new ImageIcon("images/choices.jpeg"));
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

				if (RequiredCourse(ProfileScreenGUIScreenOne.CodeCollect, "ENG4U") == true)
					RequiredCourseBoolean[0] = true;
				else
					RequiredCourseBoolean[0] = false;
				if (RequiredCourse(ProfileScreenGUIScreenOne.CodeCollect, "SCH4U") == true)
					RequiredCourseBoolean[1] = true;
				else
					RequiredCourseBoolean[1] = false;
				if (RequiredCourse(ProfileScreenGUIScreenOne.CodeCollect, "MHF4U") == true)
					RequiredCourseBoolean[2] = true;
				else
					RequiredCourseBoolean[2] = false;
				if (RequiredCourse(ProfileScreenGUIScreenOne.CodeCollect, "MCV4U") == true)
					RequiredCourseBoolean[3] = true;
				else
					RequiredCourseBoolean[3] = false;
				if (RequiredCourse(ProfileScreenGUIScreenOne.CodeCollect, "SPH4U") == true)
					RequiredCourseBoolean[4] = true;
				else
					RequiredCourseBoolean[4] = false;

				for (int x = 0; x < 6; x++) {
					if (ProfileScreenGUIScreenOne.CodeCollect[x].isEmpty() == true) {
						warning(0, "You haven't fill up your courses.(6 mark total)");
						break;
					}
				}
				
				for (int x = 0; x < 6; x++) {
					if (ProfileScreenGUIScreenOne.MarkCollect[x].isEmpty() == true) {
						warning(12, "You haven't fill up your course marks.(6 mark total)");
						break;
					}
				}
				
				

				if (ProfileScreenGUIScreenTwo.EarlyAccpetanceChoice == null
						|| ProfileScreenGUIScreenTwo.CoopChoice == null
						|| ProfileScreenGUIScreenTwo.CitzenshipChoice == null || volunteerHourChoice == null)
					warning(8, "You haven't fill up your choices.");

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

					warning(4, missingCourse);

				} else {
					StudentProfile Student = new StudentProfile(ProfileScreenGUIScreenOne.MarkCollect,
							ProfileScreenGUIScreenOne.CodeCollect, ProfileScreenGUIScreenTwo.EarlyAccpetanceChoice,
							ProfileScreenGUIScreenTwo.ExtracurricularActionType,
							ProfileScreenGUIScreenTwo.ExtracurricularDescription,
							ProfileScreenGUIScreenTwo.ExtracurricularStarDate,
							ProfileScreenGUIScreenTwo.ExtracurricularEndDate,
							ProfileScreenGUIScreenTwo.CitzenshipChoice, ProfileScreenGUIScreenTwo.CoopChoice,
							ProfileScreenGUIScreenThree.volunteerHourChoice,
							ProfileScreenGUIScreenThree.AwardActionName, ProfileScreenGUIScreenThree.AwardDescription,
							ProfileScreenGUIScreenThree.AwardDate);

					dispose();
					System.out.println(Student);
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

	public void warning(int address, String s) {

		JFrame frame = new JFrame("Warning!");

		frame.setBounds(20 + 80 * address, 300, 300, 100);

		JPanel panel = new JPanel();
		JLabel label = new JLabel(s);
		label.setFont(new Font("Serif", Font.PLAIN, 12));
		label.setBounds(0, 50, 100, 100);

		panel.add(label);

		frame.add(panel);
		frame.setVisible(true);
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
	
}
