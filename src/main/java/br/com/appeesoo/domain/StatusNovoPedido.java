/**
 * 
 */
package br.com.appeesoo.domain;

import javax.resource.spi.IllegalStateException;

/**
 * @author Delano
 *
 */
public class StatusNovoPedido implements Status {

	@Override
	public void aceitarPedido(Pedido pedido) {

		try {
			pedido.setStatus(new StatusPedidoAceito());
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

	@Override
	public void cancelarPedido(Pedido pedido) {
		try {
			throw new IllegalStateException();
		} catch (Exception e) {

		}

	}

}
