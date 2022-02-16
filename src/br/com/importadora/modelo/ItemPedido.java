package br.com.importadora.modelo;

public class ItemPedido {

	private Integer qtd;
	private String nome;
	private TipoVinho tipo;
	private TipoUva uva;
	private Integer safra;
	private Pais pais;
	private TabelaDePrecos precoVinho;

	public ItemPedido(Integer qtd, String nome, TipoVinho tipo, TipoUva uva, Integer safra, Pais pais,
			TabelaDePrecos precoVinho) {
		this.qtd = qtd;
		this.nome = nome;
		this.tipo = tipo;
		this.uva = uva;
		this.safra = safra;
		this.pais = pais;
		this.precoVinho = precoVinho;
	}

	public Integer getQtd() {
		return qtd;
	}

	public String getNome() {
		return nome;
	}

	public TipoVinho getTipo() {
		return tipo;
	}

	public TipoUva getUva() {
		return uva;
	}

	public Integer getSafra() {
		return safra;
	}

	public Pais getPais() {
		return pais;
	}

	public TabelaDePrecos getPrecoVinho() {
		return precoVinho;
	}

}
