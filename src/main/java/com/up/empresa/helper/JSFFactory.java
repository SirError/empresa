package com.up.empresa.helper;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import com.up.empresa.annotation.ScopeMap;
import com.up.empresa.annotation.ScopeMap.Scope;

public class JSFFactory implements Serializable {

	private static final long serialVersionUID = 1L;


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
	
	@Produces
	@ScopeMap(Scope.REQUEST)
	public Map<String, Object> requestMap(){
		return getExternalContext().getRequestMap();
	}
	
	@Produces
	@ScopeMap(Scope.SESSION)
	public Map<String, Object> sessionMap(){
		return getExternalContext().getSessionMap();
	}
	
	@Produces
	@ScopeMap(Scope.APPLICATION)
	public Map<String, Object> applicationMap(){
		return getExternalContext().getApplicationMap();
	}


	private ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}

}