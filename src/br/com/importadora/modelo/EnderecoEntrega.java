package br.com.importadora.modelo;

public class EnderecoEntrega {

	private Cliente cliente;
	private String rua;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;

	public EnderecoEntrega(Cliente cliente, String rua, Integer numero, String complemento, String bairro,
			String cidade, String estado, String cep) {
		this.cliente = cliente;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getRua() {
		return rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getCep() {
		return cep;
	}

	public String informaEndereco() {
		String end = "";
		end += "Cliente: " + this.cliente.getNome() + "\n";
		end += "\nEndereço de Entrega: \n" + this.rua + ", " + this.numero + ".\n";
		end += this.bairro + ". " + this.cidade + ". " + this.estado + ".\n";
		end += "CEP " + this.cep + "\n";

		return end;
	}

}
