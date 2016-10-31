/**
 * 
 */
package br.com.appeesoo.repository;

import java.util.List;

import br.com.appeesoo.domain.Pedido;

/**
 * @author delan
 *
 */
public interface IPedidoRepository {

	public void salvarPedido(Pedido pedido);

	public Pedido buscarPedidoPorId(Long id);

	public void excluirPedido(Long id);

	public List<Pedido> buscarTodosOsPedidos();

}
