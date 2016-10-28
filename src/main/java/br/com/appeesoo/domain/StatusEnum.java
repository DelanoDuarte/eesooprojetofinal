/**
 * 
 */
package br.com.appeesoo.domain;

/**
 * @author Delano
 *
 */
public enum StatusEnum implements Status {

	Novo(new StatusNovoPedido()), Aceito(new StatusPedidoAceito()), Cancelado(new StatusPedidoCancelado()), Pago(
			new StatusPedidoPago());

	private final Status status;

	private StatusEnum(Status status) {
		this.status = status;
	}

	@Override
	public void aceitarPedido(Pedido pedido) {
		status.aceitarPedido(pedido);
	}

	@Override
	public void aceitarPagamentoPedido(Pedido pedido) {
		status.aceitarPagamentoPedido(pedido);
	}

	@Override
	public void cancelarPedido(Pedido pedido) {
		status.cancelarPedido(pedido);
	}
}
