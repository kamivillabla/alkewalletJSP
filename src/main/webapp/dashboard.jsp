<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard - Alke Wallet</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/dashboard.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row vh-100">
			<header
				class="col-md-3 col-lg-2 d-md-block sidebar d-flex justify-content-center">
				<input type="checkbox" id="nav-toggle" class="nav-toggle"> <label
					for="nav-toggle" class="nav-toggle-label outside"> <i
					class="bi bi-list"></i> <i class="bi bi-x"></i>
				</label>
				<nav
					class="position-sticky nav d-flex flex-column align-items-center"
					style="top: 0">
					<div class="nav__brand">KV</div>
					<hr class="nav__hr">
					<ul class="d-flex flex-column gap-5 mt-4 nav__list">
						<li><a href=""><img src="icons/home.svg" alt="icons casa"
								class="me-3" /><span>Home</span></a></li>
						<li><a href=""><img src="icons/depositar.svg"
								alt="Icons de depositar" class="me-3" /><span>Depositar</span></a></li>
						<li><a href=""><img src="icons/transferir.svg"
								alt="Icons transferir" class="me-3" /><span>Transferir</span></a></li>
						<li><a href=""><img src="icons/transacciones.svg"
								alt="Icons de transaccion" class="me-3" /><span>Movimientos</span></a></li>
					</ul>
				</nav>
			</header>

			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div class="pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Dashboard</h1>
				</div>
				<%
				model.Usuario usuario = (model.Usuario) session.getAttribute("usuario");
				model.Cuenta cuenta = (model.Cuenta) session.getAttribute("cuenta");
				String error = (String) session.getAttribute("error");
				session.removeAttribute("error"); 
				if (usuario != null && cuenta != null) {
					if (error != null && !error.isEmpty()) {
						out.println("<p style='color: red;'>" + error + "</p>");
					}
				%>
				<div class="my-card rounded-4">
					<h2>Mi tarjeta</h2>
					<div class="my-card__credit-card">
						<div class="credit-card__logo">VISA</div>
						<div class="credit-card__balance" id="saldo-actual">
							$<%=cuenta.getSaldo()%>
						</div>
						<div class="credit-card__number">
							<span><%=cuenta.getNumeroCuentas()%></span>
						</div>
						<div
							class="credit-card__info d-flex justify-content-between w-100">
							<div class="credit-card__holder">
								<span>Titular</span>
								<%=usuario.getNombre() + " " + usuario.getApellido()%>

							</div>
							<div class="credit-card__expires">
								<span>Expires</span>01/30
							</div>
						</div>
					</div>
				</div>
				<div class="d-flex flex-md-row flex-column gap-5">
				<div class="my-card rounded-4 my-card-depositAndRemoval">
					<h2>Deposita</h2>
					<form action="depositar" method="post" class="d-flex flex-column gap-5">
						<input
							type="number" id="montoDeposito" name="monto" min="10" placeholder="Ingresa el monto a depositar" class="form-select rounded-4" required>
						<button type="submit" class="btn rounded-5 button">Depositar</button>
					</form>

				</div>
				<div class="my-card rounded-4 my-card-depositAndRemoval" >
					<h2>Retira</h2>
					<form action="retirar" method="post" class="d-flex flex-column gap-5">
						<input
							type="number" id="montoRetiro" name="monto" min="10" placeholder="Ingresa el monto a retirar" class="form-select rounded-4" required>
						<button type="submit" class="btn rounded-5 button">Retirar</button>
					</form>

				</div>
				</div>
				<%
				} else {
				response.sendRedirect("login.jsp");
				}
				%>
			</main>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script src="js/script.js"></script>
</body>
</html>
