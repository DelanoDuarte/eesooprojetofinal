/**
 * 
 */
package br.com.appeesoo.testes;

import br.com.appeesoo.domain.Pedido;

/**
 * @author Delano
 *
 */
public class TesteClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Pedido pedido = new Pedido();

		System.out.println("Estado Inicial: " + pedido.getStatus().toString());

		pedido.aceitarPedido();
		System.out.println("Aceitar Novo Pedido: " + pedido.getStatus().toString());

		pedido.cancelarPedido();
		System.out.println("Cancelando Pedido Aceito: " + pedido.getStatus().toString());

		pedido.aceitarPedido();
		System.out.println("Tentando Aceitar um Pedido ja Cancelado: " + pedido.getStatus().toString());

		pedido.aceitarPagamentoPedido();
		System.out.println("Tentando Aceitar Pagamaneto de Pedido Cancelado: " + pedido.getStatus().toString());
	}

}
