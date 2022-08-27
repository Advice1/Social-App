package multiImageRetrival;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateImageProccessor
 */
@WebServlet("/UpdateImageProccessor")
public class UpdateImageProccessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//getting a session /username from the user that loged in
		HttpSession session=req.getSession();
		String uname=(String)session.getAttribute("name");
		
		ServletOutputStream output=null;
		FriendDatabase dataiImage =new FriendDatabase();      //creating an object of friendDatabase classS
		byte[] image=dataiImage.DisplayProfileImage(uname);   //calling a methodS
		 output=resp.getOutputStream();
		 output.write(image);
		 output.close();
	}
}
