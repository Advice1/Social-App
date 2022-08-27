package Update;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import design.Database;

/**
 * Servlet implementation class UpdateProfilePicture
 */
@javax.servlet.annotation.MultipartConfig
@WebServlet("/UpdateProfilePicture")
public class UpdateProfilePicture extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//***********************************getting the username from the user when login in
		HttpSession session=request.getSession();
		String StudentNumber=(String) session.getAttribute("name");
		//*************************************************
		PrintWriter out=response.getWriter();
		
		//**************PROCESSING THE FILE 
		Part image=request.getPart("pic");
		InputStream input= image.getInputStream();
		//****************database object
	    Database data =new Database();
	    //*****************************
		if(image.getSize()<=0)
		{
			out.print("select a picture");
			out.println("<a href=\"./UpdateDetails\">BACK</a>");
			
		}
		else 
		{
			
		try 
		{
			data.insertDataa(input, StudentNumber);
			out.println("<a href=\"./UpdateDetails\">Profile Picture</a>");
		  }
		catch (SQLException e)
		{
			out.println("Unexpected error try again");
		}	
			
		}//end of else
	}//end of method

}//end of class
