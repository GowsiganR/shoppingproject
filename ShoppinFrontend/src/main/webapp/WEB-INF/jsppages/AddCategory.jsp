<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstarp.min.js"></script>
<title>Category</title>
</head>
<body>
<%@ include file="Header.jsp"%>
<h4>Category Page</h4>
    <form class="form-inline" action="AddCategory" method="post">
    <table class="table table-hover">
    <tr>
<td>Category Name</td>
<td><input name="name"/></td>
</tr>
<tr>
<td>Category Description</td>
<td><input name="catdescription"/></td>
</tr>
<tr>
<td colspan = "2">
<center><input type="submit" class="btn btn-success btn-xs" value="Add"/>
<input type="reset" class="btn btn-danger btn-xs" value="Reset"/></center>
</td>
</tr>
</table>

<br><br>
<div class="container">
	   <table class="table table-bordered">
<tr style="background-color:grey; color:white;">
<td>Category ID</td>
<td>Category Name</td>
<td>Category Description</td>
<td>Operation</td>
</tr>
<c:forEach items="${listCategories}" var="category">
<tr>
<td>${category.categoryId}</td>
<td>${category.categoryName}</td>
<td>${category.categoryDescription}</td>
<td>
<a href="<c:url value="/updateCategory/${category.categoryId}"/>" class="btn btn-success btn-xs">UPDATE</a>
<a href="<c:url value="/deleteCategory/${category.categoryId}"/>" class="btn btn-danger btn-xs">DELETE</a>
</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>