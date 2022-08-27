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
 * Servlet implementation class Admin_Manages_Orders_Details
 */
@WebServlet("/Admin_Manages_Orders_Details")
public class Admin_Manages_Orders_Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 
	 PrintWriter out =res.getWriter();
	 Staff_Database Order_Manage=new Staff_Database(); //creating an object of a database class 
	 //***********************************getting the Stuff Id from the user when login in
     HttpSession session=req.getSession();
	 String Staff_Id=(String)session.getAttribute("Stuff_Id");
	 //@@@@@@@@@@@@checking if the Stuff Id is null
	 if(Staff_Id==null) 
	 {
		 out.println("login and try again");
	 }
	 //--------------------------------------------
	 else if(Staff_Id!=null) 
	 {
    	try {
    		List<O_Storeroom> list=Order_Manage.Manage_Oder_Status(Staff_Id);   //calling the .manage_Oder_Status method from staff_database
    		req.setAttribute("listing", list);
    		RequestDispatcher dis=req.getRequestDispatcher("Admin_Manages_Orders_Display"); //servlet being proccessed by  servlet Admin_Manages_Orders_Display
    		dis.forward(req, res);
		}
    	catch (SQLException e)
    	{
			out.print("Unexpected Error try again");
		}//end of else
	 }
	 //*****************         end of else if       *******
	 else 
	 {
		 out.println("system under going maintainance");
	 }
	 // end of else
    }
	//end of method
}
//end of class