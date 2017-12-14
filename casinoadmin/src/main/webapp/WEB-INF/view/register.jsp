<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%-- <jsp:include page="navigationBar.jsp"></jsp:include>  --%>
	<div>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">		
				<ul class="nav navbar-nav">
					<li><a href="/adminpage">Home</a></li>
					<li class="active"><a href="/registeruser">Register</a></li>
					<li><a href="/getAllUser">User List</a></li>									
				</ul>
				<ul class="nav navbar-nav navbar-right">
				<p class="navbar-text">Welcome to Casino Admin App</p>
				
				</ul>
			</div>
		</nav>
	</div>	
	
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<h2>Fill Details</h2>
			</div>
		</div>		
		<form action="/save" method="post" validate>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">	
			<div class="form-group">
				<label>Name</label>
				 <input type="text"	class="form-control" placeholder="Enter Name" name="name" required>

			</div>
			</div>
		</div>	
			<div class="row">
			<div class="col-md-4 col-md-offset-4">	
			<div class="form-group">
			
				<label>Date Of Birth</label>
	                <div id='datepicker1'>
	                    <input type='date' class="form-control" placeholder="Enter DoB" name="dateOfBirth" max="1999-11-21" required>
	                </div>
	        </div>        
            </div>
            </div>
			
			<div class="row">
				<div class="col-md-4 col-md-offset-4">	
				<div class="form-group">
					<label>Contact</label>
					 <input type="number" class="form-control" placeholder="Enter Contact"name="contact" min="1000000000" max="9999999999" required>
	
				</div>
				</div>
			</div>
			
			<div class="row">
			<div class="col-md-4 col-md-offset-4">	
			<div class="form-group">
				<label for="exampleInputEmail1">Email address</label> 
				<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email" name="email" required>
					
			</div>
			</div>
			</div>
			
			<div class="row">
			<div class="col-md-4 col-md-offset-4">	
			<div class="form-group">
			 <div>
				<label for="image">Identity Proof</label> 
				<input type="file" name="img" id="exampleInputEmail1">
					
			</div>
			</div>
			</div>
			
			<br>
			
			<div class="row">
			<div class="col-md-4 col-md-offset-4">	
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
			</div>
			</div>
			</div>
		</form>

	</div>

</body>

</html>