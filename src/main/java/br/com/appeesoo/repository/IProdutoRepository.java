/**
 * 
 */
package br.com.appeesoo.repository;

import java.util.List;

import br.com.appeesoo.domain.Produto;

/**
 * @author delan
 *
 */
public interface IProdutoRepository {

	public void salvarProduto(Produto produto);

	public Produto buscarProdutoPorId(Long id);

	public void excluirProduto(Long id);

	public List<Produto> buscarTodosOsProdutos();

}
