<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="TODO APP">
<meta name="author" content="amperca@ph.ibm.com">
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
		</nav>
	</header>

	<!-- Begin page content -->
	<div class="container-fluid">

		<br />

		<form:form method="post" modelAttribute="todo">
			
			<div class="form-group">
				<form:label path="description">Description</form:label>
				<form:textarea class="form-control" path="description" id="description" rows="3"></form:textarea>
				<form:errors path="description" cssClass="text-warning"></form:errors>
			</div>

			<div class="btn-toolbar mb-3" role="toolbar"
				aria-label="Toolbar with button groups">
				<div class="btn-group mr-2" role="group" aria-label="First group">
					<a href="/all" class="btn btn-primary btn-sm" tabindex="-1"
						role="button" aria-disabled="true"> <i
						class="fas fa-angle-double-left"></i> Back
					</a>
				</div>
				<div class="input-group">
					<button type="submit" class="btn btn-primary btn-sm">
						<i class="fas fa-plus-circle"></i> Update
					</button>
				</div>
			</div>
			
			<form:hidden path="id"/>
		</form:form>
		
	</div>

	<footer class="footer">
		<div class="container-fluid">
			<span class="text-muted">Spring MVC</span>
		</div>
	</footer>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>
