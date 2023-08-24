

import java.sql.*;


import javax.servlet.RequestDispatcher;

public final class LoginPage {

	public static boolean validate(String fName ,String password) {
		
       boolean status = false;
       System.out.println("om");
       try
		{
			//load the driver
			Class.forName("com.mysql.jdbc.Driver");
			//make the connection
			System.out.println("om");
			String url="jdbc:mysql://localhost:3306/om";
			String username="root";
			String pass="Omphule77@";
			Connection con=DriverManager.getConnection(url,username,pass);
			//create a query
			String q1="select * from register1 where fName=? and password=?";
			
			//create a complex statement
			PreparedStatement pstmt=con.prepareStatement(q1);
			pstmt.setString(1, fName);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			status=rs.next();
			System.out.println("om");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("error tp much");
		}
       return status;
	}

}
