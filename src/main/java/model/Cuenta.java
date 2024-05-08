package model;

public class Cuenta {
	private int id;
	private int usuarioId;
	private int saldo;
	private String moneda;
	private long numeroCuentas;
	
	

	public Cuenta() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public long getNumeroCuentas() {
		return numeroCuentas;
	}

	public void setNumeroCuentas(long numeroCuentas) {
		this.numeroCuentas = numeroCuentas;
	}

}
