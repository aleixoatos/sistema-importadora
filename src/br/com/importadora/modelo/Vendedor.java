package br.com.importadora.modelo;

public class Vendedor {

	private Integer codigo;
	private String nome;
	private ContaVendedor conta;

	public Vendedor(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public Vendedor(Integer codigo, String nome, ContaVendedor conta) {
		this.codigo = codigo;
		this.nome = nome;
		this.conta = conta;
	}

	public ContaVendedor getConta() {
		return conta;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

}
