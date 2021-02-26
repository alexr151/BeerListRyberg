<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Edit Beer</title>
</head>
<body>
<div class="container">
<h2>Edit This Beer </h2>
<small class="text-muted">Make changes to the brewery, beer name, or beer type</small>
<br />
<form action = "editBeerServlet" method="post">

<div class="form-group">
	
	<label for="brewery">Brewery:</label><input type ="text" name = "brewery" value= "${beerToEdit.brewery}"><br />

</div>

<div class="form-group">
	<label for="beerName">Beer Name:</label>
	<input type = "text" name = "beerName"  value= "${beerToEdit.beerName}"><br />
</div>

<div class="form-group">
	<label for="beerType">Beer Type:</label>
	<input type = "text" name = "beerType"  value= "${beerToEdit.beerType}"><br />
</div>

<input type = "hidden" name = "id" value="${beerToEdit.id}">
<input type = "submit" value="Save Edited Beer" class="btn btn-primary">

</form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</div>

</body>
</html>