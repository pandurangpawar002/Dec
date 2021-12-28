import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class testSqlDB {

	 //DB Test PP 
	@Test
	public void test() throws ClassNotFoundException, SQLException {

		// Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
		String dbUrl = "jdbc:mysql://localhost:3306/piyu";

		// Database Username
		String username = "root";

		// Database Password
		String password = "rootpassword";

		// Query to Execute
		String query = "select *  from Pandu;";

		// Load mysql jdbc driver
		Class.forName("com.mysql.jdbc.Driver");

		// Create Connection to DB

		java.sql.Connection con = DriverManager.getConnection(dbUrl, username, password);

		// Create Statement Object
		Statement stmt = con.createStatement();

		// Execute the SQL Query. Store results in ResultSet
		ResultSet rs = stmt.executeQuery(query);

		// While Loop to iterate through all data and print results
		while (rs.next()) {
			String myName = rs.getString(1);
			String myAge = rs.getString(2);
			System.out.println(myName + "  " + myAge);
		}
		// closing DB Connection
		con.close();

	}

}
