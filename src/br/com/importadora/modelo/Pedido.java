package br.com.importadora.modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import br.com.importadora.util.DataUtil;

public class Pedido {

	private Integer numeroPedido;
	private Cliente cliente;
	private Vendedor vendedor;
	private Date data;
	private EnderecoEntrega endereco;
	private Double totalPedido = 0.0;
	private Integer totalGarrafas = 0;
	private Double totalFrete = 0.0;
	private String relatorioPedido = "";
	private List<ItemPedido> itensPedido;

	public Pedido(Integer numeroPedido, Cliente cliente, Vendedor vendedor, Date date, List<ItemPedido> itensPedido) {
		this.numeroPedido = numeroPedido;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.data = date;
		this.itensPedido = itensPedido;
	}

	public Pedido(Integer numeroPedido, Cliente cliente, Vendedor vendedor, Date data, EnderecoEntrega endereco,
			List<ItemPedido> itensPedido) {
		this.numeroPedido = numeroPedido;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.data = data;
		this.endereco = endereco;
		this.itensPedido = itensPedido;
	}

	public Integer getNumeroPedido() {
		return numeroPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public Date getData() {
		return data;
	}

	public Double getTotalPedido() {
		return totalPedido;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	private void informaDadosPedido() {

		String novoPedido = "";

		novoPedido += "Pedido Número: " + this.numeroPedido + "\n";
		novoPedido += "Data: " + DataUtil.formataDataPadraoBrasil(this.data) + "\n";
		novoPedido += "Vendedor: " + vendedor.getNome() + "\n";
		novoPedido += "\nCliente: " + cliente.getNome() + "\n";
		novoPedido += "Telefone: " + cliente.getTelefone() + "\n";
		novoPedido += "E-mail: " + cliente.getEmail() + "\n";

		this.relatorioPedido += novoPedido;
	}

	private void informaDadosItem() {

		String novoItem = "";

		for (ItemPedido pedidoVinho : itensPedido) {
			novoItem += "\nQTD: " + pedidoVinho.getQtd() + " UND\n";
			novoItem += pedidoVinho.getTipo().getDescricao() + "\n";
			novoItem += pedidoVinho.getNome() + "\n";
			novoItem += pedidoVinho.getPais().getDescricao() + "\n";
			novoItem += "Uva " + pedidoVinho.getUva().getDescricao() + "\n";
			novoItem += "Safra de " + pedidoVinho.getSafra() + "\n";
			novoItem += "Valor R$: " + Math.round(pedidoVinho.getPrecoVinho().getDescricao() * pedidoVinho.getQtd())
					+ "\n";
		}

		this.relatorioPedido += novoItem;
	}

	private void informaRelatorioPedido() {
		informaDadosPedido();
		informaDadosItem();
		System.out.println(relatorioPedido);
	}

	private void somaTotalGarrafas() {
		for (ItemPedido qtdVinhos : itensPedido) {
			totalGarrafas += qtdVinhos.getQtd();
		}
	}

	private void verificaQtdGarrafas() {
		if (totalGarrafas > 100) {
			throw new RuntimeException(
					"Estamos com estoque limitado. Por favor, faça um pedido de no máximo 100 garrafas no Total!");
		}
	}

	private void somaTotalPedido() {
		Double vinhoTinto = 0.0;
		Double vinhoBranco = 0.0;
		Double vinhoRose = 0.0;

		for (ItemPedido tipoVinho : itensPedido) {

			if (tipoVinho.getTipo().equals(TipoVinho.TIPO_VINHO_TINTO)) {
				vinhoTinto += tipoVinho.getQtd();
			}

			if (tipoVinho.getTipo().equals(TipoVinho.TIPO_VINHO_BRANCO)) {
				vinhoBranco += tipoVinho.getQtd();
			}

			if (tipoVinho.getTipo().equals(TipoVinho.TIPO_VINHO_ROSE)) {
				vinhoRose += tipoVinho.getQtd();
			}
		}

		this.totalPedido += Math.round(vinhoTinto * TabelaDePrecos.VALOR_VINHO_TINTO.getDescricao());
		this.totalPedido += Math.round(vinhoBranco * TabelaDePrecos.VALOR_VINHO_BRANCO.getDescricao());
		this.totalPedido += Math.round(vinhoRose * TabelaDePrecos.VALOR_VINHO_ROSE.getDescricao());
	}

	private void informaRelatorioTotais() {
		String relatorioTotal = "";
		relatorioTotal += "\nQTD TOTAL DE VINHOS NO PEDIDO: " + totalGarrafas + " UND\n";
		relatorioTotal += "VALOR TOTAL DO PEDIDO R$: " + this.totalPedido + "\n";
		System.out.println(relatorioTotal);
		this.relatorioPedido += relatorioTotal;
	}

	private void calculaDesconto() {
		if (totalGarrafas >= 15) {
			this.totalPedido -= 0.15 * totalPedido;
			System.out.println("Você pediu a partir de 15 garrafas e recebeu um desconto de 15%\n");
		}
	}

	private void geraRelatorio() {
		try {
			FileWriter arquivo = new FileWriter(
					"C:\\Users\\aleixo\\Documents\\ESTUDOS TI\\Curso Java - Allan\\Relarótio Importadora.doc");
			arquivo.write(this.relatorioPedido);
			arquivo.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void cobraFrete() {
		if (this.endereco.getCidade().contains("São Paulo")) {
			this.totalFrete = 0.0;
			System.out.println("\nO Frete para São Paulo será Gratuito!\n");
		} else {
			this.totalFrete = 20.0 * this.totalGarrafas;
			this.totalPedido += this.totalFrete;
			System.out.println("\nSerá cobrado frete de R$ " + this.totalFrete + " referente à entrega de "
					+ this.totalGarrafas + " garrafas na cidade de " + this.endereco.getCidade() + ".");
			System.out.println("O valor total do pedido foi atualizado para R$ " + this.totalPedido + "\n");
		}
	}

	private void pagaComissao() {
		Double comissao = 0.2 * (this.totalPedido - this.totalFrete);
		this.vendedor.getConta().setSaldo(comissao);
		System.out.println("Foi creditado a comissão de R$ " + Math.round(comissao) + " na conta do vendedor "
				+ this.vendedor.getNome() + ", equivalente à 2% do Total da Venda.");
		System.out.println("A comissão total de " + this.vendedor.getNome() + " até agora é de R$ "
				+ this.vendedor.getConta().getSaldo() + "\n");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------\n");
	}

	private void enviaEndereco() {

		try {
			FileWriter endereco = new FileWriter(
					"C:\\Users\\aleixo\\Documents\\ESTUDOS TI\\Curso Java - Allan\\Endereço de Entrega.doc");
			endereco.write("Pedido Número: " + this.numeroPedido + "\n" + DataUtil.formataDataPadraoBrasil(this.data)
					+ "\n" + this.endereco.informaEndereco());
			endereco.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void registraPedido() {
		somaTotalGarrafas();
		verificaQtdGarrafas();
		informaRelatorioPedido();
		somaTotalPedido();
		calculaDesconto();
		informaRelatorioTotais();
		geraRelatorio();
		cobraFrete();
		pagaComissao();
		enviaEndereco();

	}

}
