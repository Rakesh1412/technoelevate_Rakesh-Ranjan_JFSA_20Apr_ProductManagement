<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="bg-dark">
	<jsp:include page="header.jsp" />
	<form acton="./delete" method="post" class="container">
		<h2 class="text-danger">Delete :-(</h2>
		<div class="form-group">
			<label>ID</label> <input type="number" class="form-control" name="id"
				placeholder="Enter product ID which is to be deleted">
		</div>
		<input type="submit" class="btn btn-danger mt-4" value="Remove">
	</form>
	<%
	if (msg != null && !msg.isEmpty()) {
	%>
	<h1 style="color: cyan;"><%=msg%>
	</h1>
	<%
	}
	%>

</body>
</html>