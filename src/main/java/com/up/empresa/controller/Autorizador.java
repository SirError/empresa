package com.up.empresa.controller;

import javax.enterprise.event.Observes;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.inject.Inject;

import com.up.empresa.entity.Usuario;
import com.up.empresa.phaselistener.annotation.After;
import com.up.empresa.phaselistener.annotation.Phase;
import com.up.empresa.phaselistener.annotation.Phase.Phases;

public class Autorizador {

	@Inject
	private FacesContext context;

	@Inject
	private UsuarioLogadoController usuarioLogado;

	@Inject
	private NavigationHandler handler;

	public void autoriza(@Observes @After @Phase(Phases.RESTORE_VIEW) PhaseEvent event) {
		String nomePagina = context.getViewRoot().getViewId();

		System.out.println(nomePagina);

		if ("/login.xhtml".equals(nomePagina)) {
			return;
		}

		Usuario usuario = usuarioLogado.getUsuario();

		if (usuario != null) {
			return;
		}


		handler.handleNavigation(context, null, "/login?faces-redirect=true");
		context.renderResponse();
	}

}
