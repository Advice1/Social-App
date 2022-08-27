package Admin_Service;

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

import ProffesionalService.StorageProfessionalService;
import administration.Staff_Database;
import design.Database;

/**
 * Servlet implementation class AdminServiceDetails
 */
@WebServlet("/AdminServiceDetails")
public class AdminServiceDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 @Override
	    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter out=res.getWriter();
		
		 Staff_Database Stuff_data=null;       //creating an object of a class Staff_Database and setting it to null
	     Stuff_data=new  Staff_Database();      
	    	try {
	    		List<StorageProfessionalService> list=Stuff_data.DisplayServiceOfferdAdmin();   //calling the DisplayServiceOfferdAdmin method
	    		req.setAttribute("list", list);
	    		RequestDispatcher dis=req.getRequestDispatcher("AdminServiceDisplay"); //servlet being processed by a servlet (AdminServiceDisplay)
	    		dis.forward(req, res);
			} catch (SQLException e) {
				
				out.print("Unexpected error try again");
			}
	    	
	    	
	    }

}
