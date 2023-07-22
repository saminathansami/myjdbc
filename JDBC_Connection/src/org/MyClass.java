package org;
import java.sql.*;
public class MyClass
{
public void CommonConnection()
{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Driver myDriver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(myDriver);
			//above drivers are not necessary but including those are good practice.
			
			String url = "jdbc:mysql://localhost:3306/student";
			String UserName = "root";
			String Password = "root";
			Connection con = DriverManager.getConnection(url, UserName, Password) ;
			Statement statement = con.createStatement(); //for insert
			Statement s1=con.createStatement();   //for delete
			Statement s2=con.createStatement();   //for select query
			Statement s3=con.createStatement();   //for update query
			
			//insert operation
			String MyQuery = "insert into student values (9,'Maheskumar', 'Coimbatore', 109087) ";
			statement.executeUpdate(MyQuery);
			System.out.println("Query Executed--->"+MyQuery);
			
			//delete operation
			String MyQuery1="delete from student where id=8";
			s1.executeUpdate(MyQuery1);
			System.out.println("Query Executed--->"+MyQuery1);
			
			//update operation
			String MyQuery2="update student SET phone=1234 where id=5";
			s3.executeUpdate(MyQuery2);
			System.out.println("Query Executed--->"+MyQuery2);
			
			//selection operation
			String SelectQuery = "select * from student ";  
			ResultSet resultset = s2.executeQuery(SelectQuery); //it is stored in variable
			String id;      //string created for every column
			String name;
			String city;
			String phone;
			
			while(resultset.next()) {    //resultset is called
				id = resultset.getString("id");
				name = resultset.getString("name");  //before printing the values are stored in a variable
				city = resultset.getString("city");
				phone = resultset.getString("phone");
			
				System.out.println("id= "+id+" "+"name= "+name+"  "+"city= "+city+"  "+"phone= "+phone+"  ");
			}      //while loop is closed
			System.out.println("SelectQuery::::"+SelectQuery);  //printing the results
			System.out.println("resultset::::"+resultset);
			
			con.close();
			
			
		}catch(Exception e) {
			System.out.println("Exception >>>>"+e);
		}
		
		
}
	

	public static void main(String[] args) 
	{
		MyClass cc= new MyClass();
		cc.CommonConnection();
		

	}

}
