package Searching_Data;


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
import com.mysql.jdbc.MysqlDataTruncation;
import multiImageRetrival.FriendDatabase;
import multiImageRetrival.Student;

/**
 * Servlet implementation class searchingDetails
 */
@WebServlet("/searchingDetails")
public class searchingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    	PrintWriter out =res.getWriter();
		 String name=req.getParameter("name");   //getting a name from the database 
		 FriendDatabase imagedetail=null;       //creating an object of a FriendDatabase class
		 imagedetail=new FriendDatabase();      
	    	try {
	    		List<Student> list=imagedetail.SearchData(name);   //calling the getData method
	    		req.setAttribute("list", list);
	    		RequestDispatcher dis=req.getRequestDispatcher("SearchDisplay");
	    		dis.forward(req, res);
			   } 
		    catch(MysqlDataTruncation e) 
			   {
				   out.println("Search invalid");
				   out.println("<a href=\"WelcomePage.html\">HOME</a>");
			   }//end of catch
	//**********************************************************
			   catch (NumberFormatException e) 
			     {
						out.println("<h2>Mismach inputs</h2>");
						out.println("<br><a href=\"MainMenu.html\">HOME</a>");
				 }//end of catch
	 //**********************************************************
	    	catch (SQLException e) {
				e.printStackTrace();
				
			}//end of catch
	    }//end of method
}//end of method
