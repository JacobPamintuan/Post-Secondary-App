import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProfileScreenGUIScreenOne extends JFrame {

	public static JPanel TitlePanel = new JPanel();
	public static JLabel Title = new JLabel("Personal codeInformation");
	public static JLabel WrongCode = new JLabel("Wrong course code");
	public static JLabel WrongMark = new JLabel("Wrong Mark");
	public static JLabel QuestionTitle = new JLabel("1.Mark");
	public static JLabel CourseCode = new JLabel("Course code");
	public static JLabel CourseMark = new JLabel("Course mark");
	public JTextField CodeEnter = new JTextField(10);
	public JTextField MarkEnter = new JTextField(10);
	public  JTextField[] Code = new JTextField[6];
	public  JTextField[] Mark = new JTextField[6];
	public JButton save = new JButton("save");
	public JButton delete = new JButton("Delete");
	public JButton next = new JButton("Next");
	public JButton codeInformation = new JButton();
	public JButton markInformation = new JButton();
	public JButton deleteInformation = new JButton();
	public int index = 0;
	public int deleteIndex = 0;
	public Boolean CorrectCode;
	public Boolean CorrectMark;
	public Boolean CorrectCodeInBox;
	public Boolean CorrectMarkInBox;
	public static String MarkCollect[] = new String[6];
	public static String CodeCollect[] = new String[6];

	public ProfileScreenGUIScreenOne(String s) {

		setBounds(360, 60, 600, 500);
		setTitle("Profile Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		TitlePanel.setLayout(null);
		TitlePanel.setBounds(50, 50, 200, 30);
		TitlePanel.setBackground(Color.white);
		TitlePanel.setVisible(true);
		add(TitlePanel);

		Title.setFont(new Font("Serif", Font.PLAIN, 20));
		Title.setBounds(20, 10, 300, 30);

		WrongCode.setFont(new Font("Serif", Font.PLAIN, 12));
		WrongCode.setForeground(Color.RED);
		WrongCode.setBounds(120, 150, 300, 30);

		WrongMark.setFont(new Font("Serif", Font.PLAIN, 12));
		WrongMark.setForeground(Color.RED);
		WrongMark.setBounds(380, 150, 300, 30);

		QuestionTitle.setFont(new Font("Serif", Font.BOLD, 16));
		QuestionTitle.setBounds(40, 60, 200, 30);
		CourseCode.setFont(new Font("Serif", Font.PLAIN, 15));
		CourseCode.setBounds(120, 100, 200, 30);
		CourseMark.setFont(new Font("Serif", Font.PLAIN, 15));
		CourseMark.setBounds(380, 100, 200, 30);
		CodeEnter.setBounds(100, 130, 130, 20);
		MarkEnter.setBounds(360, 130, 130, 20);
		save.setBounds(245, 150, 100, 30);
		delete.setBounds(170, 330, 100, 30);
		next.setBounds(460, 420, 100, 30);

		codeInformation.setBounds(210, 103, 25, 25);
		codeInformation.setIcon(new ImageIcon("images/kk.png"));
		codeInformation.setBorderPainted(false);
		codeInformation.setVisible(true);

		markInformation.setBounds(470, 103, 25, 25);
		markInformation.setIcon(new ImageIcon("images/kk.png"));
		markInformation.setBorderPainted(false);
		markInformation.setVisible(true);

		deleteInformation.setBounds(280, 333, 25, 25);
		deleteInformation.setIcon(new ImageIcon("images/kk.png"));
		deleteInformation.setBorderPainted(false);
		deleteInformation.setVisible(true);

		for (int y = 0; y < 6; y++) {

			Code[y] = new JTextField(25);
			
			Code[y].setBounds(170, 200 + 20 * y, 130, 20);
		}
		for (int x = 0; x < 6; x++) {

			Mark[x] = new JTextField(25);
			
			Mark[x].setBounds(300, 200 + 20 * x, 130, 20);

		}

		TitlePanel.add(CodeEnter);
		TitlePanel.add(Title);
		TitlePanel.add(CourseMark);
		TitlePanel.add(QuestionTitle);
		TitlePanel.add(CourseCode);
		TitlePanel.add(save);
		TitlePanel.add(delete);
		TitlePanel.add(next);
		TitlePanel.add(codeInformation);
		TitlePanel.add(markInformation);
		TitlePanel.add(deleteInformation);
		TitlePanel.add(WrongCode);
		TitlePanel.add(WrongMark);
		WrongCode.setVisible(false);
		WrongMark.setVisible(false);

		for (int y = 0; y < 6; y++)
			TitlePanel.add(Code[y]);

		TitlePanel.add(MarkEnter);

		for (int x = 0; x < 6; x++)
			TitlePanel.add(Mark[x]);

		setVisible(true);
		
		if(s.equals("Reload")) {
			
			for (int x = 0; x < 6; x++) {
			
				
						if (CodeCollect[x].isEmpty() == false && MarkCollect[x].isEmpty() == false) { 
					Code[x].setText(CodeCollect[x]);
					Mark[x].setText(MarkCollect[x]);

				}

			}
			
		}
			
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				WrongCode.setVisible(false);

				if (CodeEnter.getText().length() == 5) {

					if (isLetterCapitalLetter(CodeEnter.getText().substring(0, 2)) == true
							&& isUorM(CodeEnter.getText().substring(4)) == true
							&& CodeEnter.getText().substring(3, 4).equals("4")) {

						CorrectCode = true;
					} else {
						WrongCode.setVisible(true);
						CorrectCode = false;
					}
				} else {
					WrongCode.setVisible(true);
					CorrectCode = false;
				}

				if (isDigit(MarkEnter.getText()) == true) {
					if (Integer.valueOf(MarkEnter.getText()) >= 0 && Integer.valueOf(MarkEnter.getText()) <= 100) {

						CorrectMark = true;
					} else {
						WrongMark.setVisible(true);
						CorrectMark = false;
					}

				} else {
					WrongMark.setVisible(true);
					CorrectMark = false;
				}

				if (CorrectMark == true && CorrectCode == true) {
					String code = CodeEnter.getText();
					Code[index].setText(code);
					CodeEnter.setText(null);
					String mark = MarkEnter.getText();
					Mark[index].setText(mark);
					
					MarkEnter.setText(null);
					deleteIndex = index;
					if (index != 5)
						index++;
				}
			}

		});
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				

				for (int x = 0; x < 6; x++) {
					
					

					if (Mark[x].getText().isEmpty() == false) {

						if (Integer.valueOf(Mark[x].getText()) < 0 && Integer.valueOf(Mark[x].getText()) > 100) {

							CorrectMarkInBox = false;
							break;

						}else {
							
							CorrectMarkInBox = true;
						}

					}else {
						
						CorrectMarkInBox = true;
						
					}

					if (Code[x].getText().isEmpty() == false) {
						
						
						if(Code[x].getText().length()!=5) {
							
							CorrectCodeInBox = false;
							break;
							
						}

						if (isLetterCapitalLetter(Code[x].getText().substring(0, 2)) == true
								&& isUorM(Code[x].getText().substring(4)) == true
								&& Code[x].getText().substring(3, 4).equals("4")) {
							
							CorrectCodeInBox = true;

						} else {

							CorrectCodeInBox = false;
							break;

						}

					}else {
						
						CorrectCodeInBox = true;
					}

				}

				if (CorrectMarkInBox == true && CorrectCodeInBox == true) {
					storeInformation();
					dispose();
					new ProfileScreenGUIScreenTwo();
					
					System.out.println(Code[1].getText()+"  "+Mark[1].getText());
					
				} else {
					System.out.println("ds");
				}

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
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				Code[deleteIndex].setText(null);
				Mark[deleteIndex].setText(null);
				index = deleteIndex;
				if (index != 0)
					deleteIndex--;

			}

		});
		codeInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				new Information();

			}

		});
		markInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				new Information();

			}

		});
		deleteInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				new Information();

			}

		});
	}

	public static boolean isLetterCapitalLetter(String str) {
		String regex = "^[A-Z]+$";
		return str.matches(regex);
	}

	public static boolean isDigit(String str) {

		String regex = "^[0-9]+$";
		return str.matches(regex);
	}

	public static boolean isUorM(String str) {
		if (str.equals("U") || str.equals("M"))
			return true;
		else
			return false;
	}

	public void storeInformation() {

		for (int x = 0; x < 6; x++) {

			MarkCollect[x] = Mark[x].getText();

			CodeCollect[x] = Code[x].getText();

		}

	}

	

}
