<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner's Academy</title>
</head>
<body>

<table>
<tr>
	<td>
	<h1>Login Form</h1>
	</td>	
</tr>
<tr>
<td>
<form action="./Login" method="post" draggable="false" >
	Username:<input type="text" name="username"></br>
	Password:<input type="password" name="password"></br>
	<input type="submit" name="login"><br>
	<%
String message=(String)request.getAttribute("msg");
if(message!=null)
out.println(message);
%>
</form>
</td>
</tr>
<tr>
<td>
New user? click on <a href="register.jsp" >Register</a>
</td>
</tr>
<tr><td>
<p style="color:red;">${requestscope.msg}</p>
</td></tr>
</table>

</body>
</html>