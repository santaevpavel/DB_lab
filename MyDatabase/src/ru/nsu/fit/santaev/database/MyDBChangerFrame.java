package ru.nsu.fit.santaev.database;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MyDBChangerFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public JPanel mainPanel = null; 
	public JButton buttonSportsmens = null;
	public JButton buttonConstructions = null;
	public JButton buttonPersons = null;
	
	public JButton buttonCoachs = null;
	public JButton buttonSportTypes = null;
	public JButton buttonSportClubs= null;
	public JButton buttonContestSportsmens = null;
	public JButton buttonConstrTypes = null;
	public JButton buttonSportsmenCoach = null;
	public JButton buttonContest = null;
	public JButton buttonValue = null;
	
	private int count = 0;
	//public JPanel 
	
	public MyDBChangerFrame() {
		mainPanel = new JPanel();
		buttonSportsmens = new JButton("����������");
		buttonConstructions = new JButton("����������");
		buttonPersons = new JButton("����");
		buttonCoachs = new JButton("�������");
		buttonSportTypes = new JButton("���� ������");
		buttonSportClubs = new JButton("���������� �����");
		buttonContestSportsmens = new JButton("�����������");
		buttonConstrTypes = new JButton("���� ����������");
		buttonSportsmenCoach = new JButton("��������� - ������");
		buttonContest = new JButton("������������");
		buttonValue = new JButton("��������������");
		
		add(mainPanel);	
		mainPanel.setLayout(null);
		
		addButton(buttonSportsmens);
		addButton(buttonConstructions);
		addButton(buttonPersons);
		addButton(buttonCoachs);
		addButton(buttonSportTypes);
		addButton(buttonSportClubs);
		addButton(buttonContestSportsmens);
		addButton(buttonConstrTypes);
		addButton(buttonSportsmenCoach);
		addButton(buttonContest);
		addButton(buttonValue);
		
		setMinimumSize(new Dimension(500, 600));
	}
	public void addButton(JButton b){
		mainPanel.add(b);
		b.setBounds(10, 10 + count * 35, 200, 30);
		count++;
		
	}
}	
