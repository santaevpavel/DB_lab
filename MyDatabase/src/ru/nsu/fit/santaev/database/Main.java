package ru.nsu.fit.santaev.database;

import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.ObjectInputStream.GetField;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Set;

import javax.sql.rowset.CachedRowSet;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main {

	public static String ip = "10.4.0.119";
	public static String port = "1521"; // 1521
	public static Datas datas = new Datas();
	public static MyFrame mainFrame = new MyFrame();

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {
		final DBOperations dbops = new DBOperations("oracle", ip + ":" + port,
				"xe", "santaev_pavel", "123");
		getAllContrTypes(datas, dbops);
		getAllSportTypes(datas, dbops);
		getAllCoachs(datas, dbops);
		getAllSportsmens(datas, dbops);
		getAllContests(datas, dbops);
		getAllSportConstr(datas, dbops);
		getAllOrganizers(datas, dbops);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);

		mainFrame.buttonChange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyDBChangerFrame frame = new MyDBChangerFrame();
				frame.buttonSportsmens.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						MyUpdateFrame update = new MyUpdateFrame();
						update.setVisible(true);
						try {
							final ResultSet res = MyQueries
									.SelectRowsSportsmensAllColums(dbops);
							update.setTable(res);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
				frame.buttonConstructions
						.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								MyUpdateFrame update = new MyUpdateFrame();
								update.setVisible(true);
								try {
									final ResultSet res = MyQueries
											.SelectRowsSportConstAllColumns(dbops);
									update.setTable(res);
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						});
				frame.buttonPersons
				.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						MyUpdateFrame update = new MyUpdateFrame();
						update.setVisible(true);
						try {
							final ResultSet res = MyQueries
									.SelectRowsPersonsAllColumns(dbops);
							update.setTable(res);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
				frame.buttonCoachs
				.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						MyUpdateFrame update = new MyUpdateFrame();
						update.setVisible(true);
						try {
							final ResultSet res = MyQueries
									.SelectRowsCoachsAllColumns(dbops);
							update.setTable(res);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
				frame.buttonSportTypes
				.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						MyUpdateFrame update = new MyUpdateFrame();
						update.setVisible(true);
						try {
							final ResultSet res = MyQueries
									.SelectRowsSportTypesAllColumns(dbops);
							update.setTable(res);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
				frame.buttonSportClubs
				.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						MyUpdateFrame update = new MyUpdateFrame();
						update.setVisible(true);
						try {
							final ResultSet res = MyQueries
									.SelectRowsSportClubsAllColumns(dbops);
							update.setTable(res);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
				frame.buttonContestSportsmens
				.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						MyUpdateFrame update = new MyUpdateFrame();
						update.setVisible(true);
						try {
							final ResultSet res = MyQueries
									.SelectRowsContestSportsmensAllColumns(dbops);
							update.setTable(res);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
				frame.buttonConstrTypes
				.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						MyUpdateFrame update = new MyUpdateFrame();
						update.setVisible(true);
						try {
							final ResultSet res = MyQueries
									.SelectRowsConstrTypesAllColumns(dbops);
							update.setTable(res);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
				frame.buttonSportsmenCoach
				.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						MyUpdateFrame update = new MyUpdateFrame();
						update.setVisible(true);
						try {
							final ResultSet res = MyQueries
									.SelectRowsSportsmenCoachsAllColumns(dbops);
							update.setTable(res);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
				frame.buttonContest
				.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						MyUpdateFrame update = new MyUpdateFrame();
						update.setVisible(true);
						try {
							final ResultSet res = MyQueries
									.SelectRowsContestsAllColumns(dbops);
							update.setTable(res);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
				frame.buttonValue
				.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						MyUpdateFrame update = new MyUpdateFrame();
						update.setVisible(true);
						try {
							final ResultSet res = MyQueries
									.SelectRowsValuesAllColumns(dbops);
							update.setTable(res);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
				
				frame.setVisible(true);
				
			}
		});

		// 1ый запрос
		mainFrame.buttonQuery1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final JComboBox<String> jComboBox = new JComboBox<String>();
				final JTextField text = new JTextField();
				Collection<String> keys = datas.getContructionTypes().keySet();
				for (int i = 0; i < keys.toArray().length; i++) {
					jComboBox.addItem((String) keys.toArray()[i]);
				}
				jComboBox.setBounds(120, 10, 200, 30);
				text.setBounds(350, 10, 100, 30);
				final MyQueryFrame myQueryFrame = new MyQueryFrame();
				myQueryFrame.setVisible(true);
				myQueryFrame.mainPanel.add(jComboBox);
				myQueryFrame.mainPanel.add(text);
				myQueryFrame.buttonOk.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							// myQueryFrame.results.setText(myQueryFrame.results
							// .getText() + "----- Result -----\n");

							ResultSet myRes = null;
							if (text.getText().isEmpty()) {
								myRes = MyQueries.SelectRowsConstrFromId(
										dbops,
										datas.getContructionTypes().get(
												jComboBox.getSelectedItem()));
							} else {
								myRes = MyQueries.SelectRowsConstrFromIdAndCapacity(
										dbops,
										datas.getContructionTypes().get(
												jComboBox.getSelectedItem()),
										Integer.valueOf(text.getText()));
							}
							// myQueryFrame.results.setText(myQueryFrame.results
							// .getText() + MyQueries.getColumns(myRes));
							/*
							 * int rowsCount = myRes.getMetaData()
							 * .getColumnCount(); while (myRes.next()) { String
							 * row = ""; for (int k = 1; k <= rowsCount; k++) {
							 * row = row + myRes.getObject(k) + "\t"; }
							 * myQueryFrame.results
							 * .setText(myQueryFrame.results.getText() + row +
							 * "\n"); }
							 */
							myQueryFrame.setTable(myRes);
						} catch (SQLException e) {
							e.printStackTrace();
						}

					}
				});
			}
		});

		// 2ой запрос
		mainFrame.buttonQuery2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final JComboBox<String> jComboBox = new JComboBox<String>();
				final JTextField text = new JTextField();
				Collection<String> keys = datas.getSportTypes().keySet();
				for (int i = 0; i < keys.toArray().length; i++) {
					jComboBox.addItem((String) keys.toArray()[i]);
				}
				jComboBox.setBounds(120, 10, 200, 30);
				text.setBounds(350, 10, 100, 30);
				final MyQueryFrame myQueryFrame = new MyQueryFrame();
				myQueryFrame.setVisible(true);
				myQueryFrame.mainPanel.add(jComboBox);
				myQueryFrame.mainPanel.add(text);
				myQueryFrame.buttonOk.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							// myQueryFrame.results.setText(myQueryFrame.results
							// .getText() + "----- Result -----\n");

							ResultSet myRes = null;
							if (text.getText().isEmpty()) {
								myRes = MyQueries.SelectRowsSportsmensFromSportTypeId(
										dbops,
										datas.getSportTypes().get(
												jComboBox.getSelectedItem()));
							} else {
								myRes = MyQueries
										.SelectRowsSportsmensFromSportTypeIdAndRank(
												dbops,
												datas.getSportTypes()
														.get(jComboBox
																.getSelectedItem()),
												Integer.valueOf(text.getText()));
							}
							/*
							 * myQueryFrame.results.setText(myQueryFrame.results
							 * .getText() + MyQueries.getColumns(myRes)); int
							 * rowsCount = myRes.getMetaData()
							 * .getColumnCount(); while (myRes.next()) { String
							 * row = ""; for (int k = 1; k <= rowsCount; k++) {
							 * row = row + myRes.getObject(k) + "\t"; }
							 * myQueryFrame.results
							 * .setText(myQueryFrame.results.getText() + row +
							 * "\n"); }
							 */
							myQueryFrame.setTable(myRes);
						} catch (SQLException e) {
							e.printStackTrace();
						}

					}
				});
			}
		});
		// 3ий запрос
		mainFrame.buttonQuery3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final JComboBox<String> jComboBox = new JComboBox<String>();
				final JTextField text = new JTextField();
				Collection<String> keys = datas.getCoachs().keySet();
				for (int i = 0; i < keys.toArray().length; i++) {
					jComboBox.addItem((String) keys.toArray()[i]);
				}
				jComboBox.setBounds(120, 10, 200, 30);
				text.setBounds(350, 10, 100, 30);
				final MyQueryFrame myQueryFrame = new MyQueryFrame();
				myQueryFrame.setVisible(true);
				myQueryFrame.mainPanel.add(jComboBox);
				myQueryFrame.mainPanel.add(text);
				myQueryFrame.buttonOk.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							// myQueryFrame.results.setText(myQueryFrame.results
							// .getText() + "----- Result -----\n");

							ResultSet myRes = null;
							if (text.getText().isEmpty()) {
								myRes = MyQueries
										.SelectRowsCoachFromSportTypeId(
												dbops,
												datas.getCoachs()
														.get(jComboBox
																.getSelectedItem()));
							} else {
								myRes = MyQueries
										.SelectRowsSportsmensFromCoachIdAndRank2(
												dbops,
												datas.getCoachs()
														.get(jComboBox
																.getSelectedItem()),
												Integer.valueOf(text.getText()));
							}
							/*
							 * myQueryFrame.results.setText(myQueryFrame.results
							 * .getText() + MyQueries.getColumns(myRes)); int
							 * rowsCount = myRes.getMetaData()
							 * .getColumnCount(); while (myRes.next()) { String
							 * row = ""; for (int k = 1; k <= rowsCount; k++) {
							 * row = row + myRes.getObject(k) + "\t"; }
							 * myQueryFrame.results
							 * .setText(myQueryFrame.results.getText() + row +
							 * "\n"); }
							 */
							myQueryFrame.setTable(myRes);
						} catch (SQLException e) {
							e.printStackTrace();
						}

					}
				});
			}
		});
		// 4ый запрос
		mainFrame.buttonQuery4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final MyQueryFrame myQueryFrame = new MyQueryFrame();
				myQueryFrame.setVisible(true);
				myQueryFrame.buttonOk.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							// myQueryFrame.results.setText(myQueryFrame.results
							// .getText() + "----- Result -----\n");

							ResultSet myRes = MyQueries
									.SelectRowsSportsmensIdWhereTypeBigger1(dbops);

							// myQueryFrame.results.setText(myQueryFrame.results
							// .getText() + MyQueries.getColumns(myRes));
							int rowsCount = myRes.getMetaData()
									.getColumnCount();
							while (myRes.next()) {
								int id = myRes.getInt(1);
								String name = myRes.getString(2);
								// myQueryFrame.results
								// .setText(myQueryFrame.results.getText()
								// + name + ":\n");
								ResultSet myRes2 = MyQueries
										.SelectRowsSportTypeForSportsmen(dbops,
												id);
								/*
								 * while (myRes2.next()) { String row = "  ";
								 * for (int k = 1; k <= rowsCount; k++) { row =
								 * row + myRes2.getObject(k) + "\t"; }
								 * myQueryFrame.results
								 * .setText(myQueryFrame.results .getText() +
								 * row + "\n"); }
								 */
								myQueryFrame.setTable(myRes2);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}

					}
				});
			}
		});
		// 5ый запрос
		mainFrame.buttonQuery5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final JComboBox<String> jComboBox = new JComboBox<String>();
				Collection<String> keys = datas.getSportsmens().keySet();
				for (int i = 0; i < keys.toArray().length; i++) {
					jComboBox.addItem((String) keys.toArray()[i]);
				}
				jComboBox.setBounds(120, 10, 200, 30);
				final MyQueryFrame myQueryFrame = new MyQueryFrame();
				myQueryFrame.setVisible(true);
				myQueryFrame.mainPanel.add(jComboBox);
				myQueryFrame.buttonOk.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							// myQueryFrame.results.setText(myQueryFrame.results
							// .getText() + "----- Result -----\n");

							ResultSet myRes = null;

							myRes = MyQueries.SelectRowsCoachFromSportsmen(
									dbops,
									datas.getSportsmens().get(
											jComboBox.getSelectedItem()));

							// myQueryFrame.results.setText(myQueryFrame.results
							// .getText() + MyQueries.getColumns(myRes));
							/*
							 * int rowsCount = myRes.getMetaData()
							 * .getColumnCount(); while (myRes.next()) { String
							 * row = ""; for (int k = 1; k <= rowsCount; k++) {
							 * row = row + myRes.getObject(k) + "\t"; }
							 * myQueryFrame.results
							 * .setText(myQueryFrame.results.getText() + row +
							 * "\n"); }
							 */
							myQueryFrame.setTable(myRes);
						} catch (SQLException e) {
							e.printStackTrace();
						}

					}
				});
			}
		});
		// 6ый запрос
		mainFrame.buttonQuery6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final JComboBox<String> jComboBox = new JComboBox<String>();
				final Checkbox cb = new Checkbox("Поиск по организатору");
				final JTextField text1 = new JTextField("01.01.2013");
				final JTextField text2 = new JTextField("01.09.2014");
				text1.setBounds(400, 10, 200, 30);
				text2.setBounds(610, 10, 200, 30);
				cb.setBounds(820, 10, 200, 30);
				Collection<String> keys = datas.getOrganazers().keySet();
				for (int i = 0; i < keys.toArray().length; i++) {
					jComboBox.addItem((String) keys.toArray()[i]);
				}
				jComboBox.setBounds(120, 10, 200, 30);
				final MyQueryFrame myQueryFrame = new MyQueryFrame();
				myQueryFrame.setVisible(true);
				myQueryFrame.mainPanel.add(jComboBox);
				myQueryFrame.mainPanel.add(text1);
				myQueryFrame.mainPanel.add(text2);
				myQueryFrame.mainPanel.add(cb);
				myQueryFrame.buttonOk.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {

							ResultSet myRes = null;
							if (cb.getState()) {
								myRes = MyQueries.SelectRowsContestFromDate(
										dbops, text1.getText(), text2.getText());
							} else {
								myRes = MyQueries.SelectRowsContestFromDateAndOrganizer(
										dbops,
										text1.getText(),
										text2.getText(),
										datas.getOrganazers().get(
												jComboBox.getSelectedItem()));
							}

							myQueryFrame.setTable(myRes);
						} catch (SQLException e) {
							e.printStackTrace();
						}

					}
				});
			}
		});
		// 7ый запрос
		mainFrame.buttonQuery7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final JComboBox<String> jComboBox = new JComboBox<String>();
				Collection<String> keys = datas.getContests().keySet();
				for (int i = 0; i < keys.toArray().length; i++) {
					jComboBox.addItem((String) keys.toArray()[i]);
				}
				jComboBox.setBounds(120, 10, 200, 30);
				final MyQueryFrame myQueryFrame = new MyQueryFrame();
				myQueryFrame.setVisible(true);
				myQueryFrame.mainPanel.add(jComboBox);
				myQueryFrame.buttonOk.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							// myQueryFrame.results.setText(myQueryFrame.results
							// .getText() + "----- Result -----\n");

							ResultSet myRes = null;

							myRes = MyQueries.SelectPlacesOnContest(
									dbops,
									datas.getContests().get(
											jComboBox.getSelectedItem()));

							/*
							 * myQueryFrame.results.setText(myQueryFrame.results
							 * .getText() + MyQueries.getColumns(myRes)); int
							 * rowsCount = myRes.getMetaData()
							 * .getColumnCount(); while (myRes.next()) { String
							 * row = ""; for (int k = 1; k <= rowsCount; k++) {
							 * row = row + myRes.getObject(k) + "\t"; }
							 * myQueryFrame.results
							 * .setText(myQueryFrame.results.getText() + row +
							 * "\n"); }
							 */
							myQueryFrame.setTable(myRes);
						} catch (SQLException e) {
							e.printStackTrace();
						}

					}
				});
			}
		});
		// 8ой запрос
		mainFrame.buttonQuery8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final JComboBox<String> jComboBox = new JComboBox<String>();
				final JComboBox<String> jComboBox2 = new JComboBox<String>();
				final Checkbox cb = new Checkbox(
						"Поиск по определенному типу спорта");
				Collection<String> keys = datas.getSportConstr().keySet();
				for (int i = 0; i < keys.toArray().length; i++) {
					jComboBox.addItem((String) keys.toArray()[i]);
				}
				jComboBox.setBounds(120, 10, 200, 30);
				cb.setBounds(560, 0, 300, 30);
				Collection<String> keys2 = datas.getSportTypes().keySet();
				for (int i = 0; i < keys.toArray().length; i++) {
					jComboBox2.addItem((String) keys2.toArray()[i]);
				}
				jComboBox2.setBounds(330, 10, 200, 30);

				final MyQueryFrame myQueryFrame = new MyQueryFrame();
				myQueryFrame.setVisible(true);
				myQueryFrame.mainPanel.add(jComboBox);
				myQueryFrame.mainPanel.add(jComboBox2);
				myQueryFrame.mainPanel.add(cb);
				myQueryFrame.buttonOk.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							ResultSet myRes = null;
							// myQueryFrame.results.setText(myQueryFrame.results
							// .getText() + "----- Result -----\n");
							if (!cb.getState()) {
								myRes = MyQueries.SelectRowsContestFromConstr(
										dbops,
										datas.getSportConstr().get(
												jComboBox.getSelectedItem()));
							} else {
								myRes = MyQueries
										.SelectRowsContestFromConstrAndSportType(
												dbops,
												datas.getSportConstr()
														.get(jComboBox
																.getSelectedItem()),
												datas.getSportTypes()
														.get(jComboBox2
																.getSelectedItem()));
							}
							// myQueryFrame.results.setText(myQueryFrame.results
							// .getText() + MyQueries.getColumns(myRes));
							/*
							 * int rowsCount = myRes.getMetaData()
							 * .getColumnCount(); while (myRes.next()) { String
							 * row = ""; for (int k = 1; k <= rowsCount; k++) {
							 * row = row + myRes.getObject(k) + "\t"; }
							 * myQueryFrame.results
							 * .setText(myQueryFrame.results.getText() + row +
							 * "\n"); }
							 */
							myQueryFrame.setTable(myRes);
						} catch (SQLException e) {
							e.printStackTrace();
						}

					}
				});
			}
		});
		// 9ой запрос
		mainFrame.buttonQuery9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final JTextField text1 = new JTextField("01.01.2013");
				final JTextField text2 = new JTextField("01.09.2014");
				text1.setBounds(200, 10, 200, 30);
				text2.setBounds(450, 10, 200, 30);
				final MyQueryFrame myQueryFrame = new MyQueryFrame();
				myQueryFrame.setVisible(true);
				myQueryFrame.mainPanel.add(text1);
				myQueryFrame.mainPanel.add(text2);
				myQueryFrame.buttonOk.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							ResultSet myRes = null;
							// myQueryFrame.results.setText(myQueryFrame.results
							// .getText() + "----- Result -----\n");

							myRes = MyQueries
									.SelectRowsSportClubFromContestTime(dbops,
											text1.getText(), text2.getText());

							/*
							 * myQueryFrame.results.setText(myQueryFrame.results
							 * .getText() + MyQueries.getColumns(myRes)); int
							 * rowsCount = myRes.getMetaData()
							 * .getColumnCount(); while (myRes.next()) { String
							 * row = ""; for (int k = 1; k <= rowsCount; k++) {
							 * row = row + myRes.getObject(k) + "\t"; }
							 * myQueryFrame.results
							 * .setText(myQueryFrame.results.getText() + row +
							 * "\n"); }
							 */
							myQueryFrame.setTable(myRes);
						} catch (SQLException e) {
							e.printStackTrace();
						}

					}
				});
			}
		});
		// 10ый запрос
		mainFrame.buttonQuery10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final JComboBox<String> jComboBox = new JComboBox<String>();
				Collection<String> keys = datas.getSportTypes().keySet();
				for (int i = 0; i < keys.toArray().length; i++) {
					jComboBox.addItem((String) keys.toArray()[i]);
				}
				jComboBox.setBounds(120, 10, 200, 30);
				final MyQueryFrame myQueryFrame = new MyQueryFrame();
				myQueryFrame.setVisible(true);
				myQueryFrame.mainPanel.add(jComboBox);
				myQueryFrame.buttonOk.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							ResultSet myRes = null;

							myRes = MyQueries.SelectRowsCoachFromSortType(
									dbops,
									datas.getSportTypes().get(
											jComboBox.getSelectedItem()));

							myQueryFrame.setTable(myRes);
						} catch (SQLException e) {
							e.printStackTrace();
						}

					}
				});
			}
		});
		// 11ой запрос
		mainFrame.buttonQuery11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final JTextField text1 = new JTextField("01.01.2013");
				final JTextField text2 = new JTextField("01.09.2014");
				text1.setBounds(200, 10, 200, 30);
				text2.setBounds(450, 10, 200, 30);
				final MyQueryFrame myQueryFrame = new MyQueryFrame();
				myQueryFrame.setVisible(true);
				myQueryFrame.mainPanel.add(text1);
				myQueryFrame.mainPanel.add(text2);
				myQueryFrame.buttonOk.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							ResultSet myRes = null;

							myRes = MyQueries
									.SelectRowsSportsmenWitchNotPlayed(dbops,
											text1.getText(), text2.getText());
							myQueryFrame.setTable(myRes);
						} catch (SQLException e) {
							e.printStackTrace();
						}

					}
				});
			}
		});
		// 12ой запрос
		mainFrame.buttonQuery12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final JTextField text1 = new JTextField("01.01.2013");
				final JTextField text2 = new JTextField("01.09.2014");
				text1.setBounds(200, 10, 200, 30);
				text2.setBounds(450, 10, 200, 30);
				final MyQueryFrame myQueryFrame = new MyQueryFrame();
				myQueryFrame.setVisible(true);
				myQueryFrame.mainPanel.add(text1);
				myQueryFrame.mainPanel.add(text2);
				myQueryFrame.buttonOk.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							ResultSet myRes = null;

							myRes = MyQueries
									.SelectRowsOrganizersAndContestCountFromDate(
											dbops, text1.getText(),
											text2.getText());
							myQueryFrame.setTable(myRes);
						} catch (SQLException e) {
							e.printStackTrace();
						}

					}
				});
			}
		});
		// 12ой запрос
		mainFrame.buttonQuery13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final JTextField text1 = new JTextField("01.01.2013");
				final JTextField text2 = new JTextField("01.09.2014");
				text1.setBounds(200, 10, 200, 30);
				text2.setBounds(450, 10, 200, 30);
				final MyQueryFrame myQueryFrame = new MyQueryFrame();
				myQueryFrame.setVisible(true);
				myQueryFrame.mainPanel.add(text1);
				myQueryFrame.mainPanel.add(text2);
				myQueryFrame.buttonOk.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							ResultSet myRes = null;

							myRes = MyQueries
									.SelectRowsSportConstAndDateFromDate(
											dbops, text1.getText(),
											text2.getText());
							myQueryFrame.setTable(myRes);
						} catch (SQLException e) {
							e.printStackTrace();
						}

					}
				});
			}
		});

		mainFrame.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent arg0) {
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				try {
					dbops.conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			@Override
			public void windowActivated(WindowEvent arg0) {
			}
		});
	}

	public static void getAllContrTypes(Datas datas, DBOperations dbops)
			throws SQLException {
		ResultSet myRes = MyQueries.SelectRowsConstrTypes(dbops);
		// int rowsCount = myRes.getMetaData().getColumnCount();
		System.out.println("-- Contr types -- ");
		while (myRes.next()) {
			int id = myRes.getInt(1);
			String name = myRes.getString(2);
			datas.getContructionTypes().put(name, id);
			System.out.println("" + id + " " + name);
		}
	}

	public static void getAllSportTypes(Datas datas, DBOperations dbops)
			throws SQLException {
		ResultSet myRes = MyQueries.SelectRowsSportTypes(dbops);
		// int rowsCount = myRes.getMetaData().getColumnCount();
		System.out.println("-- Sport types -- ");
		while (myRes.next()) {
			int id = myRes.getInt(1);
			String name = myRes.getString(2);
			datas.getSportTypes().put(name, id);
			System.out.println("" + id + " " + name);
		}
	}

	public static void getAllCoachs(Datas datas, DBOperations dbops)
			throws SQLException {
		ResultSet myRes = MyQueries.SelectRowsCoach(dbops);
		// int rowsCount = myRes.getMetaData().getColumnCount();
		System.out.println("-- Coach  -- ");
		while (myRes.next()) {
			int id = myRes.getInt(1);
			String name = myRes.getString(2);
			datas.getCoachs().put(name, id);
			System.out.println("" + id + " " + name);
		}
	}

	public static void getAllSportsmens(Datas datas, DBOperations dbops)
			throws SQLException {
		ResultSet myRes = MyQueries.SelectRowsSportsmens(dbops);
		// int rowsCount = myRes.getMetaData().getColumnCount();
		System.out.println("-- Sportsmens -- ");
		while (myRes.next()) {
			int id = myRes.getInt(1);
			String name = myRes.getString(2);
			datas.getSportsmens().put(name, id);
			System.out.println("" + id + " " + name);
		}
	}

	public static void getAllContests(Datas datas, DBOperations dbops)
			throws SQLException {
		ResultSet myRes = MyQueries.SelectRowsContests(dbops);
		// int rowsCount = myRes.getMetaData().getColumnCount();
		System.out.println("-- Contests -- ");
		while (myRes.next()) {
			int id = myRes.getInt(1);
			String name = "ID = " + id + " Date = "
					+ myRes.getObject(2).toString();
			datas.getContests().put(name, id);
			System.out.println("" + id + " " + name);
		}
	}

	public static void getAllSportConstr(Datas datas, DBOperations dbops)
			throws SQLException {
		ResultSet myRes = MyQueries.SelectRowsSportConst(dbops);
		// int rowsCount = myRes.getMetaData().getColumnCount();
		System.out.println("-- Constr -- ");
		while (myRes.next()) {
			int id = myRes.getInt(1);
			String name = myRes.getString(2);
			datas.getSportConstr().put(name, id);
			System.out.println("" + id + " " + name);
		}
	}

	public static void getAllOrganizers(Datas datas, DBOperations dbops)
			throws SQLException {
		ResultSet myRes = MyQueries.SelectRowsAllOrganazers(dbops);
		// int rowsCount = myRes.getMetaData().getColumnCount();
		System.out.println("-- Organazers -- ");
		while (myRes.next()) {
			int id = myRes.getInt(1);
			String name = myRes.getString(2);
			datas.getOrganazers().put(name, id);
			System.out.println("" + id + " " + name);
		}
	}
}
