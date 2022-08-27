package orderStoreroom;

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

import design.Database;

/**
 * Servlet implementation class Order_Details
 */
@WebServlet("/Order_Details")
public class Order_Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Override
	    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 
		PrintWriter out =res.getWriter();
		 Database Order_Status=new Database();       //creating an object of a database class 
		 //***********************************getting the username from the user when login in
	     HttpSession session=req.getSession();
		 String StudentId=(String)session.getAttribute("name");
		 //********checking if the username is null
		
		 if(StudentId==null) 
		 {
			 out.println("login and try again");
		 }
		 //--------------------------------------------
		 else if(StudentId!=null) 
		 {
	    	try {
	    		List<O_Storeroom> list=Order_Status.View_Oder_Status(StudentId);   //calling the .View_Oder_Status method from database
	    		req.setAttribute("listing", list);
	    		RequestDispatcher dis=req.getRequestDispatcher("Order_Details_Display"); //servlet being proccessed by a servlet(Order_Details_Display)
	    		dis.forward(req, res);
			   } 
	    	catch (SQLException e) 
	    	{
				out.print("Unexpected error");
			}//end of catch
		 }
		 //*****************         end of else if       *******
 }//end of method
}
//end of class
