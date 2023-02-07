<%@page import="org.learnersacademy.lms.entities.Student"%>
<%@page import="org.learnersacademy.lms.entities.AcademicClass"%>
<%@page import="org.learnersacademy.lms.service.AcademicClassService"%>
<%@page import="java.util.List"%>
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
<%List<AcademicClass> cls=(List<AcademicClass>) request.getAttribute("classes");
List<Student> studs=(List<Student>)request.getAttribute("students");
%>
<form action="./map" method="post">
<table>
<tr>
<td align="left">
Classes
</td>
<td align="left">
Students
</td>
</tr>
<tr>
<td align="left">
<select name="classType">
<%
for(AcademicClass c:cls)
{
	%>
<option value=<%=c.getcId() %>><%=c.getName() %></option>
<%} %>
</select>
</td>
<td align="left">
<select name="studentType">
<%
for(Student stu:studs)
{
	%>
<option value=<%=stu.getStudentId() %>><%=stu.getFirstName() %></option>
<%} %>
</select>

</td>
</tr>
<tr>
<td align="center"><input type="submit" value="Assign"></td>
</tr>
</table>

</form>
</body>
</html>