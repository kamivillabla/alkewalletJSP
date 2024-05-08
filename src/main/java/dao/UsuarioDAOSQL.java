package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DBConnection;
import model.Cuenta;
import model.Usuario;

public class UsuarioDAOSQL implements UsuarioDAO {
	@Override
	public Usuario obtenerUsuarioPorEmail(String email) {
	    String sql = "SELECT id, nombre, email, contraseña, rut FROM usuarios WHERE email = ?";
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, email);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            Usuario usuario = new Usuario();
	            usuario.setId(rs.getInt("id"));
	            usuario.setNombre(rs.getString("nombre"));
	            usuario.setEmail(rs.getString("email"));
	            usuario.setContraseña(rs.getString("contraseña"));
	            usuario.setRut(rs.getString("rut"));
	            return usuario;
	        }
	    } catch (SQLException e) {
	        System.err.println("Error de SQL: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return null;
	}


    @Override
    public boolean validarUsuario(String email, String contraseña) {
        String sql = "SELECT 1 FROM usuarios WHERE email = ? AND contraseña = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, contraseña);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Retorna true si hay al menos un resultado
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public Cuenta obtenerCuentaPorUsuarioId(int usuarioId) {
        String sql = "SELECT id, usuario_id, saldo, moneda, numeroCuentas FROM cuentas WHERE usuario_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setId(rs.getInt("id"));
                cuenta.setUsuarioId(rs.getInt("usuario_id"));
                cuenta.setSaldo(rs.getInt("saldo"));
                cuenta.setMoneda(rs.getString("moneda"));
                cuenta.setNumeroCuentas(rs.getLong("numeroCuentas"));  
                return cuenta;
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    public void actualizarSaldo(Cuenta cuenta) {
        String sql = "UPDATE cuentas SET saldo = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cuenta.getSaldo());
            stmt.setInt(2, cuenta.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar saldo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}