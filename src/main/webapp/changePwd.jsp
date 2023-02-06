<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body>
<form action="./ChangePassword" method="post">
<table>
<tr><td width=i00% align="left"><a href="home.jsp">Home</a></td></tr>
<tr><td width=i00% align="left"><a href="index.jsp">Login</a></td></tr>

<tr><td>Old Password</td><td align="left"><input type="text" name="oldPwd"></td></tr>
<tr><td>New Password</td><td align="left"><input type="text" name="newPwd"></td></tr>
<tr><td align="center"><input type="submit" value="Change"></td></tr>
</table>
</form>

<table>
<tr>
<td style="background-color:red">
<%
String message=(String)request.getAttribute("msg");
if(message!=null)
out.println(message);
%>
</td>
</tr>
</table>
</body>
</html>