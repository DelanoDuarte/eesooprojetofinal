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
public class TesteStatusNovoPedido extends TestCase {

	Pedido pedido = new Pedido();

	@Test
	public final void testeStatusAceitarPedido() {
		pedido.aceitarPedido();
		assertEquals(pedido.getStatus(), StatusEnum.Aceito);
	}

	@Test
	public final void testeStatusAceitarPagamento() {
		pedido.aceitarPedido();
		pedido.aceitarPagamentoPedido();
		assertEquals(pedido.getStatus(), StatusEnum.Pago);
	}

	@Test
	public final void testeStatusCancelarPedido() {
		pedido.cancelarPedido();
		assertEquals(pedido.getStatus(), StatusEnum.Cancelado);
	}
}
