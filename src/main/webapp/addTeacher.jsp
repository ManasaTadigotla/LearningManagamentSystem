<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="home.jsp">Home</a><br>
<form action="./addTeacher" method="post">
<table>
<tr width=100%><td align="center">Teacher Form</td></tr>
<tr><td align="left">FirstName:</td><td align="left"><input type="text" name="firstname"></td></tr>
<tr><td align="left">LastName:</td ><td align="left"><input type="text" name="lastname"></td></tr>
<tr><td align="left">Designation:</td> <td align="left"><input type="text" name="designation"></td></tr>
<tr><td align="left">ContactNo:</td> <td align="left"><input type="text" name="contact"></td></tr>
<tr width=100%><td align="center"><input type="submit" value="Add"></td></tr>
</table>
<%
String message=(String)request.getAttribute("msg");
if(message!=null)
out.println(message);
%>
</form>
</body>
</html>