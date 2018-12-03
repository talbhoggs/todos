<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="favicon.ico">

<title>Todos</title>

<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.12/css/all.css"
	integrity="sha384-G0fIWCsCzJIMAVNQPfjH08cyYaUtMwjJwqiRKxxE/rx96Uroj1BtIQ6MLJuheaO9"
	crossorigin="anonymous">
<link href="bootstrap/css/custom.css" rel="stylesheet">

</head>

<body>

	<header>
		<!-- Fixed navbar -->
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
			<a class="navbar-brand" href="#">Todo App</a>
			
			<security:authorize access="hasRole('USER')">
			
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarCollapse" aria-controls="navbarCollapse"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item${action eq 'all' ? ' active' : ''}"><a class="nav-link" href="/all"></i>All</a></li>
					<li class="nav-item${action eq 'active' ? ' active' : ''}"><a class="nav-link" href="active">Active</a></li>
					<li class="nav-item${action eq 'completed' ? ' active' : ''}"><a class="nav-link" href="/completed">Completed</a>
					</li>
				</ul>
			</div>
			
		
			
				

				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#">Hello <security:authentication property="principal.username" /></a></li>
					<li class="nav-item"><a class="nav-link" href="/logout">Sign out</a></li>
				</ul>
				
				</security:authorize>

			

		</nav>

	</header>

	<!-- Begin page content -->
	<div class="container-fluid">
		<br />
		<table class="table table-sm">
			<thead>
				<tr>
					<th>Description</th>
					<th>Created Date</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.description}</td>
						<td>${todo.createdDate}</td>
						<td><a href="/update?id=${todo.id }"><i
								class="fas fa-edit"></i></a> <a href="/delete?id=${todo.id }"><i
								class="fas fa-trash-alt"></a></i> <a href="complete"></a></td>
					</tr>
				</c:forEach>

			</tbody>

		</table>
		<a href="/add" class="btn btn-primary btn-sm" tabindex="-1"
			role="button" aria-disabled="true"> <i class="fas fa-plus-circle"></i>
			Add Todo
		</a>
	</div>

	<footer class="footer">
		<div class="container-fluid">
			<span class="text-muted">Todo App by amperca@ph.ibm.com</span>
		</div>
	</footer>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>
</body>
</html>
