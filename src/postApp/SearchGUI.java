/*
 * Dev Punjabi
 */

package postApp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

//1290 725, jacob is 745, search is 800ish
public class SearchGUI implements ActionListener, KeyListener {

	// Fields
	// program Object
	private ProcessingInformation program;
	public SearchResultsGUI results;

	// frame for the search
	public JFrame programSearch = new JFrame();

	// Necessary buttons
	
	private JButton submit = new JButton();
	private JLabel systemMessage = new JLabel("System Message: ");

	// All different search types
	private JButton basicSearch = new JButton();
	private JButton comboSearch = new JButton();
	private JButton altSearch = new JButton();
	private JButton schoolSearch = new JButton();
	private JButton showProgramList = new JButton();
	public int searchType = 1;
	private JButton[] schoolList = new JButton[19];

	// Text fields and their results
	private JTextField[] tags = new JTextField[3];
	private JLabel[] tagsCaption = new JLabel[3];
	private JTextField searchText = new JTextField();
	private String searchResult = "";
	public String[] tagResult = new String[3];

	// OUAC logo image
	private ImageIcon ouacImage = new ImageIcon(); 
	private JLabel image = new JLabel();

	/*
	 * Constructor Pre: None Post: GUI is created
	 */
	public SearchGUI() {
		programSearch.setSize(970, 525);
		programSearch.setLayout(null);
		programSearch.setTitle("Program Search");

		// Adds the buttons, text boxes, and base Labels
		setSearchLayout();
		// program.setupBinarySearch("gold");

		ouacImage = new ImageIcon("images/ouaclogo.png");
		image = new JLabel(ouacImage);
		image.setBounds(230, 10, 510, 80);
		programSearch.add(image);

		programSearch.setVisible(true);
		programSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// Sets the search layout
	// Sets the action listeners up and the set bounds for each search,
	private void setSearchLayout() {
		// Adds all the buttons, text fields and Labels and the first search screen
		// adds the search text field and caption
		searchText.setBounds(280, 200, 400, 35);
		JLabel searchTextCaption = new JLabel("Program Name: ");
		searchTextCaption.setBounds(170, 205, 100, 25);
		searchText.addKeyListener(this);
		programSearch.add(searchText);
		programSearch.add(searchTextCaption);

		// sets background colour
		// https://stackoverflow.com/questions/1081486/setting-background-color-for-a-jframe
		programSearch.getContentPane().setBackground(Color.lightGray);

		// submit/search button
		submit = new JButton("Search");
		submit.setBounds(700, 200, 75, 35);
		submit.addActionListener(this);
		submit.setBackground(Color.red);
		submit.setForeground(Color.white);
		programSearch.add(submit);

		// setting up search types
		// Basic Search, only using program searching
		basicSearch = new JButton("Basic Search");
		basicSearch.setBounds(10, 400, 180, 75);
		basicSearch.addActionListener(this);
		basicSearch.setBackground(Color.green);
		basicSearch.setForeground(Color.white);
		programSearch.add(basicSearch);

		// Search using tags instead -- will disable the program search main
		altSearch = new JButton("Search ONLY Using Tags");
		altSearch.setBounds(200, 400, 180, 75);
		altSearch.addActionListener(this);
		altSearch.setBackground(Color.white);
		altSearch.setForeground(Color.ORANGE);
		programSearch.add(altSearch);

		// Combo search, where they search using tags and program search
		comboSearch = new JButton("Basic + Tag Search");
		comboSearch.setBounds(390, 400, 180, 75);
		comboSearch.addActionListener(this);
		comboSearch.setBackground(Color.white);
		comboSearch.setForeground(Color.ORANGE);
		programSearch.add(comboSearch);

		// Search by School, when clicked shows a button of each school and you pick the
		// one you want to see
		schoolSearch = new JButton("Search by School");
		schoolSearch.setBounds(580, 400, 180, 75);
		schoolSearch.addActionListener(this);
		schoolSearch.setBackground(Color.white);
		schoolSearch.setForeground(Color.ORANGE);
		programSearch.add(schoolSearch);

		// Show Program List
		showProgramList = new JButton("Program Results");
		showProgramList.setBounds(770, 400, 180, 75);
		showProgramList.addActionListener(this);
		showProgramList.setBackground(Color.white);
		showProgramList.setForeground(Color.ORANGE);
		programSearch.add(showProgramList);

		for (int n = 0; n < 3; n++) {
			tags[n] = new JTextField();
			tags[n].setBounds(380, 260 + (30 * n), 200, 25);
			tagsCaption[n] = new JLabel("Tag #" + (n + 1) + ": ");
			tagsCaption[n].setBounds(325, 260 + (30 * n), 50, 25);
			tags[n].setEditable(false);
			programSearch.add(tags[n]);
			programSearch.add(tagsCaption[n]);
		}

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			displayPrograms();

		} else if (e.getSource() == basicSearch) {
			for (int n = 0; n < 3; n++) {
				tags[n].setEditable(false);
			}
			searchText.setEditable(true);
			basicSearch.setBackground(Color.green);
			basicSearch.setForeground(Color.white);
			altSearch.setBackground(Color.white);
			altSearch.setForeground(Color.ORANGE);
			schoolSearch.setBackground(Color.white);
			schoolSearch.setForeground(Color.ORANGE);
			comboSearch.setBackground(Color.white);
			comboSearch.setForeground(Color.ORANGE);

		} else if (e.getSource() == altSearch) {
			for (int n = 0; n < 3; n++) {
				tags[n].setEditable(true);
			}
			searchText.setEditable(false);
			basicSearch.setBackground(Color.white);
			basicSearch.setForeground(Color.orange);
			altSearch.setBackground(Color.green);
			altSearch.setForeground(Color.white);
			schoolSearch.setBackground(Color.white);
			schoolSearch.setForeground(Color.ORANGE);
			comboSearch.setBackground(Color.white);
			comboSearch.setForeground(Color.ORANGE);

		} else if (e.getSource() == schoolSearch) {
			// setSchoolSearch();
		} else if (e.getSource() == comboSearch) {

		}

		programSearch.repaint();
	}

	private void displayPrograms() {
		programSearch.setVisible(false);
		if (searchType == 1) {
			new SearchResultsGUI(searchResult);
		} else if (searchType == 2 ) {
		//	new SearchResultsGUI(tagResult) {
				
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Saves text into a variable, and text is saved after a key is released
		// so if you
		searchResult = searchText.getText();
		tagResult[0] = tags[0].getText();
		tagResult[1] = tags[1].getText();
		tagResult[2] = tags[2].getText();
		// System.out.println(searchResult);

		if (searchType == 1) {
			if (searchText.getText().equals("")) {
				systemMessage = new JLabel("System Message: Cannot Search with an empty search field when using basic search.");
				systemMessage.setForeground(Color.red);
				submit.setBackground(Color.red);
				systemMessage.setBounds(225, 235, 500, 30);
				programSearch.add(systemMessage);
				programSearch.repaint();
			} else if (!(searchText.getText().equals(""))) {
				submit.setBackground(Color.green);
				programSearch.remove(systemMessage);
				programSearch.repaint();
			}
		}
	}

}
