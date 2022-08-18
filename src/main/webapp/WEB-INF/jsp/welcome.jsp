<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<c:url value="/js/jquery-3.6.0.min.js" var="jqueryJs" />
<script type="text/javascript" src="${jqueryJs}"></script>
<c:url value="/js/jquery-ui.min.js" var="jqueryUiJs" />
<script type="text/javascript" src="${jqueryUiJs}"></script>
<c:url value="/js/moment.js" var="momentJs" />
<script type="text/javascript" src="${momentJs}"></script>
<link rel="stylesheet" type="text/css"	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<c:url value="/js/app.js" var="appJs" />
<script type="text/javascript" src="${appJs}"></script>

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Employee Demo</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<h1>Employee Demo Web JSP Example</h1>
			<button id ="get" type="button" class="btn btn-info">Get</button>
			<button id ="create" type="button" class="btn btn-info">Create</button>
			<button id ="put" type="button" class="btn btn-info">Update</button>
			<button id ="delete" type="button" class="btn btn-info">Delete</button>
			<button id ="deleteAll" type="button" class="btn btn-info">deleteAll</button>
			<button id ="fetchAll" type="button" class="btn btn-info">FetchAll</button>
			<button id ="search" type="button" class="btn btn-info">Search</button>			
		</div>
		<div id="emp-get" >
			<form name="get">
				<div class="form-group">
					<label for="emp-get-id">EmployeeId</label> <input type="text"
						class="form-control" id="emp-get-id" pattern="[0-9]+" maxlength="10"
						placeholder="ex:123455">
				</div>			
				<div class="form-group">
					<input id="btn-info" class="btn btn-primary"  type="button" onclick="onGetSubmit(this);" value="Info">
					<input id="btn-delete" class="btn btn-primary" type="button" onclick="onDeleteSubmit(this);" value="Delete">
					<input class="btn btn-primary" type="reset" value="Reset">					
				</div>

			</form>
		</div>
		<div id="emp-cre" >
			<form name="create">
				<div class="form-group">
					<label for="emp-id">EmployeeId</label> <input type="text"
						class="form-control" id="emp-id" pattern="[0-9]+" maxlength="10"
						placeholder="ex:123455">
				</div>
				<div class="form-group">
					<label for="no">EmployeeNo</label> <input type="text"
						class="form-control" id="no" pattern="[0-9]+" maxlength="10"
						placeholder="ex:123455">
				</div>
				<div class="form-group">
					<label for="name">EmployeeName</label> <input type="text"
						class="form-control" id="name" pattern="[\w\s]+" maxlength="100"
						placeholder="Enter Name">
				</div>
				<div class="form-group">
					<label for="dateOfJoin">DateOfJoin</label> <input type="date"
						class="form-control" id="dateOfJoin"  maxlength="10" class="datepicker" data-date-format="dd/mm/yyyy"
						placeholder="DD/MM/YYYY">
				</div>
				<div class="form-group">
					<label for="depCode">select</label> <select class="form-control"
						id="depCode" placeholder="Select Department" >						
					</select>
				</div>
				<div class="form-group">
					<label for="salary">Salary</label> <input type="text"
						class="form-control" id="salary" pattern="[0-9]+" maxlength="10"
						placeholder="ex:123455">
				</div>
				<div class="form-group">
					<input id="emp-cre-sub" class="btn btn-primary" type="button" onclick="onCreateSubmit(this);" value="Submit">
					<input id="emp-upd-sub" class="btn btn-primary" type="button" onclick="onUpdateSubmit(this);" value="Submit">					
					<input class="btn btn-primary" type="reset" value="Reset">
				</div>

			</form>
		</div>

		<div id="emp-search" >
			<form name="search">
				<div class="form-group">
					<label for="emp-search-no">EmployeeNo</label> <input type="text"
						class="form-control" id="emp-search-no" pattern="[0-9]+" maxlength="10"
						placeholder="ex:123455">
				</div>
				<div class="form-group">
					<label for="emp-search-name">EmployeeName</label> <input type="text"
						class="form-control" id="emp-search-name" pattern="[\w\s]+" maxlength="100"
						placeholder="Enter Name">
				</div>
				
				<div class="form-group">
					<input class="btn btn-primary" type="button" onclick="onSearchSubmit(this);" value="Submit">
					<input class="btn btn-primary" type="reset" value="Reset">
				</div>

			</form>
		</div>
		<div id="emp-tab" class="container mt-3">     
        <table class="table">
            <thead>
                <tr>
                    <th>#</th>
                    <th>EmployeeNo</th>
                    <th>Name</th>
                    <th>DateOfJoining</th>
                    <th>DepartMent</th>
                    <th>Salary</th>                    
                </tr>
            </thead>
            <tbody>                
            </tbody>
        </table>    
		</div>

	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
