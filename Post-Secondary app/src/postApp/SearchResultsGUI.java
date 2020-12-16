package postApp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SearchResultsGUI implements ActionListener {
	
	public ProcessingInformation data;
	
	public JFrame results = new JFrame();
	
	private JPanel[] showResults = new JPanel[6];

	private String searchResult;
	private String[] tagResults;

	private JButton[] addProgram = new JButton[6];
	private JButton[] moreInformation = new JButton[6];

	// For displaying the program Name and information
	private JLabel[] programName = new JLabel[6];
	private JLabel[] programSchool = new JLabel[6];
	
	// OUAC logo image
	private ImageIcon ouacImage = new ImageIcon(); 
	private JLabel image = new JLabel();


	// A constructor which is called by the search class when Basic Search is used
	public SearchResultsGUI(String searchResult) {
		super();
		this.searchResult = searchResult;
		setResultLayout();
		displayResults();
	}

	// A constructor which is called by the search class when Search only using tags is used
	public SearchResultsGUI(String[] tagResults) {
		super();
		this.tagResults = tagResults;
		setResultLayout();
		displayResults();
	}

	// combo Search
	public SearchResultsGUI(String searchResult, String[] tagResults) {
		super();
		this.searchResult = searchResult;
		this.tagResults = tagResults;
		setResultLayout();
		displayResults();
	}

	// A recursive method which sets the layout of the results of the search
	private void setResultLayout() {
		results.setSize(960, 568);
		results.setLayout(null);
		results.setTitle("Search Results");

		ouacImage = new ImageIcon("images/ouaclogo.png");
		image = new JLabel(ouacImage);
		image.setBounds(225, 0, 510, 80);
		results.add(image);
		
		results.getContentPane().setBackground(Color.lightGray);

		results.setVisible(true);
		results.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(int x = 0; x < 3; x++) {
			showResults[x] = new JPanel(null, false);
			showResults[x].setBounds(0, 80 + (150 * x), 480, 150);
			
			addProgram[x] = new JButton("Add Program #" + (x + 1));
			addProgram[x].addActionListener(this);
			addProgram[x].setBounds(320, 100 + (150 * x), 130, 45);
			
			moreInformation[x] = new JButton("More Information");
			moreInformation[x].addActionListener(this);
			moreInformation[x].setBounds(310, 155 + (150 * x), 140, 45);
			
			if (x == 0 || x == 2) {
				showResults[x].setBackground(Color.white);
			} else {
				showResults[x].setBackground(Color.lightGray);
			}
			results.getContentPane().add(showResults[x]);
			results.add(addProgram[x]);
			results.add(moreInformation[x]);
		}
		
		for(int x = 3; x < 6; x++) {
			showResults[x] = new JPanel(null, false);
			showResults[x].setBounds(480, 80 + (150 * (x - 3)), 480, 150);
			
			addProgram[x] = new JButton("Add Program #" + (x + 1));
			addProgram[x].addActionListener(this);
			addProgram[x].setBounds(800, 100 + (150 * (x - 3)), 130, 45);
			
			moreInformation[x] = new JButton("More Information");
			moreInformation[x].addActionListener(this);
			moreInformation[x].setBounds(790, 155 + (150 * (x - 3)), 140, 45);
			
			//moreInformation[x].setBackground(Color.cyan);
			//moreInformation[x].setForeground(Color.white);
			
			if (x == 4) {
				showResults[x].setBackground(Color.white);
			} else {
				showResults[x].setBackground(Color.lightGray);
			}
			
			results.getContentPane().add(showResults[x]);
			results.add(addProgram[x]);
			results.add(moreInformation[x]);
		}

		
		results.repaint();
	}
	
	private void displayResults() {
		int i = 0;
		int j = 0;
		while (!(i == 5)) {
			if (data.setupBinarySearch(searchResult) == "no") {
				System.out.println("no");
			} else if (data.setupBinarySearch(searchResult).equals("final")) {
				i = 5;
			} else {
				programName[i] = new JLabel("Program #1 Name: " + searchResult);
				programSchool[i] = new JLabel("University: " + (data.setupBinarySearch(searchResult)));
				i++;
				j++;
			}
		}
		
		if (j < 3) {
			for (int w = 0; w < (j+1); w++) {
				programName[w].setBounds(20, 100 + (150 * w), 130, 35);
				programSchool[w].setBounds(20, 140 + (150 * w), 130, 35);
				showResults[w].add(programSchool[w]);
				results.add(programName[w]);
			}
		}
		
		if (j > 3 || j == 3) {
			for (int w = 3; w < (j+1); w++) {
				programName[w].setBounds(500, 100 + (150 * w), 130, 35);
				programSchool[w].setBounds(500, 140 + (150 * w), 130, 35);
				results.add(programSchool[w]);
				results.add(programName[w]);
			}
		}
		
		results.revalidate();
		results.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addProgram[0]) {
			addprogram(0);

		} else if (e.getSource() == addProgram[1]) {
			addprogram(1);

		} else if (e.getSource() == addProgram[2]) {
			addprogram(2);

		} else if (e.getSource() == addProgram[3]) {
			addprogram(3);

		} else if (e.getSource() == addProgram[4]) {
			addprogram(4);

		}
	}
	
	private void addprogram(int i) {

	}

}
