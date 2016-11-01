package br.com.appeesoo.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.appeesoo.domain.Pedido;
import br.com.appeesoo.repository.IPedidoRepository;

@Model
public class PedidoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Pedido pedido = new Pedido();
	private List<Pedido> pedidos;

	@Inject
	private IPedidoRepository repository;

	public PedidoBean() {
		pedido.setDataPedido(new Date());
	}

	public String salvarPedido() {

		repository.salvarPedido(pedido);
		return "/paginas/pedido/lista";
	}

	public void buscarPedidoPorId() {
		this.pedido = repository.buscarPedidoPorId(this.pedido.getId());
	}

	public Pedido getPedido() {
		if (this.pedido == null)
			this.pedido = new Pedido();
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> getPedidos() {
		if (this.pedidos == null)
			this.pedidos = repository.buscarTodosOsPedidos();
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public IPedidoRepository getRepository() {
		return repository;
	}

	public void setRepository(IPedidoRepository repository) {
		this.repository = repository;
	}

}
