`<%@ page language="java" contentType="text/html; charset=UTF-8"
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
				<a href="https://www.javaguides.net" class="navbar-brand"> Home Management</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Homes</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			
				<c:if test="${House != null}">
					<form action="update" method="post">
				</c:if>
			 	<c:if test="${House == null}"> 
					<form action="insert" method="post">
				</c:if> 

				<caption>
					<h2>
						<c:if test="${House != null}">
            			Edit Home
            		</c:if>
					 	<c:if test="${House == null}">
            			Add New Home
            		</c:if> 
					</h2>
				</caption>

				<c:if test="${House != null}">
					<input type="hidden" name="id" value="<c:out value='${House.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Type</label> <input type="text"
						value="<c:out value='${House.type}' />" class="form-control"
						name="type" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out value='${House.address}' />" class="form-control"
						name="address">
				</fieldset>

				<fieldset class="form-group">
					<label>Description</label> <input type="text"
						value="<c:out value='${House.description}' />" class="form-control"
						name="description">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Price</label> <input type="text"
						value="<c:out value='${House.price}' />" class="form-control"
						name="price">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Phone</label> <input type="text"
						value="<c:out value='${House.phoneNo}' />" class="form-control"
						name="phoneNo">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${House.email}' />" class="form-control"
						name="email">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>