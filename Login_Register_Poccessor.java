package design;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@javax.servlet.annotation.MultipartConfig
@WebServlet("/Login_Register_Poccessor")
public class Login_Register_Poccessor extends HttpServlet {
	private String name;
	private String surname;
	private String password;
	private String StudentN;
	private String Department;
	private String report;
	private String facebook;
	private String Instagram;
	private String tweeter;
	private String Action;
	private String Image;
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out =response.getWriter();
		Database inform=new Database();  //object type
		
		//processing form data
		 name=request.getParameter("name");
		 surname=request.getParameter("surname");
		 password=request.getParameter("password");
		 StudentN=request.getParameter("STUDENT_NUMBER");
		 Department=request.getParameter("deparment");
		 facebook=request.getParameter("facebook");
		 Instagram=request.getParameter("instagram");
		 tweeter=request.getParameter("tweeter");
		 report=Case();
		 
		 Image=request.getParameter("picture");
		 System.out.print(Image);

		 
		 
		
		 Action=request.getParameter("action");
		 //register
		    out.println("<!DOCTYPE html>");
		    out.println("<head>");
		    out.println("<meta charset=\"utf-8\">");
		    out.println("<title></title>");
		    out.println("<link rel=\"stylesheet\" href=\"MainManu.css\">");
		    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		    out.println("</head>");
		    out.println("<body>");
		    //validating userInputs
		 if(name.length()>=40)
		 {
			 out.println("<h3>Name is too long</h3>");
			 out.println("<a href=\"WelcomePage.html\">home Here</a>");
		 }
		 else if(surname.length()>=30)
		 {
			 out.println("<h3>Surname is too long</h3>");
			 out.println("<a href=\"WelcomePage.html\">home Here</a>");
		 }
		 else if(StudentN.length()!=9)
		 {
			 out.println("<h3>Please Enter A Correct Student Number</h3>");
			 out.println("<a href=\"WelcomePage.html\">home Here</a>");
		 }
		 else if(StudentN.endsWith("2")==false|StudentN.startsWith("2")==false)
		 {
			 out.println("<h3>please provide a valid student number</h3>");
			 out.println("<a href=\"WelcomePage.html\">home Here</a>");
		 }
		 else if(facebook.length()>=30|Instagram.length()>=30|tweeter.length()>=30)
		 {
			 out.println("<h3>Social Media fields is too long</h3>");
			 out.println("<a href=\"WelcomePage.html\">home Here</a>");
		 }
		 
		 
		 else { 
		 if(Action.equalsIgnoreCase("Register")) 
		 {
			
			 Part picture=request.getPart("picture");
			
			 if(picture.getSize()<=0)      //default image
			 {
				 out.println("<h3>Social Media fields is too long</h3>"+Image);
					 try {
						
						ServletContext context = getServletContext(); // Inherited from HttpServlet.
						InputStream DefaultInput = context.getResourceAsStream("manu.png"); //default image if one is not selected
						 
							inform.insert_data(name, surname, Department, password, StudentN, DefaultInput, facebook, tweeter, Instagram, report);
							    out.println("<h3>Registration Successful</h3>");   
							  //++++++++++++++++++++++++++ end social services
							    out.println("<a href=\"Login.html\">Login Here</a>");
							    out.println("</ul></div>");
							    //*****************************end list*****************************
						     }//end of try
					    catch(NullPointerException a)
					     {
					    	 out.println("<p> Sorry Image not found</p>");
					    	 a.printStackTrace();
					     }
					 //end of first
					 catch(SQLIntegrityConstraintViolationException a)
					 {
						 out.println("<h3>Student Number  Already Exists</h3>");
						 out.println("<a href=\"WelcomePage.html\">home Here</a>");
						 a.printStackTrace();
					 }//end of second catch
						 catch (SQLException e) 
						    {
							out.println("<h3>unexpected error try again</h3>");
							out.println("<a href=\"WelcomePage.html\">home Here</a>");
							e.printStackTrace();
						    }
			 }
			 //if image is selected
			 else
			 {
			 try {
				 
				 InputStream input= picture.getInputStream();
				inform.insert_data(name, surname, Department, password, StudentN, input, facebook, tweeter, Instagram, report);
				
				    out.println("<h1>Registration Successful</h1>");   
				  //++++++++++++++++++++++++++ end social services
				    out.println("<a href=\"./Login.html\">Login Here</a>");
				    //*****************************end list*****************************
			     }
			 catch(SQLIntegrityConstraintViolationException a)
			 {
				 out.println("<h3>Student Number  Already Exists</h3>");
				 out.println("<a href=\"WelcomePage.html\">home Here</a>");
			 }//end of first catch
			 catch (SQLException e) 
			    {
				out.println("<h3>unexpected error try again</h3>");
				out.println("<a href=\"WelcomePage.html\">home Here</a>");
			    }
			 }//end of inner else
		   }//end of inner if
		 else 
		 {
			 out.println("<h1>Sorry could not register you<br>try again</h1>");
		 }//end of inner else
		}//end of outer else
		 out.println("</body>");
		 out.println("</html>");
		
	}
	//*****************************validation********************
		public String Case()
		{
			int a=0;
			String report="";
			return report+"\n"+a++;
		}	
		//****************************
}
