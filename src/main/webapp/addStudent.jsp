<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Student</title>
</head>
<body>
<a href="home.jsp">Home</a><br>
	<form action="./addStudent" method="post">
	
		<table>
		<tr><td align="center">Student Form</td></tr>
		<tr><td align="left">First Name:</td><td align="left"><input type="text" name="firstname"></td></tr>
		<tr><td align="left">LastName:</td><td align="left"><input type="text" name="lastname"></td></tr>
		<tr><td align="left"> Address:</td><td align="left"><input	type="text" name="address"></td></tr>
		 <tr><td align="left">Age:</td><td align="left"><input type="text"	name="age"></td></tr> 
		 <tr><td align="left">Email:</td><td align="left"><input type="text" name="email"></td></tr>
		<tr><td align="left">Contact Num:</td><td align="left"><input type="text" name="contactno"></td></tr>
		 <tr><td align="center"><input	type="submit" value="Add"></td></tr>
		 </table>
		<%
		String message = (String) request.getAttribute("msg");
		if (message != null)
			out.println(message);
		%>
		<label name="msgUnamePwd" ></br>UserName and password must have min 4 and max 10 chars. Alphanumerics<br></label>
<label name="msgLabel">Email must contain @.<br>Contact number must contain 10 numbers.</label>
		
	</form>

</body>
</html>