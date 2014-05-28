package ru.nsu.fit.santaev.database;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
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


public class MyUpdateFrame extends JFrame {

	private static final long serialVersionUID = -6400085397222113246L;
	public JPanel mainPanel = null;
	public JButton buttonOk = null;
	public JTable results = null;
	public ResultSet res = null;
	// public J

	public MyUpdateFrame() {
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

	public void setTable(final ResultSet res) throws SQLException{
		this.res = res;
		int numColumns = res.getMetaData().getColumnCount();
		final TableModel model = results.getModel();
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
		//res.beforeFirst();
		while (res.next()) {
			defModel.setRowCount(i + 1);
			for (int k = 1; k <= rowsCount; k++) {
				defModel.setValueAt(res.getObject(k), i, k - 1);
			}
			i++;
			
		}	
		
		
		model.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent arg0) {
				System.out.println("-- " + arg0.getFirstRow() + " " + arg0.getLastRow() + " " + arg0.getColumn());
				try {
					if (res.getMetaData().getColumnName(1).toLowerCase() != "id"){
						try {
							JOptionPane.showMessageDialog(MyUpdateFrame.this, "Cannot change " + res.getMetaData().getColumnName(1).toLowerCase());
						} catch (HeadlessException e1) {
							e1.printStackTrace();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						return;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				int id =  Integer.valueOf(model.getValueAt(arg0.getFirstRow(), 0).toString());
				String data = model.getValueAt(arg0.getFirstRow(), arg0.getColumn()).toString();
				try {
					if (res.getMetaData().getColumnType(arg0.getColumn() + 1) == Types.VARCHAR){
						updateRowWithIdString(id, res, data, arg0.getColumn() + 1);
					}
					if (res.getMetaData().getColumnType(arg0.getColumn() + 1) == Types.NUMERIC){
						updateRowWithIdInt(id, res, Integer.valueOf(data), arg0.getColumn() + 1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//res.updateString(columnIndex, x)
			}
		});
		
	}
	public void updateRowWithIdString(int id, ResultSet res, String data, int column) throws SQLException{
		res.beforeFirst();
		while (res.next()) {
			if (res.getInt(1) == id){
				res.updateString(column, data);
				res.updateRow();
				return;
			}
		}	
	}
	public void updateRowWithIdInt(int id, ResultSet res, int data , int column) throws SQLException{
		res.beforeFirst();
		while (res.next()) {
			if (res.getInt(1) == id){
				res.updateInt(column, data);
				res.updateRow();
				return;
			}
		}	
	}
	public void addRow(int id, ResultSet res, DefaultTableModel defModel) throws SQLException{
		res.moveToInsertRow();
		//for (int i = 0; i < defModel.)
	
	}
}
