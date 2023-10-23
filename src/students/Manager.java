package students;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import students.details.Details;
import students.details.DetailsDAO;

public class Manager {
	private static String url = "jdbc:mysql://localhost";
	private static String username = "root";
	private static String password = "@A^9iV*YMCDrdRC6ZKzg%u1xY3g9%AB";
	private static Connection conn;
	private static Scanner sc;
	private static DetailsDAO detailDAO;
	
	private Manager() {}

	static {
		try {
			Manager.conn = DriverManager.getConnection(Manager.url, Manager.username, Manager.password);
			Statement st = Manager.conn.createStatement();
			String query = "CREATE DATABASE IF NOT EXISTS students;";
			
			st.executeUpdate(query);
			
			query = "USE students;";
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Manager.sc = new Scanner(System.in);
		Manager.detailDAO = new DetailsDAO(Manager.conn);
	}
	
	public static void insertDetail() throws SQLException {
		System.out.print("Enter the student name: ");
		String name = Manager.sc.nextLine();
		
		System.out.print("Enter the student age: ");
		int age = Manager.sc.nextInt();
		
		Details detail = new Details(name, age);
		
		Manager.detailDAO.insert(detail);
		
		System.out.println("Details entered.");
	}
	
	public static void findAllDetails() throws SQLException {
		ArrayList<Details> details = Manager.detailDAO.findAll();
		
		if (details.size() == 0) {
			System.out.println("No details found!");
		}
		
		for (Details s : details) {
			System.out.println("Id: " + s.getId());
			System.out.println("Name: " + s.getName());
			System.out.println("Age: " + s.getAge());
			System.out.println();
		}
	}
	
	public static void deleteDetail() throws SQLException {
		System.out.print("Enter the 'detail' id to be deleted: ");
		int id = Manager.sc.nextInt();
		Manager.detailDAO.delete(id);
		
		System.out.println("'detail' deleted!"); 
	}

	public static void clean() throws SQLException {
		Manager.conn.close();
	}
}
