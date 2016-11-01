/**
 * 
 */
package br.com.appeesoo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * @author Delano
 *
 */
@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_pedido", sequenceName = "seq_pedido", initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedido")
	@Column(name = "id_pedido")
	@NotNull
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
	@NotNull
	private Cliente cliente;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_pedido")
	@NotNull
	private Date dataPedido;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_produtos_pedido", joinColumns = @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido"), inverseJoinColumns = @JoinColumn(name = "id_produto", referencedColumnName = "id_produto"))
	@NotNull
	private List<Produto> produto;

	@Column(name = "quantidade_pedido")
	private Integer quantidade;

	@Enumerated(EnumType.STRING)
	private StatusEnum status = StatusEnum.Novo;

	public void aceitarPedido() {
		status.aceitarPedido(this);
	}

	public void aceitarPagamentoPedido() {
		status.aceitarPagamentoPedido(this);
	}

	public void cancelarPedido() {
		status.cancelarPedido(this);
	}

	public Pedido() {
		super();
	}

	public Pedido(Cliente cliente, Date dataPedido, List<Produto> produto, Integer quantidade, StatusEnum status) {
		super();
		this.cliente = cliente;
		this.dataPedido = dataPedido;
		this.produto = produto;
		this.quantidade = quantidade;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((dataPedido == null) ? 0 : dataPedido.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (dataPedido == null) {
			if (other.dataPedido != null)
				return false;
		} else if (!dataPedido.equals(other.dataPedido))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", dataPedido=" + dataPedido + ", produto=" + produto
				+ ", quantidade=" + quantidade + ", status=" + status + "]";
	}

}
