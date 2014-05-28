package ru.nsu.fit.santaev.database;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.DialogPeer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.rowset.CachedRowSet;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class MyAddFrame extends JFrame {

	private static final long serialVersionUID = -6400085397222113246L;
	public JPanel mainPanel = null;
	public JButton buttonOk = null;
	public JTable results = null;
	public ResultSet res = null;
	// public J

	public MyAddFrame() {
		mainPanel = new JPanel();
		mainPanel.setLayout(null);

		buttonOk = new JButton("Добавить");
		results = new JTable();
		add(mainPanel);
		mainPanel.add(buttonOk);
		buttonOk.setBounds(10, 10, 100, 30);
		results.setMinimumSize(new Dimension(300, 300));
		results.setBounds(10, 60, 1000, 400);
		mainPanel.add(results);

		setMinimumSize(new Dimension(1100, 600));
		
	}

	public void setTable(final ResultSet res) throws SQLException{
		this.res = res;
		int numColumns = res.getMetaData().getColumnCount();
		final TableModel model = results.getModel();
		DefaultTableModel defModel = (DefaultTableModel) model;
		defModel.setColumnCount(numColumns);
	
		int rowsCount = res.getMetaData()
				.getColumnCount();
		defModel.setRowCount(2);
		for (int j = 1; j <= res.getMetaData().getColumnCount(); j++){
			//String n = ress.getMetaData().getColumnName(i).toLowerCase() + " ";
			defModel.setValueAt("-- " + res.getMetaData().getColumnName(j).toLowerCase() + " --", 0, j - 1);
		}
		buttonOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (int j = 1; j <= res.getMetaData().getColumnCount(); j++){
					//defModel.setValueAt("-- " + res.getMetaData().getColumnName(j).toLowerCase() + " --", 0, j - 1);
				}
			}
		});
	}
	
}
