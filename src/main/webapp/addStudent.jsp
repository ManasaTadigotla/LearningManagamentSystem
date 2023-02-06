<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Student</title>
</head>
<body>
	<form action="./addStudent" method="post">
	
		<table>
		
		<tr><td>First Name:</td><td><input type="text" name="firstname"></td></tr>
		<tr><td>LastName:</td><td><input type="text" name="lastname"></td></tr>
		<tr><td> Address:</td><td><input	type="text" name="address"></td></tr>
		 <tr><td>Age:</td><td><input type="text"	name="age"></td></tr> 
		 <tr><td>Email:</td><td><input type="text" name="email"></td></tr>
		<tr><td>Contact Num:</td><td><input type="text" name="contactno"></td></tr>
		 <tr><td align="center"><input	type="submit" value="Add"></td></tr>
		 
		 <tr>
		 <td>
		<%
		String message = (String) request.getAttribute("msg");
		if (message != null)
			out.println(message);
		%>
		</td>
		</tr></table>
	</form>

</body>
</html>