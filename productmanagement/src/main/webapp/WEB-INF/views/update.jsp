<%@page import="com.te.productmanagement.beans.ProductBean"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String msg=(String) request.getAttribute("msg"); 
    ProductBean infoBean = (ProductBean) request.getAttribute("id");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body  class="bg-dark">
	<jsp:include page="header.jsp" />
	<form acton="./home" method="post" class="container">
		<h2 class="text-danger">Add Product</h2>
		<div class="form-group">
			<label>Product ID</label> <%=infoBean.getPid() %> <input type="hidden" class="form-control"
				name="pid" placeholder="Enter Product ID" value=<%=infoBean.getPid() %>>
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
			<label>Expiry Date</label> <input type="date"
				class="form-control" name="exp" placeholder="Password">
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
		<button type="submit" class="btn btn-primary">Update Product</button>
	</form>
</body>
</html>