package ProffesionalService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import design.Database;

@WebServlet("/Prof_ImageProcessor")
public class Prof_ImageProcessor extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletOutputStream output=null;
		//reading  username from database 
		String username=req.getParameter("username");
		Database processeImage =new Database();    //creating an object database class
		byte[] image=processeImage.RetriveImage(username);// calling a RetriveImage() method
		 output=resp.getOutputStream();
		 output.write(image);
		 output.close();
		
	}

}
