package ProffesionalService;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mysql.jdbc.MysqlDataTruncation;
import administration.Staff_Database;


/**
 * Servlet implementation class StaffService_Registration
 */
@javax.servlet.annotation.MultipartConfig
@WebServlet("/StaffService_Registration")
public class StaffService_Registration extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String Description;
	private Float prize;
	private String town;
	private String building;
	private String BuildingNo;
	private String Action;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//
		PrintWriter out =response.getWriter();
		 Staff_Database information=new  Staff_Database();  //object type of staff database class
		//***********************************getting the username from the user when login in
        HttpSession session=request.getSession();
		 String StaffId=(String)session.getAttribute("Stuff_Id");
		 //********checking if the username is null
		//************************************scanning user inputs**********************8
		 name=request.getParameter("name");
		 Description=request.getParameter("description");
		 prize=Float.parseFloat(request.getParameter("prize"));
		 
		 town=request.getParameter("town");
		 building=request.getParameter("building");
		 BuildingNo=request.getParameter("buildingNo");
		 
		    //**************PROCESSING THE FILE 
			Part image=request.getPart("picture");
			InputStream input= image.getInputStream();
			//****************database object
		 
		 
		 Action=request.getParameter("action");
		//****************************************html code************************************************
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Main Manu</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"displayProfilestyleProfessional.css\">");
			out.println("</head>");
			
			out.println("<body>");
			
			out.println("<nav>");
			out.println("<a href=\"StuffMainMenu.html\">HOME</a>"); 
			out.println("<a href=\"./StaffProductDetails\">Display</a>");
			
			out.println("</nav>");
			
			//*************************************************
			if(name.length()>=30)
			{
				out.println("<h2 style=\"background:blue\">Product Name Too Long</h2>");
			}
			//********************************//*************************************************
			//*************************************************
			else if(Description.length()>=150)
			{
				out.println("<h2 style=\"background:blue\">Desription exceeds the maximum 150 words</h2>");
			}
			//********************************//*************************************************
			
			else if(town.length()>=40|building.length()>=40|BuildingNo.length()>=50)
			{
				out.println("<h2 style=\"background:blue\">Name of Loction is too long</h2>");
				
			}
			//********************************
		//********inside if 
			else if(StaffId==null) 
		 	{
		 		out.println("<h2 style=\"background:blue\">please login and try again</h2>");
		 	}
		 		 //********end of inside if
       
		 	else {
		 
		//******************************* Adding service*****************************
		 if(Action.equalsIgnoreCase("ADD")) 
		 {
			 			
		 try {
					 
	       information.Food_Service( name, StaffId, prize,  town,building, BuildingNo,Description,input);
	      
	       out.println("<h2 style=\"background:blue\">congradulation u are officially offering service</h2>");
			}
		//**********************************************************
		 catch(NullPointerException a)
	     {
	    	 out.println("<p> Sorry Image not found</p>");
	    	 a.printStackTrace();
	     }
	      catch(MysqlDataTruncation e) 
			   {
				   out.println("details invalid");
			
			   }//end of catch

	//**********************************************************
			   catch (NumberFormatException e) 
			     {
						out.println("<h2 style=\"background:blue\">provide Correct details</h2>");
				 }//end of catch
	//**********************************************************
		 
	    catch (SQLException e) 
		    {
					out.println("<h3 style=\"background:blue\">Unexpected error try again </h3>");
		
			 }//end of catch
		 }//end of if
		 else 
		 	{
			 out.println("<h2>Sorry could not Add Service</h2>");
		 	}
		} //end of main else
		 	out.println("</body>");
		 	out.println("</html>");
	}
	//*******************************************************end of post*********************************
}
