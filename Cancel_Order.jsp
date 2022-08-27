<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@page import=" java.sql.*" %>
   <%@page import=" java.io.*" %>
   <%@page import=" javax.servlet.http.*" %>
   <%@page import=" java.sql.*" %>
   <%@page import="design.Database" %>
   <%@page import="java.util.*"%>
    <%@page import="administration.Staff_Database" %>
     <%@page import="com.mysql.jdbc.MysqlDataTruncation" %>
    <%@page import= "com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancel Order</title>
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
		
		<a href="./Order_Details">student</a>
		<a href="./View_Order_Details">Cafeteria</a>
		
		</nav>
<%
//***********************************getting the student id from a season
String StudentId=(String)session.getAttribute("name");
//************************************************************************************
Database Cancel_Order=new  Database();  //object type of database class  //student
Staff_Database Cancel_Cafeteia_Order=new  Staff_Database();  //object type of database class  //cafeteria
//************************************scanning new password**********************8
//int itemNumber=Integer.parseUnsignedInt(request.getParameter("item_No"));
String itemNumber=(request.getParameter("item_No"));
String submit=request.getParameter("action");
//@@@@@@@@@@@@checking if the student_id is null

//*************************************************
if(itemNumber.length()>=100000)
{
	out.println("<h2>Order Number is invalid provide a valid order number</h2>");
	out.println("<br><a href=\"MainMenu.html\">HOME</a>");
}
//*************************************************
else{

if(submit.equals("Remove"))
{
	 try{ 
		 Cancel_Order.deletMyOders(itemNumber,StudentId);
	 out.println("<h2>Order number "+itemNumber+" canceled</h2>");
	 }//end of try
	
	//**********************************************************
	catch (NumberFormatException e) 
  {
			out.println("<h2>Order Number invalide</h2>");
			out.println("<a href=\"MainMenu.html\">HOME</a>");
			e.printStackTrace();
	 }//end of catch
	    catch(MysqlDataTruncation e) 
		   {
			   out.println("<h3>Number invalid<h3>");
			   out.println("<a href=\"MainMenu.html\">HOME</a>");
			  
		   }//end of catch
//**********************************************************
 catch (SQLException e) 
  {
			out.println("<h2>unexpected error try again</h2>");
			out.println("<a href=\"MainMenu.html\">HOME</a>");
			
	 }//end of catch


}
else if(submit.equals("Cancel"))
{
	try{ 
		Cancel_Cafeteia_Order.deletMy_Cafe_Oders(itemNumber,StudentId);
	 out.println("<h2 >Order number\t "+itemNumber+" \tcanceled</h2>");
	 }//end of try
	//**********************************************************
	catch (NumberFormatException e) 
 {
		out.println("<h2>Order Number invalide</h2>");
		out.println("<a href=\"MainMenu.html\">HOME</a>");
		e.printStackTrace();
 }//end of catch
    catch(MysqlDataTruncation e) 
	   {
		   out.println("<h3>Number invalid<h3>");
		   out.println("<a href=\"MainMenu.html\">HOME</a>");
		  
	   }//end of catch
//**********************************************************
catch (SQLException e) 
 {
		out.println("<h2>unexpected error try again</h2>");
		out.println("<a href=\"MainMenu.html\">HOME</a>");
		
 }//end of catch


}
//end of else if
else
{
	out.println("<h2>unexpected error occured ensure that the value entered are correct</h2>");
	out.println("<h2>Order Number \n"+itemNumber+"</h2>");
}
//end of inner  else
}//end of outer else

%>

</body>
</html>