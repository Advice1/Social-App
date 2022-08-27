package Update;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import design.Database;

/**
 * Servlet implementation class UpdateServiceDetailsUser
 */
@MultipartConfig
@WebServlet("/UpdateServiceDetailsUser")
public class UpdateServiceDetailsUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String service;
	private String Description;

	private String town;
	private String building;
	private String BuildingNo;
	
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =response.getWriter();
		 Database information=new Database();  //object type of database class
		 
		//***********************************getting the username from the user when login in
        HttpSession session=request.getSession();
		 String username=(String)session.getAttribute("name");
		 //@@@@@@@@@@@@checking if the username is null
		//************************************scanning user inputs**********************8 
		 name=request.getParameter("name");
		 service=request.getParameter("service");
		 Description=request.getParameter("description");
		
		 town=request.getParameter("town");
		 building=request.getParameter("building");
		 BuildingNo=request.getParameter("buildingNo");
		 
		 Part image=request.getPart("picture");
		 InputStream input= image.getInputStream();
		 
		//"*********************************html code
		 out.println("<html>");
		 out.println("<head>");
		 out.println("</head>");
		 out.println("<body>");
		 
		      //********inside if 
		 	if(username==null) 
		 	{
		 		out.println("<h2>please login and try again</h2>");
		 	}
		 		 //********end of inside if
		 	 //
			 else if(username!=null)
			 {
				 try {
					information.updateServiceDetails_pic(name, service, Description, town, building, BuildingNo,input,username);
					out.println("<p>successfully updated</p>");
					out.println("<br><a href=\"./UpdatingServiceDetails\">Back</a>"); 
				    }
				 catch (SQLException e)
				{
					out.println("<p>something went wrong try again</p>");
					out.println("<br><a href=\"./UpdatingServiceDetails\">Back</a>");
				}
			 }
		 	//end of else if
			 else 
			 {
				 out.println("<p>something went wrong</p>");
				 out.println("<br><a href=\"./UpdatingServiceDetails\">Back</a>");
			 }
		 	//end of else
		 	out.println("</body>");
		 	out.println("</html>");
			
	}//end of method

}//end of class
