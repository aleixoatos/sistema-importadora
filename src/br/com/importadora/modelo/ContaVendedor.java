package br.com.importadora.modelo;

public class ContaVendedor {

	private Double saldo = 0.0;

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo += Math.round(saldo);
	}

}
