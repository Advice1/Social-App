<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@page import=" java.sql.*" %>
   <%@page import=" java.io.*" %>
   <%@page import=" javax.servlet.http.*" %>
   <%@page import=" java.sql.*" %>
   <%@page import="design.Database" %>
   <%@page import="java.util.*"%>
   <%@page import=" orderStoreroom.O_Storeroom"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
</head>
<body>

<% 
O_Storeroom storage=new O_Storeroom();
List<O_Storeroom> list=(ArrayList<O_Storeroom>)request.getAttribute("listing"); //creating a list of StorageImage class
//***********************************getting the student_id from the user when login in

//**********************************************************

	out.println("<h3>Sorry Login and Try Again</h3>");

	
	try{
		 for(int n=0;n<list.size();n++){
				
			storage = list.get(n);
			storage.getStatus();
			storage.getNotification();
			System.out.println(storage.getNotification());
			 
		 
		 }
		
	 out.println("<h2>congrats</h2>");
	 }//end of try
	 catch (SQLException e) 
	    {
				out.println("<h1>something went wrong with the server try again</h1>");
				out.println(e);
				e.printStackTrace();
	  }//end of catch



%>

</body>
</html>