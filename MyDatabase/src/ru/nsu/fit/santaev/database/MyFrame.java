package ru.nsu.fit.santaev.database;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class MyFrame extends JFrame{
	

	private static final long serialVersionUID = -6400085397222113246L;
	public JPanel mainPanel = null; 
	public JButton buttonQuery1 = null;
	public JButton buttonQuery2 = null;
	public JButton buttonQuery3 = null;
	public JButton buttonQuery4 = null;
	public JButton buttonQuery5 = null;
	public JButton buttonQuery6 = null;
	public JButton buttonQuery7 = null;
	public JButton buttonQuery8 = null;
	public JButton buttonQuery9 = null;
	
	public JButton buttonChange = null;

	public JPanel panel1 = null;
	public JPanel panel2 = null;
	public JPanel panel3 = null;
	public JPanel panel4 = null;
	public JPanel panel5 = null;
	public JPanel panel6 = null;
	public JPanel panel7 = null;
	public JPanel panel8 = null;
	public JPanel panel9 = null;
	
	public JPanel panelChange = null;
	
	public MyFrame() {
		mainPanel = new JPanel();
		buttonQuery1 = new JButton("������ 1");
		buttonQuery2 = new JButton("������ 2");
		buttonQuery3 = new JButton("������ 3");
		buttonQuery4 = new JButton("������ 4");
		buttonQuery5 = new JButton("������ 5");
		buttonQuery6 = new JButton("������ 6");
		buttonQuery7 = new JButton("������ 7");
		buttonQuery8 = new JButton("������ 8");
		buttonQuery9 = new JButton("������ 9");
		
		buttonChange = new JButton("�������");
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel7 = new JPanel();
		panel8 = new JPanel();
		panel9 = new JPanel();
		
		panelChange = new JPanel();
		
		add(mainPanel);
		
		mainPanel.add(panelChange);
		panelChange.setLayout(new GridLayout(2, 1));
		panelChange.add(buttonChange);
		JTextArea p = new JTextArea("������� ���� ��� \n�������������� ��");
		panelChange.add(p);
		
		
		mainPanel.add(panel1);
		panel1.setLayout(new GridLayout(2, 1));
		panel1.add(buttonQuery1);
		p = new JTextArea("�������� �������� ���������� \n���������� ���������� ���� \n� ����� ��� ��������������� \n�������� ���������������");
		panel1.add(p);
		
		mainPanel.add(panel2);
		panel2.setLayout(new GridLayout(2, 1));
		panel2.add(buttonQuery2);
		p = new JTextArea("�������� ������ �����������\n, ������������ ��������� �����\n ������ � ����� ���� �� \n���� ������������� �������.");
		panel2.add(p);
		
		mainPanel.add(panel3);
		panel3.setLayout(new GridLayout(2, 1));
		panel3.add(buttonQuery3);
		p = new JTextArea("�������� ������ �����������\n, ������������� � ������ \n������� � ����� \n���� �� ���� �������������\n �������.");
		panel3.add(p);
		
		mainPanel.add(panel4);
		panel4.setLayout(new GridLayout(2, 1));
		panel4.add(buttonQuery4);
		p = new JTextArea("�������� ������ �����������\n, ������������ ����� ��� ����� \n����� ������ � ��������� \n���� ����� ������.");
		panel4.add(p);
		
		mainPanel.add(panel5);
		panel5.setLayout(new GridLayout(2, 1));
		panel5.add(buttonQuery5);
		p = new JTextArea("�������� ������ �������� \n���������� ����������.");
		panel5.add(p);
		
		mainPanel.add(panel6);
		panel6.setLayout(new GridLayout(2, 1));
		panel6.add(buttonQuery6);
		p = new JTextArea("---");
		panel6.add(p);
		
		mainPanel.add(panel7);
		panel7.setLayout(new GridLayout(2, 1));
		panel7.add(buttonQuery7);
		p = new JTextArea("�������� ������ ��������\n ���������� ������������.");
		panel7.add(p);
		
		mainPanel.add(panel8);
		panel8.setLayout(new GridLayout(2, 1));
		panel8.add(buttonQuery8);
		p = new JTextArea("�������� �������� \n������������, ����������� \n� ��������� ���������� \n���������� � ����� ����\n �� ������������� ���� ������.");
		panel8.add(p);
		
		mainPanel.add(panel9);
		panel9.setLayout(new GridLayout(2, 1));
		panel9.add(buttonQuery9);
		p = new JTextArea("---");
		panel9.add(p);
		
		
		
		
		mainPanel.setLayout(new GridLayout(4, 2));
		setMinimumSize(new Dimension(500, 600));
	}
	
}
