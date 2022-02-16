package br.com.importadora.modelo;

public enum TipoUva {

	UVA_MALBEC("Malbec"), UVA_CABERNET("Cabernet Sauvignon"), UVA_CHARDONNAY("Chardonnay"),
	UVA_SAUVIGNON_BLANC("Sauvignon Blanc");

	private String descricao;

	private TipoUva(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}
