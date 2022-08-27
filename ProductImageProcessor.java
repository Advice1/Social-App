package UpdatingProfessinalService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import design.Database;

/**
 * Servlet implementation class ProductImageProcessor
 */
@WebServlet("/ProductImageProcessor")
public class ProductImageProcessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//***************************getting username
				HttpSession session=req.getSession();
				String uname=(String)session.getAttribute("name");
	    //**************************************
		ServletOutputStream output=null;
		Database dataiImage =new Database();                        //object type of Database Class
		byte[] image=dataiImage.RetriveImage(uname);                //calling a method
		 output=resp.getOutputStream();
		 output.write(image);
		 output.close();
		
	}

}
