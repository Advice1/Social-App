package ProffesionalService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import design.Database;

/**
 * 218248970 Design Project
 * Advice Nxumalo
 * CPUT
 * Servlet implementation class ProcessingDetails
 */
@WebServlet("/ProcessingDetails")
public class ProcessingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 @Override
	    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 Database data=null;       //creating an object of a class and setting it to null
	     data=new Database();      //
	    	
	    	try {
	    		List<StorageProfessionalService> list=data.StoreDetails();   //calling the StoreDetails method
	    		req.setAttribute("listing", list);
	    		RequestDispatcher dis=req.getRequestDispatcher("ProfessionalServiceDisplay"); //servlet being proccessed by a servlet(ProfessionalServiceDisplay)
	    		dis.forward(req, res);
			    }
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}//end of catch
	    }//end of method

}//end of class
