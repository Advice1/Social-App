package ProffesionalService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfessionalServiceDisplay
 */
@WebServlet("/ProfessionalServiceDisplay")
public class ProfessionalServiceDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   PrintWriter out =resp.getWriter();
		   StorageProfessionalService category = new StorageProfessionalService();//object of StorageProfessionalService class
		@SuppressWarnings("unchecked")
		List<StorageProfessionalService> list=(ArrayList<StorageProfessionalService>)req.getAttribute("listing"); //creating a list of ProcessingDetails class

		//****************************************html code************************************************
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Market Place</title>");
				out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"displaystyleProfessional.css\">");
				out.println("</head>");
				
				out.println("<body>");
				
				out.println("<nav>");
				out.println("<a href=\"MainMenu.html\">Menu</a>"); //
				out.println("<a href=\"#\">Logout</a>");
				
				out.println("</nav>");
				
				out.println("");
				out.println("<table>");
				//check if the lis is empty
	if(list.isEmpty())
	{
		out.println("Not offering any service");
	}		
		else 
		{	
		for(int n=0;n<list.size();n++){
			//getting data
			category = list.get(n);
			
			int itemNo=category.getItemNumber();
			String username=category.getUsername();
			String name=category.getName();
			String type=category.getService();
			String discription=category.getDescription();
			Float price=category.getPrize();
			String town=category.getTown();
			String building=category.getBuilding();
		    String buildingNo=category.getBuildingNo();
			
			out.println("<tr>");
			
			out.println("<td>");
	
			out.println("<h3>Location</h3>");
			out.println("<p>Town\t<bold>"+town+"<br></bold>\tBuilding\t<bold>"+building+"<br></bold>\tBuilding No\t<bolds>"+buildingNo+"</bold></p>");//change needed
			
			out.println("<h3>Item Number</h3>");
			out.println("<p style=\"color:red\"><bold>Number</bold>\t<b>"+itemNo+"</b></p>");//change needed

			out.println("</td>");
			
			out.println("<td>");
			out.print("<img src=\"./Prof_ImageProcessor?username="+username+" \" width=\"100\" height=\"100\">");
			//details needed
			out.println("<h3>Details</h3>");
			out.println("<p>Service Provider\t<bold>"+name+"</bold>\tService\t<bold>"+type+"</bold>\tPRICE\t<bold>R"+price+"</blold></p>");//change needed
			
			out.println("<a href=\"https:/www.instagram.com/\">\"ORDER\"</a>");
			out.println("<h3>Description</h3>");
			out.println(discription);
			out.println("</td>");
			
			out.println("</tr>");
			}
			//end of LOOP statement
		}//end of else	
			
	    out.println("</table>");
	    //*****************************order section 
	    out.println("<button class=\"btn\" onclick=\"toggleOrder()\">REQUEST</button>");
	    
	    out.println("<div class=\"overlay\">");
	    
	    out.println("<div class=\"form_display\">");
	    out.println("<div class=\"form_body\">");
	    
	    out.println("<h3>REQUEST SERRVICE</h3>");
	    
	    out.println("<form action=\"Order_Proccessor.jsp\">");
	    
	    out.println("<p>Instructions</p>");
	    out.println("<textarea name=\"Instruct\" Placeholder=\"Guidlines\" ></textarea>");
	    
	    out.println("<p>Service</p>");
	    out.println("<input type=\"text\" name=\"P_Name\" required pattern=\"[A-Za-z]+\">");
	   
	    out.println("<p>Item Number</p>");
	    out.println("<input type=\"text\" name=\"I_Number\" Placeholder=\"Number\" required pattern=\"[0-9]*\"> ");
	    
	    out.println("<p>Contact Details</p>");
	    out.println("Cell No:<input type=\"text\" name=\"Cell_No\"Placeholder=\"10 Digits\" required pattern=\"[0-9]{10}\">");
	   
	    out.println("<br>");
	    out.println("<input type=\"submit\" value=\"ORDER\"><br>");
	    
	    out.println("</form>");
	    out.println("</div>");
	    
	    out.println("</div>");
	    out.println("</div>");
	    
	    out.println("</body>");
	    //script running a function  openning the form
	    out.println("<script>");
	    out.println("function toggleOrder(){document.querySelector(\".overlay\").classList.toggle(\"open\");}");
	    out.println("</script>");
	    
	    out.println("</html>");
	    //end of html code

}//end of service method
}//end of class
