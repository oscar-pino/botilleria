<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>listar</title>
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
		<a class="navbar-brand" id="refrescar" href="/index"><img id="logo"
			src="/img/logo.png" alt="esto es un logos" class="rounded-circle">
		</a>
		<!-- Links -->
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link menu" href="/products/create">Registrar Producto</a>
			</li>
			<li class="nav-item"><a class="nav-link menu" href="/products/read_all">Listar</a>
			</li>
			<li class="nav-item"><a class="nav-link menu" href="/contact">Contacto</a>
			</li>
			<c:if test="${size == 0}">
				<li class="nav-item automaticos"><a
					class="nav-link menu text-primary automaticos" id="automatico"
					href="listar">CrearProductosAutomaticamente</a></li>
			</c:if>
		</ul>
	</nav>
<div class="container w-75">
		<c:if test="${size > 0}">		
		
			<p class="text-center text-primary my-5 display-4 font-italic my-3">Productos
				Registrados
			<p>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>Marca</th>
						<th>Stock</th>
						<th>Precio</th>
						<th>Ingreso</th>
						<th>imagen</th>
						<th><input type="checkbox" id="todos" class="mr-2">Todos</input></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${products}" var="p">
						<tr>
							<td>${p.idProduct}</td>
							<td>${p.name}</td>
							<td>${p.brand}</td>
							<td>${p.stock}</td>
							<td>${p.price}</td>							
							<td>${p.admissionDate}</td>
							<td class="bebidas"><img height="35" width="35"
								alt="imagen de bebida"
								src="/img/${p.image.name}"></img></td>
							<td><input type="checkbox" class="input-control items"
								id="${p.idProduct}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<form method="post" action="/products/edit" id="frmCrud" style="font-size: 120%">
				<input type="hidden" id="ids" name="ids" value="nulo" /> <input
					type="button" class="my-3" id="btnModificar" value="modificar" /> <input
					type="button" class="my-3" id="btnEliminar" value="eliminar" />
			</form>
		</c:if>
		<c:if test="${size == 0}">
			<p class="text-center text-danger my-5 display-4 font-italic my-3">
			No Existen Productos Registrados
			<p>
		</c:if>
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
