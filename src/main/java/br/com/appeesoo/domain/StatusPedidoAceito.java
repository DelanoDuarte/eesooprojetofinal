/**
 * 
 */
package br.com.appeesoo.domain;

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
		}

	}

	@Override
	public void cancelarPedido(Pedido pedido) {
		try {
			pedido.setStatus(new StatusPedidoCancelado());
		} catch (Exception e) {
		}

	}

}
