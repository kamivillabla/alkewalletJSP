<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard - Alke Wallet</title>
</head>
<body>
    <h1>Dashboard</h1>
    <%
    model.Usuario usuario = (model.Usuario) session.getAttribute("usuario");
    model.Cuenta cuenta = (model.Cuenta) session.getAttribute("cuenta");
    String error = (String) session.getAttribute("error");
    session.removeAttribute("error");  // Limpiar el mensaje de error después de mostrarlo
    if (usuario != null && cuenta != null) {
        if (error != null && !error.isEmpty()) {
            out.println("<p style='color: red;'>" + error + "</p>");
        }
    %>
        <h3>Bienvenido/a, <%= usuario.getNombre() %>!</h3>
        <p>Tu número de cuenta es: <%= cuenta.getNumeroCuentas() %></p>
        <p>Tu saldo es: $<%= cuenta.getSaldo() %> <%= cuenta.getMoneda() %></p>

        <form action="depositar" method="post">
            <label for="montoDeposito">Monto a depositar:</label>
            <input type="number" id="montoDeposito" name="monto" min="10" required>
            <button type="submit">Depositar</button>
        </form>

        <form action="retirar" method="post">
            <label for="montoRetiro">Monto a retirar:</label>
            <input type="number" id="montoRetiro" name="monto" min="10" required>
            <button type="submit">Retirar</button>
        </form>

    <% 
    } else {
        response.sendRedirect("login.jsp");
    }
    %>
</body>
</html>
