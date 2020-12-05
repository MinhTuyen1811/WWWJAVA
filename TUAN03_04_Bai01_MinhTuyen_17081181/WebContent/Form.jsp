<%@ page import="fit.iuh.entities.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Student svt = new Student();
		svt = (Student) request.getAttribute("student");
		out.println("First name:" + svt.getFname()
		+ "<br/> Last name: " + svt.getLname()
		+ "<br/> Email : " + svt.getEmail()
		+ "<br/> Mobile Number: " +svt.getMobileNum()
		+ "<br/> Address: " + svt.getAddress()
		+ "<br/> City: " + svt.getCity()
		+ "<br/> Pin code: " + svt.getPinCode()
		+ "<br/> State: " + svt.getState()
		+ "<br/> Country: " + svt.getCountry()
		);
	%>
</body>
</html>