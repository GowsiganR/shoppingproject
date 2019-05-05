<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<title>Product Description</title>
</head>
<body>
<%@ include file="Header.jsp"%>
<table>
<tr>
<td style="text-transform:uppercase;">${product.productName}</td>
</tr>
<tr>
<td  colspan="2" rowspan="2"><img class="img-fluid img-thumbnail" src="<c:url value="/resources/images/${product.productId}.jpg"/>" style="width:200px; height:200px;"></td>
<td>Description:${product.productDescription}</td>
</tr>
<tr>
<td>Price:${product.price}</td>
</tr>
<tr>
<center><td><a href="#" class="btn btn-success btn-xs">Add to Cart</a></td></center>
</table>
</body>
</html>