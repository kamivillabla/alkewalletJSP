package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cuenta;
import service.CuentaService;
import dao.UsuarioDAOSQL;

import java.io.IOException;

@WebServlet("/depositar")
public class DepositarServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2928506015880783105L;
	private CuentaService cuentaService;

    public void init() {
        this.cuentaService = new CuentaService(new UsuarioDAOSQL());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cuenta cuenta = (Cuenta) session.getAttribute("cuenta");
        String montoStr = request.getParameter("monto");
        try {
            int monto = Integer.parseInt(montoStr);
            cuentaService.depositar(cuenta, monto);
            session.setAttribute("cuenta", cuenta);
        } catch (NumberFormatException e) {
            session.setAttribute("error", "Por favor, ingrese un número válido.");
        }
        response.sendRedirect("dashboard.jsp");
    }
}

