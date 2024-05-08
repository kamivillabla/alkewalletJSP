<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - Alke Wallet</title>
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css"
	rel="stylesheet" />
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="css/login.css" />
</head>
<body>
	<main
		class="login_container d-flex justify-content-center align-items-center">
		<div id="alert-container" class="alert-container container"></div>
		<form id="loginForm" action="login" method="post"
			class="login_form d-flex flex-column justify-content-center align-items-center rounded-4">
			<i class="login_form-icons bi bi-person"></i>
			<p>Login</p>
			<div
				class="login_form-container-input d-flex justify-content-center align-items-center">
				<i class="bi bi-envelope"></i> <input type="email"
					class="form-control rounded-4" id="email" name="email"
					aria-describedby="emailHelp" placeholder="Ingresa tu correo"
					required />
			</div>
			<div
				class="login_form-container-input d-flex justify-content-center align-items-center">
				<i class="bi bi-lock"></i> <input type="password"
					class="form-control rounded-4" id="password" name="password"
					placeholder="Ingresa tu contraseña" required />
			</div>
			<button type="submit" class="btn rounded-5">Iniciar Sesión</button>
			<a href="">¿Olvidaste tu contraseña?</a>
		</form>
	</main>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script src="js/script.js"></script>
	<script>
    $(document).ready(function() {
        <%if (request.getAttribute("errorMessage") != null) {%>
            showAlert('<%=request.getAttribute("errorMessage")%>
		', 'danger');
	<%}%>
		});
	</script>
</body>
</html>
