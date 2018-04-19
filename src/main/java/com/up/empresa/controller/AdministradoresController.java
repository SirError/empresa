package com.up.empresa.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.up.empresa.entity.Administrador;
import com.up.empresa.helper.MessageHelper;
import com.up.empresa.lazydatatable.GenericDataModel;
import com.up.empresa.service.AdministradorService;

@Named
@ViewScoped
public class AdministradoresController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AdministradorService service;

	private GenericDataModel<Administrador> lazyModel;

	@Inject
	private MessageHelper helper;

	@Inject
	private Flash flash;

	@Inject
	private UsuarioLogadoController usuarioLogado;

	private List<Administrador> administradores;

	private String token;

	@PostConstruct
	private void onInit() {
		token = usuarioLogado.getToken();
		lazyModel = new GenericDataModel<>(service, token);
	}

	public String remover(Administrador p) {
		service.delete(p, token);
		helper.onFlash().addMessage(new FacesMessage("Registro removido com sucesso"));
		return null;
	}

	public String alterar(Administrador p) {
		flash.put("administrador", p);
		return "/administrador?faces-redirect=true";
	}

	public List<Administrador> getAdministradores() {
		return administradores;
	}

	public void setAdministradores(List<Administrador> administradores) {
		this.administradores = administradores;
	}

	public GenericDataModel<Administrador> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(GenericDataModel<Administrador> lazyModel) {
		this.lazyModel = lazyModel;
	}

}
