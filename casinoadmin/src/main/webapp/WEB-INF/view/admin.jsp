<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<title>Admin page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>

<body>
	<%-- <jsp:include page="navigationBar.jsp"></jsp:include> --%>
		<div>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">		
				<ul class="nav navbar-nav">
					<li class="active"><a href="/adminpage">Home</a></li>
					<li><a href="/registeruser">Register</a></li>
					<li><a href="/getAllUser">User List</a></li>									
				</ul>
				<ul class="nav navbar-nav navbar-right">
				<p class="navbar-text">Welcome to Casino Admin App</p>
				
				</ul>
			</div>
		</nav>
	</div>
	<div class="container">
		<img style="width:100%; height:80%" src="./image/imageAdmin.jpg" />
	</div>
	
</body>
</html>