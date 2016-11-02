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
public class TesteStatusPedidoAceito extends TestCase {

	Pedido pedido = new Pedido();

	@Test
	public final void testeAceitarPedito() {
		pedido.aceitarPedido();
		assertEquals(pedido.getStatus(), StatusEnum.Aceito);
	}

	@Test
	public final void testeAceitarPagamentoPedido() {
		pedido.aceitarPedido();
		pedido.aceitarPagamentoPedido();
		assertEquals(pedido.getStatus(), StatusEnum.Pago);
	}

	@Test
	public final void testeCancelarPedidoAceito() {
		pedido.aceitarPagamentoPedido();
		pedido.cancelarPedido();

		assertEquals(pedido.getStatus(), StatusEnum.Cancelado);
	}
}
