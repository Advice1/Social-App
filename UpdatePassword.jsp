<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import=" java.sql.*" %>
    <%@page import=" java.io.*" %>
    <%@page import=" javax.servlet.http.*" %>
    <%@page import=" java.sql.*" %>
    <%@page import=" administration.Staff_Database" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<title>password</title>
<link rel="stylesheet" type="text/css" href="OrderViewStyle.css">
</head>

<Style>
h1{color:white;}
h2{color:blue}
</Style>


<body>
        <nav>
		<a href="StuffMainMenu.html">Menu</a>
		</nav>

<% 

//***********************************getting the staff_id from the user when login in
 String StaffId=(String)session.getAttribute("Stuff_Id");
//************************************************************************************
Staff_Database password=new  Staff_Database();  //object type of database class
//************************************scanning new password**********************8
 String passwrd=request.getParameter("password");
 //@@@@@@@@@@@@checking if the staff_id is null
 //*************************************************
if(passwrd.length()>=50)
{
	out.println("password too Long");
	out.println("<br><a href=\"StuffMainMenu.html\">HOME</a>");
}
//********************************
 
else if(StaffId==null)
 {
	 out.println("<h1>sorry login again</h1>");
	 out.println("<br><a href=\"WelcomePage.html\">HOME</a>");
 }
 //end of if
 else if(StaffId!=null)
 {
	 try{
	 password.UpdateStaffPassword(passwrd,StaffId);
	 out.println("<h1>congradulations password succesfully updated to \n</h1><h2>"+passwrd+"</h2>");
	 }//end of try
	 catch (SQLException e) 
	    {
				out.println("something went wrong with the server try again");
				out.println("<br><a href=\"StuffMainMenu.html\">HOME</a>");
		 }//end of catch
 }
 //end of else if
 else
 {
	 out.println("something went wrong try again"); 
	 out.println("<br><a href=\"StuffMainMenu.html\">HOME</a>");
 }
 //end of else
 

 
%>
</body>
</html>