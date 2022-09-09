package demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class ApacheCommonDBCPTest {

	private static void DBCPDataSource(String dbType) {
		DataSource ds = DBCPDataSource.getDataSource(dbType);

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			stmt.addBatch("insert into STUDENT_DETAILS values(10,'Amini', 'ECE', 1)");
			stmt.addBatch("insert into STUDENT_DETAILS values(11,'Nitheesh', 'CSE', 4)");
			stmt.addBatch("insert into STUDENT_DETAILS values(12,'Kalai', 'MECH', 3)");
			stmt.addBatch("insert into STUDENT_DETAILS values(13,'Ranjith', 'CSE', 2)");
			stmt.executeBatch();
			/*
			 * while(rs.next()){
			 * System.out.println("ID="+rs.getInt("id")+", Name="+rs.getString("name")); }
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		DBCPDataSource("h2");
		System.out.println("Thus the results...");

	}

}
