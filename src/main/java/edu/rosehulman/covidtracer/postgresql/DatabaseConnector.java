package edu.rosehulman.covidtracer.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {

	private final String url = "jdbc:postgresql://localhost:5432/CovidTracer";
	private final String user = "postgres";
	private final String password = "Nn2Nm7PaNF#^";

	public Connection connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the PostgreSQL server successfully.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}
	
	public void readFromDBTest() {
		Connection c = connect();
		try {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM \"Test\";");
			while(rs.next()) {
				System.out.println(rs.getString("test"));
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertIntoDBTest() {
		Connection c = connect();
		String SQL = "INSERT INTO \"Test\"(test) VALUES(?)";
		
		try {
			PreparedStatement pstmt = c.prepareStatement(SQL);
			pstmt.setString(1, "Insert");
			pstmt.execute();
			System.out.println("Successfully inserted 'Insert'...");
			pstmt.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
