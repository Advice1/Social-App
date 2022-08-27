package Searching_Data;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import multiImageRetrival.FriendDatabase;

/**
 * Servlet implementation class SearchingImages
 */
@WebServlet("/SearchingImages")
public class SearchingImages extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletOutputStream output=null;
		String name=req.getParameter("name");    //getting the  name from database
		FriendDatabase im =new FriendDatabase(); //creating an object type of FriendDatabase database
		byte[] image=im.getImage(name);          //calling a method getImage()
		 output=resp.getOutputStream();
		 output.write(image);
		 output.close();
		
	}

}
