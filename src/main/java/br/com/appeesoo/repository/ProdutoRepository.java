/**
 * 
 */
package br.com.appeesoo.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.appeesoo.domain.Produto;

/**
 * @author delan
 *
 */
@RequestScoped
public class ProdutoRepository implements IProdutoRepository {

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.appeesoo.repository.IProdutoRepository#salvarProduto(br.com.
	 * appeesoo.domain.Produto)
	 */

	@Inject
	private EntityManager entityManager;

	@Override
	@Transactional
	public void salvarProduto(Produto produto) {

		try {
			if (produto.getId() == null) {
				entityManager.persist(produto);
			} else {
				entityManager.merge(produto);
			}
		} catch (Exception e) {

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.appeesoo.repository.IProdutoRepository#buscarProdutoPorId(java.
	 * lang.Long)
	 */
	@Override
	public Produto buscarProdutoPorId(Long id) {
		try {
			return entityManager.find(Produto.class, id);
		} catch (Exception e) {

		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.appeesoo.repository.IProdutoRepository#excluirProduto(java.lang.
	 * Long)
	 */
	@Override
	@Transactional
	public void excluirProduto(Long id) {
		try {
			Produto produto = buscarProdutoPorId(id);
			entityManager.remove(produto);
		} catch (Exception e) {

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.appeesoo.repository.IProdutoRepository#buscarTodosOsProdutos()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> buscarTodosOsProdutos() {
		try {
			return entityManager.createQuery("from Produto p").getResultList();
		} catch (Exception e) {

		}
		return null;
	}

}
