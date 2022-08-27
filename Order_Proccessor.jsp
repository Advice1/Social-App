<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import=" java.sql.*" %>
    <%@page import=" java.io.*" %>
    <%@page import=" javax.servlet.http.*" %>
    <%@page import=" java.sql.*" %>
    <%@page import="com.mysql.jdbc.MysqlDataTruncation" %>
    <%@page import="design.Database" %>
    <%@page import= "com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order</title>
<link rel="stylesheet" type="text/css" href="OrderViewStyle.css">

</head>

 <style>
 h2
 {
 background:blue;
 }
 </style>
 
<body>
<nav>
 <% out.println("<a href=\"./ProcessingDetails\">Services</a>"); //%>
</nav>


<% 

//***********************************getting the student_id from the user when login in
String StudentId=(String)session.getAttribute("name");
//************************************************************************************
Database Order_Item=new  Database();  //object type of database class
//************************************scanning items**********************
//int Item_Number=Integer.parseInt(request.getParameter("I_Number"));
String Item_Number=(request.getParameter("I_Number"));
String Product=request.getParameter("P_Name");
String cellNo=request.getParameter("Cell_No");
String Instructions=request.getParameter("Instruct");
String contact_Option="sms";
String Status="Recieved";
//*************************************************
//*************************************************
if((Item_Number.length()>10000))
{
	out.println("<h2>Order Number is invalid provide a valid order number</h2>");
	out.println("<br><a href=\"MainMenu.html\">HOME</a>");
}
//*************************************************
else if(Product.length()>=20)
{
	out.println("<h2>Product Name is too Long</h2>");
	out.println("<br><a href=\"MainMenu.html\">HOME</a>");
}
//********************************

else if(Instructions.length()>=20)
{
	out.println("<h2>Instruction/Specification cannot be more tha 100 words</h2>");
	out.println("<br><a href=\"MainMenu.html\">HOME</a>");
}
//********************************
//********************************
else if(StudentId==null)
{
	out.println("<h2>Sorry Login and Try Again</h2>");
}
else if (StudentId!=null)
{
	 try{
	 Order_Item.OderService(Item_Number, Product, StudentId,cellNo, Instructions, contact_Option, Status);
	 out.println("<h2>Congradulation YOUR ORDER was placed successefuly view the Status on your Profile </h2>");
	   }//end of try 
	 catch (MySQLIntegrityConstraintViolationException e) 
	    {
				out.println("<h2>Order deos not exists</h2>");
				out.println("<br><a href=\"MainMenu.html\">HOME</a>");
				

	  }//end of catch
//**********************************************************
	    catch(MysqlDataTruncation e) 
		   {
			   out.println("invalid OrderNumber");
			   out.println("<a href=\"MainMenu.html\">HOME</a>");
			  
		   }//end of catch
//**********************************************************
		   catch (NumberFormatException e) 
		     {
					out.println("<h2>A Number is expect on item number field</h2>");
					out.println("<br><a href=\"MainMenu.html\">HOME</a>");
				
			 }//end of catch
 //**********************************************************
	 catch (SQLException e) 
	    {
				out.println("<h2>Item Unavailable</h2>");
				out.println("<br><a href=\"MainMenu.html\">HOME</a>");
				
				
	  }//end of catch
//**********************************************************
	

}
//end of else if
else
{
	 out.println("<h2>something went wrong try again</h2>"); 
}
//end of else


%>



</body>
</html>