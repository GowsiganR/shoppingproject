<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstarp.min.js"></script>
<title>Product</title>
</head>
<body>
<%@ include file="Header.jsp"%>
<div class="container">
<table>
<tr>
<c:forEach items="${listProducts}" var="product">
<td>
<c:choose>
  <c:when test="${product.stock>0}">
    <a href="<c:url value="/ProductDescription/${product.productId}"/>"><img class="img-fluid img-thumbnail" src="<c:url value="/resources/images/${product.productId}.jpg"/>" style="width:200px; height:200px;"></a>
 Stock:${product.stock}
  </c:when>
  <c:otherwise>
  <img class="img-fluid img-thumbnail" src="<c:url value="/resources/images/${product.productId}.jpg"/>" style="width:200px; height:200px;">
 <font color="#b2bec3">Out of Stock</font>
  </c:otherwise>
</c:choose>
</td>
</c:forEach>
</tr>
</table>
</div>
</body>
</html>