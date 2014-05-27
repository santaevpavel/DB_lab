package ru.nsu.fit.santaev.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

import oracle.jdbc.OracleDriver;

public class DBOperations {

	public Connection conn = null;
	public Statement stmt = null;

	public ResultSet Select(String query) throws SQLException {
		ResultSet rSet;
		rSet = stmt.executeQuery(query);
		return rSet;
	}

	public int UpdateQuery(String query) throws SQLException {
		return stmt.executeUpdate(query);
	}

	public boolean Query(String query) throws SQLException {
		return stmt.execute(query);
	}

	public DBOperations(String db, String ipport, String SID, String Name,
			String passwd) throws ClassNotFoundException {
		try {
			Locale.setDefault(Locale.ENGLISH);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			DriverManager.registerDriver(new OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:" + db
					+ ":thin:@" + ipport + ":" + SID, Name, passwd);
			conn = connection;
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("SQL Error " + e.getMessage());
		}

	}

	public int getRows(ResultSet res) {
		int totalRows = 0;
		try {
			res.last();
			totalRows = res.getRow();
			res.beforeFirst();
		} catch (Exception ex) {
			return 0;
		}
		return totalRows;
	}
}