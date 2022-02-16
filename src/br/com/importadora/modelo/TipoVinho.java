package br.com.importadora.modelo;

public enum TipoVinho {

	TIPO_VINHO_BRANCO("Vinho Branco"), TIPO_VINHO_TINTO("Vinho Tinto"), TIPO_VINHO_ROSE("Vinho Rosé");

	private String descricao;

	private TipoVinho(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}
