package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args) throws Exception {

		try {
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			Statement statement = connection.createStatement();

			String query = "CREATE TABLE FRIENDS(NAME VARCHAR(100))";
			statement.executeUpdate(query);

			String name = "KARTHICK";
			statement.executeUpdate("INSERT INTO FRIENDS VALUES('" + name + "')");

			name = "ADHAVAN";
			statement.executeUpdate("INSERT INTO FRIENDS VALUES('" + name + "')");

			ResultSet resultSet = statement.executeQuery("SELECT * FROM FRIENDS");
			while (resultSet.next()) {
				System.out.println(resultSet.getString("NAME"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
