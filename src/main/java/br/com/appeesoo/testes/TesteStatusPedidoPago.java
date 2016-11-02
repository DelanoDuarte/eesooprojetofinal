/**
 * 
 */
package br.com.appeesoo.testes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.com.appeesoo.domain.Pedido;
import br.com.appeesoo.domain.StatusEnum;
import junit.framework.TestCase;

/**
 * @author delan
 *
 */
@RunWith(JUnit4.class)
public class TesteStatusPedidoPago extends TestCase {

	Pedido pedido = new Pedido();

	@Test
	public final void testeAceitarPedidoJaPago() {
		pedido.aceitarPedido();
		pedido.aceitarPagamentoPedido();

		pedido.aceitarPedido();

		assertEquals(pedido.getStatus(), StatusEnum.Pago);
	}

	public final void testeAceitarPagamentoDePedidoJaPago() {

	}

	@Test
	public final void testeCancelarPedidoJaPago() {
		pedido.cancelarPedido();
		pedido.aceitarPagamentoPedido();

		assertEquals(pedido.getStatus(), StatusEnum.Cancelado);
	}
}
