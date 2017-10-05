package db;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/*
 *  Database class provides methods for working with database.
 */
public class DataBase {

	private Connection connection = null;
	private static final Logger log = LogManager.getLogger(DataBase.class);

	// For QALight BD
	private String MySQL_PADB_DB_USER = "old_qa";
	private String MySQL_PADB_DB_PASSWORD = "PB3Q2F6tdSD9cL3z";

	// Constructor opens connection to database using connection string
	public DataBase(String dataBaseURL, String driver) throws IOException, ClassNotFoundException, SQLException {

		// Load driver for JDBC class
		Class.forName(driver);

		// Create a connection to the database
		connection = DriverManager.getConnection(dataBaseURL, MySQL_PADB_DB_USER, MySQL_PADB_DB_PASSWORD);
		log.info("Connection: " + connection);
	}

	/*
	 * That method verifies if the row in the query exists in the database
	 */
	public boolean isRowPresent(String query) throws SQLException {
		// System.out.println(query);

		// Create statement for connection, execute query and save outcome in
		// ResultSet
		Statement stm = connection.createStatement();
		ResultSet rSet = stm.executeQuery(query);

		// Calculate number of rows
		int rowNumber = 0;
		while (rSet.next()) {
			rowNumber++;
		}

		stm.close();

		// Verify if the row exists in the table
		if (rowNumber == 0) {
			return false;
		} else {
			return true;
		}

	}

	/*
	 * That method gets SQL [Select COLUMN_NAME from TABLE_NAME where ...] query
	 * as parameter and returns result as String
	 */
	public String selectValue(String query) throws SQLException {

		// Create statement for connection, execute query and save outcome in
		// ResultSet
		Statement stm = connection.createStatement();
		ResultSet rSet = stm.executeQuery(query);
		ResultSetMetaData meta = rSet.getMetaData();

		// Retrieve value from ResultSet
		String value = "";

		if (rSet.next()) {
			if (rSet.getObject(1) != null) {
				value = rSet.getObject(1).toString();

				if (meta.getColumnType(1) == 93) {
					value = value.substring(0, value.length() - 2);
				}
			}
		}

		stm.close();
		value = value.trim();
		return value;
	}

	/*
	 * That method gets SQL [Select COLUMN_NAME from TABLE_NAME where ...] query
	 * as parameter and returns result set as List of Strings
	 */
	public List<String> selectResultSet(String query) throws SQLException {

		// Create statement for connection, execute query and save outcome in
		// ResultSet
		Statement stm = connection.createStatement();
		ResultSet rSet = stm.executeQuery(query);

		// Get ResultSet's meta data
		ResultSetMetaData meta = rSet.getMetaData();

		List<String> resultSet = new ArrayList<String>();

		while (rSet.next()) {
			String value = "";

			if (rSet.getObject(1) != null) {
				value = rSet.getObject(1).toString();

				if (meta.getColumnType(1) == 93) {
					value = value.substring(0, value.length() - 2);
				}
			}

			value = value.trim();
			resultSet.add(value);
		}

		// Close the statement
		stm.close();
		// System.out.println(query);
		return resultSet;
	}

	/*
	 * That method gets SQL [Select COLUMN_NAME_1,COLUMN_NAME_2 from TABLE_NAME
	 * where ...] query as parameter and returns result set as List of Strings
	 */
	public List<ArrayList<String>> selectTable(String query) throws SQLException {
		// Create statement for connection, execute query and save outcome in
		// ResultSet
		Statement stm = connection.createStatement();
		// System.out.println(query);
		ResultSet rSet = stm.executeQuery(query);

		// Get ResultSet's meta data
		ResultSetMetaData meta = rSet.getMetaData();
		int columnNumber = meta.getColumnCount();

		List<ArrayList<String>> resultTable = new ArrayList<ArrayList<String>>();

		// Add column_name's values in the result table header
		ArrayList<String> columnNameSet = new ArrayList<String>();
		columnNameSet.add("");
		for (int i = 0; i < columnNumber; i++) {
			columnNameSet.add(meta.getColumnName(i + 1));
		}
		resultTable.add(columnNameSet);

		// Add result rows in the result table
		int resultSize = 0;

		while (rSet.next()) {
			ArrayList<String> resultSet = new ArrayList<String>();
			resultSize++;
			resultSet.add(String.valueOf(resultSize));

			for (int k = 1; k < (columnNumber + 1); k++) {
				String value = "";

				if (rSet.getObject(k) != null) {
					value = rSet.getObject(k).toString();

					if (meta.getColumnType(k) == 93) {
						value = value.substring(0, value.length() - 2);
					}
				}

				value = value.trim();
				resultSet.add(value);
			}

			resultTable.add(resultSet);
		}

		// Close the statement
		stm.close();
		// System.out.println(query);
		return resultTable;
	}

	/*
	 * That method gets SQL [Select count(*) from TABLE_NAME where ...] query as
	 * parameter and returns number of rows as Integer
	 */
	public int getRowNumber(String query) throws SQLException {

		// Create statement for connection, execute query and save outcome in
		// ResultSet
		Statement stm = connection.createStatement();
		ResultSet rSet = stm.executeQuery(query);

		// Retrieve value from ResultSet
		int rowCount = 0;

		if (rSet.next()) {
			if (rSet.getObject(1) != null) {
				rowCount = Integer.parseInt(rSet.getObject(1).toString());
			}
		}

		stm.close();
		// System.out.println(query);
		return rowCount;
	}


	// Close connection to the database
	public void close() throws SQLException {
		connection.close();
	}

}
