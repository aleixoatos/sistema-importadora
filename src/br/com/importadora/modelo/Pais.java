package br.com.importadora.modelo;

public enum Pais {

	PAIS_ARGENTINA("Argentino"), PAIS_CHILE("Chileno"), PAIS_BRASIL("Brasileiro");

	private String descricao;

	private Pais(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}
