package model;

/**
 * Representa una cuenta bancaria de usuario en el sistema Alke Wallet.
 * Permite gestionar la información de las cuentas de los usuarios.
 */
public class Cuenta {
    private int id;
    private int usuarioId;
    private int saldo;
    private String moneda;
    private long numeroDeCuenta;

    /**
     * Constructor por defecto para crear una instancia de Cuenta sin inicializar sus campos.
     */
    public Cuenta() {
    }

    /**
     * Obtiene el ID de la cuenta.
     * @return El ID único de la cuenta.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID de la cuenta.
     * @param id El ID único de la cuenta.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el ID del usuario asociado a la cuenta.
     * @return El ID del usuario propietario de la cuenta.
     */
    public int getUsuarioId() {
        return usuarioId;
    }

    /**
     * Establece el ID del usuario asociado a la cuenta.
     * @param usuarioId El ID del usuario propietario de la cuenta.
     */
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    /**
     * Obtiene el saldo actual de la cuenta.
     * @return El saldo de la cuenta.
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo de la cuenta.
     * @param saldo El saldo a establecer en la cuenta.
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtiene la moneda en la que se expresa el saldo de la cuenta.
     * @return La moneda del saldo.
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * Establece la moneda en la que se expresa el saldo de la cuenta.
     * @param moneda La moneda del saldo.
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    /**
     * Obtiene el número de la cuenta asociada al usuario.
     * @return El número de la cuenta.
     */
    public long getNumeroCuentas() {
        return numeroDeCuenta;
    }

    /**
     * Establece el número de la cuenta de usuario.
     * @param numeroDeCuenta El número de la cuenta.
     */
    public void setNumeroCuenta(long numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }
}
