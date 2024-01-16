<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>modificar</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="/css/estilos.css" rel="stylesheet">
</head>
<body>
	<nav
		class="navbar navbar-expand-sm justify-content-center bg-dark navbar-dark mt-5">
		<!-- Brand/logo -->
		<a class="navbar-brand" id="refrescar" href="/index"><img
			id="logo" src="/img/logo.png" alt="esto es un logos"
			class="rounded-circle"> </a>
		<!-- Links -->
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link menu"
				href="/products/create">Registrar Producto</a></li>
			<li class="nav-item"><a class="nav-link menu"
				href="/products/read_all">Listar</a></li>
			<li class="nav-item"><a class="nav-link menu" href="/contact">Contacto</a>
			</li>			
		</ul>
	</nav>
	<div class="container w-50 my-5">
		<p class="text-center text-primary my-5 display-4 font-italic">Modificar
			Producto
		<p>
			<form:form action="/products/update" method="post" modelAttribute="prod"
				id="frmEditar">
				<div class="form-group">
					<form:label path="name">Nombre</form:label>
					<form:input path="name" cssClass="form-control entradas"
						placeholder="ingrese nombre" id="rtxtNombre" value="${pro.name}" />
					<form:errors path="name" cssClass="error"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="brand">Marca</form:label>
					<form:input path="brand" cssClass="form-control entradas"
						placeholder="ingrese marca" id="rtxtMarca" value="${pro.brand}" />
					<form:errors path="brand" cssClass="error"></form:errors>
				</div>

				<div class="form-group">
					<form:label path="stock">Stock</form:label>
					<form:errors path="stock" cssClass="error"></form:errors>
					<form:input path="stock" placeholder="ingrese stock"
						cssClass="form-control entradas" id="rnumStock"
						value="${pro.stock}" />
				</div>

				<div class="form-group">
					<form:label path="price">Precio</form:label>
					<form:errors path="price" cssClass="error"></form:errors>
					<form:input path="price" placeholder="ingrese precio"
						cssClass="form-control entradas" id="rnumPrecio"
						value="${pro.price}" />
				</div>
				<form:label path="image">Imagen</form:label>
				<form:errors path="image" cssClass="error"></form:errors>
				<div class="input-group mb-3">
					<form:select path="image" cssClass="desplegable inline w-75 h-25 entradas" id="selProducto">
						<form:option value="${pro.image.idImage}" label="${pro.image.name}" />
						<form:options items="${images}" itemValue="idImage" itemLabel="name" />
					</form:select>
					<img class="ml-5" width="35" height="35" id="imgProducto"
						src="/img/${pro.image.name}">
				</div>
				<form:hidden path="idProduct" value="${pro.idProduct}" />
				<form:button class="my-3" id="btnRegistrarProducto">modificar</form:button>
				<form:button class="my-3" id="btnVolver">volver</form:button>
			</form:form>
	</div>
	<footer>
		<div class="container-fluid bg-dark py-3 my-3">
			<p class="text-white text-center">
				CopyRight Derechos Reservados, Chile 2024 - <a href="/contact"
					class="fono">contacto</a>
			</p>
		</div>
	</footer>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="/js/scripts.js"></script>
</body>
</html>
