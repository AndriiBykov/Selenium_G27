package db;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDataBase {
	
	private String MySQLDriver = "com.mysql.jdbc.Driver";
	private String dataBaseURL = "jdbc:mysql://185.25.118.54/old_qa";
	private static final Logger log = LogManager.getLogger(TestDataBase.class);
	private DataBase dBMySQL;

	@Before
	public void setUp() throws Exception {

		log.info("--- Test STARTED --------");
		log.info("--- Connect MySQL DB --------");
		dBMySQL = new DataBase(dataBaseURL, MySQLDriver);
		log.info("--- Connected to MySQL --------");
	}

	@Test
	public void testSingleValue() throws SQLException, ClassNotFoundException, IOException {
		
		String testMySQLValue = dBMySQL.selectValue("select login from seleniumTable where idNumber=10");
		log.info("Result value is " + testMySQLValue);	
	}
	
	@Test
	public void testMultipleValues() throws SQLException, ClassNotFoundException, IOException {
		
		List<String> testMySQLValue = dBMySQL.selectResultSet("select idNumber from seleniumTable");
		
	    for (Object object : testMySQLValue) {
			System.out.println(object);
		}
	}
	
	@Test
	public void testTableResult() throws SQLException, ClassNotFoundException, IOException {
		
		List<ArrayList<String>> testMySQLValue = dBMySQL.selectTable("select idNumber, passWord from seleniumTable"
				+ " where idNumber > 2");
		
	    
			for (int i = 0; i < testMySQLValue.size(); i++) {
				
				System.out.println(testMySQLValue.get(i));
			}

	}
	
	@Test
	public void testValueExist() throws SQLException, ClassNotFoundException, IOException {

		boolean testMySQLValue = dBMySQL.isRowPresent("select login from seleniumTable where idNumber=77");
		log.info("Result value is " + testMySQLValue);	
	}
	
	@Test
	public void testRowsNumber() throws SQLException, ClassNotFoundException, IOException {

		int testMySQLValue = dBMySQL.getRowNumber("select count(*) from seleniumTable");
		log.info("Result value is " + testMySQLValue);	
	}

	@After
	public void tearDown() throws Exception {

		dBMySQL.close();
		log.info(" ----- Test FINISHED  -----");
	}

}
