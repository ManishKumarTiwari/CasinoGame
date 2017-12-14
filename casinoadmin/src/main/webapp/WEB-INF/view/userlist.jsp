<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	 <%-- <jsp:include page="navigationBar.jsp"></jsp:include> --%>
	 <div>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">		
				<ul class="nav navbar-nav">
					<li><a href="/adminpage">Home</a></li>
					<li><a href="/registeruser">Register</a></li>
					<li class="active"><a href="/getAllUser">User List</a></li>									
				</ul>
				<ul class="nav navbar-nav navbar-right">
				<p class="navbar-text">Welcome to Casino Admin App</p>
				
				</ul>
			</div>
		</nav>
	</div>	
	
	<div class="container">
	<br>
	<br>
		<form class="form-inline" action="/getSearchedUser" method="post">
			<div class="form-group">
				<label >Name</label> 
				<input  type="text"
					class="form-control" 
					 name="name">
					 
			</div>
			<div class="form-group">
				<label >Contact</label> <input type="text"
					class="form-control" 
					name="contact" />
			</div>
			
			<div class="form-group">
				<label for="email">Email:</label>
					 <input type="text"class="form-control" id="email" name="email">					
			</div>
					
			<button type="submit" class="btn btn-default">Search</button>
		</form>
		
			<br>
			<hr>
			<br>
			<br>
			<div>
				<table class="table">
				    <thead>
				      <tr>
				        <th>SNo.</th>
				        <th>Name</th>
				        <th>DOB</th>
				        <th>Contact</th>
				        <th>Email</th>
				        <th>Balance(in Rs)</th>
				        <th>Recharge</th>				        				        
				      </tr>
				    </thead>
				    
				    <tbody>
				    <c:forEach items ="${customer}" var = "customerItem" varStatus="ind">	      			      	
				      <tr>
				        <td>${ind.index+1}</td>
				        <td>${customerItem.name}</td>
				        <td>${customerItem.dateOfBirth}</td>
				        <td>${customerItem.contact}</td>
				        <td>${customerItem.email}</td>		        
				        <td>${customerItem.balance}</td>
				        <!-- 
				       		<button type="button" class="btn btn-xs btn-danger">
  								<span class="glyphicon glyphicon-plus"></span>&nbsp;
							</button> -->
							<td><input type="image" data-toggle="modal"
								data-target="#myModal${customerItem.id}" style="height: 20px; width: 20px;"
								src="./image/buttonimages.png" />
								<div class="modal fade" id="myModal${customerItem.id}" role="dialog">
									<div class="modal-dialog">

										<!--  Modal content -->
										<div class="modal-content">

											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">Recharge Balance for: ${customerItem.name}</h4>
											</div>
											<div class="modal-body">
												<form class="form-inline" action="/recharge" method="post">
													<div class="form-group">
														
														<label>Amount in Rs</label> <input type="number"
															class="form-control" required name="balance">															
															<input type="hidden" name="id" value="${customerItem.id}">
													</div>
													<button type="submit" class="btn btn-default"
														>Recharge</button>
												</form>
											</div>
										</div>
									</div>
								</div>
							</td>
				      </tr>
					</c:forEach>		
				    </tbody>
				  </table>
				</div>			
	</div>
</body>
</html>