

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Register() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String fName= request.getParameter("firstname");
		String mName= request.getParameter("middlename");
		String lName= request.getParameter("lastname");
		String qualification= request.getParameter("qualification");
		String gender= request.getParameter("gender");
		String phone= request.getParameter("phone");
		String address= request.getParameter("adrr");
		String email= request.getParameter("email");
		String password= request.getParameter("psw");
		String repeat_psw= request.getParameter("psw_repeat");
		
		
		try
		{	
		
		
			//load the driver
			Class.forName("com.mysql.jdbc.Driver");
	
		
			
			//make the connection
			String url="jdbc:mysql://localhost:3306/om";
			String username="root";
			String passwords="Omphule77@";
			
			Connection con=DriverManager.getConnection(url,username,passwords);
			
//			if(con.isClosed())
//			{
//				System.out.println("Not Connected");
//				
//			}
//			else
//			{
//				System.out.println("Connected.......!");
//			}
			//create a query
			String q="insert into register1(fName,mName,lName,qualification,gender,phone,address,email,password,repeat_psw) values(?,?,?,?,?,?,?,?,?,?)";
			
			//create a complex statement
			PreparedStatement pstmt=con.prepareStatement(q);
			pstmt.setString(1,fName);
			pstmt.setString(2,mName);
			pstmt.setString(3,lName);
			pstmt.setString(4,qualification);
			pstmt.setString(5,gender);
			pstmt.setString(6,phone);
			pstmt.setString(7,address);
			pstmt.setString(8,email);
			pstmt.setString(9,password);
			pstmt.setString(10,repeat_psw);
			
			int i=pstmt.executeUpdate();
			
			
			if(i>0)
			{
				out.print("You are successfully registered...!");
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		out.close();
	}

}
