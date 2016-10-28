package br.com.appeesoo.repository;

import java.util.List;

import br.com.appeesoo.domain.Cliente;

public interface IClienteRepository {

	public void salvarCliente(Cliente cliente);

	public Cliente buscarClientePorId(Long id);

	public void excluirCliente(Long id);

	public List<Cliente> buscarTodosOsClientes();

}