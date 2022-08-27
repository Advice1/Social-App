package UpdatingProfessinalService;

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
import ProffesionalService.StorageProfessionalService;
import design.Database;



@WebServlet("/UpdatingServiceDetails")
public class UpdatingServiceDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 //***********************************getting the username from the user when login in
		PrintWriter out =res.getWriter();
     HttpSession session=req.getSession();
	 String uname=(String)session.getAttribute("name");
	 //@@@@@@@@@@@@checking if the username is null
	 //--------------------------------------------
	 Database datails=null;       //creating an object of database class 
    	datails=new Database();     
    	try {
    		List<StorageProfessionalService> list=datails.updateService(uname);   //calling the updateservice method
    		req.setAttribute("list", list);
    		RequestDispatcher dis=req.getRequestDispatcher("DisplayService"); //servlet being proccessed by a sevlert(DisplayService)
    		dis.forward(req, res);
		  } 
    	catch (SQLException e)
    	{
			e.printStackTrace();
			out.print("Unexpected error");
			out.println("<a href=\"MainMenu.html\">MENU</a>");
		}  	
 }// end of method
}//end of class
