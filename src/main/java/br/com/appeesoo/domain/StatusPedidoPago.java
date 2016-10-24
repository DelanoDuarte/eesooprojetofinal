/**
 * 
 */
package br.com.appeesoo.domain;

import javax.resource.spi.IllegalStateException;

/**
 * @author Jessica
 *
 */
public class StatusPedidoPago implements Status {

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
			throw new IllegalStateException();
		} catch (Exception e) {

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
