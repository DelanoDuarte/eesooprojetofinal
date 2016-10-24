/**
 * 
 */
package br.com.appeesoo.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.appeesoo.domain.Cliente;

/**
 * @author Delano
 *
 */
public class TesteClass {

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		Cliente cliente = new Cliente();
		cliente.setNome("Teste");
		cliente.setCpf("342423423");
		cliente.setCidade("Teste");
		cliente.setEstado("Teste");

		EntityManager entityManager = Persistence.createEntityManagerFactory("ProjetoFinal-PU").createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
