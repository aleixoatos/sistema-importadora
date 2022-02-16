package br.com.importadora.teste;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.importadora.Importadora;
import br.com.importadora.modelo.Cliente;
import br.com.importadora.modelo.ContaVendedor;
import br.com.importadora.modelo.EnderecoEntrega;
import br.com.importadora.modelo.ItemPedido;
import br.com.importadora.modelo.Pais;
import br.com.importadora.modelo.Pedido;
import br.com.importadora.modelo.TabelaDePrecos;
import br.com.importadora.modelo.TipoUva;
import br.com.importadora.modelo.TipoVinho;
import br.com.importadora.modelo.Vendedor;

public class ImportadoraTeste {

	public static void main(String[] args) {

		testaRegra1();
		/*
		 * RN1 - O sistema deve registrar os pedidos dos clientes, informando os
		 * seguintes dados: Número do Pedido, Data, Nome Vendedor, Nome Cliente,
		 * Telefone, E-mail, QTD garrafas, Tipo de Vinho, Nome do Vinho, País do Vinho,
		 * Uva do Vinho, Safra do Vinho e Valor do vinho. OBS: Se for pedido mais de 1
		 * garrafa do mesmo vinho, o valor unitário deve ser multiplicado pela
		 * quantidade de garrafas.
		 */

		// testaRegra2();
		/*
		 * RN2 - Estamos com a entrega limitada por conta da pandemia, então o sistema
		 * deve rejeitar pedidos com mais de 100 garrafas.
		 */

		// testaRegra3();
		/*
		 * RN3 - Ao registrar o pedido, o sistema deve calcular e informar no final, a
		 * soma total do número de garrafas e a soma total do valor do pedido,
		 * independente do tipo de vinho solicitado.OBS: O valor Total deve ser
		 * arredondado.
		 */

		// testaRegra4();
		/*
		 * RN4 Se um cliente comprar a partir de 15 vinhos, deve ser concedido um
		 * desconto de 10% sobre o valor total daquele pedido.
		 */

		// testaRegra5();
		/*
		 * RN5 O Sistema deve gerar um relatório de venda em arquivo .doc com: Número do
		 * Pedido, Data Pedido, Nome do Vendedor, Nome do cliente, Telefone Cliente,
		 * Email Cliente, Ítens do Pedido e Valor Total do pedido.
		 */

		// testaRegra6();
		/*
		 * RN6 Para entregas fora da cidade de São Paulo, deve ser cobrado R$ 20 de
		 * frete por garrafa. O valor deve ser somado ao valor total do pedido e
		 * informado no ato do pedido.
		 */

		// testaRegra7();
		/*
		 * RN6 O sistema deve informar quem foi o vendedor, creditar em sua conta uma
		 * comissão de 2% sobre o total de cada venda, e atualizar a comissão total a
		 * cada venda realizada. ATENÇÃO: a comissão do vendedor deve ser calculada
		 * somente sobre o valor total de produtos vendidos, devendo ser excluído o
		 * valor de frete na hora de calcular a comissão.
		 */

		// testaRegra8();
		/*
		 * RN8 O sistema deve enviar um relatório em arquivo .doc para a logística ao
		 * final do dia, com o endereço de entrega dos pedidos emitidos.
		 */
	}

	public static void testaRegra1() {

		ItemPedido vinhoLosBoldosCabernet = new ItemPedido(2, "Los Boldos Cabernet", TipoVinho.TIPO_VINHO_TINTO,
				TipoUva.UVA_CABERNET, 2016, Pais.PAIS_CHILE, TabelaDePrecos.VALOR_VINHO_TINTO);

		List<ItemPedido> itensPedido = new ArrayList<>();
		itensPedido.add(vinhoLosBoldosCabernet);

		Cliente cliente = new Cliente("Norberto", "11 97777-7080", "norberto@email.com.br");
		Vendedor vendedor = new Vendedor(0013, "Douglas");

		Pedido pedido = new Pedido(1002, cliente, vendedor, new Date(), itensPedido);

		Importadora novaCompra = new Importadora();
		novaCompra.pedidoVinho(pedido);
	}

	public static void testaRegra2() {

		ItemPedido vinhoPortilloMalbec = new ItemPedido(95, "Portillo Malbec", TipoVinho.TIPO_VINHO_TINTO,
				TipoUva.UVA_MALBEC, 2019, Pais.PAIS_ARGENTINA, TabelaDePrecos.VALOR_VINHO_TINTO);
		ItemPedido vinhoDonAbelChardonnay = new ItemPedido(6, "Don Abel Chardonnay", TipoVinho.TIPO_VINHO_BRANCO,
				TipoUva.UVA_CHARDONNAY, 2018, Pais.PAIS_BRASIL, TabelaDePrecos.VALOR_VINHO_BRANCO);

		List<ItemPedido> itensPedido = new ArrayList<>();
		itensPedido.add(vinhoPortilloMalbec);
		itensPedido.add(vinhoDonAbelChardonnay);

		Cliente cliente = new Cliente("Mário", "11 98888-3040", "mario@email.com.br");
		Vendedor vendedor = new Vendedor(0010, "Alexandre");

		Pedido pedido = new Pedido(1001, cliente, vendedor, new Date(), itensPedido);

		Importadora novaCompra = new Importadora();

		try {

			novaCompra.pedidoVinho(pedido);

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());

		}
	}

	public static void testaRegra3() {

		ItemPedido vinhoPortilloRose = new ItemPedido(38, "Portillo Rose", TipoVinho.TIPO_VINHO_ROSE,
				TipoUva.UVA_MALBEC, 2014, Pais.PAIS_ARGENTINA, TabelaDePrecos.VALOR_VINHO_ROSE);
		ItemPedido vinhoDonAbelCabernet = new ItemPedido(12, "Don Abel Cabernet", TipoVinho.TIPO_VINHO_TINTO,
				TipoUva.UVA_CABERNET, 2012, Pais.PAIS_BRASIL, TabelaDePrecos.VALOR_VINHO_TINTO);
		ItemPedido vinhoRutiniReserva = new ItemPedido(23, "Rutini Reserva", TipoVinho.TIPO_VINHO_TINTO,
				TipoUva.UVA_MALBEC, 2018, Pais.PAIS_ARGENTINA, TabelaDePrecos.VALOR_VINHO_TINTO);

		List<ItemPedido> itensPedido = new ArrayList<>();
		itensPedido.add(vinhoPortilloRose);
		itensPedido.add(vinhoDonAbelCabernet);
		itensPedido.add(vinhoRutiniReserva);

		Cliente cliente = new Cliente("Ricardo", "11 96666-1213", "ricardo@email.com.br");
		Vendedor vendedor = new Vendedor(0014, "Joares");

		Pedido pedido = new Pedido(1003, cliente, vendedor, new Date(), itensPedido);

		Importadora novaCompra = new Importadora();

		try {

			novaCompra.pedidoVinho(pedido);

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());

		}
	}

	public static void testaRegra4() {

		ItemPedido vinhoTraditionRose = new ItemPedido(30, "Tradition Rose", TipoVinho.TIPO_VINHO_ROSE,
				TipoUva.UVA_MALBEC, 2010, Pais.PAIS_CHILE, TabelaDePrecos.VALOR_VINHO_ROSE);
		ItemPedido vinhoDonAbelMalbec = new ItemPedido(30, "Don Abel Malbec", TipoVinho.TIPO_VINHO_TINTO,
				TipoUva.UVA_MALBEC, 2009, Pais.PAIS_BRASIL, TabelaDePrecos.VALOR_VINHO_TINTO);
		ItemPedido vinhoCalliaChardonnay = new ItemPedido(30, "Callia Chardonnay", TipoVinho.TIPO_VINHO_BRANCO,
				TipoUva.UVA_CHARDONNAY, 2020, Pais.PAIS_ARGENTINA, TabelaDePrecos.VALOR_VINHO_BRANCO);
		ItemPedido vinhoMáscaraSauvignonBlanc = new ItemPedido(10, "Máscara Sauvignon Blanc",
				TipoVinho.TIPO_VINHO_BRANCO, TipoUva.UVA_SAUVIGNON_BLANC, 2022, Pais.PAIS_CHILE,
				TabelaDePrecos.VALOR_VINHO_BRANCO);

		List<ItemPedido> itensPedido = new ArrayList<>();
		itensPedido.add(vinhoTraditionRose);
		itensPedido.add(vinhoDonAbelMalbec);
		itensPedido.add(vinhoCalliaChardonnay);
		itensPedido.add(vinhoMáscaraSauvignonBlanc);

		Cliente cliente = new Cliente("Tadeu", "11 94444-0102", "tadeu@email.com.br");
		Vendedor vendedor = new Vendedor(0021, "Beto");

		Pedido pedido = new Pedido(1004, cliente, vendedor, new Date(), itensPedido);

		Importadora novaCompra = new Importadora();

		try {

			novaCompra.pedidoVinho(pedido);

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());

		}
	}

	public static void testaRegra5() {

		ItemPedido vinhoPyrosRose = new ItemPedido(14, "Pyros Rose", TipoVinho.TIPO_VINHO_ROSE,
				TipoUva.UVA_SAUVIGNON_BLANC, 2021, Pais.PAIS_ARGENTINA, TabelaDePrecos.VALOR_VINHO_ROSE);

		List<ItemPedido> itensPedido = new ArrayList<>();
		itensPedido.add(vinhoPyrosRose);

		Cliente cliente = new Cliente("Romeu", "11 82333-0709", "romeu@email.com.br");
		Vendedor vendedor = new Vendedor(0034, "Toninho");

		Pedido pedido = new Pedido(1005, cliente, vendedor, new Date(), itensPedido);

		Importadora novaCompra = new Importadora();

		try {

			novaCompra.pedidoVinho(pedido);

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());

		}
	}

	public static void testaRegra6() {

		Cliente cliente = new Cliente("Joana", "11 72644-6673", "joana@email.com.br");

		ItemPedido vinhoDomusAurea = new ItemPedido(15, "Domus Áurea", TipoVinho.TIPO_VINHO_TINTO, TipoUva.UVA_CABERNET,
				2002, Pais.PAIS_CHILE, TabelaDePrecos.VALOR_VINHO_TINTO);

		List<ItemPedido> itensPedido = new ArrayList<>();
		itensPedido.add(vinhoDomusAurea);

		EnderecoEntrega endereco = new EnderecoEntrega(cliente, "Av. Copacabana", 777, "APTO 144", "Copacabana",
				"Rio de Janeiro", "RJ", "01130-000");

		Vendedor vendedor = new Vendedor(0067, "Gilmar");

		Pedido pedido = new Pedido(1006, cliente, vendedor, new Date(), endereco, itensPedido);

		Importadora novaCompra = new Importadora();

		try {

			novaCompra.pedidoVinho(pedido);

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());

		}
	}

	public static void testaRegra7() {

		Cliente clienteTania = new Cliente("Tania", "21 62633-0251", "tania@email.com.br");

		ItemPedido vinhoLazuli = new ItemPedido(10, "Lazuli", TipoVinho.TIPO_VINHO_TINTO, TipoUva.UVA_CABERNET, 1990,
				Pais.PAIS_CHILE, TabelaDePrecos.VALOR_VINHO_TINTO);

		List<ItemPedido> itensPedidoTania = new ArrayList<>();
		itensPedidoTania.add(vinhoLazuli);

		EnderecoEntrega enderecoTania = new EnderecoEntrega(clienteTania, "Rua Pio XII", 10, "Casa", "Barro Branco",
				"Mauá", "SP", "05300-000");

		Cliente clienteDoroteia = new Cliente("Dorotéia", "16 98765-3443", "doroteia@email.com.br");

		ItemPedido vinhoEncuentroMalbec = new ItemPedido(5, "Encuentro Malbec", TipoVinho.TIPO_VINHO_TINTO,
				TipoUva.UVA_MALBEC, 2014, Pais.PAIS_ARGENTINA, TabelaDePrecos.VALOR_VINHO_TINTO);

		List<ItemPedido> itensPedidoDoroteia = new ArrayList<>();
		itensPedidoDoroteia.add(vinhoEncuentroMalbec);

		EnderecoEntrega enderecoDoroteia = new EnderecoEntrega(clienteDoroteia, "Av. Paulista", 1080, "5º Andar",
				"Jd.Paulista", "São Paulo", "SP", "08170-001");

		ContaVendedor contaVendedorHenrique = new ContaVendedor();
		Vendedor vendedorHenrique = new Vendedor(0045, "Henrique", contaVendedorHenrique);

		Pedido pedidoTania = new Pedido(1007, clienteTania, vendedorHenrique, new Date(), enderecoTania,
				itensPedidoTania);

		Pedido pedidoDoroteia = new Pedido(1008, clienteDoroteia, vendedorHenrique, new Date(), enderecoDoroteia,
				itensPedidoDoroteia);

		Importadora novaCompra = new Importadora();

		try {

			novaCompra.pedidoVinho(pedidoTania);
			novaCompra.pedidoVinho(pedidoDoroteia);

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());

		}
	}

	public static void testaRegra8() {

		Cliente clienteRomeu = new Cliente("Romeu", "43 99653-7281", "romeu@email.com.br");

		ItemPedido vinhoLuizArgenta = new ItemPedido(15, "Luiz Argenta", TipoVinho.TIPO_VINHO_TINTO, TipoUva.UVA_MALBEC,
				2016, Pais.PAIS_BRASIL, TabelaDePrecos.VALOR_VINHO_TINTO);

		List<ItemPedido> itensPedidoRomeu = new ArrayList<>();
		itensPedidoRomeu.add(vinhoLuizArgenta);

		EnderecoEntrega enderecoRomeu = new EnderecoEntrega(clienteRomeu, "Alameda das Neves", 14320, "Andar 23",
				"Nascer do Sol", "São Paulo", "SP", "12600-000");

		ContaVendedor contaVendedorEduardo = new ContaVendedor();
		Vendedor vendedorEduardo = new Vendedor(0017, "Eduardo", contaVendedorEduardo);

		Pedido pedidoRomeu = new Pedido(1009, clienteRomeu, vendedorEduardo, new Date(), enderecoRomeu,
				itensPedidoRomeu);

		Importadora novaCompra = new Importadora();

		try {

			novaCompra.pedidoVinho(pedidoRomeu);

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());

		}
	}

}
