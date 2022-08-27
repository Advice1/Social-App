<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import=" java.sql.*" %>
    <%@page import=" java.io.*" %>
    <%@page import=" javax.servlet.http.*" %>
    <%@page import=" java.sql.*" %>
    <%@page import="administration.Staff_Database" %>
      <%@page import="com.mysql.jdbc.MysqlDataTruncation" %>
    <%@page import="design.Database" %>
    <%@page import= "com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Order</title>
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
		<a href="./Admin_Manages_Orders_Details">back</a>

		</nav>
<% 


//int OrderId=Integer.parseUnsignedInt(request.getParameter("OrderId"));
String OrderId=(request.getParameter("OrderId"));
String Status=request.getParameter("Status");
String submit=request.getParameter("action");

//*************************************************
if(Status.length()>=100)
{
	out.println("<h2>Status Too Long</h2>");
	out.println("<br><a href=\"StuffMainMenu.html\">HOME</a>");
}
//********************************
//*************************************************
else if(OrderId.length()>=100000)
{
	out.println("<h2>Order Number is invalid provide a valid order number</h2>");
	out.println("<br><a href=\"StuffMainMenu.html\">HOME</a>");
}
//*************************************************
//
else{
	
	Staff_Database update_n_Delete=new  Staff_Database();  //object type of  Staff_Database class

 if(submit.equals("update"))
{
	try{
	update_n_Delete.updateStatus(OrderId, Status);
	out.println("<h2>Order Number <p style=color:red>"+OrderId+" <p>Status has been updated </h2>");
       }//end of try
     //**********************************************************
	    catch(MysqlDataTruncation e) 
		   {
			   out.println("<h3>Number invalid<h3>");
			   out.println("<a href=\"StuffMainMenu.html\">HOME</a>");
			  
		   }//end of catch
//**********************************************************
    catch (SQLException e) 
     {
			out.println("<h2>unexpected error try again</h2>");
			out.println("<a href=\"StuffMainMenu.html\">HOME</a>");
			
	 }//end of catch
 catch (NumberFormatException e) 
     {
			out.println("<h2>Order Number invalide</h2>");
			out.println("<a href=\"StuffMainMenu.html\">HOME</a>");
			e.printStackTrace();
	 }//end of catch

}//end of if

else if(submit.equals("Remove"))
{
	try{
		
		update_n_Delete.delet_Processed_Orders(OrderId);
		out.println("<h2>Order Number "+OrderId+"succesfully Removed </h2>");
	       }//end of try
	       catch (MySQLIntegrityConstraintViolationException e) 
		    {
					out.println("<h2>Order deos not exists</h2>");
					out.println("<br><a href=\"StuffMainMenu.html\">HOME</a>");
					

		  }//end of catch
	//**********************************************************
		    catch(MysqlDataTruncation e) 
			   {
				   out.println("<h3>details invalid<h3>");
				   out.println("<a href=\"StuffMainMenu.html\">HOME</a>");
				  
			   }//end of catch
	//**********************************************************
	    catch (SQLException e) 
	     {
				out.println("<h1>something went wrong with the server try again</h1>");
				 out.println("<a href=\"StuffMainMenu.html\">HOME</a>");
				e.printStackTrace();
		 }//end of catch
	    
			   catch (NumberFormatException e) 
			     {
						out.println("<h2>A Number is expect on item number field</h2>");
						out.println("<br><a href=\"StuffMainuMenu.html\">HOME</a>");
					
				 }//end of catch
	 //**********************************************************
	

}
//end of else if
else
{
	out.println("<h3>unexpected error occured ensure that the value entered are correct</h3>");
	out.println("<h1>Order Number \n</h1><h2>"+OrderId+"</h2>");
}
//end of inner else
}//end of outer esle
%>

</body>
</html>