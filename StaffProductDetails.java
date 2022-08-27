package cafeteriaService;

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
import administration.Staff_Database;

/**
 * Servlet implementation class StaffProductDetails
 */
@WebServlet("/StaffProductDetails")
public class StaffProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		 PrintWriter out=res.getWriter();
		//***********************************getting the staff id from the session
     HttpSession session=req.getSession();
	 String StaffNo=(String)session.getAttribute("Stuff_Id");
	 //*********checking if the staff id is null
	 if(StaffNo==null) 
	 {
		 out.println("<h1>Sorry login again<h1>");
		 out.println("<a href=\"WelcomePage.html\">Home</a>");
	 }
	 //--------------------------------------------
	 else {
	 Staff_Database dataDetails=null;       //creating an object of a class and setting it to null
	 dataDetails=new Staff_Database();   
    	try {
    		List<StorageProfessionalService> list=dataDetails.displayService(StaffNo);   //calling the getData method
    		req.setAttribute("list", list);
    		RequestDispatcher dis=req.getRequestDispatcher("StuffServiceDisplay"); //servlet being processed by a sevlert(StuffServiceDisplay)
    		dis.forward(req, res);
		} 
    	catch (SQLException e)
    	{
			out.print("Unexpected error try again");
		}
	 }//*****************end of else	
    }//end of method
}
