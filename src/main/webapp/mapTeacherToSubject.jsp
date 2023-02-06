<%@page import="java.util.List"%>
<%@page import="org.learnersacademy.lms.entities.Subject"%>
<%@page import="org.learnersacademy.lms.entities.Teacher"%>
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
<% 
List<Teacher> teachers=(List<Teacher>) request.getAttribute("teachers");
List<Subject> subjects=(List<Subject>) request.getAttribute("subjects");

%>
<form action="./mapTeacherSubjects" method="post">
<table>
<tr>
<td>Teachers</td>
<td>Subjects</td>
</tr>
<tr>
<td>
<select name="teacherType">
<%
for(Teacher t:teachers)
{
%>
<option value=<%=t.gettId() %>><%=t.getFirstName() %></option>
<%
}
%>
</select>
</td>
<td>
<select name="subjectType">
<%
for(Subject s:subjects)
{
%>
<option value=<%=s.getsId() %>><%=s.getName() %></option>
<%
}
%>
</select>
</td>
</tr>
<tr> 
<td><input type="submit" value="assign"></td>
</tr>
</table>

</form>

</body>
</html>