/**
 * 
 */
package br.com.appeesoo.domain;

import javax.resource.spi.IllegalStateException;

/**
 * @author Delano
 *
 */
public class StatusPedidoAceito implements Status {

	@Override
	public void aceitarPedido(Pedido pedido) {
		try {
			throw new IllegalStateException();
		} catch (Exception e) {

		}

	}

	@Override
	public void aceitarPagamentoPedido(Pedido pedido) {
		try {
			pedido.setStatus(new StatusPedidoPago());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.appeesoo.domain.Status#atualizarStatus(br.com.appeesoo.domain.
	 * Pedido)
	 */

}
