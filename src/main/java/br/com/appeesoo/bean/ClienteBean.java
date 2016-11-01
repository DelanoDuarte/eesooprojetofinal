/**
 * 
 */
package br.com.appeesoo.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.appeesoo.domain.Cliente;
import br.com.appeesoo.repository.IClienteRepository;

/**
 * @author Delano
 *
 */
@Model
public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IClienteRepository clienteRepository;

	private Cliente cliente = new Cliente();

	private List<Cliente> clientes;

	public String salvarCliente() {
		clienteRepository.salvarCliente(cliente);
		return "/paginas/cliente/lista";
	}

	public void buscarClientePorId() {
		this.cliente = clienteRepository.buscarClientePorId(this.cliente.getId());
	}

	public IClienteRepository getClienteRepository() {
		return clienteRepository;
	}

	public void setClienteRepository(IClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente getCliente() {
		if (this.cliente == null) {
			this.cliente = new Cliente();
		}
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		if (this.clientes == null) {
			this.clientes = clienteRepository.buscarTodosOsClientes();
		}
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
