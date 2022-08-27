package Admin_Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ProffesionalService.StorageProfessionalService;

/**
 * Servlet implementation class AdminServiceDisplay
 */
@WebServlet("/AdminServiceDisplay")
public class AdminServiceDisplay extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	//
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   PrintWriter out =resp.getWriter();
		   StorageProfessionalService category = new StorageProfessionalService();//object of StorageProfessionalService class

			@SuppressWarnings("unchecked")
		   List<StorageProfessionalService> list=(ArrayList<StorageProfessionalService>)req.getAttribute("list"); //creating a list of staffserviceDetails class


		//****************************************html code************************************************
				out.println("<html>");
				out.println("<head>");
				out.println("<title>FOOD</title>");
				out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"StaffProfessionalaServUsers.css\">");
				out.println("</head>");
				
				out.println("<body>");
				
				out.println("<nav>");
				out.println("<a href=\"MainMenu.html\">Menu</a>"); //
				
				
				out.println("</nav>");
				
				out.println("<table>");
				
				
		
		if(list.isEmpty())
		{out.println("<h2>Nothing to display not registered</h2>");}
			    //*********************************end of if
			    
		else {	
		
	    for(int i=0;i<list.size();i++){
			
			
			//getting data from the list
			category = list.get(i);
			int itemNo=category.getItemNumber();
			String StaffId=category.getUsername();
			String name=category.getName();
			String discription=category.getDescription();
			Float price=category.getPrize();
			String town=category.getTown();
			String building=category.getBuilding();
		    String buildingNo=category.getBuildingNo();
			
			out.println("<tr>");
			
			out.println("<td>");
			out.println("Name <b>@"+name+"</b><br>");
			out.println("<p style=\"background:red;\">Item No <b>@"+itemNo+"</b></p>");
			out.println("<img src=\"./CAfeImageProcessor?Name="+name+" \" width=\"100px\" height=\"100px\">");
			out.println("<p style=\"background:red;\">..</p>");
			out.println("<h4>Details</h4>");
			out.println("<p>price <b>R"+price+"</b> Type <b>Cafeteria</b> Name <b>"+name+"</b></p>");//change needed
			out.println("<h4 >Location</h4>");
			out.println("<p>Town <b>"+town+"</b> Building <b>"+building+"</b> Building No <b>"+buildingNo+"</b></p>");
			
			out.println("<h3 >Description</h3>");
			out.println("<p>");
			out.println("<textarea>");
			out.println(discription);
			out.println(StaffId);
			out.println("</textarea>");
			out.println("</p>");
 
			out.println("</td>");
			out.println("</tr>");
		    }//end of else
			}
			//end of LOOP statement
		out.println("</table>");
		
	
		//END OF ELSE
		//*****************************order section 
	    out.println("<button class=\"btn\" onclick=\"toggleOrder()\"><marquee>ORDER HERE</marquee></button>");
	    
	    out.println("<div class=\"overlay\">");
	    
	    out.println("<div class=\"form_display\">");
	    out.println("<div class=\"form_body\">");
	    
	    out.println("<h3>REQUEST SERRVICE</h3>");
	    
	    out.println("<form action=\"Cafeteria_Order_Pros.jsp\">");
	    
	    out.println("<p>Specification</p>");
	    out.println("<textarea name=\"Instruct\" Placeholder=\"Any special instructions we should follow\" ></textarea>");
	    
	    out.println("<p>Product Name</p>");
	    out.println("<input type=\"text\" name=\"P_Name\" required  pattern=\"[A-Za-z]*\"> ");
	   
	    out.println("<p>Item number</p>");
	    out.println("<input type=\"text\" name=\"I_Number\" Placeholder=\"Number\" required  pattern=\"[0-9]*\">");
	    
	    out.println("<p>Contact Details</p>");
	    out.println("Cell No:<input type=\"text\" name=\"Cell_No\" Placeholder=\"10 Digits\" required  pattern=\"[0-9]{10}*\">");
	      
	    out.println("<br><input type=\"submit\" value=\"ORDER\">");
	    
	    out.println("</form>");
	    out.println("</div>");
	    
	    out.println("</div>");
	    out.println("</div>");
	    
		 out.println("</body>");
		 //script running a function  opening the form
		    out.println("<script>");
		    out.println("function toggleOrder(){document.querySelector(\".overlay\").classList.toggle(\"open\");}");
		    out.println("</script>");
		 
		 out.println("</html>");
		 //**************************end of html code   
}
	//
}
