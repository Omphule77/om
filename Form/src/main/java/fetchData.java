

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fetchData
 */
@WebServlet("/fetchData")
public class fetchData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fetchData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try
			{
			    response.setContentType("text/html");
			    PrintWriter out=response.getWriter();
				//load the driver
				Class.forName("com.mysql.jdbc.Driver");
				//make the connection
				System.out.println("om");
				String url="jdbc:mysql://localhost:3306/om";
				String username="root";
				String pass="Omphule77@";
				Connection con=DriverManager.getConnection(url,username,pass);
				//create a query
			String q1="select * from register1";
			
				//create a complex statement
			PreparedStatement pstmt=con.prepareStatement(q1);
				ResultSet rs=pstmt.executeQuery();
				out.println("<html><head><link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"></head><body><table class='table table-bordered'><tr><td>id</td><td>fName</td><td>mName</td><td>lName</td><td>qualification</td><td>gender</td><td>phone</td><td>address</td><td>email</td><td>password</td><td>repeat_psw</td></tr>");
				while(rs.next())
				{
					out.println("<tr><td>"+rs.getString(1)+"</td>");
					out.println("<td>"+rs.getString(2)+"</td>");
					out.println("<td>"+rs.getString(3)+"</td>");
					out.println("<td>"+rs.getString(4)+"</td>");
					out.println("<td>"+rs.getString(5)+"</td>");
					out.println("<td>"+rs.getString(6)+"</td>");
					out.println("<td>"+rs.getString(7)+"</td>");
					out.println("<td>"+rs.getString(8)+"</td>");
					out.println("<td>"+rs.getString(9)+"</td>");
					out.println("<td>"+rs.getString(10)+"</td></tr>");
				}
				out.println("</table></body></html>");	
				System.out.println("ok done");
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("error tp much");
			}
	}

}
