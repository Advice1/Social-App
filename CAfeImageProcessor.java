package Admin_Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import administration.Staff_Database;
import design.Database;

/**
 * Servlet implementation class CAfeImageProcessor
 */
@WebServlet("/CAfeImageProcessor")
public class CAfeImageProcessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		ServletOutputStream output=null;
		//reads name from database(business_admin) then scanning it
		String Prod_Name=req.getParameter("Name");
		
		Staff_Database dataiImage =new Staff_Database();
		byte[] image=dataiImage.RetriveImage(Prod_Name);
		 output=resp.getOutputStream();
		 output.write(image);
		 output.close();
		
	}

}
