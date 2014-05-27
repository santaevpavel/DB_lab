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
	public JButton buttonQuery1 = null;

	//public JPanel 
	
	public MyDBChangerFrame() {
		mainPanel = new JPanel();
		buttonQuery1 = new JButton("Добавить");
		add(mainPanel);	
		mainPanel.setLayout(null);
		
		mainPanel.add(buttonQuery1);
		buttonQuery1.setBounds(10, 10, 100, 30);
		setMinimumSize(new Dimension(500, 600));
	}
	private void getFrameFromTable() throws SQLException{
		ResultSet res = null;
		int size = res.getMetaData().getColumnCount();
		//res.getMetaData().
		//for (int i = 0; i < )
		
	}
}
