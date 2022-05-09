<%@ page errorPage="error.jsp" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
	<%
		String op = request.getParameter("op");
		int val1 = Integer.parseInt(request.getParameter("val1"));
		int val2 = Integer.parseInt(request.getParameter("val2"));
		int result = 0;
	
		if(op.equals("add")) {
			result = val1+val2;
		}
		else if(op.equals("sub")) {
			result = val1-val2;
		}
		else if(op.equals("mul")) {
			result = val1*val2;
		}
		else if(op.equals("div")) {
			result = val1/val2;
		}
	%>
	
	<h1>Result for <%= op %></h1>
	<p> Result: <%= result %></p>
</body>
</html>