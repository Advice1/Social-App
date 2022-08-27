package Update;


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

import administration.Staff_Database;


/**
 * Servlet implementation class StaffUdateService
 */
@javax.servlet.annotation.MultipartConfig
@WebServlet("/StaffUdateService")
public class StaffUdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String ItemNo;
	private String Description;
	private Float prize;
	private String town;
	private String building;
	private String BuildingNo;
	private String name;

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//
		PrintWriter out =response.getWriter();
		 Staff_Database updateServ=new  Staff_Database();  //object type of Staff_Database class
		 
		//***********************************getting the staff id from the seasion
        HttpSession session=request.getSession();
		 String StaffId=(String)session.getAttribute("Stuff_Id");
		//************************************scanning user inputs**********************8
		 ItemNo=request.getParameter("itemNo");
		 name=request.getParameter("name");
		 Description=request.getParameter("description");
		 prize=Float.parseFloat(request.getParameter("prize"));
		 
		 town=request.getParameter("town");
		 building=request.getParameter("building");
		 BuildingNo=request.getParameter("buildingNo");
		 
		 //**************PROCESSING THE FILE and storing in the database
			Part image=request.getPart("picture");
			InputStream input= image.getInputStream();

		//****************************************html code************************************************
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Update</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"displayProfilestyleProfessional.css\">");
			out.println("</head>");
			
			out.println("<body>");
			
			out.println("<nav>");
			out.println("<a href=\"#\">BACK</a>"); 
			out.println("<a href=\"./StaffProductDetails\">Display</a>");
			
			out.println("</nav>");
		
		//******** if 
		 	if(StaffId==null) 
		 	{
		 		out.println("<h2>please login and try again</h2>");
		 	}
		//********end of  if
		 	//******** if 
		 	else if(ItemNo.matches("[0-9]*")==false) 
		 	{
		 		out.println("<h2>PLEASE USE NUMBERS FOR Item No Section</h2>");
		 	}
		//********end of  if
   
		//******************************* Update Service*****************************
		 	else  if(StaffId!=null&&ItemNo!=null) 
		    {
			 			
		 try {
			
			updateServ.UpdateStaff_Service( name, prize,  town,building, BuildingNo,Description,input,StaffId,ItemNo);
	      
	       out.println("<h2>Updated Successfully</h2>");
	       }
		 catch(NullPointerException a)
	     {
	    	 out.println("<p> Sorry Image not found</p>");
	    	 a.printStackTrace();
	     }
			
	    catch (SQLException e) 
		     {
					out.println("Unexpected error try again");
			 }//end of catch
		 
		 }//end of else if
		
		 else 
		 	{
			 out.println("<h2>Sorry could not update Service</h2>");
		 	}
		 	 out.println("</body>");
			 out.println("</html>");
			 //**************************end of html code
	}
	//*******************************************************end of post********************************
}
//**********************end of class


