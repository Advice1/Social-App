package multiImageRetrival;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/UpdateDetails")
public class UpdateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	 @Override
	    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter out =res.getWriter();
		 //***********************************getting the username from the user when login in
         HttpSession session=req.getSession();
		 String uname=(String)session.getAttribute("name");
		 
		
		//"*********************************html code
		 out.println("<html>");
		 out.println("<head>");
		 out.println("</head>");
		 out.println("<body>");
		 
		 
		 //@@@@@@@@@@@@checking if the username is null
		 if(uname==null) 
		 {
			 out.println("<p>login and try again</p>");
			 out.println("<a href=\"WelcomePage.html\">MENU</a>");
		 }
		 //--------------------------------------------
		 else {
		 FriendDatabase imagedata=null;       //creating an object of a class and setting it to null
	    imagedata=new FriendDatabase();      //
	    	try {
	    		List<Student> list=imagedata.updateProfile(uname);   //calling the updateprofile mathod
	    		req.setAttribute("list", list);
	    		RequestDispatcher dis=req.getRequestDispatcher("UpdateDispaly"); //servlet being proccessed by a sevlert
	    		dis.forward(req, res);	
			    } 
	    	catch (SQLException e) 
	    	{	
				out.print("<p>Unexpected error</p>");
				out.println("<a href=\"WelcomePage.html\">MENU</a>");
			}
		 }//**********************end of else
		 
		 out.println("</body>");
		 out.println("</html>");
 }//end of method

}
