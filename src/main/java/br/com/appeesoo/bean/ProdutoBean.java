/**
 * 
 */
package br.com.appeesoo.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.appeesoo.domain.Produto;
import br.com.appeesoo.repository.IProdutoRepository;

/**
 * @author delan
 *
 */
@Model
public class ProdutoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Produto produto = new Produto();

	private List<Produto> produtos;

	@Inject
	private IProdutoRepository repository;

	@Inject
	private FacesContext context;

	public String salvarProduto() {
		repository.salvarProduto(produto);
		context.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Novo Produto Registrado com Sucesso !", null));
		return "/paginas/produto/lista";
	}

	public String excluirProduto() {
		repository.excluirProduto(this.produto.getId());
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto Deletado com Sucesso !", null));
		return "/paginas/produto/lista";
	}

	public void buscarProdutoPorId() {
		this.produto = repository.buscarProdutoPorId(this.produto.getId());
	}

	public Produto getProduto() {
		if (this.produto == null)
			this.produto = new Produto();
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		if (this.produtos == null) {
			this.produtos = repository.buscarTodosOsProdutos();
		}
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public IProdutoRepository getRepository() {
		return repository;
	}

	public void setRepository(IProdutoRepository repository) {
		this.repository = repository;
	}

}
