package org;

import java.sql.*;


//import com.mysql.cj.jdbc.Driver;
//import com.mysql.cj.xdevapi.Statement;

public class MyConnection {
	
	public void DoConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Driver myDriver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(myDriver);
			String url = "jdbc:mysql://localhost:3306/sakila";
			String UserName = "root";
			String Password = "root";
			Connection con = DriverManager.getConnection(url, UserName, Password) ;
			Statement statement = con.createStatement();
			String MyQueryString = "insert into city values(601, 'Bangalore', 91, '2023-07-21 12:00:00');";
			statement.executeUpdate(MyQueryString);
			
			System.out.println("Query executed successfuly");
			con.close();
			
			
		}catch(Exception e) {
			System.out.println("Exception >>>>"+e);
		}
		
		
	}
	
	
	
	

	public static void main(String[] args) {
		MyConnection m = new MyConnection();
		m.DoConnection();

	}

}
