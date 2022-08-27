<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import=" java.sql.*" %>
    <%@page import=" java.io.*" %>
    <%@page import=" javax.servlet.http.*" %>
    <%@page import=" java.sql.*" %>
    <%@page import="design.Database" %>
     <%@page import="com.mysql.jdbc.MysqlDataTruncation" %>
    <%@page import= "com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Orders</title>
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
		<a href="./ServiceProviderManageDetails">back</a>
		</nav>

<% 

Database updatenDelete=new  Database();  //object type of database class
//int Item_No=Integer.parseInt(request.getParameter("item_No"));
String Item_No=(request.getParameter("item_No"));
String Status=request.getParameter("Status");
String submit=request.getParameter("action");




 if(submit.equals("update"))
{
	 
	//*************************************************
	 if(Status.length()>=100)
	 {
	 	out.println("<h2Status Too Long</h2>");
	 	out.println("<br><a href=\"MainMenu.html\">HOME</a>");
	 }
	 //********************************
	 //*************************************************
	 else if(Item_No.length()>=100000)
	 {
	 	out.println("<h2>Order Number is invalid provide a valid order number</h2>");
	 	out.println("<br><a href=\"MainMenu.html\">HOME</a>");
	 }
	 //*************************************************
	 else{
	try{
	updatenDelete.updateStatus(Item_No, Status);
	out.println("<h2>Order Number <p style=color:red>"+Item_No+" <p>Status has been updated </h2>");
       }//end of try
	 //**********************************************************
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
catch (NumberFormatException e) 
 {
		out.println("<h2>Order Number invalide</h2>");
		out.println("<a href=\"MainMenu.html\">HOME</a>");
		e.printStackTrace();
 }//end of catch

	 }//end of else

}//end of if

else if(submit.equals("Remove"))
{
	
	//*************************************************
	if(Status.length()>=100)
	{
		out.println("<h2Status Too Long</h2>");
		out.println("<br><a href=\"MainMenu.html\">HOME</a>");
	}
	//********************************
	//*************************************************
	else if(Item_No.length()>10000)
	{
		out.println("<h2>Order Number is invalid provide a valid order number</h2>");
		out.println("<br><a href=\"MainMenu.html\">HOME</a>");
	}
	//*************************************************
	
	else{
	
	try{
		updatenDelete.deletStatus(Item_No);
		out.println("<h2>Order Number\t "+Item_No+"\tsuccesfully deleted </h2>");
	       }//end of try
	 //**********************************************************
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
catch (NumberFormatException e) 
 {
		out.println("<h2>Order Number invalide</h2>");
		out.println("<a href=\"MainMenu.html\">HOME</a>");
		e.printStackTrace();
 }//end of catch

	}//end of else

}
//end of else if
else
{
	out.println("<h2>unexpected error occured ensure that the value entered are correct</h2>");
	out.println("<h2>Order id \n"+Item_No+"</h2>");
}


 
 

 
%>
</body>
</html>