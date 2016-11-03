package br.com.appeesoo.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.appeesoo.domain.Pedido;
import br.com.appeesoo.domain.StatusEnum;
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

	@Inject
	private FacesContext facesContext;

	public PedidoBean() {
		this.pedido.setDataPedido(new Date());
	}

	public String salvarPedido() {
		this.pedido = null;
		repository.salvarPedido(pedido);
		facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Novo Pedido Registrado com Sucesso !", null));
		return "/paginas/pedido/lista";
	}

	public void buscarPedidoPorId() {
		this.pedido = repository.buscarPedidoPorId(this.pedido.getId());
	}

	public void aceitarPedido() {
		buscarPedidoPorId();
		this.pedido.aceitarPedido();
		repository.salvarPedido(this.pedido);
		// facesContext.addMessage(null,
		// new FacesMessage(FacesMessage.SEVERITY_INFO, "Pedido Aceito com
		// Sucesso !", null));
	}

	public void aceitarPagamentoPedido() {
		buscarPedidoPorId();
		this.pedido.aceitarPagamentoPedido();
		repository.salvarPedido(this.pedido);
		// facesContext.addMessage(null,
		// new FacesMessage(FacesMessage.SEVERITY_INFO, "Pagamento do Pedido
		// Aceito com Sucesso !", null));
	}

	public void cancelarPedido() {
		buscarPedidoPorId();
		this.pedido.cancelarPedido();
		repository.salvarPedido(this.pedido);
		// facesContext.addMessage(null, new
		// FacesMessage(FacesMessage.SEVERITY_INFO,
		// "Cancelamento do Pedido realizado com com Sucesso !", null));
	}

	public boolean mostrarBotao() {
		try {
			buscarPedidoPorId();
			if (this.pedido.getStatus().equals(StatusEnum.Novo)) {
				return true;
			} else if (this.pedido.getStatus().equals(StatusEnum.Aceito)) {
				return true;
			} else if (this.pedido.getStatus().equals(StatusEnum.Pago)) {
				return true;
			} else if (this.pedido.getStatus().equals(StatusEnum.Cancelado)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
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
