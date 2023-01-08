<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>House Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
 <header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Home
					Management </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Homes</a></li>
			</ul>
		
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Homes...</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Home</a>
			</div>
			<br>
			
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Type</th>
						<th>Address</th>
						<th>Description</th>
						<th>Price</th>
						<th>Phone</th>
						<th>Email</th>
						<th>Actions</th>
						
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="house" items="${houselist}">
					<c:set var ="houseId" value = "${house.id}"/>
						<tr>
							<td><c:out value="${house.id}" /></td>  
							<td><c:out value="${house.type}" /></td>
							<td><c:out value="${house.address}" /></td>
							<td><c:out value="${house.description}" /></td>
							<td><c:out value="${house.price}" /></td>
							<td><c:out value="${house.phoneNo}" /></td>
							<td><c:out value="${house.email}" /></td>

							<td><a href="edit?id=<c:out value='${house.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="delete?id=<c:out value='${house.id}' />">Delete</a></td>
						
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>