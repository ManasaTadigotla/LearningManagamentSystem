<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Class</title>
</head>
<body>
<a href="home.jsp">Home</a><br>

<form action="./addClass" method="post">
<table>
<tr>
<td align="left">name</td>
<td><input type="text" name="classname"></td>
<td align="center"><input type="submit" value="Add"></td>
</tr>
<tr>
<td>
<%
String message=(String)request.getAttribute("msg");
if(message!=null)
out.println(message);
%>
</td>
</tr>
</table>
</form>
</body>
</html>