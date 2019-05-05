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
<title>UpdateSupplierPage</title>
</head>
<body>
<%@ include file="Header.jsp"%>
<h4>Update Supplier</h4>
<form method="post" action="<c:url value="/updateSupplierDB/${supplier.supplierId}"/>">
<table class="table table-hover">
<tr>
<td>Supplier Name</td>
<td><input id="supname" name="supname" value="${supplier.supplierName}"/></td>
</tr>
<tr>
<td>Supplier Location</td>
<td><input id="supploc" name="supploc" value="${supplier.supplierLocation}"/></td>
</tr>
<tr>
<td colspan = "2">
<center><input type="submit" class="btn btn-success btn-xs" value="Update"/>
<input type="reset" class="btn btn-danger btn-xs" value="Reset"/></center>
</td>
</tr>
</table>
<div class="container">
<table class="table table-bordered">
<tr style="background-color:#636e72; color:black;">
<td>Supplier ID</td>
<td>Supplier Name</td>
<td>Supplier Location</td>
<td>Operation</td>
</tr>
<c:forEach items="${listSupplier}" var="supplier">
<tr>
<td>${supplier.supplierId}</td>
<td>${supplier.supplierName}</td>
<td>${supplier.supplierLocation}</td>
<td>
<a href="<c:url value="/updateSupplier/${supplier.supplierId}"/>" class="btn btn-success btn-xs">Update</a>
<a href="<c:url value="/deleteSupplier/${supplier.supplierId}"/>" class="btn btn-danger btn-xs">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</div>
</form>
</body>
</html>