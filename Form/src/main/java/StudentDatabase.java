import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentDatabase {

	private static Connection con=null;
	public static void main(String[] args) {
		
		StudentDatabase studentDatabase=new StudentDatabase();
		try
		{
		 //load the driver
			Class.forName("com.mysql.jdbc.Driver");
			
		//Creating connection
			String url="jdbc:mysql://localhost:3306/om";
			String username="root";
			String password="Omphule77@";
			Connection con=DriverManager.getConnection(url,username,password);
			
			studentDatabase.selectRecord();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}
	public void selectRecord() throws SQLException{
		String sql="select * from register1 where id=1";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			int Id=rs.getInt("id");
			String fname=rs.getString("fName");
			System.out.println(Id   + fname);
		}
		
	}

}
