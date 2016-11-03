/**
 * 
 */
package br.com.appeesoo.producers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

/**
 * @author delan
 *
 */
public class FacesContextProducer {

	private FacesContext context = FacesContext.getCurrentInstance();

	@Produces
	@RequestScoped
	public FacesContext getContext() {
		return context;
	}

}
