<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner's Academy</title>
</head>
<body>
	<form action="./Register" method="post">
		<table>
		<tr><td width=i00% align="left"><a href="index.jsp">Login</a></td></tr>
			<tr>
				<td align="left">UserName:</td>
				<td align="left"><input type="text" name="username"></td>
			</tr>
			<tr>
				<td align="left">Password:</td>
				<td align="left"><input type="password" name="password"></td>
			</tr>
			<tr>
				<td align="left">Email:</td>
				<td align="left"><input type="text" name="email"></td>
			</tr>
			
			<tr>
			<td align="left">Contact No.</td>
				<td align="left"><input type="number" name="phone"></td>			
			</tr>
			<tr>
				<td align="left">UserType</td>
                 <td>
				<select name="usertype">
				<option value="admin">Admin</option>
				<!-- <option value="student">Student</option>
				<option value="teacher">Teacher</option>
				 -->
				</select>
				</td>
			</tr>
			<tr>
			<td align="center"><input type="submit" value="Register"></td>
			</tr>			
			<tr>
			</tr>
		</table>
		<table>
		<tr>
		<td style="font-color:red">
		<%
String message=(String)request.getAttribute("msg");
if(message!=null)
out.println("<h4>"+message+"</h4>");
%>
</td>
</tr>
</table>
<label name="msgUnamePwd" >UserName and password must have min 4 and max 10 chars. Alphanumerics<br></label>
<label name="msgLabel">Email must contain @.</label>
</form>
</body>
</html>