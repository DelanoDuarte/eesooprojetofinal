/**
 * 
 */
package br.com.appeesoo.producers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Jessica
 *
 */
public class EntityManagerProducer {

	@PersistenceContext
	private EntityManager entityManager;

	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
