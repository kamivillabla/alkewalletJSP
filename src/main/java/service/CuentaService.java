package service;

import dao.UsuarioDAO;
import model.Cuenta;

/**
 * La clase CuentaService proporciona métodos para realizar operaciones de depósito y retiro en una cuenta.
 */
public class CuentaService {
    private UsuarioDAO usuarioDAO;

    /**
     * Constructor de la clase CuentaService.
     *
     * @param dao el objeto UsuarioDAO utilizado para actualizar el saldo de la cuenta
     */
    public CuentaService(UsuarioDAO dao) {
        this.usuarioDAO = dao;
    }

    /**
     * Realiza un depósito en la cuenta especificada.
     *
     * @param cuenta la cuenta en la que se realizará el depósito
     * @param monto el monto a depositar
     */
    public void depositar(Cuenta cuenta, int monto) {
        if (monto > 0) {
            cuenta.setSaldo(cuenta.getSaldo() + monto);
            usuarioDAO.actualizarSaldo(cuenta);
        }
    }

    /**
     * Realiza un retiro de la cuenta especificada.
     *
     * @param cuenta la cuenta de la que se realizará el retiro
     * @param monto el monto a retirar
     * @throws Exception si hay fondos insuficientes o el monto es inválido
     */
    public void retirar(Cuenta cuenta, int monto) throws Exception {
        if (monto > 0 && cuenta.getSaldo() >= monto) {
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            usuarioDAO.actualizarSaldo(cuenta);
        } else {
            throw new Exception("Fondos insuficientes o monto inválido.");
        }
    }
}
