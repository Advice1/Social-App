package Update;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import design.Database;


@WebServlet("/UpdatePrice_Picture")
public class UpdatePrice_Picture extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Float price;
	private String Action;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//***********************************getting the username from the user when login in
				HttpSession session=request.getSession();
				String uNumber=(String) session.getAttribute("name");
		//*************************************************
				PrintWriter out=response.getWriter();
				Database information=new Database();  //object type
		
		 price=Float.parseFloat(request.getParameter("prize"));
		 Action=request.getParameter("action");
		 
		 //****************************************html code
		 out.println("<html>");
		 out.println("<head>");
		 out.println("</head>");
		 out.println("<body>");
		 
		 
		 if(Action.equalsIgnoreCase("update")) 
		 {
			 try {
				 
				 information.UpdatePrice(price, uNumber);
				 out.print("<p>price Succefully Updated</p>");
				 out.println("<br><a href=\"./UpdatingServiceDetails\">Menu</a>");
			     }
			 catch (SQLException e) //need more catch if a string is entered
			    {
				out.println("<p>something went wrong</p>");
				out.println("<br><a href=\"./UpdatingServiceDetails\">Menu</a>");
				e.printStackTrace();
			    }
		 }
		 else
		 {
			    out.println("<p>sorry couldnt update</p>");
		        out.println("<br><a href=\"./UpdatingServiceDetails\">Menu</a>");
		 }
		 
		 
		 out.println("</body>");
		 out.println("</html>");
		 
	}//end of dopost method

}
