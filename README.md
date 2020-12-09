import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProfileScreenGUIScreenOne extends JFrame{
	
	public static JPanel TitlePanel= new JPanel();
	public  static JLabel Title = new JLabel("Personal information");
	public  static JLabel QuestionTitle = new JLabel("1.Mark");
	public  static JLabel CourseCode= new JLabel("Course code");
	public  static JLabel CourseMark = new JLabel("Course mark");
	private JTextField CodeEnter=new JTextField(10);
	private JTextField MarkEnter=new JTextField(10);
	private JTextField Code=new JTextField(25);
	private JTextField Mark=new JTextField(25);
	public JButton save= new JButton("save");
	
	public ProfileScreenGUIScreenOne() {
		
		setBounds(360,60,600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
		TitlePanel.setLayout(null);
        TitlePanel.setBounds(50, 50, 200, 30);
        TitlePanel.setBackground(Color.white);
        TitlePanel.setVisible(true);
        add(TitlePanel);
        
        
		Title.setFont(new Font("Serif", Font.PLAIN, 20));
		Title.setBounds(20, 10, 200, 30);
		
		QuestionTitle.setFont(new Font("Serif", Font.BOLD, 16));
		QuestionTitle.setBounds(40, 60, 200, 30);
		CourseCode.setFont(new Font("Serif", Font.PLAIN, 15));
		CourseCode.setBounds(120,100,200,30);
		CourseMark.setFont(new Font("Serif", Font.PLAIN, 15));
		CourseMark.setBounds(380,100,200,30);
		CodeEnter.setBounds(100, 130, 130, 20);
		MarkEnter.setBounds(360, 130, 130, 20);
		Code.setBounds(170, 200, 130, 20);
		save.setBounds(245,150,100,30);
		Mark.setBounds(300, 200, 130, 20);
		
		
		
		TitlePanel.add(CodeEnter);
		TitlePanel.add(Title);
		TitlePanel.add(CourseMark);
		TitlePanel.add(QuestionTitle);
		TitlePanel.add(CourseCode);
		TitlePanel.add(save);
		TitlePanel.add(Code);
		TitlePanel.add(MarkEnter);
		TitlePanel.add(Mark);
		setVisible(true);		
		save.addActionListener(new ActionListener() {
			public void	actionPerformed(ActionEvent event) {
				String code=CodeEnter.getText();
				String mark=MarkEnter.getText();
				Code.setText(code);
				Mark.setText(mark);
				
				
			}
			
		});
		
		
		
	}

}
