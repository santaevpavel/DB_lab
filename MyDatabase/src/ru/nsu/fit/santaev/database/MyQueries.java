package ru.nsu.fit.santaev.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyQueries {
	
	public static void CreateTable(DBOperations dbops) {
		try {
			dbops.Query("CREATE TABLE testtable (field1 VARCHAR2(10))");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void InsertRows(DBOperations dbops) throws SQLException {
		dbops.UpdateQuery("INSERT INTO testtable VALUES ('a')");

	}
	public static String getColumns(ResultSet myRes) throws SQLException{
		String str = "";
		for (int i = 1; i < myRes.getMetaData().getColumnCount(); i++){
			String n = myRes.getMetaData().getColumnName(i).toLowerCase() + " ";
			str = str + n;
		}
		return str + "\n";
		
	}
	public static ResultSet SelectRowsConstrFromId(DBOperations dbops, int id) throws SQLException {
		return dbops.Select("SELECT * FROM SportConstruction WHERE construction_type_id = " + id);
	}
	public static ResultSet SelectRowsConstrFromIdAndCapacity(DBOperations dbops, int id, int num) throws SQLException {
		return dbops.Select("SELECT *FROM " +
				"SportConstruction " +
				"JOIN Value ON SportConstruction.id = Value.construction_id " +
				"AND Value.characteristic_id = 1 WHERE " +
				"SportConstruction.construction_type_id = " + id + " AND TO_NUMBER(Value.value) >= " + num);
	}
	public static ResultSet SelectRowsConstrTypes(DBOperations dbops) throws SQLException {
		return dbops.Select("SELECT * FROM ConstructionType");
	}
	public static ResultSet SelectRowsSportTypes(DBOperations dbops) throws SQLException {
		return dbops.Select("SELECT * FROM SportType");
	}
	
	public static ResultSet SelectRowsSportsmensFromSportTypeId(DBOperations dbops, int id) throws SQLException {
		return dbops.Select("SELECT * FROM Sportsmen " +
				"JOIN SportsmenCoach ON Sportsmen.id = SportsmenCoach.sportsmen_id " +
				"WHERE SportsmenCoach.sport_type_id = " + id);
	}
	public static ResultSet SelectRowsSportsmensFromSportTypeIdAndRank
		(DBOperations dbops, int id, int num) throws SQLException {
		return dbops.Select("SELECT * FROM Sportsmen " +
				" JOIN SportsmenCoach ON Sportsmen.id = SportsmenCoach.sportsmen_id WHERE" +
				" SportsmenCoach.sport_type_id = " + id + " AND Sportsmen.category >= " + num);
	}
	public static ResultSet SelectRowsCoach(DBOperations dbops) throws SQLException {
		return dbops.Select("SELECT Coach.id, Person.first_name FROM Coach JOIN Person ON Person.id = Coach.person_id");
	}
	public static ResultSet SelectRowsCoachFromSportTypeId(DBOperations dbops, int id) throws SQLException {
		return dbops.Select("SELECT * FROM Sportsmen JOIN " +
				"SportsmenCoach ON Sportsmen.id = SportsmenCoach.sportsmen_id WHERE " +
				"SportsmenCoach.coach_id = " + id);
	}
	public static ResultSet SelectRowsSportsmensFromCoachIdAndRank2
		(DBOperations dbops, int id, int num) throws SQLException {
		return dbops.Select("SELECT * FROM Sportsmen JOIN " +
			" SportsmenCoach ON Sportsmen.id = SportsmenCoach.sportsmen_id JOIN Person " +
			" ON Sportsmen.person_id = Person.id" +
			" WHERE SportsmenCoach.coach_id = "+ id + " AND Sportsmen.category >= " + num);
	}
	public static ResultSet SelectRowsSportsmensIdWhereTypeBigger1(DBOperations dbops) throws SQLException {
		return dbops.Select("SELECT iid, Person.first_name FROM ( SELECT iid, per FROM ( " +
				" SELECT Sportsmen.id AS iid, count(SportsmenCoach.sport_type_id) AS count_type, " +
				" Sportsmen.person_id AS per FROM Sportsmen " +
				"JOIN SportsmenCoach ON Sportsmen.id = SportsmenCoach.sportsmen_id  " +
				"LEFT JOIN Person ON Person.id = Sportsmen.id" +
				" GROUP BY Sportsmen.id, Sportsmen.person_id ) " +
				"WHERE count_type > 1 ) JOIN Person ON Person.id = per");
	}
	public static ResultSet SelectRowsSportTypeForSportsmen(DBOperations dbops, int id) throws SQLException {
		return dbops.Select("SELECT SportType.name FROM SportsmenCoach " +
				" JOIN SportType ON SportsmenCoach.sport_type_id " +
				" = SportType.id WHERE SportsmenCoach.sportsmen_id = " + id);
	}
	public static ResultSet SelectRowsSportsmens(DBOperations dbops) throws SQLException {
		return dbops.Select("SELECT Sportsmen.id, first_name  " +
				"FROM Sportsmen JOIN Person ON Person.id = Sportsmen.person_id");
	}
	public static ResultSet SelectRowsSportsmensAllColums(DBOperations dbops) throws SQLException {
		return dbops.Select("SELECT id, person_id, category " +
				"FROM Sportsmen");
	}
	public static ResultSet SelectRowsCoachFromSportsmen(DBOperations dbops, int id) throws SQLException {
		return dbops.Select("SELECT Person.first_name, Person.last_name FROM " +
				" SportsmenCoach JOIN Coach ON Coach.id = SportsmenCoach.coach_id" +
				"  JOIN Person ON Person.id = Coach.person_id WHERE " +
				"SportsmenCoach.sportsmen_id = " + id);
	}
	public static ResultSet SelectRowsContests(DBOperations dbops) throws SQLException {
		return dbops.Select("SELECT id, contest_date FROM Contest");
	}
	public static ResultSet SelectPlacesOnContest(DBOperations dbops,int id) throws SQLException {
		return dbops.Select("SELECT  ContestSportsmens.place AS places, Person.first_name FROM Contest " +
				" JOIN ContestSportsmens ON ContestSportsmens.contest_id = Contest.id " +
				" JOIN Sportsmen ON ContestSportsmens.sportsmen_id = Sportsmen.id " +
				" JOIN Person ON Sportsmen.person_id = Person.id WHERE Contest.id = " + id);
	}
	public static ResultSet SelectRowsSportConst(DBOperations dbops) throws SQLException {
		return dbops.Select("SELECT id, name  FROM SportConstruction");
	}
	public static ResultSet SelectRowsSportConstAllColumns(DBOperations dbops) throws SQLException {
		return dbops.Select("SELECT id, name, construction_type_id  FROM SportConstruction");
	}
	public static ResultSet SelectRowsPersonsAllColumns(DBOperations dbops) throws SQLException {
		return dbops.Select("SELECT id, first_name, last_name  FROM Person");
	}
	public static ResultSet SelectRowsCoachsAllColumns(DBOperations dbops) throws SQLException {
		return dbops.Select("SELECT id, person_id  FROM Coach");
	}
	public static ResultSet SelectRowsSportTypesAllColumns(DBOperations dbops) throws SQLException {
		return dbops.Select("SELECT id, name  FROM SportType");
	}
	public static ResultSet SelectRowsSportClubsAllColumns(DBOperations dbops) throws SQLException {
		return dbops.Select("SELECT id, name  FROM SportClub");
	}
	public static ResultSet SelectRowsContestSportsmensAllColumns(DBOperations dbops) throws SQLException {
		return dbops.Select("SELECT contest_id, sportsmen_id, place  FROM ContestSportsmens");
	}
	public static ResultSet SelectRowsContestsAllColumns(DBOperations dbops) throws SQLException {
		return dbops.Select("SELECT id, construction_id, sporttype_id  FROM Contest");
	}
	public static ResultSet SelectRowsSportsmenCoachsAllColumns(DBOperations dbops) throws SQLException {
		return dbops.Select("SELECT sportsmen_id, coach_id, sport_type_id FROM SportsmenCoach");
	}
	public static ResultSet SelectRowsConstrTypesAllColumns(DBOperations dbops) throws SQLException {
		return dbops.Select("SELECT id, name  FROM ConstructionType");
	}
	public static ResultSet SelectRowsValuesAllColumns(DBOperations dbops) throws SQLException {
		return dbops.Select("SELECT id, construction_id, construction_type_id, characteristic_id, value FROM Value");
	}
	public static ResultSet SelectRowsContestFromConstr(DBOperations dbops, int id) throws SQLException {
		return dbops.Select("SELECT Contest.id, Contest.contest_date FROM Contest " +
				"JOIN SportConstruction ON SportConstruction.id = Contest.construction_id " +
				"WHERE SportConstruction.id = " + id);
	}
	public static ResultSet SelectRowsContestFromConstrAndSportType(DBOperations dbops, int id, int id2) throws SQLException {
		return dbops.Select("SELECT Contest.id, Contest.contest_date FROM Contest " +
				"JOIN SportConstruction ON SportConstruction.id = Contest.construction_id " +
				"WHERE SportConstruction.id = " + id + " AND Contest.sporttype_id = " + id2);
	}
	public static ResultSet SelectRowsSportClubFromContestTime(DBOperations dbops, String date1, String date2) throws SQLException {
		return dbops.Select("SELECT SportClub.id, COUNT(iid), SportClub.name FROM ( SELECT  DISTINCT Sportsmen.id AS iid," +
				" Sportsmen.sport_club_id AS spid FROM Contest  " +
				"JOIN ContestSportsmens ON ContestSportsmens.contest_id = Contest.id " +
				"JOIN Sportsmen ON Sportsmen.id = ContestSportsmens.sportsmen_id WHERE " +
				"Contest.contest_date BETWEEN TO_DATE('"+ date1 + "', 'DD.MM.YYYY') " +
				"AND TO_DATE('"+ date2 + "', 'DD.MM.YYYY') ) JOIN SportClub ON SportClub.id = spid " +
				"GROUP BY SportClub.id, SportClub.name");
	}
	public static ResultSet SelectRowsContestFromDate(DBOperations dbops, String date1, String date2) throws SQLException {
		return dbops.Select("SELECT * FROM Contest  WHERE " +
				" Contest.contest_date BETWEEN TO_DATE('" + date1 + "', 'DD.MM.YYYY') " +
				" AND TO_DATE('" + date2 + "', 'DD.MM.YYYY') ");
	}
	public static ResultSet SelectRowsAllOrganazers(DBOperations dbops) throws SQLException {
		return dbops.Select("SELECT DISTINCT Person.id, Person.first_name, Person.last_name FROM Organizer JOIN Person ON Person.id = Organizer.person_id");
	}
	public static ResultSet SelectRowsContestFromDateAndOrganizer(DBOperations dbops, String date1, String date2, int id) throws SQLException {
		return dbops.Select("SELECT * FROM Contest  " +
				" JOIN Organizer ON Contest.id = Organizer.contest_id WHERE Contest.contest_date BETWEEN" +
				" TO_DATE('" + date1 + "', 'DD.MM.YYYY') AND TO_DATE('" + date2 + "', 'DD.MM.YYYY') " +
				"AND Organizer.person_id = " + id);
	}
	public static ResultSet SelectRowsCoachFromSortType(DBOperations dbops, int id) throws SQLException {
		return dbops.Select("SELECT DISTINCT Person.id, Person.first_name, Person.last_name " +
				"FROM Coach JOIN SportsmenCoach ON Coach.id = SportsmenCoach.coach_id " +
				"JOIN Person ON Person.id = Coach.person_id " +
				"WHERE SportsmenCoach.sport_type_id = " + id);
	}
	public static ResultSet SelectRowsSportsmenWitchNotPlayed(DBOperations dbops, String date1, String date2) throws SQLException {
		return dbops.Select("SELECT * FROM Sportsmen  " +
				"JOIN Person ON Person.id = Sportsmen.person_id " +
				"WHERE  Sportsmen.id NOT IN ( SELECT DISTINCT Sportsmen.id " +
				"FROM ContestSportsmens " +
				"JOIN Sportsmen ON Sportsmen.id = ContestSportsmens.sportsmen_id " +
				"JOIN Contest ON Contest.id = ContestSportsmens.contest_id " +
				"WHERE Contest.contest_date BETWEEN " +
				"TO_DATE('" +date1+"', 'DD.MM.YYYY') AND TO_DATE('" +date2+"', 'DD.MM.YYYY'))");
	}
	public static ResultSet SelectRowsOrganizersAndContestCountFromDate(DBOperations dbops, String date1, String date2) throws SQLException {
		return dbops.Select("SELECT Organizer.person_id, Person.first_name, COUNT(Contest.id) " +
				"FROM Organizer  JOIN Contest ON Contest.id = Organizer.contest_id " +
				"JOIN Person ON Person.id = Organizer.person_id WHERE Contest.contest_date BETWEEN " +
				"TO_DATE('"+date1+"', 'DD.MM.YYYY') AND TO_DATE('"+date2+"', 'DD.MM.YYYY') " +
				"GROUP BY Organizer.person_id, Person.first_name");
	}
	public static ResultSet SelectRowsSportConstAndDateFromDate(DBOperations dbops, String date1, String date2) throws SQLException {
		return dbops.Select("SELECT SportConstruction.name, Contest.contest_date FROM " +
				"SportConstruction JOIN Contest ON Contest.construction_id = SportConstruction.id " +
				"WHERE Contest.contest_date BETWEEN " +
				"TO_DATE('" +date1+"', 'DD.MM.YYYY') AND TO_DATE('" +date2+"', 'DD.MM.YYYY')");
	}
}



