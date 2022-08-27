package orderStoreroom;


import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Order_Details_Display
 */
@WebServlet("/Order_Details_Display")
public class Order_Details_Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   PrintWriter out =resp.getWriter();
		   
		   O_Storeroom read_Data=new O_Storeroom();
		   List<O_Storeroom> list=(ArrayList<O_Storeroom>)req.getAttribute("listing"); //creating a list of  O_Storeroom class
		   //***********************************getting the student_id from the user when login in
		   
		 //****************************************html code************************************************
		    out.println("<html>");
			out.println("<head>");
			out.println("<title>Friends</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"OrderViewStyle.css\">");
			out.println("</head>");
			out.println("<body>");
			
			out.println("<nav>");
			out.println("<a href=\"./UpdateDetails\">Profile</a>"); //
			out.println("</nav>");
		 //check if the lis is empty
			if(list.isEmpty())
			{
				out.println("<h2 style=\"background:red\">You have Not Ordered anything</h2>");
			}
			//
			
			else 
			{	
			out.println("<table>");
			
			for(int n=0;n<list.size();n++)
			{
				read_Data = list.get(n);
				
				int itemNo=read_Data.getItem_No();
				String p_name=read_Data.getProduct_Name();
				String status=read_Data.getStatus();
				
				out.println("<tr>");
				
				out.println("<td>");
				out.println("<h3>Item Number</h3>");
				out.println("<p style=\"color:red\"><b>"+itemNo+"</b></p>");//change needed
				out.println("</td>");
				//__________________________________________________________
				out.println("<td>");
				out.println("<h3>Name</h3>");
				out.println(p_name);
				out.println("</td>");
				//_________________________________________________________
               
				//_________________________________________________________
				
				out.println("<td>");
				out.println("<h3>Status</h3>");
				out.println(status);
				out.println("</td>");
				out.println("</tr>");
				}
				//end of LOOP statement
			
			out.println("</table>"); //*****************************order section 
		    out.println("<button class=\"btn\" onclick=\"toggleOrder()\">Remove</button>");
		    
		    out.println("<div class=\"overlay\">");
		    
		    out.println("<div class=\"form_display\">");
		    out.println("<div class=\"form_body\">");
		 
		    out.println("<form action=\"Cancel_Order.jsp\">"); //different jsp page from the service provider
		    out.println("Item No");
		    out.println("<input type=\"text\" name=\"item_No\" required pattern=\"[0-9]+\">");
		    out.println("<input type=\"submit\" value=\"Remove\" name=\"action\"><br>");
		    out.println("</form>");
		    
		    out.println("</div>");
		    
		    out.println("</div>");
		    out.println("</div>");
			//
			}//end of else
			out.println("</body>");
			//script running a function  openning the form
		    out.println("<script>");
		    out.println("function toggleOrder(){document.querySelector(\".overlay\").classList.toggle(\"open\");}");
		    out.println("</script>");
			
		    out.println("</html>");
		    //end of html code			
		   }//******************************************end of service mathod
}
//*********end of class
