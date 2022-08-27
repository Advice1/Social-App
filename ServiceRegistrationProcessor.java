package ProffesionalService;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mysql.jdbc.MysqlDataTruncation;

import design.Database;

/**
 * Servlet implementation class ServiceRegistrationProcessor
 */

@javax.servlet.annotation.MultipartConfig
@WebServlet("/ServiceRegistrationProcessor")
public class ServiceRegistrationProcessor extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String service;
	private String Description;
	private Float prize;
	private String town;
	private String building;
	private String BuildingNo;
	private String Action;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out =response.getWriter();
		 Database information=new Database();  //object type of database class
		//***********************************getting the username from the user when login in
         HttpSession session=request.getSession();
		 String username=(String)session.getAttribute("name");
		 //**************checking if the username is null
		 
		//************************************scanning user inputs**********************8
		 name=request.getParameter("name");
		 service=request.getParameter("service");
		 Description=request.getParameter("description");
		 prize=Float.parseFloat(request.getParameter("prize"));
		 
		 town=request.getParameter("town");
		 building=request.getParameter("building");
		 BuildingNo=request.getParameter("buildingNo");
		 
		 Part image=request.getPart("picture");
		 InputStream input= image.getInputStream();

		 Action=request.getParameter("action");
		 
		 //"*********************************html code
		 out.println("<html>");
		 out.println("<head>");
		 out.println("</head>");
		 out.println("<body>");
		//********inside if 
		 	if(username==null) 
		 	{
		 		out.println("<p>please login and try again</p>");
		 		 out.println("<br><a href=\"MainMenu.html\">Menu</a>");
		 		 
		 	}
		 		 //********end of inside if
        
		 	else {
		 
		//******************************* registering service*****************************
		 if(Action.equalsIgnoreCase("Register")) 
		 {
			 			
		 try {
					 
	       information.RegistrationService(username, name, service, prize,Description,  town,building, BuildingNo,input);
	       out.println("<p>congradulation u are officially offering service</p>");
	       out.println("<a href=\"MainMenu.html\">Menu</a>");
	     //*****************HTML CODE NEEDED
				     }//end of try
		 catch(SQLIntegrityConstraintViolationException a)
		 {
			 out.println("<p>Already Registered A Service</p>");
			 out.println("<br><a href=\"MainMenu.html\">Menu</a>");
		 }//end of second catch
		  catch(MysqlDataTruncation e) 
		   {
			   out.println("<p>prince invalid</p>");
			   out.println("<a href=\"MainMenu.html\">HOME</a>");
		   }//end of catch
	//**********************************************************
	catch (SQLException e) 
	 {
			out.println("<p>unexpected error try again</p>");
			out.println("<a href=\"MainMenu.html\">HOME</a>");
	 }//end of catch
	catch (NumberFormatException e) 
	 {
			out.println("<p>failed please input correct values note\n number where they are required</p>");
			out.println("<a href=\"MainMenu.html\">HOME</a>");
	 }//end of catch
		 }//end of if
		 else 
		 {
			 out.println("<h2>Sorry could not register you</h2>");
		 }
	} //end of main else
		 	out.println("</body>");
		 	out.println("</html>");
		
	}
	//end of do post method
}
