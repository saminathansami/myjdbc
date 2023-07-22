package org;

import java.sql.*;
import javax.management.Query;




public class SelectQuery {
	
	public void ConnectionMethod() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Driver myDriver = new com.mysql.jdbc.Driver();
			//DriverManager.registerDriver(myDriver);
			String url = "jdbc:mysql://localhost:3306/sakila";
			String UserName = "root";
			String Password = "root";
			Connection con = DriverManager.getConnection(url, UserName, Password) ;
			Statement statement = con.createStatement();
			String SelecQuery = "select * from city ";
								
			
			ResultSet resultset = statement.executeQuery(SelecQuery);
			
			String cityid;
			String cityName;
			String CountryId;
			String LastUpdate;
			
			while(resultset.next()) {
				cityid = resultset.getString("city_id");
				cityName = resultset.getString("city");
				CountryId = resultset.getString("country_id");
				LastUpdate = resultset.getString("last_update");
				
			//	System.out.println(resultset.getString("city_id"));
			//	System.out.println(resultset.getString("city"));
			//	System.out.println(resultset.getString("country_id"));
			//	System.out.println(resultset.getString("last_update"));
				
				System.out.println("city_id="+cityid+"  "+"cityName="+cityName+" "+ "CountryId="+CountryId+" "+" "+"LastUpdate="+ LastUpdate);
				
			}
			
			
			System.out.println("SelecQuery::::"+SelecQuery);
			System.out.println("resultset::::"+resultset);
			con.close();
			
			
			
			
		}catch(Exception e) {
			System.out.println("Exception::::"+e);
		}
	}

	public static void main(String[] args) {
		SelectQuery sq = new SelectQuery();
		sq.ConnectionMethod();

	}

}
