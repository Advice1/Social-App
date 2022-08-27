package multiImageRetrival;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//class for processing the image
@WebServlet("/ImageProccessor")
public class ImageProccessor extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletOutputStream output=null;
		//reads  name from database 
		String name=req.getParameter("name");
		
		FriendDatabase im =new FriendDatabase();  //creating object of friendDatabase
		byte[] image=im.getImage(name);//getting a byte type method(getImage)
		 output=resp.getOutputStream();
		 output.write(image);
		 output.close();
		
	}
	

}
