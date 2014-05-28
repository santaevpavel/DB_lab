package ru.nsu.fit.santaev.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.OracleDriver;

public class DBOperations {

	public Connection conn = null;
	public Statement stmt = null;

	public ResultSet Select(String query) throws SQLException {
		ResultSet rSet;

		rSet = stmt.executeQuery(query);
		// System.out.println("Type " + rSet.getType(). + " " +
		// rSet.getConcurrency());
		// ResultSet rs=statement.executeQuery(sql);
		int concur = rSet.getConcurrency();
		if (concur == ResultSet.CONCUR_READ_ONLY) {
			System.out.println("ResultSet is CONCUR_READ_ONLY");
		} else if (concur == ResultSet.CONCUR_UPDATABLE) {
			System.out.println("ResultSet is CONCUR_UPDATABLE");
		} else {
			System.out.println("ResultSet is Error");
		}
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
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
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