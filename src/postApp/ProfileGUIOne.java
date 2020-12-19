package postApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class ProfileGUIOne extends JFrame implements DocumentListener {

	//initialize the variables
	public static JPanel TitlePanel = new JPanel();
	public static JLabel Title = new JLabel("Personal codeInformation");
	public static JLabel WrongCode = new JLabel("Wrong course code");
	public static JLabel WrongMark = new JLabel("Wrong Mark");
	public static JLabel WrongWarning = new JLabel(
			"<html>There is something wrong in the table.<br/>Fix them to continue.");
	public static JLabel QuestionTitle = new JLabel("1.Mark");
	public static JLabel CourseCode = new JLabel("Course code");
	public static JLabel CourseMark = new JLabel("Course mark");
	public JLabel[] WrongCodeInBox = new JLabel[6];
	public JLabel[] WrongMarkInBox = new JLabel[6];
	public static JLabel CrouseInformation = new JLabel(
			"<html>You can enter any courses <br/>you had in G11 or G12.<br/>Tips: These courses must be 'M' or'U' type");
	public JTextField CodeEnter = new JTextField(10);
	public JTextField MarkEnter = new JTextField(10);
	public JTextField[] Code = new JTextField[6];
	public JTextField[] Mark = new JTextField[6];
	public JButton save = new JButton("Save");
	public JButton delete = new JButton("Delete");
	public JButton next = new JButton("NEXT");
	public JButton codeInformation = new JButton();
	public JButton closeInformation = new JButton("CLOSE");
	public int index = 0;
	public int deleteIndex = 0;
	public Boolean CorrectCode;
	public Boolean CorrectMark;
	public Boolean CorrectCodeInBox1[] = new Boolean[6];
	public Boolean CorrectMarkInBox1[] = new Boolean[6];
	public Boolean CorrectCodeInBox = true;
	public Boolean CorrectMarkInBox = true;
	public static String MarkCollect[] = new String[6];
	public static String CodeCollect[] = new String[6];
	public JLabel background = new JLabel();
	
	//set the first screen
	public ProfileGUIOne(String s) {

		setBounds(360, 60, 832, 500);
		setTitle("Profile Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close all the window when this window is closed

		TitlePanel.setLayout(null);
		TitlePanel.setBounds(50, 50, 200, 30);
		TitlePanel.setBackground(Color.white);
		TitlePanel.setVisible(true);
		add(TitlePanel);// add the JPanel to tthe JFrame

		//Add the tiltle
		Title.setFont(new Font("Serif", Font.BOLD, 20));
		Title.setBounds(20, 10, 300, 30);

		//Add the wrong code warning
		WrongCode.setFont(new Font("Serif", Font.PLAIN, 12));
		WrongCode.setForeground(Color.RED);
		WrongCode.setBounds(225, 160, 300, 30);

		//Add the information of course
		CrouseInformation.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		CrouseInformation.setForeground(new Color(0, 0, 0));
		CrouseInformation.setBounds(10, 70, 300, 300);

		//Add the wrong warning
		WrongWarning.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		WrongWarning.setForeground(new Color(205, 92, 92));
		WrongWarning.setBounds(10, 200, 300, 300);

		//add the button to close the information 
		closeInformation.setFont(new Font("Nunito", Font.BOLD, 20));
		closeInformation.setForeground(new Color(255, 127, 80));
		closeInformation.setBounds(10, 250, 70, 40);
		closeInformation.setMargin(new Insets(0, 0, 0, 0));
		closeInformation.setIconTextGap(0);
		closeInformation.setBorderPainted(false);
		closeInformation.setBorder(null);
		closeInformation.setFocusPainted(false);
		closeInformation.setContentAreaFilled(false);
		closeInformation.setVisible(false);//the codes above are used to set the button invisible(just show the word instead)

		//Add the wrong mark warning
		WrongMark.setFont(new Font("Serif", Font.PLAIN, 12));
		WrongMark.setForeground(Color.RED);
		WrongMark.setBounds(525, 160, 300, 30);

		//Add the qeustion
		QuestionTitle.setFont(new Font("Serif", Font.BOLD, 20));
		QuestionTitle.setBounds(40, 60, 200, 30);
		
		//Add the course code title
		CourseCode.setFont(new Font("Oswald", Font.BOLD, 20));
		CourseCode.setBounds(215, 120, 200, 30);
		
		//Add the course mark title
		CourseMark.setFont(new Font("Oswald", Font.BOLD, 20));
		CourseMark.setBounds(520, 120, 200, 30);
		
		CodeEnter.setBounds(225, 150, 110, 20);
		MarkEnter.setBounds(525, 150, 110, 20);
		
		//Add the save button and set the button invisible(just show the word)
		save.setBounds(395, 170, 80, 40);
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

		//Add the delete button and set the button invisible(just show the word)
		delete.setBounds(200, 360, 130, 70);
		delete.setFont(new Font("Impact", Font.PLAIN, 40));
		delete.setForeground(new Color(255, 127, 80));
		delete.setBorderPainted(false);
		delete.setMargin(new Insets(0, 0, 0, 0));
		delete.setIconTextGap(0);
		delete.setBorderPainted(false);
		delete.setBorder(null);
		delete.setFocusPainted(false);
		delete.setContentAreaFilled(false);
		delete.setVisible(true);

		////Add the next button and set the button invisible(just show the word)
		next.setBounds(625, 370, 130, 60);
		next.setFont(new Font("Impact", Font.PLAIN, 60));
		next.setForeground(new Color(255, 127, 80));
		next.setBorderPainted(false);
		next.setMargin(new Insets(0, 0, 0, 0));
		next.setIconTextGap(0);
		next.setBorderPainted(false);
		next.setBorder(null);
		next.setFocusPainted(false);
		next.setContentAreaFilled(false);
		next.setVisible(true);

		//Add the instructioin button and set the button invisible(just show the word)
		codeInformation.setBounds(346, 127, 25, 25);
		codeInformation.setIcon(new ImageIcon("Images/Info.png"));
		codeInformation.setBorderPainted(false);
		codeInformation.setMargin(new Insets(0, 0, 0, 0));// set the distance between margin to zero
		codeInformation.setIconTextGap(0);// set the distance between Icon and text to zero
		codeInformation.setBorderPainted(false);// don't print the margin
		codeInformation.setBorder(null);// delete the margin
		codeInformation.setFocusPainted(false);// delete the frame for focus
		codeInformation.setContentAreaFilled(false);
		codeInformation.setVisible(true);

		//assume all the codes and marks in the box are right
		for (int x = 0; x < 6; x++) {
			CorrectCodeInBox1[x] = true;
			CorrectMarkInBox1[x] = true;
		}

		//add the warning that will show up besides the table(used when sers type directly in the box)
		for (int x = 0; x < 6; x++) {

			WrongCodeInBox[x] = new JLabel("Wrong Code");
			WrongCodeInBox[x].setFont(new Font("Impact", Font.PLAIN, 14));
			WrongCodeInBox[x].setForeground(Color.RED);
			WrongCodeInBox[x].setBounds(200, 215 + 25 * x, 300, 25);

			WrongMarkInBox[x] = new JLabel("Wrong Mark");
			WrongMarkInBox[x].setFont(new Font("Impact", Font.PLAIN, 14));
			WrongMarkInBox[x].setForeground(Color.RED);
			WrongMarkInBox[x].setBounds(595, 215 + 25 * x, 300, 25);

			TitlePanel.add(WrongCodeInBox[x]);
			TitlePanel.add(WrongMarkInBox[x]);
			WrongCodeInBox[x].setVisible(false);
			WrongMarkInBox[x].setVisible(false);// set the JLabel to false

		}

		//initailize the textfield where store the Course Code user are put in
		//the textfields are not enable to edit utill users have input some information in them 
		for (int y = 0; y < 6; y++) {

			Code[y] = new JTextField(25);

			Code[y].setBounds(290, 215 + 25 * y, 150, 25);
			Code[y].enable(false);

			//after the users input the course code into the TextFields
			//they will be able to edit, so these codes are used for the error checking
			Code[y].getDocument().addDocumentListener(new DocumentListener() {

				//check ever time when user remove something in the text box
				public void removeUpdate(DocumentEvent e) {

					//check all the six boxes
					for (int x = 0; x < 6; x++) {
						
						//asssume the code is right
						CorrectCodeInBox1[x] = true;

						//when the box is not empty
						if (Code[x].getText().isEmpty() == false) {
							
							//if the code itself is wrong or it is the same as the other course in the box
							//system show the error
							if (CodeBoxChecking(Code[x].getText()) == false
									|| RepeatCourseCode(Code[x].getText(), x) == false) {

								WrongCodeInBox[x].setVisible(true);
								CorrectCodeInBox1[x] = false;

							} else {
								WrongCodeInBox[x].setVisible(false);//otherwise, make the warning invisible

							}
						} else {
							WrongCodeInBox[x].setVisible(false);//when the box is empty, don't show the warning

						}

					}

				}

				//check everytime when user input something in the text box(the checking process is the same as remove update)
				public void insertUpdate(DocumentEvent e) {

					//check all the textboxes
					for (int x = 0; x < 6; x++) {

						CorrectCodeInBox1[x] = true;

						//if the code itself is wrong or it is the same as the other course in the box
							//system show the error
						if (Code[x].getText().isEmpty() == false) {
							if (CodeBoxChecking(Code[x].getText()) == false
									|| RepeatCourseCode(Code[x].getText(), x) == false) {

								WrongCodeInBox[x].setVisible(true);
								CorrectCodeInBox1[x] = false;

							} else {
								WrongCodeInBox[x].setVisible(false);

							}
						} else {
							WrongCodeInBox[x].setVisible(false);
						}

					}

				}

				public void changedUpdate(DocumentEvent e) {

				}
			});

		}

		//set the boxes to store users marks
		//the textfields are not enable to edit utill users have input some information in them 
		for (int y = 0; y < 6; y++) {

			Mark[y] = new JTextField(25);

			Mark[y].setBounds(440, 215 + 25 * y, 150, 25);
			Mark[y].enable(false);

			
			//after the users input the mark into the TextFields
			//they will be able to edit, so these codes are used for the error checking
			Mark[y].getDocument().addDocumentListener(new DocumentListener() {

				public void removeUpdate(DocumentEvent e) {

					for (int x = 0; x < 6; x++) {

						CorrectMarkInBox1[x] = true;//assume the amrk is correct
						
						//if the mark itself is wrong system show the error
						if (Mark[x].getText().isEmpty() == false) {
							if (MarkBoxChecking(Mark[x].getText()) == false) {
								WrongMarkInBox[x].setVisible(true);
								CorrectMarkInBox1[x] = false;

							} else {
								WrongMarkInBox[x].setVisible(false);//Otherwise set the warning invisible

							}
						} else {
							WrongMarkInBox[x].setVisible(false);// if the text field is empty, set the warning invisible too

						}

					}

				}

				//check evertime user inout something into the Text Fields
				public void insertUpdate(DocumentEvent e) {

					//check all the TextFields
					for (int x = 0; x < 6; x++) {

						CorrectMarkInBox1[x] = true;//assue all the TextFields are correct

						//if the mark is worn ,show the warning
						if (Mark[x].getText().isEmpty() == false) {
							if (MarkBoxChecking(Mark[x].getText()) == false) {
								WrongMarkInBox[x].setVisible(true);
								CorrectMarkInBox1[x] = false;

							} else {
								WrongMarkInBox[x].setVisible(false);//otherwise make the warning invisible

							}
						} else {
							WrongMarkInBox[x].setVisible(false);// if the text field is empty, set the warning invisible too

						}

					}

				}

				public void changedUpdate(DocumentEvent e) {

				}
			});

		}

		//add all the components to the Panel
		TitlePanel.add(Title);
		TitlePanel.add(CourseMark);
		TitlePanel.add(QuestionTitle);
		TitlePanel.add(CourseCode);
		TitlePanel.add(CodeEnter);
		TitlePanel.add(save);
		TitlePanel.add(delete);
		TitlePanel.add(next);
		TitlePanel.add(codeInformation);
		TitlePanel.add(WrongCode);
		TitlePanel.add(WrongMark);
		TitlePanel.add(CrouseInformation);
		TitlePanel.add(closeInformation);
		TitlePanel.add(WrongWarning);

		//make both the warnings and information invisible
		CrouseInformation.setVisible(false);
		WrongCode.setVisible(false);
		WrongMark.setVisible(false);
		WrongWarning.setVisible(false);
		
		//
		setContentPane(TitlePanel);
		TitlePanel.setOpaque(false);

		//add the Text field that show users the information they input
		for (int y = 0; y < 6; y++)
			TitlePanel.add(Code[y]);

		//add the Text field where users can input their mark
		TitlePanel.add(MarkEnter);

		for (int x = 0; x < 6; x++)
			TitlePanel.add(Mark[x]);

		setVisible(true);
		init();

		if (s.equals("Reload")) {

			for (int x = 0; x < 6; x++) {

				if (CodeCollect[x].isEmpty() == false && MarkCollect[x].isEmpty() == false) {
					Code[x].setText(CodeCollect[x]);
					Mark[x].setText(MarkCollect[x]);

					Mark[x].enable(true);
					Code[x].enable(true);
				}

			}

		}

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				WrongCode.setVisible(false);

				if (CodeEnter.getText().length() == 5) {

					if (isLetterCapitalLetter(CodeEnter.getText().substring(0, 2)) == true
							&& isUorM(CodeEnter.getText().substring(4)) == true
							&& CodeEnter.getText().substring(3, 4).matches("^[3-4]+$")) {

						CorrectCode = true;
						WrongCode.setVisible(false);
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
						WrongMark.setVisible(false);
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
					Mark[index].enable(true);
					Code[index].enable(true);

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

					if (CorrectMarkInBox1[x] == false)
						CorrectMarkInBox = false;

					if (CorrectCodeInBox1[x] == false)
						CorrectCodeInBox = false;

				}

				if (CorrectMarkInBox == true && CorrectCodeInBox == true) {
					storeInformation();
					dispose();
					new ProfileGUITwo();
					
					CrouseInformation.setVisible(false);
					closeInformation.setVisible(false);

					if (CodeEnter.getText().isEmpty() == false)
						CodeEnter.setText(null);

					if (MarkEnter.getText().isEmpty() == false)
						MarkEnter.setText(null);

				} else {

					WrongWarning.setVisible(true);
					System.out.println("a");
				}

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

				CrouseInformation.setVisible(true);
				closeInformation.setVisible(true);

			}

		});

		closeInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				CrouseInformation.setVisible(false);
				closeInformation.setVisible(false);

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

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	public Boolean CodeBoxChecking(String s) {

		if (s.isEmpty() == false) {

			if (s.length() != 5) {

				CorrectCodeInBox = false;
				return false;

			}

			if (isLetterCapitalLetter(s.substring(0, 2)) == true && isUorM(s.substring(4)) == true
					&& s.substring(3, 4).matches("^[3-4]+$")) {

				CorrectCodeInBox = true;
				return true;

			} else {

				CorrectCodeInBox = false;
				return false;

			}

		} else {

			CorrectCodeInBox = false;
			return false;
		}

	}

	public Boolean MarkBoxChecking(String s) {

		if (isDigit(s) == true) {

			if (Integer.valueOf(s) < 0 && Integer.valueOf(s) > 100) {

				CorrectMarkInBox = false;
				return false;

			} else {

				CorrectMarkInBox = true;
				return true;
			}

		} else {

			CorrectMarkInBox = false;
			return false;

		}

	}

	public Boolean RepeatCourseCode(String s, int index) {

		for (int x = 0; x < 6; x++) {

			if (s.equals(Code[x].getText()) && Code[x].getText().isEmpty() == false && x != index)
				return false;

		}

		return true;
	}

	public void init() {

		ImageIcon img = new ImageIcon("Images/background.PNG");
		JLabel imgLabel = new JLabel(img);
		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));// add the background to the LayeredPane
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// set the location of the background
	}

}
