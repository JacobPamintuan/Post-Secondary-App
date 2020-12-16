import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProfileScreenGUIScreenTwo extends JFrame {

	public static JPanel TotalPanel = new JPanel();
	public static JLabel Title = new JLabel("Personal information");
	public static JLabel EarlyAccpetance = new JLabel("2.Early Acceptance");
	public static JLabel EarlyAccpetanceQuestion = new JLabel("Are you considering the early offer?");
	public static JLabel Yes = new JLabel("Yes");
	public static JLabel No = new JLabel("No");
	public static JLabel Yes2 = new JLabel("Yes");
	public static JLabel No2 = new JLabel("No");
	public static JLabel Yes3 = new JLabel("Yes");
	public static JLabel No3 = new JLabel("No");
	public static JLabel Citzenship = new JLabel("4.Canadian Citzenship");
	public static JLabel Coop = new JLabel("5.Co-op");
	public static JLabel CoopQuestion = new JLabel("Are you considering the co-op programs?");
	public static JLabel CitzenshipQuestion = new JLabel("Do you have Canadian Citizenship?");
	public static JButton choiceYes = new JButton();
	public static JButton choiceNo = new JButton();
	public static JButton choiceYes2 = new JButton();
	public static JButton choiceNo2 = new JButton();
	public static JButton choiceYes3 = new JButton();
	public static JButton choiceNo3 = new JButton();
	public JButton ViewAll = new JButton("View All");
	public static JLabel Extracurricular = new JLabel("3.Extracurricular");
	public static JLabel ActionType = new JLabel("Action type");
	public static JLabel Description = new JLabel("Description/title");
	public static JLabel StarDate = new JLabel("<html>Start Date<br/>E.x 2020/01/01<br/>should be <br/>200101");
	public static JLabel EndDate = new JLabel("<html>End Date<br/>E.x 2020/01/01<br/>should be <br/>200101");
	public static JLabel ExtracurricularIncomplete = new JLabel("The information isn't filled out.");
	public static JLabel WrongeDateType = new JLabel("Wrong Date Type.");
	public static JLabel EarlyOfferInformation = new JLabel(
			"<html>By pressing the 'Yes' button<br/>it means you will consider the early offer.<br/>Tips: It is more possible for the system to rank the earlyoffer-possible university higher.");
	public static JLabel ExtracurricularInfo = new JLabel(
			"<html>Adequate Extracurricular Information will help you<br/> enter a greater universities");
	public JButton close2 = new JButton("CLOSE");
	private JTextField[] ExtracurricularBox = new JTextField[4];
	public JButton next = new JButton("Next");
	public JButton back = new JButton("Back");
	public JButton save = new JButton("Save");
	public JButton close = new JButton("CLOSE");
	public JButton EarlyInformation = new JButton();
	public JButton ExtracurricularInformation = new JButton();
	public static Boolean EarlyAccpetanceChoice = null;
	public static Boolean CitzenshipChoice = null;
	public static Boolean CoopChoice = null;
	public static Boolean DateType = null;
	public static ArrayList<String> ExtracurricularActionType = new ArrayList<String>();
	public static ArrayList<String> ExtracurricularDescription = new ArrayList<String>();
	public static ArrayList<String> ExtracurricularStarDate = new ArrayList<String>();
	public static ArrayList<String> ExtracurricularEndDate = new ArrayList<String>();

	public ProfileScreenGUIScreenTwo() {

		setBounds(360, 60, 832, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Profile Screen");

		TotalPanel.setLayout(null);
		TotalPanel.setBounds(0, 0, 832, 500);
		TotalPanel.setBackground(Color.white);
		TotalPanel.setVisible(true);
		add(TotalPanel);

		for (int x = 0; x < 4; x++)
			ExtracurricularBox[x] = new JTextField(10);

		EarlyAccpetance.setFont(new Font("Serif", Font.BOLD, 16));
		EarlyAccpetance.setBounds(40, 45, 200, 30);
		EarlyAccpetanceQuestion.setFont(new Font("Serif", Font.BOLD, 16));
		EarlyAccpetanceQuestion.setBounds(157, 73, 300, 30);
		Title.setFont(new Font("Serif", Font.BOLD, 20));
		Title.setBounds(20, 10, 200, 30);
		EarlyOfferInformation.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		EarlyOfferInformation.setForeground(new Color(255, 250, 250));
		EarlyOfferInformation.setBounds(500, 0, 300, 90);
		ExtracurricularInfo.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		ExtracurricularInfo.setForeground(new Color(255, 250, 250));
		ExtracurricularInfo.setBounds(500, 300, 300, 90);
		Yes.setFont(new Font("Serif", Font.PLAIN, 16));
		Yes.setBounds(200, 100, 200, 30);
		No.setFont(new Font("Serif", Font.PLAIN, 16));
		No.setBounds(300, 100, 200, 30);
		Yes2.setFont(new Font("Serif", Font.PLAIN, 16));
		Yes2.setBounds(200, 265, 200, 30);
		Coop.setFont(new Font("Serif", Font.BOLD, 16));
		Coop.setBounds(40, 293, 200, 30);
		CoopQuestion.setFont(new Font("Serif", Font.BOLD, 16));
		CoopQuestion.setBounds(157, 318, 300, 30);
		Yes3.setFont(new Font("Serif", Font.PLAIN, 16));
		Yes3.setBounds(200, 338, 200, 30);
		No3.setFont(new Font("Serif", Font.PLAIN, 16));
		No3.setBounds(300, 338, 200, 30);
		No2.setFont(new Font("Serif", Font.PLAIN, 16));
		No2.setBounds(300, 265, 200, 30);
		Extracurricular.setFont(new Font("Serif", Font.BOLD, 16));
		Extracurricular.setBounds(40, 130, 200, 30);
		ActionType.setFont(new Font("Serif", Font.BOLD, 13));
		ActionType.setBounds(70, 160, 200, 30);
		Description.setFont(new Font("Serif", Font.BOLD, 13));
		Description.setBounds(230, 160, 200, 30);
		EndDate.setFont(new Font("Serif", Font.BOLD, 12));
		EndDate.setBounds(466, 110, 200, 80);
		StarDate.setFont(new Font("Serif", Font.BOLD, 12));
		StarDate.setBounds(390, 110, 200, 80);
		Citzenship.setFont(new Font("Serif", Font.BOLD, 16));
		Citzenship.setBounds(40, 220, 200, 30);
		CitzenshipQuestion.setFont(new Font("Serif", Font.BOLD, 16));
		CitzenshipQuestion.setBounds(157, 245, 300, 30);
		ExtracurricularBox[0].setBounds(60, 190, 70, 20);
		ExtracurricularBox[1].setBounds(127, 190, 265, 20);
		ExtracurricularBox[2].setBounds(389, 190, 80, 20);
		ExtracurricularBox[3].setBounds(466, 190, 70, 20);

		ViewAll.setBounds(550, 180, 190, 40);
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

		close.setBounds(730, 60, 100, 70);
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
		

		close2.setBounds(475, 360, 100, 70);
		close2.setFont(new Font("Impact", Font.PLAIN, 20));
		close2.setForeground(new Color(255, 127, 80));
		close2.setBorderPainted(false);
		close2.setMargin(new Insets(0, 0, 0, 0));// set the distance between margin to zero
		close2.setIconTextGap(0);// set the distance between Icon and text to zero
		close2.setBorderPainted(false);// don't print the margin
		close2.setBorder(null);// delete the margin
		close2.setFocusPainted(false);// delete the frame for focus
		close2.setContentAreaFilled(false);
		close2.setVisible(true);
		

		save.setBounds(590, 130, 100, 40);
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

		next.setBounds(700, 400, 100, 50);
		next.setFont(new Font("Impact", Font.PLAIN, 35));
		next.setForeground(new Color(255, 127, 80));
		next.setBorderPainted(false);
		next.setMargin(new Insets(0, 0, 0, 0));
		next.setIconTextGap(0);
		next.setBorderPainted(false);
		next.setBorder(null);
		next.setFocusPainted(false);
		next.setContentAreaFilled(false);
		next.setVisible(true);

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

		ExtracurricularIncomplete.setFont(new Font("Serif", Font.PLAIN, 12));
		ExtracurricularIncomplete.setForeground(Color.RED);
		ExtracurricularIncomplete.setBounds(60, 204, 300, 30);

		WrongeDateType.setFont(new Font("Serif", Font.PLAIN, 12));
		WrongeDateType.setForeground(Color.RED);
		WrongeDateType.setBounds(300, 204, 300, 30);

		EarlyInformation.setBounds(185, 49, 25, 25);
		EarlyInformation.setIcon(new ImageIcon("images/kk.png"));
		EarlyInformation.setMargin(new Insets(0, 0, 0, 0));
		EarlyInformation.setIconTextGap(0);
		EarlyInformation.setBorderPainted(false);
		EarlyInformation.setBorder(null);
		EarlyInformation.setFocusPainted(false);
		EarlyInformation.setContentAreaFilled(false);
		EarlyInformation.setVisible(true);

		ExtracurricularInformation.setBounds(170, 130, 25, 25);
		ExtracurricularInformation.setIcon(new ImageIcon("images/kk.png"));
		ExtracurricularInformation.setMargin(new Insets(0, 0, 0, 0));
		ExtracurricularInformation.setIconTextGap(0);
		ExtracurricularInformation.setBorderPainted(false);
		ExtracurricularInformation.setBorder(null);
		ExtracurricularInformation.setFocusPainted(false);
		ExtracurricularInformation.setContentAreaFilled(false);
		ExtracurricularInformation.setVisible(true);

		choiceYes.setBounds(230, 110, 12, 15);
		choiceYes.setIcon(new ImageIcon("images/choice.png"));
		choiceYes.setBorderPainted(false);
		choiceYes.setMargin(new Insets(0, 0, 0, 0));// set the distance between margin to zero
		choiceYes.setIconTextGap(0);// set the distance between Icon and text to zero
		choiceYes.setBorderPainted(false);// don't print the margin
		choiceYes.setBorder(null);// delete the margin
		choiceYes.setFocusPainted(false);// delete the frame for focus
		choiceYes.setContentAreaFilled(false);
		choiceYes.setVisible(true);

		choiceNo.setBounds(330, 110, 12, 15);
		choiceNo.setIcon(new ImageIcon("images/choice.png"));
		choiceNo.setBorderPainted(false);
		choiceNo.setMargin(new Insets(0, 0, 0, 0));// set the distance between margin to zero
		choiceNo.setIconTextGap(0);// set the distance between Icon and text to zero
		choiceNo.setBorderPainted(false);// don't print the margin
		choiceNo.setBorder(null);// delete the margin
		choiceNo.setFocusPainted(false);// delete the frame for focus
		choiceNo.setContentAreaFilled(false);
		choiceNo.setVisible(true);

		choiceYes2.setBounds(230, 275, 12, 15);
		choiceYes2.setIcon(new ImageIcon("images/choice.png"));
		choiceYes2.setBorderPainted(false);
		choiceYes2.setMargin(new Insets(0, 0, 0, 0));// set the distance between margin to zero
		choiceYes2.setIconTextGap(0);// set the distance between Icon and text to zero
		choiceYes2.setBorderPainted(false);// don't print the margin
		choiceYes2.setBorder(null);// delete the margin
		choiceYes2.setFocusPainted(false);// delete the frame for focus
		choiceYes2.setContentAreaFilled(false);
		choiceYes2.setVisible(true);

		choiceNo2.setBounds(330, 275, 12, 15);
		choiceNo2.setIcon(new ImageIcon("images/choice.png"));
		choiceNo2.setBorderPainted(false);
		choiceNo2.setMargin(new Insets(0, 0, 0, 0));// set the distance between margin to zero
		choiceNo2.setIconTextGap(0);// set the distance between Icon and text to zero
		choiceNo2.setBorderPainted(false);// don't print the margin
		choiceNo2.setBorder(null);// delete the margin
		choiceNo2.setFocusPainted(false);// delete the frame for focus
		choiceNo2.setContentAreaFilled(false);
		choiceNo2.setVisible(true);

		choiceYes3.setBounds(230, 348, 12, 15);
		choiceYes3.setIcon(new ImageIcon("images/choice.png"));
		choiceYes3.setBorderPainted(false);
		choiceYes3.setMargin(new Insets(0, 0, 0, 0));// set the distance between margin to zero
		choiceYes3.setIconTextGap(0);// set the distance between Icon and text to zero
		choiceYes3.setBorderPainted(false);// don't print the margin
		choiceYes3.setBorder(null);// delete the margin
		choiceYes3.setFocusPainted(false);// delete the frame for focus
		choiceYes3.setContentAreaFilled(false);
		choiceYes3.setVisible(true);

		choiceNo3.setBounds(330, 348, 12, 15);
		choiceNo3.setIcon(new ImageIcon("images/choice.png"));
		choiceNo3.setBorderPainted(false);
		choiceNo3.setMargin(new Insets(0, 0, 0, 0));// set the distance between margin to zero
		choiceNo3.setIconTextGap(0);// set the distance between Icon and text to zero
		choiceNo3.setBorderPainted(false);// don't print the margin
		choiceNo3.setBorder(null);// delete the margin
		choiceNo3.setFocusPainted(false);// delete the frame for focus
		choiceNo3.setContentAreaFilled(false);
		choiceNo3.setVisible(true);

		TotalPanel.add(Title);
		TotalPanel.add(EarlyAccpetance);
		TotalPanel.add(EarlyAccpetanceQuestion);
		TotalPanel.add(Yes);
		TotalPanel.add(No);
		TotalPanel.add(Yes2);
		TotalPanel.add(No2);
		TotalPanel.add(Yes3);
		TotalPanel.add(No3);
		TotalPanel.add(choiceYes);
		TotalPanel.add(choiceNo);
		TotalPanel.add(Extracurricular);
		TotalPanel.add(ActionType);
		TotalPanel.add(Description);
		TotalPanel.add(next);
		TotalPanel.add(EndDate);
		TotalPanel.add(StarDate);
		TotalPanel.add(ExtracurricularBox[0]);
		TotalPanel.add(ExtracurricularBox[1]);
		TotalPanel.add(ExtracurricularBox[2]);
		TotalPanel.add(ExtracurricularBox[3]);
		TotalPanel.add(ViewAll);
		TotalPanel.add(Citzenship);
		TotalPanel.add(CitzenshipQuestion);
		TotalPanel.add(choiceYes2);
		TotalPanel.add(choiceNo2);
		TotalPanel.add(choiceNo3);
		TotalPanel.add(choiceYes3);
		TotalPanel.add(Coop);
		TotalPanel.add(CoopQuestion);
		TotalPanel.add(back);
		TotalPanel.add(EarlyInformation);
		TotalPanel.add(ExtracurricularInformation);
		TotalPanel.add(save);
		TotalPanel.add(ExtracurricularIncomplete);
		TotalPanel.add(WrongeDateType);
		TotalPanel.add(EarlyOfferInformation);
		TotalPanel.add(close);
		TotalPanel.add(ExtracurricularInfo);
		TotalPanel.add(close2);

		setContentPane(TotalPanel);
		TotalPanel.setOpaque(false);

		init();

		ExtracurricularIncomplete.setVisible(false);
		WrongeDateType.setVisible(false);
		close.setVisible(false);
		EarlyOfferInformation.setVisible(false);
		ExtracurricularInfo.setVisible(false);
		close2.setVisible(false);

		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				dispose();
				new ProfileScreenGUIScreenThree();
				
				close.setVisible(false);
				close2.setVisible(false);

				if (ProfileScreenGUIScreenThree.volunteerHourChoice != null) {
					if (ProfileScreenGUIScreenThree.volunteerHourChoice == true) {
						ProfileScreenGUIScreenThree.choiceYes.setIcon(new ImageIcon("images/choices.png"));
					} else {
						ProfileScreenGUIScreenThree.choiceNo.setIcon(new ImageIcon("images/choices.png"));
					}

				}

				for (int x = 0; x < 4; x++) {

					if (ExtracurricularBox[x].getText().isEmpty() == false)
						ExtracurricularBox[x].setText(null);

				}

			}
		});
		choiceYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				choiceNo.setIcon(new ImageIcon("images/choice.png"));
				choiceYes.setIcon(new ImageIcon("images/choices.png"));
				EarlyAccpetanceChoice = true;

			}

		});
		choiceNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				choiceYes.setIcon(new ImageIcon("images/choice.png"));
				choiceNo.setIcon(new ImageIcon("images/choices.png"));
				EarlyAccpetanceChoice = false;

			}

		});
		choiceYes2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				choiceNo2.setIcon(new ImageIcon("images/choice.png"));
				choiceYes2.setIcon(new ImageIcon("images/choices.png"));
				CitzenshipChoice = true;

			}

		});
		choiceNo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				choiceYes2.setIcon(new ImageIcon("images/choice.png"));
				choiceNo2.setIcon(new ImageIcon("images/choices.png"));
				CitzenshipChoice = false;
			}

		});
		choiceYes3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				choiceNo3.setIcon(new ImageIcon("images/choice.png"));
				choiceYes3.setIcon(new ImageIcon("images/choices.png"));
				CoopChoice = true;

			}

		});
		choiceNo3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				choiceYes3.setIcon(new ImageIcon("images/choice.png"));
				choiceNo3.setIcon(new ImageIcon("images/choices.png"));
				CoopChoice = false;

			}

		});

		ViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				new ExtracurricularViewAll();

			}

		});

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				dispose();
				close.setVisible(false);
				close2.setVisible(false);
				new ProfileScreenGUIScreenOne("Reload");

			}

		});

		EarlyInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				close.setVisible(true);
				EarlyOfferInformation.setVisible(true);

			}

		});

		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				close.setVisible(false);
				EarlyOfferInformation.setVisible(false);

			}

		});

		ExtracurricularInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				ExtracurricularInfo.setVisible(true);
				close2.setVisible(true);

				

			}

		});
		close2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				ExtracurricularInfo.setVisible(false);
				close2.setVisible(false);

			}

		});

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				if (DateType(ExtracurricularBox[2].getText()) == false
						|| DateType(ExtracurricularBox[3].getText()) == false
						|| Integer.valueOf(ExtracurricularBox[3].getText()) < Integer
								.valueOf(ExtracurricularBox[2].getText())) {

					WrongeDateType.setVisible(true);

					DateType = false;

				} else {
					DateType = true;
					WrongeDateType.setVisible(false);

				}

				if (ExtracurricularBox[0].getText().isEmpty() || ExtracurricularBox[1].getText().isEmpty()
						|| ExtracurricularBox[2].getText().isEmpty() || ExtracurricularBox[3].getText().isEmpty()) {

					ExtracurricularIncomplete.setVisible(true);

				} else {

					if (DateType == true) {
						ExtracurricularActionType.add(ExtracurricularBox[0].getText());
						ExtracurricularDescription.add(ExtracurricularBox[1].getText());
						ExtracurricularStarDate.add(ExtracurricularBox[2].getText());
						ExtracurricularEndDate.add(ExtracurricularBox[3].getText());

						ExtracurricularBox[0].setText(null);
						ExtracurricularBox[1].setText(null);
						ExtracurricularBox[2].setText(null);
						ExtracurricularBox[3].setText(null);

					}
					ExtracurricularIncomplete.setVisible(false);
				}

			}

		});

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

		ImageIcon img = new ImageIcon("images/background.PNG");
		JLabel imgLabel = new JLabel(img);
		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));// add the background to the LayeredPane
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// set the location of the background
	}
	

}