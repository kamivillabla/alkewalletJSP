package dao;

import model.Cuenta;
import model.Usuario;

/**
 * Interfaz que define las operaciones CRUD para el acceso a datos de usuario y cuenta.
 */
public interface UsuarioDAO {
    /**
     * Obtiene un usuario por su dirección de correo electrónico.
     * 
     * @param email La dirección de correo electrónico del usuario.
     * @return El objeto Usuario correspondiente al correo electrónico proporcionado, o null si no se encuentra.
     */
    Usuario obtenerUsuarioPorEmail(String email);

    /**
     * Valida las credenciales de inicio de sesión de un usuario.
     * 
     * @param email       La dirección de correo electrónico del usuario.
     * @param contraseña  La contraseña del usuario.
     * @return true si las credenciales son válidas, false de lo contrario.
     */
    boolean validarUsuario(String email, String contraseña);

    /**
     * Obtiene la cuenta asociada a un usuario por su identificador.
     * 
     * @param usuarioId El identificador único del usuario.
     * @return La cuenta asociada al usuario especificado, o null si no se encuentra.
     */
    Cuenta obtenerCuentaPorUsuarioId(int usuarioId);

    /**
     * Actualiza el saldo de una cuenta.
     * 
     * @param cuenta La cuenta cuyo saldo se actualizará.
     */
    void actualizarSaldo(Cuenta cuenta);
}
