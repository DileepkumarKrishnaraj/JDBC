package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FetchRecords {

	public static void main(String[] args) throws Exception {
		Class.forName("org.h2.Driver");
		Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		Statement stmt = con.createStatement();

		String createTable = ("create table STUDENT_DETAILS(id int,name varchar(30),department varchar(30),collegeyear int);");
		stmt.executeUpdate(createTable);
		System.out.println("Table has been created...");

		stmt.addBatch("insert into STUDENT_DETAILS values(1,'Geethanjali', 'ECE', 1)");
		stmt.addBatch("insert into STUDENT_DETAILS values(2,'GT Prasanth Arvind', 'CIVIL', 4)");
		stmt.addBatch("insert into STUDENT_DETAILS values(3,'Adhavan', 'MECH', 3)");
		stmt.addBatch("insert into STUDENT_DETAILS values(4,'Karthick', 'ECE', 2)");
		stmt.addBatch("insert into STUDENT_DETAILS values(5, 'Teechana Devi', 'ECE', 1)");

		stmt.executeBatch();

		System.out.println("Completed adding with the batch values. ");

		stmt.close();
		con.close();

	}

}

/*
 * package com.samco.servlet;
 * 
 * import java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.Statement;
 * 
 * import javax.servlet.RequestDispatcher;
 * 
 * public class PasswordCheck {
 * 
 * public static void main(String[] args) throws Exception {
 * Class.forName("org.h2.Driver"); Connection con =
 * DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
 * Statement stmt = con.createStatement();
 * 
 * }
 * 
 * public static boolean validate(String name, String password) { // TODO
 * Auto-generated method stub return false; }
 * 
 * 
 * if(PasswordCheck.validate(name, password)){ RequestDispatcher
 * rd=request.getRequestDispatcher("servlet2"); rd.forward(request,response); }
 * else{ out.print("Sorry username or password error"); RequestDispatcher
 * rd=request.getRequestDispatcher("index.html"); rd.include(request,response);
 * }
 * 
 * 
 * }
 * 
 */