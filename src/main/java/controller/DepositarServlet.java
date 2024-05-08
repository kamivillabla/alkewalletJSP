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
/**
 * Servlet para manejar el proceso de depósito en una cuenta.
 */
@WebServlet("/depositar")
public class DepositarServlet extends HttpServlet {
    /**
     * El serialVersionUID para la serialización.
     */
    private static final long serialVersionUID = 2928506015880783105L;
    
    /**
     * Servicio para operaciones relacionadas con cuentas.
     */
    private CuentaService cuentaService;

    /**
     * Inicializa el servlet.
     */
    public void init() {
        this.cuentaService = new CuentaService(new UsuarioDAOSQL());
    }

    /**
     * Maneja las solicitudes POST para depositar en una cuenta.
     * 
     * @param request  El objeto HttpServletRequest que contiene la solicitud del cliente.
     * @param response El objeto HttpServletResponse que contiene la respuesta que se enviará al cliente.
     * @throws ServletException Si ocurre un error al manejar la solicitud.
     * @throws IOException      Si ocurre un error de E/S al manejar la solicitud.
     */
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
