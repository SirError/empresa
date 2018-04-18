package com.up.empresa.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.up.empresa.entity.Administrador;
import com.up.empresa.helper.MessageHelper;
import com.up.empresa.service.AdministradorService;

@Named
@ViewScoped
public class AdministradorController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Administrador administrador = new Administrador();

	@Inject
	private AdministradorService service;

	@Inject
	private MessageHelper helper;

	@Inject
	private Flash flash;
	
	@Inject 
	private UsuarioLogadoController usuarioLogado;	

	private String token;

	@PostConstruct
	private void onInit() {
		Object object = flash.get("administrador");
		if (object != null)
			this.administrador = (Administrador) object;
		
		token = usuarioLogado.getToken();
	}
	
	public String salvar() {

		if (administrador.getId() == null)
			service.save(administrador, token);
		else
			service.update(administrador, token);

		helper.onFlash().addMessage(new FacesMessage("Registro salvo com sucesso"));

		return "/administradores?faces-redirect=true";
	}
	
	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

}
