<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-image:
		url("/LearningManagementSystem/src/main/resources/university.jpg");
}
</style>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body background <%="university.jpg"%>>
	<h4 font-size:20px>Hi ${sessionScope.user.userName }, Welcome to
		LMS..</h4>

	<a href="changePwd.jsp">Change Password</a>
	<table style="width: 100%">
		<tr>
			<td><a href="addSubject.jsp">Add Subject</a></td>
			<td><a href="addClass.jsp">Add Class</a></td>
			<td><a href="addTeacher.jsp">Add Teacher</a></td>
			<td><a href="addStudent.jsp">Add Student</a></td>
			<td><a href="./mapSubjectAndClass">Add Subjects to Class</a></td>
			<td><a href="./mapTeacherSubjects">Add Teacher to Subject</a></td>
			<td><a href="./map">Add Student to Class</a></td>
			<td><a href="./classReport">ClassReport</a></td>
			<td><a href="./StudentReport">StudentReport</a></td>
			<td><a href="./TeacherReport">TeacherReport</a></td>
		</tr>
	</table>
	<table>
		<tr width=100%>
			<td width=100%><img src="university.jpg" width=100% height="100%"
				alt="This is Learner's Academy" >
				<!-- 
	<p>Learners Academy is found in 2003,by xyz.It is successfully trained more than 400 students 
	It availed so many rewards to the effort its being providing.	
	</p>
	 -->
		</tr>

	</table>












</body>
</html>