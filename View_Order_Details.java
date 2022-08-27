package cafeteria_orders;

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
import administration.Staff_Database;
import orderStoreroom.O_Storeroom;

/**
 * Servlet implementation class View_Order_Details
 */
@WebServlet("/View_Order_Details")
public class View_Order_Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Override
	    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out =res.getWriter();
		 Staff_Database Order_Status=new Staff_Database();       //creating an object of a Staff_Database class 
		 //***********************************getting the username from the user when login in
	     HttpSession session=req.getSession();
		 String StudentId=(String)session.getAttribute("name");
		 //***********checking if the username is null
		
		 if(StudentId==null) 
		 {
			 out.println("login and try again");
		 }
		 //--------------------------------------------
		 else if(StudentId!=null) 
		 {
	    	try {
	    		List<O_Storeroom> list=Order_Status.Cafeteria_Oder_Status(StudentId);   //calling the .View_Oder_Status method from database
	    		req.setAttribute("listing", list);
	    		RequestDispatcher dis=req.getRequestDispatcher("Display_Orders"); //servlet being proccessed by  servlet Display_Orders
	    		dis.forward(req, res);
			} //end of try
	    	catch (SQLException e) 
	    	{
				out.print("Unexpected error try again");
			}//end of try
		 }
		 //*****************         end of else if       ******* 	
	    }//end of method
}
//end of class