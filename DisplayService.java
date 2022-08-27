package UpdatingProfessinalService;

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
 * Servlet implementation class DisplayService
 */
@WebServlet("/DisplayService")
public class DisplayService extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	StorageProfessionalService category = new StorageProfessionalService();//object of StorageProfessionalService class
	 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   PrintWriter out =resp.getWriter();
		
			@SuppressWarnings("unchecked")
		   List<StorageProfessionalService> list=(ArrayList<StorageProfessionalService>)req.getAttribute("list"); //creating a list of StorageProfessionalService class

			//****************************************html code************************************************
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>SERVICE OFFERED</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"displayProfilestyleProfessional.css\">");
			out.println("</head>");
			
			out.println("<body>");
			if(list.isEmpty())
			{
				out.println("<nav>");
			   out.println("<a href=\"./UpdateDetails\">Back</a>");
			   out.println("</nav>");
			
			out.println("<h2 style=\"background:red\">Nothing to display not registered</h2>");
			}
	 //*********************************end of if
			else
			{		
	    for(int i=0;i<list.size();i++){
			
			//getting data from the list
			category = list.get(i);
			String username=category.getUsername();
			String name=category.getName();
			String type=category.getService();
			String discription=category.getDescription();
			Float price=category.getPrize();
			String town=category.getTown();
			String building=category.getBuilding();
		    String buildingNo=category.getBuildingNo();
          			
		    out.println("<nav>");
			out.println("<a href=\"./UpdateDetails\">BACK</a>");
			out.println("<a href=\"./ServiceProviderManageDetails\">ORDERS </a>");
			out.println("<a href=\"UpdateService.html\">UPDATE</a>");
			out.println("</nav>");
			
			out.println("<table>");
		    
			out.println("<tr>");
			
			out.println("<td>");
			out.println("<img src=\"./ProductImageProcessor?username="+username+" \" width=\"100\" height=\"100\">");
			
			out.println("<h3>Details</h3>");
			out.println("<p>price <b>R"+price+"</b> Type <b>"+type+"</b> Name <b>"+name+"</b></p>");//change needed
			out.println("<h3 >Location</h3>");
			out.println("<p>Town <b>"+town+"</b> Building <b>"+building+"</b> Building No <b>"+buildingNo+"</b></p>");
			
			out.println("<h3 style=\"left:60%; top:40%; position:absolute;\">Description</h3>");
			out.println("<textarea style=\"left:60%; top:52%; position:absolute;\">");
			out.println(discription);
			out.println(username);
			out.println("</textarea>");
			
			out.println("</td>");
			out.println("</tr>");
			
            out.println("<tr>");
            out.println("<td>");
			out.println("<div class=\"login_dialogue\">");
			
			out.println("<form action=\"./UpdatePrice_Picture\" method=\"post\">");
			out.println("<p>Prize</p>");
			out.println("<input type=\"text\" name=\"prize\" required pattern=\"[+-]?([0-9]+[.])?[0-9]*\">");
			out.println("<input type=\"submit\" value=\"update\" name=\"action\"><br>");
			out.println("</form>");
			
			out.println("</div>");
			
			out.println("</td>");
			out.println("</tr>");
		    }//end of else
			}
			//end of LOOP statement
	
		 out.println("</table>");
		 out.println("</body>");
		 out.println("</html>");
		 //**************************end of html code   
}
	//end of method 
	
}
