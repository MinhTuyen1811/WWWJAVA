<%@page import="fit.iuh.entities.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Managerment Person</title>
<style>
	table{
		border-collapse: collapse;
	}
	table, th, td{
		border: 1px solid black;
	}
</style>
</head>
<body>
	<h1>Managerment Person</h1>
	<table >
		<thead>
			<tr>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Birthday</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Person> lstPersons = ((List<Person>) request.getAttribute("lst"));
				for (Person p : lstPersons) {
					out.println("<tr><td>" + p.getFirstName() + "</td><td>" + p.getLastName() + "</td><td>" + p.getEmail()+ "</td><td></td><td>" + p.getBirthday() + "</td></tr>");
				}
			%>
		</tbody>
	</table>

</body>
</html>