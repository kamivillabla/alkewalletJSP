package service;

import dao.UsuarioDAO;
import model.Cuenta;

public class CuentaService {
    private UsuarioDAO usuarioDAO;

    public CuentaService(UsuarioDAO dao) {
        this.usuarioDAO = dao;
    }

    public void depositar(Cuenta cuenta, int monto) {
        if (monto > 0) {
            cuenta.setSaldo(cuenta.getSaldo() + monto);
            usuarioDAO.actualizarSaldo(cuenta);
        }
    }

    public void retirar(Cuenta cuenta, int monto) throws Exception {
        if (monto > 0 && cuenta.getSaldo() >= monto) {
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            usuarioDAO.actualizarSaldo(cuenta);
        } else {
            throw new Exception("Fondos insuficientes o monto inválido.");
        }
    }
}
