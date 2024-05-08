package controller;

import java.io.IOException;
import dao.UsuarioDAO;
import dao.UsuarioDAOSQL;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Usuario;
import model.Cuenta;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 9195277462080564358L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UsuarioDAO usuarioDAO = new UsuarioDAOSQL();

        try {
            if (usuarioDAO.validarUsuario(email, password)) {
                Usuario usuario = usuarioDAO.obtenerUsuarioPorEmail(email);
                if (usuario != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("usuario", usuario);

                    Cuenta cuenta = usuarioDAO.obtenerCuentaPorUsuarioId(usuario.getId());
                    if (cuenta != null) {
                        session.setAttribute("cuenta", cuenta);
                    }

                    response.sendRedirect("dashboard.jsp");
                } else {
                    request.setAttribute("errorMessage", "Usuario no encontrado.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                request.setAttribute("errorMessage", "Credenciales inválidas.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Error interno: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
