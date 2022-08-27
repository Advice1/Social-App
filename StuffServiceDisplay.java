package cafeteriaService;

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
 * Servlet implementation class StuffServiceDisplay
 */
@WebServlet("/StuffServiceDisplay")
public class StuffServiceDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		if(list.isEmpty())
		{
			out.println("<nav>");
			out.println("<a href=\"StuffMainMenu.html\">MENU</a>"
					+ "</nav>");
			out.println("<h2 style=\"background:red\">Nothing to display not registered</h2>");
		}//end of if
		    
		else 
		{	
		
	    for(int i=0;i<list.size();i++){
			//getting data from the list
			category = list.get(i);
			String StaffId=category.getUsername();
			String name=category.getName();
			String discription=category.getDescription();
			Float price=category.getPrize();
			String town=category.getTown();
			String building=category.getBuilding();
		    String buildingNo=category.getBuildingNo();
		    int ItemNo=category.getItemNumber();
		    
		    out.println("<nav>");
		    out.println("<a href=\"StuffMainMenu.html\">Menu</a>");
		    out.println("<a href=\"./StaffProductDetails\">FOOD</a>");
			out.println("<a href=\"updateCafeproduct.html\">MANAGE</a>");
			out.println("<a href=\"ServiceRemoval.html\">REMOVE</a>");
			out.println("<a href=\"./Admin_Manages_Orders_Details\"> ORDER </a>");
			out.println("</nav>");
			
			out.println("<table>");
		    
			out.println("<tr>");
			
			out.println("<td>");
			out.println("<h3>Item NO <b>"+ItemNo+"</b><br></h3>");
			out.println("Name <b>"+name+"</b><br>");
			out.println("<img src=\"./ProductImageProccesor?Name="+name+" \" width=\"880px\" height=\"400px\">");
			
			out.println("<h3>Details</h3>");
			out.println("<p>price <b>R"+price+"</b> Type <b>Cafeteria</b> Name <b>"+name+"</b></p>");//change needed
			out.println("<h3 >Location</h3>");
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
			 out.println("</table>");
		    }//end of else
			}
			//end of LOOP statement
		
		 out.println("</body>");
		 out.println("</html>");
		 //**************************end of html code   
}
//end of method	
}
//end of class
