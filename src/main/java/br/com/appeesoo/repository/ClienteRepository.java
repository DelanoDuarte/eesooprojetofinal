/**
 * 
 */
package br.com.appeesoo.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.appeesoo.domain.Cliente;

/**
 * @author Delano
 *
 */

@RequestScoped
public class ClienteRepository implements IClienteRepository {

	@Inject
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.appeesoo.repository.IClienteRepository#salvarCliente(br.com.
	 * appeesoo.domain.Cliente)
	 */
	@Override
	@Transactional
	public void salvarCliente(Cliente cliente) {
		try {
			if (cliente.getId() == null) {
				entityManager.persist(cliente);
			} else {
				entityManager.merge(cliente);
			}
		} catch (Exception e) {

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.appeesoo.repository.IClienteRepository#buscarClientePorId(java.
	 * lang.Long)
	 */
	@Override
	public Cliente buscarClientePorId(Long id) {
		try {
			return entityManager.find(Cliente.class, id);
		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.appeesoo.repository.IClienteRepository#excluirCliente(java.lang.
	 * Long)
	 */
	@Override
	@Transactional
	public void excluirCliente(Long id) {
		try {
			Cliente cliente = buscarClientePorId(id);
			entityManager.remove(cliente);
		} catch (Exception e) {

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.appeesoo.repository.IClienteRepository#buscarTodosOsClientes()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> buscarTodosOsClientes() {
		try {
			return entityManager.createQuery("from Cliente c").getResultList();
		} catch (Exception e) {
			return null;
		}
	}

}
