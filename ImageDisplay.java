package multiImageRetrival;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageDisplay
 */
@WebServlet("/ImageDisplay")
public class ImageDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   PrintWriter out =resp.getWriter();
		   Student category = new Student();//object of Student class
		List<Student> list=(ArrayList<Student>)req.getAttribute("list"); //creating a list of Student
		//****************************************html code************************************************
		out.println("<html>");
		out.println("<head>");
		out.println("<title>NETWORKING</title>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"ImageDisplayStyle.css\">");
		out.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<nav>");
		out.println("<a href=\"MainMenu.html\">Menu</a>"); //
		out.println("<a href=\"#\">Logout</a>");
		out.println("<a href=\"./UpdateDetails\">PROFILE</a>");
		//*****************************form used for search section
		out.println("<form action=\"./searchingDetails\" method=\"post\">");
		out.println("<input type=\"text\" placeholder=\"search\" name=\"name\"> ");
		out.println("<input type=\"submit\" value=\"search\">");
		out.println("</form>");
		
		out.println("</nav>");
		//****************************************************************
		//check if the lis is empty
		if(list.isEmpty())
		{out.println("Nothing to display at the moment check again later");}
		
		else 
		{
		
		out.println("");
		out.println("<table id=\"table\">");
		
		
	    for(int i=0;i<list.size();i++){
			
	    	System.out.println("checking"+list.size());
	    	//getting data from the list
			category = list.get(i);
			String name =  category.getName();
			String surname=category.getSurname();
			String department=category.getDepartment();
			String facebook=category.getFacebook();
			String instagram=category.getInstagram();
			String tweeter=category.getTweeter();
			//try {out.println("<img src=./ImageProcessor?name="+name+"/>");}catch(Exception ex) {System.out.print("something is wrong");}
			
			out.println("<tr>");
			
			out.println("<td>");
			out.println(name);
			out.println("<br>");
			out.println(surname);
			out.println("<br>");
			out.println(department);
			out.println("<br>");
			out.println("</td>");
			
			out.println("<td>");
			out.println("<img src=\"./ImageProccessor?name="+name+" \" width=\"100\" height=\"100\">");
			//details needed
			out.println(
					" <a href=\"#\" class=\"insideB\">FOLLOW</a>\r\n" + 
					"<a href=\"#\" class=\"insideB\">MESSAGE</a>\r\n" 
					);
			out.println("<h3>Social Medial Accounts</h3>");
			out.println("<a href=\"www.facebook.com\" class=\"fa fa-facebook\"></a></i><blue>"+facebook+"</blue><a href=\"www.instagram.com\" class=\"fa fa-instagram\"></a></a><blue>"+instagram+"</blue><a href=\"www.twitter.com\" class=\"fa fa-twitter\"></a></><blue>"+tweeter+"</blue>");//change needed
			
			out.println("</td>");
			
			out.println("</tr>");
			}
			//end of LOOP statement
	}//end of else
		
	    out.println("</table>");
	    //********************************massaging section
	    out.println("<Script>");
	    
	    out.println("var table=document.getElementById(\"table\"),rIndex");
	    out.println("for(var i=0;i<table.rows.length;i++){table.rows[i].onclick=function()"
	    		+ "{rIndex=this.rowIndex;"
	    		+ "console.log(rIndex);"
	    		+ "document.getElementById(\"fname\").value=this.cells[0].rIndex;}}");
	    	
	    out.println("");
	    out.println("</Script>");
	    //*************************************************************
	    
	    out.println("</body>");
	    out.println("</html>");
	    //end of html code

}

}
