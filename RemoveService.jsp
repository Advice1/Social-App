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
<title>Remove Service</title>
<link rel="stylesheet" type="text/css" href="ProfessionalServiceReg.css">
</head>
<body>

<% 

//***********************************getting the staff_id from the user when login in
 String StaffId=(String)session.getAttribute("Stuff_Id");
//************************************************************************************
Staff_Database Remove=new  Staff_Database();  //object type of database class
//************************************scanning new password**********************8
 String ItemNo=request.getParameter("itemNo");
 //@@@@@@@@@@@@checking if the staff_id is null
 //*************************************************
if(ItemNo.length()>=10000)
{
	out.println("<h1>Order Number too Long</h1>");
	out.println("<br><a href=\"StuffMainMenu.html\">HOME</a>");
}
//*******************************
 
else if(StaffId==null)
 {
	 out.println("<h1>sorry login again<h1>");
	 out.println("<br><a href=\"WelcomePage.html\">HOME</a>");
 }
 //end of if
 else if(StaffId!=null)
 {
	 try{
	 Remove.Remove_service_offered(ItemNo,StaffId);
	 out.println("<h1 style=\"background:red\">service succefully removed</h1> ");
	 out.println("<br><a href=\"StuffMainMenu.html\">HOME</a>");
	 }//end of try
	 catch (SQLException e) 
	    {
				out.println("<h1>Unexpected error try again</h1>");
				out.println("<br><a href=\"StuffMainMenu.html\">HOME</a>");
				
		 }//end of catch
 }
 //end of else if
 else
 {
	 out.println("<h1>something went wrong try again</h1>"); 
	 out.println("<br><a href=\"StuffMainMenu.html\">HOME</a>");
 }
 //end of else
 

 
%>





</body>
</html>