package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementDemo {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Student student = new Student();
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter the details: ");
			student.setId(scanner.nextInt());
			student.setName(scanner.next());
			student.setDept(scanner.next());
			student.setYear(scanner.next());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Class.forName("org.h2.Driver");
		Connection connection = null;
		Statement statement = null;
		PreparedStatement pstmt = null;

		try {
			connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");

			//String createTable = "CREATE TABLE STUDENT_DETAILS (ID INT,NAME VARCHAR(10),DEPT VARCHAR(10),YR VARCHAR(4))";
			statement = connection.createStatement();
			//statement.executeUpdate(createTable);
			System.out.println("Table Created");

			pstmt = connection.prepareStatement("INSERT INTO STUDENT_DETAILS VALUES(?,?,?,?);");
			pstmt.setInt(1, student.getId());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getDept());
			pstmt.setString(4, student.getYear());

			pstmt.executeUpdate();
			System.out.println("Inserted");
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			statement.close();
			pstmt.close();
			connection.close();

		}

	}

}
