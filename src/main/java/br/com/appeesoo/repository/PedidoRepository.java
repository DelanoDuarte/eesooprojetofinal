/**
 * 
 */
package br.com.appeesoo.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.appeesoo.domain.Pedido;

/**
 * @author delan
 *
 */
@RequestScoped
public class PedidoRepository implements IPedidoRepository {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.appeesoo.repository.IPedidoRepository#salvarPedido(br.com.appeesoo
	 * .domain.Pedido)
	 */

	@Inject
	private EntityManager entityManager;

	@Override
	public void salvarPedido(Pedido pedido) {
		try {
			if (pedido.getId() == null) {
				entityManager.persist(pedido);
			} else {
				entityManager.merge(pedido);
			}
		} catch (Exception e) {

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.appeesoo.repository.IPedidoRepository#buscarPedidoPorId(java.lang.
	 * Long)
	 */
	@Override
	public Pedido buscarPedidoPorId(Long id) {
		try {
			return entityManager.find(Pedido.class, id);
		} catch (Exception e) {

		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.appeesoo.repository.IPedidoRepository#excluirPedido(java.lang.
	 * Long)
	 */
	@Override
	public void excluirPedido(Long id) {
		try {
			Pedido pedido = buscarPedidoPorId(id);
			entityManager.remove(pedido);
		} catch (Exception e) {

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.appeesoo.repository.IPedidoRepository#buscarTodosOsPedidos()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> buscarTodosOsPedidos() {
		try {
			return entityManager.createQuery("from Pedido p").getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
