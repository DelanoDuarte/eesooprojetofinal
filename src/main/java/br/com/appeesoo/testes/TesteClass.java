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

		pedido.aceitarPedido(pedido);

		System.out.println(pedido.getStatus().toString());

		pedido.aceitarPagamentoPedido(pedido);

		System.out.println(pedido.getStatus().toString());
	}

}
