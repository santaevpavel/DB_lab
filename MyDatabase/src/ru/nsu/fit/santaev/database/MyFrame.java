package ru.nsu.fit.santaev.database;

import java.awt.Color;
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
	public JButton buttonQuery10 = null;
	public JButton buttonQuery11 = null;
	public JButton buttonQuery12 = null;
	public JButton buttonQuery13 = null;
	
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
	public JPanel panel10 = null;
	public JPanel panel11 = null;
	public JPanel panel12 = null;
	public JPanel panel13 = null;
	
	public JPanel panelChange = null;
	
	public MyFrame() {
		mainPanel = new JPanel();
		buttonQuery1 = new JButton("Запрос 1");
		buttonQuery2 = new JButton("Запрос 2");
		buttonQuery3 = new JButton("Запрос 3");
		buttonQuery4 = new JButton("Запрос 4");
		buttonQuery5 = new JButton("Запрос 5");
		buttonQuery6 = new JButton("Запрос 6");
		buttonQuery7 = new JButton("Запрос 7");
		buttonQuery8 = new JButton("Запрос 8");
		buttonQuery9 = new JButton("Запрос 9");
		buttonQuery10 = new JButton("Запрос 10");
		buttonQuery11 = new JButton("Запрос 11");
		buttonQuery12 = new JButton("Запрос 12");
		buttonQuery13 = new JButton("Запрос 13");
		
		buttonChange = new JButton("Открыть");
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel7 = new JPanel();
		panel8 = new JPanel();
		panel9 = new JPanel();
		panel10 = new JPanel();
		panel11 = new JPanel();
		panel12 = new JPanel();
		panel13 = new JPanel();
		
		panelChange = new JPanel();
		
		add(mainPanel);
		
		mainPanel.add(panelChange);
		panelChange.setLayout(new GridLayout(1, 1));
		panelChange.add(buttonChange);
		//JTextArea p = new JTextArea("Открыть окно для \nредактирования БД");
		buttonChange.setText("<html>Открыть окно для \nредактирования БД</html>");
		buttonChange.setBackground(Color.WHITE);
		//panelChange.add(p);
		
		
		mainPanel.add(panel1);
		panel1.setLayout(new GridLayout(1, 1));
		panel1.add(buttonQuery1);
		buttonQuery1.setText("<html>1.Получить перечень спортивныхсооружений указанного типа в целом или удовлетворяющих заданным характеристикам </html>");
		buttonQuery1.setBackground(Color.LIGHT_GRAY);
		
		mainPanel.add(panel2);
		panel2.setLayout(new GridLayout(1, 1));
		panel2.add(buttonQuery2);
		buttonQuery2.setBackground(Color.LIGHT_GRAY);
		buttonQuery2.setText("<html> 2.Получить список спортсменов\n, занимающихся указанным видом\n спорта в целом либо не \nниже определенного разряда. </html>");
		//p = new JTextArea("Получить список спортсменов\n, занимающихся указанным видом\n спорта в целом либо не \nниже определенного разряда.");
		//panel2.add(p);
		
		mainPanel.add(panel3);
		panel3.setLayout(new GridLayout(1, 1));
		panel3.add(buttonQuery3);
		buttonQuery3.setBackground(Color.LIGHT_GRAY);
		buttonQuery3.setText("<html> 3.Получить список спортсменов\n, тренирующихся у некого \nтренера в целом \nлибо не ниже определенного\n разряда. </html>");
		//p = new JTextArea("Получить список спортсменов\n, тренирующихся у некого \nтренера в целом \nлибо не ниже определенного\n разряда.");
		//panel3.add(p);
		
		mainPanel.add(panel4);
		panel4.setLayout(new GridLayout(1, 1));
		panel4.add(buttonQuery4);
		buttonQuery4.setBackground(Color.LIGHT_GRAY);
		buttonQuery4.setText("<html> 4.Получить список спортсменов\n, занимающихся более чем одним \nвидом спорта с указанием \nэтих видов спорта. </html>");
		//p = new JTextArea("Получить список спортсменов\n, занимающихся более чем одним \nвидом спорта с указанием \nэтих видов спорта.");
		//panel4.add(p);
		
		mainPanel.add(panel5);
		panel5.setLayout(new GridLayout(1, 1));
		panel5.add(buttonQuery5);
		buttonQuery5.setBackground(Color.LIGHT_GRAY);
		buttonQuery5.setText("<html> 5.Получить список тренеров \nуказанного спортсмена. </html>");
		//p = new JTextArea("Получить список тренеров \nуказанного спортсмена.");
		//panel5.add(p);
		
		mainPanel.add(panel6);
		panel6.setLayout(new GridLayout(1, 1));
		panel6.add(buttonQuery6);
		buttonQuery6.setBackground(Color.LIGHT_GRAY);
		buttonQuery6.setText("<html> 6.Получить перечень соревнований, проведенных в течение заданного периода времени в целом либо указанным организатором.</html>");
		//p = new JTextArea("---");
		//panel6.add(p);
		
		mainPanel.add(panel7);
		panel7.setLayout(new GridLayout(1, 1));
		panel7.add(buttonQuery7);
		buttonQuery7.setBackground(Color.LIGHT_GRAY);
		buttonQuery7.setText("<html> 7.Получить список тренеров \nуказанного спортсмена. </html>");
		//p = new JTextArea("Получить список призеров\n указанного соревнования.");
		//panel7.add(p);
		
		mainPanel.add(panel8);
		panel8.setLayout(new GridLayout(1, 1));
		panel8.add(buttonQuery8);
		buttonQuery8.setBackground(Color.LIGHT_GRAY);
		buttonQuery8.setText("<html> 8.Получить перечень \nсоревнований, проведенных \nв указанном спортивном \nсооружении в целом либо\n по определенному виду спорта. </html>");
		//p = new JTextArea("Получить перечень \nсоревнований, проведенных \nв указанном спортивном \nсооружении в целом либо\n по определенному виду спорта.");
		//panel8.add(p);
		
		mainPanel.add(panel9);
		panel9.setLayout(new GridLayout(1, 1));
		panel9.add(buttonQuery9);
		buttonQuery9.setBackground(Color.LIGHT_GRAY);
		buttonQuery9.setText("<html> 9.Получить перечень спортивных клубов и число спортсменов этих клубов, участвовавших в спортивных соревнованиях в течение заданного интервала времени. </html>");
		//p = new JTextArea("---");
		//panel9.add(p);
		
		mainPanel.add(panel10);
		panel10.setLayout(new GridLayout(1, 1));
		panel10.add(buttonQuery10);
		buttonQuery10.setBackground(Color.LIGHT_GRAY);
		buttonQuery10.setText("<html> 10.Получить список тренеров по определенному виду спорта. </html>");
		//p = new JTextArea("---");
		//panel10.add(p);
		
		mainPanel.add(panel11);
		panel11.setLayout(new GridLayout(1, 1));
		panel11.add(buttonQuery11);
		buttonQuery11.setBackground(Color.LIGHT_GRAY);
		buttonQuery11.setText("<html> 11.Получить список спортсменов, не участвовавших ни в каких соревнованиях в течение определенного периода времени. </html>");
		//p = new JTextArea("---");
		//panel11.add(p);
		
		mainPanel.add(panel12);
		panel12.setLayout(new GridLayout(1, 1));
		panel12.add(buttonQuery12);
		buttonQuery12.setBackground(Color.LIGHT_GRAY);
		buttonQuery12.setText("<html> 12.Получить список организаторов соревнований и число проведенных ими соревнований в течение определенного периода времени. </html>");
		//p = new JTextArea("---");
		//panel12.add(p);
		
		mainPanel.add(panel13);
		panel13.setLayout(new GridLayout(1, 1));
		panel13.add(buttonQuery13);
		buttonQuery13.setBackground(Color.LIGHT_GRAY);
		buttonQuery13.setText("<html> 13.Получить перечень спортивных сооружений и даты проведения на них соревнований в течение определенного периода времени. </html>");
		//p = new JTextArea("---");
		//panel13.add(p);
		
		
		
		mainPanel.setLayout(new GridLayout(4, 2));
		setMinimumSize(new Dimension(900, 600));
	}
	
}

