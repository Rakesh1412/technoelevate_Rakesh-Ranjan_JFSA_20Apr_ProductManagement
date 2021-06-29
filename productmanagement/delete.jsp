<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="bg-dark mt-5">
	
	<form acton="./delete" method="get" class="container">
		<h2 class="text-danger">Delete Product</h2>
		<div class="form-group">
			<label>ID</label> <input type="number" class="form-control" name="id"
				aria-describedby="emailHelp" placeholder="Enter ID">
		</div>
		<button type="submit" class="btn btn-danger mt-4">Delete</button>
	</form>

</body>
</html>