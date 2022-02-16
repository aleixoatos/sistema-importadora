package br.com.importadora.modelo;

public enum TabelaDePrecos {

	VALOR_VINHO_BRANCO(95.60), VALOR_VINHO_TINTO(139.90), VALOR_VINHO_ROSE(79.80);

	private Double descricao;

	private TabelaDePrecos(Double descricao) {
		this.descricao = descricao;
	}

	public Double getDescricao() {
		return this.descricao;
	}

}
