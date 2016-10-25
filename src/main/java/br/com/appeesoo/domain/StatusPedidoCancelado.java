/**
 * 
 */
package br.com.appeesoo.domain;

import javax.resource.spi.IllegalStateException;

/**
 * @author Delano
 *
 */
public class StatusPedidoCancelado implements Status {

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.appeesoo.domain.Status#aceitarPedido(br.com.appeesoo.domain.
	 * Pedido)
	 */
	@Override
	public void aceitarPedido(Pedido pedido) {
		try {
			throw new IllegalStateException();
		} catch (Exception e) {

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.appeesoo.domain.Status#aceitarPagamentoPedido(br.com.appeesoo.
	 * domain.Pedido)
	 */
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
	 * @see br.com.appeesoo.domain.Status#cancelarPedido(br.com.appeesoo.domain.
	 * Pedido)
	 */
	@Override
	public void cancelarPedido(Pedido pedido) {
		try {
			throw new IllegalStateException();
		} catch (Exception e) {
		}
	}

}
