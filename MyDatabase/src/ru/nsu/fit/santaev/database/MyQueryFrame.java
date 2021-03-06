package ru.nsu.fit.santaev.database;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class MyQueryFrame extends JFrame{
	

	private static final long serialVersionUID = -6400085397222113246L;
	public JPanel mainPanel = null; 
	public JButton buttonOk = null;
	public JTable results = null;
	//public J
	
	public MyQueryFrame() {
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
        
		buttonOk = new JButton("Ok");
		results = new JTable();
		add(mainPanel);
		mainPanel.add(buttonOk);
		buttonOk.setBounds(10, 10, 100, 30);
		results.setMinimumSize(new Dimension(300, 300));
		results.setBounds(10, 60, 1000, 400);
		mainPanel.add(results);
		
		setMinimumSize(new Dimension(1100, 600));
	}
	public void setTable(ResultSet res) throws SQLException{
		int numColumns = res.getMetaData().getColumnCount();
		TableModel model = results.getModel();
		DefaultTableModel defModel = (DefaultTableModel) model;
		defModel.setColumnCount(numColumns);
	
		int rowsCount = res.getMetaData()
				.getColumnCount();
		int i = 0;
		defModel.setRowCount(1);
		for (int j = 1; j <= res.getMetaData().getColumnCount(); j++){
			//String n = ress.getMetaData().getColumnName(i).toLowerCase() + " ";
			defModel.setValueAt("-- " + res.getMetaData().getColumnName(j).toLowerCase() + " --", 0, j - 1);
		}
		i++;
		while (res.next()) {
			defModel.setRowCount(i + 1);
			for (int k = 1; k <= rowsCount; k++) {
				defModel.setValueAt(res.getObject(k), i, k - 1);
			}
			i++;
			
		}			
	}
}
