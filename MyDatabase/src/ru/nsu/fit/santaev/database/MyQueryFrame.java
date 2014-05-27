package ru.nsu.fit.santaev.database;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MyQueryFrame extends JFrame{
	

	private static final long serialVersionUID = -6400085397222113246L;
	public JPanel mainPanel = null; 
	public JButton buttonOk = null;
	public JTextArea results = null;
	//public J
	
	public MyQueryFrame() {
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
        
		buttonOk = new JButton("Ok");
		results = new JTextArea();
		add(mainPanel);
		mainPanel.add(buttonOk);
		buttonOk.setBounds(10, 10, 100, 30);
		results.setMinimumSize(new Dimension(300, 300));
		results.setBounds(10, 60, 1000, 400);
		mainPanel.add(results);
		
		
		setMinimumSize(new Dimension(1100, 600));
	}
	
}
