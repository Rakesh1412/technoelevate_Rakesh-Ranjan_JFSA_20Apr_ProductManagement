<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sharingan Mart</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body class="bg-dark mt-5">

	<form acton="./login" method="post" class="container">
		<h2 class="text-danger">Login :-D</h2>
		<div class="form-group">
			<label>ID</label> <input type="number" class="form-control" name="id"
				placeholder="Enter ID"> <small class="form-text text-muted">We
				will share your Id with anyone else.</small>
		</div>
		<div class="form-group">
			<label>Password</label> <input type="password" class="form-control"
				name="password" placeholder="Password">
		</div>
		<input type="submit" class="btn btn-danger mt-4" value="Login">
	</form>

</body>
</html>