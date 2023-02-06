<%@page import="org.learnersacademy.lms.entities.Subject"%>
<%@page import="org.learnersacademy.lms.entities.Student"%>
<%@page import="org.learnersacademy.lms.entities.AcademicClass"%>
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
<% 
List<AcademicClass> classes=(List<AcademicClass>) request.getAttribute("classes");
List<Subject> subjects=(List<Subject>) request.getAttribute("subjects");
%>
<form action="./mapSubjects" method="post">
<table>
<tr>
<td>Classes</td>
<td>Subjects</td>
</tr>
<tr>
<td>
<select name="className" >
<%
for(AcademicClass c:classes)
{
%>
<option value=<%=c.getcId() %>><%=c.getName() %></option>
 <%
}
%>
</select>
</td>
<td>
<select name="subjectName">
<%
for(Subject s:subjects)
{
	//if()
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