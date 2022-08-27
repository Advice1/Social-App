package multiImageRetrival;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ImageView")
public class ImageView extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	FriendDatabase imagedata=null;       //creating an object of a class and setting it to null
    	imagedata=new FriendDatabase();      //
    	try {
    		List<Student> list=imagedata.GetData();   //calling the getData mathod
    		req.setAttribute("list", list);
    		RequestDispatcher dis=req.getRequestDispatcher("ImageDisplay"); //servlet being proccessed by a sevlert("ImageDisplay)
    		dis.forward(req, res);
		}
    	catch (SQLException e)
    	{
			e.printStackTrace();
		}
    	
    	
    }

}
