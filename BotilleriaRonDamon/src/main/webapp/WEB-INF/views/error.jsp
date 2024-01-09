<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>error</title>
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
			<li class="nav-item"><a class="nav-link menu" href="logout">Salir</a>
			</li>
		</ul>
	</nav>
	<div class="container my-5">
		<img width="60%" height="100%" src="/img/error.png"
			alt="pagina de error" id="pagerror">
	</div>
	<footer>
		<div class="container-fluid bg-secondary my-3 py-3">
			<p class="text-white text-center">
				CopyRight Derechos Reservados, Chile 2020 - <a href="/contact"
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
	<script type="/js/scripts.js"></script>
</body>
</html>
