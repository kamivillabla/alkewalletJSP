package dao;

import model.Cuenta;
import model.Usuario;

public interface UsuarioDAO {
    Usuario obtenerUsuarioPorEmail(String email);
    boolean validarUsuario(String email, String contraseña);
    Cuenta obtenerCuentaPorUsuarioId(int usuarioId);
    void actualizarSaldo(Cuenta cuenta);  // Añade esta línea
}
