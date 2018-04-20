package com.up.empresa.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.up.empresa.entity.Credenciado;
import com.up.empresa.helper.MessageHelper;
import com.up.empresa.service.CredenciadoService;

@Named
@ViewScoped
public class CredenciadoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Credenciado credenciado = new Credenciado();

	@Inject
	private CredenciadoService service;

	@Inject
	private MessageHelper helper;

	@Inject
	private Flash flash;

	@Inject
	private UsuarioLogadoController usuarioLogado;

	private String token;

	@PostConstruct
	private void onInit() {
		Object object = flash.get("credenciado");
		token = usuarioLogado.getToken();
		if (object != null) {
			this.credenciado = (Credenciado) object;
			this.credenciado = service.get(credenciado.getId(), token);
		}
	}

	public String salvar() {

		if (credenciado.getId() == null)
			service.save(credenciado, token);
		else
			service.update(credenciado, token);

		helper.onFlash().addMessage(new FacesMessage("Registro salvo com sucesso"));

		return "/credenciados?faces-redirect=true";
	}

	public Credenciado getCredenciado() {
		return credenciado;
	}

	public void setCredenciado(Credenciado credenciado) {
		this.credenciado = credenciado;
	}

}
