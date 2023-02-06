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
<td align="left">Class Name</td>
<td align="left"><input type="text" name="classname"></td>
<td align="center"><input type="submit" value="Add"></td>
</tr>
</table>
<%
String message=(String)request.getAttribute("msg");
if(message!=null)
out.println(message);
%>

</form>
</body>
</html>