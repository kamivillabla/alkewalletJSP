package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cuenta;
import service.CuentaService;

import java.io.IOException;
import dao.UsuarioDAOSQL;

@WebServlet("/retirar")
public class RetirarServlet extends HttpServlet {
    private static final long serialVersionUID = 3744107470811054392L;

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
            cuentaService.retirar(cuenta, monto);
            session.setAttribute("cuenta", cuenta);
        } catch (NumberFormatException e) {
            session.setAttribute("error", "Por favor, ingrese un número válido.");
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
        }
        response.sendRedirect("dashboard.jsp");
    }
}