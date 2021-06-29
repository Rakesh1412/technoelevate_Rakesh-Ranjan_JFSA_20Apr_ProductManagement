<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sharingan Mart Add</title>
</head>
<body class="bg-dark">
	<jsp:include page="header.jsp" />
	<form acton="./add" method="get" class="container">
		<h2 class="text-danger">Add Product</h2>
		<div class="form-group">
			<label>Product ID</label> <input type="number" class="form-control"
				name="pid" placeholder="Enter Product ID">
		</div>
		<div class="form-group">
			<label>Product Name</label> <input type="text" class="form-control"
				name="pname" placeholder="Product Name">
		</div>
		<div class="form-group">
			<label>Manufacture Date</label> <input type="date"
				class="form-control" name="mfg" placeholder="Manufacture Date">
		</div>
		<div class="form-group">
			<label>Expiry Date</label> <input type="date" class="form-control"
				name="exp" placeholder="Password">
		</div>
		<div class="form-group">
			<label>Product Price</label> <input type="number"
				class="form-control" name="price"
				placeholder="Enter the Price of Product">
		</div>
		<div class="form-group">
			<label>Product Quantity</label> <input type="number"
				class="form-control" name="qnty" placeholder="Quantity available">
		</div>
		<input type="submit" class="btn btn-danger mt-4" value="Add">
	</form>
	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h1 class="text-warning"><%=msg%>
	</h1>
	<%
		}
	%>
</body>
</html>