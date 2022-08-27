package design;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@WebServlet("/Login_Proccessor")
public class Login_Proccessor extends HttpServlet {
	
	//instance variable 
			private String usrname="root";
			private String pasword="Nxumalo#1";
			private String url="jdbc:mysql://127.0.0.1:3306/login";
			private Connection connect;
			private Statement state;
			private ResultSet set;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		  PrintWriter out =response.getWriter();
		  //****processing form data
		 String password=request.getParameter("password");
		 String StudentN=request.getParameter("STUDENT_NUMBER");
		 
		 // html page
		    out.println("<!DOCTYPE html>");
		    out.println("<head>");
		    out.println("<meta charset=\"utf-8\">");
		    out.println("<title>MAIN MANU</title>");
		    out.println("<link rel=\"stylesheet\" href=\"MainManu.css\">");
		    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		    out.println("</head>");
		 
		try {
			Establish_connection();
		    } 
		catch (SQLException e1)
		{
			 out.println("<p>unexpected error</p>");
			 out.println("<br><a href=\"WelcomePage.html\">Home</a>");	
			e1.printStackTrace();
		}

	//
	try {
	state=(Statement) connect.createStatement(); 
    set=state.executeQuery("select * from registration2 where Student_number='"+StudentN+"' and password='"+password+"'");//execute query and validate the inputs
    //statements to validate and give output if these a match
    if(set.next())
    {
    	//***********************setting student number to a session
    HttpSession session=request.getSession();
    session.setAttribute("name", StudentN);
      
    out.println("<body>");
    out.println("<div class=\"Main_Manu\">");
    
    out.println("<ul class=\"TOP_NAV_BAR\" >\r\n" + 
    		"    <li ><a href=\"WelcomePage.html\">Home</a></li>\r\n" + 
    		"  <li><a href=\"./UpdateDetails\">PROFILE</a> </li>\r\n" +
    		"</ul>");
    
    out.println("<h1>Menu</h1>");
    out.println("<div class=\"border\"></div>");
    //*****************************list*****************************
    out.println("<ul class=\"Manu_List\" >");
    
    out.println(
    	"    <li><a href=\"ProfessionalServiceReg.html\">Register Service</a> </li>");
  //++++++++++++++++++++++++++start of professional services
    out.println("<li><a href=\"#\">Professional Service</a>");
    out.println("<div class=\"Prof_list\">");
    out.println("<ul>\r\n" + 
    		"		<li ><a href=\"./AdminServiceDetails\">CAFETERIA</a></li>\r\n" + 
    		"		 <li><a href=\"#\">LECTURERS</a> </li>\r\n" + 
    		"	    </ul>");
    out.println(" </div>\r\n" + 
    		"   </li>");
    //
  //++++++++++++++++++++++++++end of professional services
    //++++++++++++++++++++++++++social services
    out.println("<li><a href=\"#\">Social Services</a>");
    out.println("<div class=\"Prof_list\">");
    out.println("<ul>\r\n" + 
    		"		<li ><a href=\"./ImageView\">NETWORKING</a></li>\r\n" + 
    		"            	 <li><a href=\"./ProcessingDetails\">MARKET</a> </li>\r\n" + 
    		"		 <li><a href=\"#\">GAMES</a> </li>\r\n" + 
    		"	    </ul>");
    out.println("</div></li>");
  //++++++++++++++++++++++++++ end social services
    out.println("<li><a href=\"#\">About</a></li>");
    out.println("</ul></div>");
    //*****************************end list*****************************

    out.println("</body>");
   
    }
    else
    {
    	out.println("sorry wrong student number\t"+StudentN+"\t or password\t"+password+" ");
    	out.println("<br><a href=\"WelcomePage.html\">Home</a>");	
     }
	}//end of try
   catch(Exception e) 
   {
	   out.println("Something went wrong Login Again");
	   out.println("<br><a href=\"WelcomePage.html\">Home</a>");
    }//end of catch
	
	 out.println("</html>");
}
//****************************************establishing connection*******************************************	
	public void Establish_connection() throws SQLException 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect=(Connection) DriverManager.getConnection(url, usrname, pasword);
		    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		    }
	}
	//****************************************end of establishing connection*******************************************
}
