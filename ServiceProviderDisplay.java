package orderStoreroom;

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
 * Servlet implementation class ServiceProviderDisplay
 */
@WebServlet("/ServiceProviderDisplay")
public class ServiceProviderDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   PrintWriter out =resp.getWriter();
		   
		   O_Storeroom manage_Data=new O_Storeroom();   //creating an object
		   List<O_Storeroom> list=(ArrayList<O_Storeroom>)req.getAttribute("listing"); //creating a list of O_Storeroom class
		   //***********************************getting the student_id from the user when login in
		 //****************************************html code************************************************
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Friends</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"OrderViewStyle.css\">");
			
			//re editing style sheet
			out.println("<style>");
			
			out.println("table{background:white;}");
			out.println(".form_display\r\n" + 
					"{\r\n" + 
					"position:absolute;\r\n" + 
					"width:200px;\r\n" + 
					"height:150px;\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"}");
			
			out.println("</style>");
			//*************************************end of style 
			out.println("</head>");
			out.println("<body>");
			//check if the lis is empty
			if(list.isEmpty())
			{
				out.println("<nav>");
				out.println("<a href=\"./UpdatingServiceDetails\">Back</a>"); //
				out.println("</nav>");
				out.println("<h2 Style=\"background:red\">NO Orders Available</h2>");}
			//
			else 
			{	
			out.println("<nav>");
			out.println("<a href=\"./UpdatingServiceDetails\">Back</a>"); //
			out.println("</nav>");
			
			out.println("");
			out.println("<table>");
			
			for(int n=0;n<list.size();n++){
				
				manage_Data = list.get(n);
				
				String p_name=manage_Data.getProduct_Name();
				String status=manage_Data.getStatus();
				String client=manage_Data.getClient();
				String contact=manage_Data.getContactNo();
				String contactOption=manage_Data.getContact_Option();
				int OrderNo=manage_Data.getItem_No();
		
				out.println("<tr>");
		
				out.println("<td>");
				out.println("<h4>Order No</h4>");
				out.println(OrderNo);
				out.println("</td>");
				//__________________________________________________________
				out.println("<td>");
				out.println("<h4>Client</h4>");
				out.println(client);
				out.println("</td>");
				//_________________________________________________________
				//__________________________________________________________
				out.println("<td>");
				out.println("<h4>Name</h4>");
				out.println(p_name);
				out.println("</td>");
				//_________________________________________________________
				//__________________________________________________________
				out.println("<td>");
				out.println("<h4>Cell No</h4>");
				out.println(contact);
				out.println("</td>");
				//_________________________________________________________
				out.println("<td>");
				out.println("<h4>Contact Option</h4>");
				out.println(contactOption);
				out.println("</td>");
				//_________________________________________________________
				
				out.println("<td>");
				out.println("<h4>Status</h4>");
				out.println(status);
				out.println("</td>");
				out.println("</tr>");
               //_________________________________________________________
				
				}
				//end of LOOP statement
			out.println("</table>"); //*****************************order section 
			
		    out.println("<button class=\"btn\" onclick=\"toggleOrder()\">Manage</button>");
			}//end of else
		    
		    out.println("<div class=\"overlay\">");
		    
		    out.println("<div class=\"form_display\">");
		    out.println("<div class=\"form_body\">");
		    
		    out.println("<form action=\"Update_n_Delete.jsp\">");
		    
		    out.println("<p>Order No</p>");
		    out.println("<input type=\"text\" name=\"item_No\"  required pattern=\"[0-9]+\">");
		    out.println("");
		    
		    out.println("<p>Status</p>");
		    out.println("<input type=\"text\" name=\"Status\"  >");
		    
		    out.println("<input type=\"submit\" value=\"update\" name=\"action\">");
		    out.println("<input type=\"submit\" value=\"Remove\" name=\"action\"><br>");
		    
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
		   }//******************************************end of service mathod
}
//***************************************end of class