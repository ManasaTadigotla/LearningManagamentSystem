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

<form action="./addSub" method="post">
<table>
<tr>
<td>Name:</td><td align="left"><input type="text" name="name"></td>
<tr><td align="center"> <input type="submit" value="submit"></td></tr>
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