package com.up.empresa.helper;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

public class JSFFactory {

	@Produces
	@RequestScoped
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	@Produces
	@RequestScoped
	public Flash getFlash() {
		return getExternalContext().getFlash();
	}

	@Produces
	@RequestScoped
	public NavigationHandler getNavigationHandler() {
		return getFacesContext().getApplication().getNavigationHandler();
	}

	private ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}

}