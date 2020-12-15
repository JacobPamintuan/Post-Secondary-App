import java.awt.Color;
import java.awt.Font;
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
	public static JLabel StarDate = new JLabel("Start Date");
	public static JLabel EndDate = new JLabel("End Date");
	public static JLabel ExtracurricularIncomplete = new JLabel("The information isn't filled out.");
	public static JLabel WrongeDateType = new JLabel("Wrong Date Type.");
	private JTextField[] ExtracurricularBox = new JTextField[4];
	public JButton next = new JButton("Next");
	public JButton back = new JButton("Back");
	public JButton save = new JButton("Save");
	public JButton EarlyInformation = new JButton();
	public JButton ExtracurricularInformation = new JButton();
	public static Boolean EarlyAccpetanceChoice=null;
	public static Boolean CitzenshipChoice=null;
	public static Boolean CoopChoice=null;
	public static Boolean DateType=null;
	public static ArrayList<String> ExtracurricularActionType = new ArrayList<String>();
	public static ArrayList<String> ExtracurricularDescription = new ArrayList<String>();
	public static ArrayList<String> ExtracurricularStarDate = new ArrayList<String>();
	public static ArrayList<String> ExtracurricularEndDate = new ArrayList<String>();

	public ProfileScreenGUIScreenTwo() {

		setBounds(360, 60, 600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Profile Screen");

		TotalPanel.setLayout(null);
		TotalPanel.setBounds(50, 50, 200, 30);
		TotalPanel.setBackground(Color.white);
		TotalPanel.setVisible(true);
		add(TotalPanel);

		for (int x = 0; x < 4; x++)
			ExtracurricularBox[x] = new JTextField(10);

		EarlyAccpetance.setFont(new Font("Serif", Font.PLAIN, 16));
		EarlyAccpetance.setBounds(40, 45, 200, 30);
		EarlyAccpetanceQuestion.setFont(new Font("Serif", Font.BOLD, 16));
		EarlyAccpetanceQuestion.setBounds(157, 73, 300, 30);
		Title.setFont(new Font("Serif", Font.PLAIN, 20));
		Title.setBounds(20, 10, 200, 30);
		Yes.setFont(new Font("Serif", Font.PLAIN, 16));
		Yes.setBounds(200, 100, 200, 30);
		No.setFont(new Font("Serif", Font.PLAIN, 16));
		No.setBounds(300, 100, 200, 30);
		Yes2.setFont(new Font("Serif", Font.PLAIN, 16));
		Yes2.setBounds(200, 265, 200, 30);
		Coop.setFont(new Font("Serif", Font.PLAIN, 16));
		Coop.setBounds(40, 293, 200, 30);
		CoopQuestion.setFont(new Font("Serif", Font.BOLD, 16));
		CoopQuestion.setBounds(157, 318, 300, 30);
		Yes3.setFont(new Font("Serif", Font.PLAIN, 16));
		Yes3.setBounds(200, 338, 200, 30);
		No3.setFont(new Font("Serif", Font.PLAIN, 16));
		No3.setBounds(300, 338, 200, 30);
		No2.setFont(new Font("Serif", Font.PLAIN, 16));
		No2.setBounds(300, 265, 200, 30);
		Extracurricular.setFont(new Font("Serif", Font.PLAIN, 16));
		Extracurricular.setBounds(40, 130, 200, 30);
		ActionType.setFont(new Font("Serif", Font.PLAIN, 10));
		ActionType.setBounds(70, 160, 200, 30);
		Description.setFont(new Font("Serif", Font.PLAIN, 10));
		Description.setBounds(230, 160, 200, 30);
		EndDate.setFont(new Font("Serif", Font.PLAIN, 10));
		EndDate.setBounds(440, 160, 200, 30);
		StarDate.setFont(new Font("Serif", Font.PLAIN, 10));
		StarDate.setBounds(390, 160, 200, 30);
		Citzenship.setFont(new Font("Serif", Font.PLAIN, 16));
		Citzenship.setBounds(40, 220, 200, 30);
		CitzenshipQuestion.setFont(new Font("Serif", Font.BOLD, 16));
		CitzenshipQuestion.setBounds(157, 245, 300, 30);
		ExtracurricularBox[0].setBounds(60, 190, 70, 20);
		ExtracurricularBox[1].setBounds(127, 190, 265, 20);
		ExtracurricularBox[2].setBounds(389, 190, 50, 20);
		ExtracurricularBox[3].setBounds(436, 190, 50, 20);
		ViewAll.setBounds(440, 220, 90, 20);
		save.setBounds(200, 140, 70, 15);
		next.setBounds(460, 420, 100, 30);
		back.setBounds(30, 420, 100, 30);

		ExtracurricularIncomplete.setFont(new Font("Serif", Font.PLAIN, 12));
		ExtracurricularIncomplete.setForeground(Color.RED);
		ExtracurricularIncomplete.setBounds(60, 204, 300, 30);
		

		WrongeDateType.setFont(new Font("Serif", Font.PLAIN, 12));
		WrongeDateType.setForeground(Color.RED);
		WrongeDateType.setBounds(300, 204, 300, 30);

		EarlyInformation.setBounds(180, 47, 25, 25);
		EarlyInformation.setIcon(new ImageIcon("images/kk.png"));
		EarlyInformation.setBorderPainted(false);
		EarlyInformation.setVisible(true);

		ExtracurricularInformation.setBounds(160, 130, 25, 25);
		ExtracurricularInformation.setIcon(new ImageIcon("images/kk.png"));
		ExtracurricularInformation.setBorderPainted(false);
		ExtracurricularInformation.setVisible(true);

		choiceYes.setBounds(230, 110, 12, 15);
		choiceYes.setIcon(new ImageIcon("images/choice.png"));
		choiceYes.setBorderPainted(false);
		choiceYes.setVisible(true);

		choiceNo.setBounds(330, 110, 12, 15);
		choiceNo.setIcon(new ImageIcon("images/choice.png"));
		choiceNo.setBorderPainted(false);
		choiceNo.setVisible(true);

		choiceYes2.setBounds(230, 275, 12, 15);
		choiceYes2.setIcon(new ImageIcon("images/choice.png"));
		choiceYes2.setBorderPainted(false);
		choiceYes2.setVisible(true);

		choiceNo2.setBounds(330, 275, 12, 15);
		choiceNo2.setIcon(new ImageIcon("images/choice.png"));
		choiceNo2.setBorderPainted(false);
		choiceNo2.setVisible(true);

		choiceYes3.setBounds(230, 348, 12, 15);
		choiceYes3.setIcon(new ImageIcon("images/choice.png"));
		choiceYes3.setBorderPainted(false);
		choiceYes3.setVisible(true);

		choiceNo3.setBounds(330, 348, 12, 15);
		choiceNo3.setIcon(new ImageIcon("images/choice.png"));
		choiceNo3.setBorderPainted(false);
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
		ExtracurricularIncomplete.setVisible(false);
		WrongeDateType.setVisible(false);
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				dispose();
				new ProfileScreenGUIScreenThree();
				
				
				
				if(ProfileScreenGUIScreenThree.volunteerHourChoice!=null) {
				if(ProfileScreenGUIScreenThree.volunteerHourChoice==true) {
					ProfileScreenGUIScreenThree.choiceYes.setIcon(new ImageIcon("images/choices.jpeg"));}
				else {
					ProfileScreenGUIScreenThree.choiceNo.setIcon(new ImageIcon("images/choices.jpeg"));}
				
			}

			}
		});
		choiceYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				choiceNo.setIcon(new ImageIcon("images/choice.png"));
				choiceYes.setIcon(new ImageIcon("images/choices.jpeg"));
				EarlyAccpetanceChoice = true;

			}

		});
		choiceNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				choiceYes.setIcon(new ImageIcon("images/choice.png"));
				choiceNo.setIcon(new ImageIcon("images/choices.jpeg"));
				EarlyAccpetanceChoice = false;

			}

		});
		choiceYes2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				choiceNo2.setIcon(new ImageIcon("images/choice.png"));
				choiceYes2.setIcon(new ImageIcon("images/choices.jpeg"));
				CitzenshipChoice = true;

			}

		});
		choiceNo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				choiceYes2.setIcon(new ImageIcon("images/choice.png"));
				choiceNo2.setIcon(new ImageIcon("images/choices.jpeg"));
				CitzenshipChoice= false;
			}

		});
		choiceYes3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				choiceNo3.setIcon(new ImageIcon("images/choice.png"));
				choiceYes3.setIcon(new ImageIcon("images/choices.jpeg"));
				CoopChoice = true;

			}

		});
		choiceNo3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				choiceYes3.setIcon(new ImageIcon("images/choice.png"));
				choiceNo3.setIcon(new ImageIcon("images/choices.jpeg"));
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
				new ProfileScreenGUIScreenOne("Reload");

			}

		});

		EarlyInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				new Information();

			}

		});

		ExtracurricularInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				new Information();

			}

		});

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				if(DateType(ExtracurricularBox[2].getText())==false|| DateType(ExtracurricularBox[3].getText())==false) {
					
					WrongeDateType.setVisible(true);
					
					DateType=false;
				
				}else {
					DateType=true;
					WrongeDateType.setVisible(false);
					
				}
				

				if (ExtracurricularBox[0].getText().isEmpty()|| ExtracurricularBox[1].getText().isEmpty()
						|| ExtracurricularBox[2].getText().isEmpty() ||ExtracurricularBox[3].getText().isEmpty()) {
					
					
					ExtracurricularIncomplete.setVisible(true);

				}else{
					
					if(DateType==true) {
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


	
	public Boolean DateType(String s ) {
		
		if(s.length()!=6)
			return false;
		
		int firstTwoDigits=Integer.parseInt(s.substring(0,2));
		int ThirdFourthDigits=Integer.parseInt(s.substring(2,4));
		int LastDigits=Integer.parseInt(s.substring(4));
		
		if(firstTwoDigits<0||firstTwoDigits>20||ThirdFourthDigits<1||ThirdFourthDigits>12||LastDigits<1||LastDigits>32)
			return false;
		
		return true;
		
	}

}
