

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String fName= request.getParameter("firstname");
		String password= request.getParameter("psw");
		String code=request.getParameter("authcode");
		
		if(LoginPage.validate(fName,password))
		{
			String s="1128";
			System.out.println(fName);
			if(s.equals(code)) 
			{
				//admin: admin.html
				RequestDispatcher rd=request.getRequestDispatcher("admin.html");
				rd.include(request, response);
			}
			else
			{
				//user: user.html

				RequestDispatcher rd=request.getRequestDispatcher("user.html");
				rd.include(request, response);
			}
			
			
			
		}
		else
		{
			out.print("Sorry name and password not match");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);	
		}
	}

}
