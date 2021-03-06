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
public class TesteStatusPedidoCancelado extends TestCase {

	Pedido pedido = new Pedido();

	@Test
	public final void testeAceitarPedidoCancelado() {
		pedido.aceitarPedido();
		pedido.cancelarPedido();
		pedido.aceitarPedido();

		assertEquals(pedido.getStatus(), StatusEnum.Cancelado);
	}

	@Test
	public final void testeAceitarPagamentoDePedidoCancelado() {
		pedido.aceitarPedido();
		pedido.cancelarPedido();
		pedido.aceitarPagamentoPedido();

		assertEquals(pedido.getStatus(), StatusEnum.Cancelado);
	}

	@Test
	public final void testeCancelarPedidoJaCancelado() {

	}
}
