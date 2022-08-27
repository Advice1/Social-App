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
import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class Staff_LoginProccerssor
 */
@WebServlet("/Staff_LoginProccerssor")
public class Staff_LoginProccerssor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//instance variable 
	private String usrname="root";
	private String pasword="Nxumalo#1";
	private String url="jdbc:mysql://127.0.0.1:3306/login";
	private String StaffNo;
	private String passwod;
	//intafaces
	private Connection connect;
	private Statement state;
	private ResultSet set;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		    PrintWriter out =response.getWriter();
		    
		    StaffNo=request.getParameter("StaffNo"); 
		    passwod=request.getParameter("password");
		    
		    //------------------------html code
		    out.println("<!DOCTYPE html>");
		    out.println("html");
		    out.println("<head>");
		    out.println("<meta charset=\"utf-8\">");
		    out.println("<title></title>");
		    out.println("<link rel=\"stylesheet\" href=\"MainManu.css\">");
		    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		    out.println("</head>");
		    
			
				try {
					Establish_connection();
					state=(Statement) connect.createStatement(); 
				    set=state.executeQuery("select * from  Staff_Admin where Staff_id='"+StaffNo+"' and password='"+passwod+"'");//execute query and validate the inputs
				    //statements to validate and give output if these a match
				    if(set.next())
				    {
				    	//***********************setting staff id number to a session
				    HttpSession session=request.getSession();
				    session.setAttribute("Stuff_Id", StaffNo);
				       // html page
				    out.println("<body>");
				   
				    out.println("<div class=\"Main_Manu\">");
				    
				    out.println("<ul class=\"TOP_NAV_BAR\" >\r\n" + 
				    		  
				    		"    <li><a href=\"./StaffProductDetails\">STORE</a> </li>\r\n" + 
				    		"</ul>");
				   
				    out.println("<h1>Menu</h1>");
				    out.println("<div class=\"border\"></div>");
				    //*****************************list*****************************
				    out.println("<ul class=\"Manu_List\" >");
				    
				    out.println("<li ><a href=\"WelcomePage.html\">HOME</a></li>");
				    out.println("<li><a href=\"CafeteriaAdd.html\">ADD MORE</a> </li>");			 
			   out.println("<li> <a href=\"./StaffProductDetails\">STORE</a>  </li>");
				    
				  //++++++++++++++++++++++++++end of professional services
				    out.println("</ul></div>");
				    //*****************************end list*****************************
				    //********password update section
				    out.println("<button class=\"btn\" onclick=\"toggleLogin()\">Password</button>");
				    
				    out.println("<div class=\"overlay\">");
				   
				    out.println("<div class=\"login\">");
				    
				    out.println("<div class=\"header\">");
				    out.println("<h3>update Password</h3>");
				    out.println("</div>");
				    
				    out.println("<div class=\"body\">");
				    out.println("<form action=\"UpdatePassword.jsp\">");  //processed by jsp page
				    out.println("<p>password</p> ");
				    out.println("<input type=\"password\" placeholder=\"upadate here\" name=\"password\"><br>");
				    out.println("<input type=\"submit\" value=\"update\" ><br>");
				    out.println("</form>");
				    out.println("</div>");
				    
				    out.println("</div>");
				    out.println("</div>");
				    
				    out.println("</body>");
				   // javascript code
				    out.println("<script>");
				    out.println("function toggleLogin(){document.querySelector(\".overlay\").classList.toggle(\"open\");}");
				    out.println("</script>");
				    
				   
				    }
				    //end of if
				    else {
				    	out.println("\nsorry wrong stuff number\t"+StaffNo+"\t or password\t"+passwod+" ");
				    	out.println("<br><a href=\"WelcomePage.html\">Home</a>");
				        }
					
				    } //end of try 
				catch(MysqlDataTruncation e) 
				   {
					   out.println("details invalid");
					   out.println("<a href=\"WelcomePage.html\">HOME</a>");
				   }
				catch(MySQLIntegrityConstraintViolationException e) 
				   {
					   out.println("do not exists");
					   out.println("<a href=\"WelcomePage.html\">HOME</a>");
				   }//end of first catch
				catch (SQLException e1)
				{ 
					out.println("Unexpected error try again");
					out.println("<a href=\"WelcomePage.html\">HOME</a>");
				}//end of second catch
				 catch(Exception e) 
				   {
					   out.println("Check your details and try again");
					   out.println("<a href=\"WelcomePage.html\">HOME</a>");
				   }//end of third catch
				
				 out.println("</html>");
				    //end of html page
	}
	//****************************************establishing connection*******************************************	
		public void Establish_connection() throws SQLException 
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connect=(Connection) DriverManager.getConnection(url, usrname, pasword);
			    } 
			catch (ClassNotFoundException e)
			    {
				e.printStackTrace();
			    }
		}
		//****************************************end of establishing connection*******************************************

}
