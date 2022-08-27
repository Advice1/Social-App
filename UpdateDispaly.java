package multiImageRetrival;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class UpdateDispaly
 */
@WebServlet("/UpdateDispaly")
public class UpdateDispaly extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   PrintWriter out =resp.getWriter();
		   Student category = new Student();//object of Student class

		 //***********************************getting the student_id from the user when login in
		   HttpSession session=req.getSession();
		   String StudentId=(String)session.getAttribute("name");
		   //************************************************************************************
		List<Student> list=(ArrayList<Student>)req.getAttribute("list"); //creating a list of Student class
		
		//*************************************html code
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Profile</title>");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"UpdateDisplayProfile.css\">");
		out.println("");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<nav>");
		out.println("<a href=\"MainMenu.html\">Main Manu</a>");
		out.println("<a href=\"./ImageView\">NETWORK</a>");
		out.println("<a href=\"./UpdatingServiceDetails\">BUSINESS</a>");
		out.println("</nav>");
		
		out.println("<table ");
		
	    for(int n=0;n<list.size();n++){
			
			category = list.get(n);
//			getting data from the StorageImage class
			String name =  category.getName();
			String surname=category.getSurname();
			String student =category.getStdNumber();
			String department=category.getDepartment();
			String facebook=category.getFacebook();
			String instagram=category.getInstagram();
			String tweeter=category.getTweeter();
			
			out.println("<tr>");
			//********************************Display personal information
			out.println("<td>");
			out.println(name);
			out.println("<br>");
			out.println(surname);
			out.println("<br>");
			out.println(student);
			
			out.println("</td>");
			
			out.println("<td>");
			out.println("<img src=\"./UpdateImageProccessor?Student_Number="+student+" \" width=\"100\" height=\"100\">");
			
			//********************************form for updating a picture
			out.println("<form action=\"./UpdateProfilePicture\" method=\"post\" enctype=\"multipart/form-data\">" );
			out.println("<input type=\"file\" name=\"pic\" value=\"upload\"  accept=\"pictures/*\"  required>");
			out.println("<input type=\"submit\" value=\"update\">");
			out.println("</form>");
			
			//********************************Display social media accounts
			out.println("<h3>Social Media Accounts</h3>");
			
			out.println("Follow on Facebook# <bold>"+facebook+"</bold>");
			out.println("<br>");
			out.println("Follow on Tweeter#  <bold>"+instagram+"</bold>");
			out.println("<br>");
			out.println("Follow on Instagram#<bold>"+tweeter+"</bold>");
			
            out.println("<h3>Department</h3>");
			out.println("#Department of <bold>"+department+"</bold>");
			out.println("<br>");       
			
			//********************************Services offered
			out.println("<h3>Service Requested</h3>");
			
			out.println(StudentId);
			out.println("<br>");
			out.println("Student service<a href=\"./Order_Details\">MY Orders</a><br>");
			out.println("Cafeteria<a href=\"./View_Order_Details\">MY Orders</a>");
			
			out.println("</td>");
			out.println("</tr>");
			//********************************Display messages available
			out.println("<tr>");
			out.println("<td>FOLLOWERS</td>");
			out.println("<td><a href=\"#\">CHECK</a> </td>");
			out.println("</tr>");
	
		}//end of if
	    out.println("</table>");
	    out.println("</body>");
		out.println("</html>");
		
}

	
}
