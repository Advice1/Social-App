package cafeteriaService;

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
 * Servlet implementation class ProductImageProccesor
 */
@WebServlet("/ProductImageProccesor")
public class ProductImageProccesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//***************************getting stuff id from session
				HttpSession session=req.getSession();
				String StuffNo=(String)session.getAttribute("Stuff_Id");
	    //*************************************************************
				String name=req.getParameter("Name");//reading name from databases 
				
		ServletOutputStream output=null;
		Staff_Database dataiImage =new Staff_Database();
		byte[] image=dataiImage.DisplayProductImage(name,StuffNo);   //calling the byte  method
		 output=resp.getOutputStream();
		 output.write(image);
		 output.close();
	}

}//end of method
