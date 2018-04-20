package com.up.empresa.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.up.empresa.entity.Credenciado;
import com.up.empresa.helper.MessageHelper;
import com.up.empresa.lazydatatable.GenericDataModel;
import com.up.empresa.service.CredenciadoService;

@Named
@ViewScoped
public class CredenciadosController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CredenciadoService service;

	private GenericDataModel<Credenciado> lazyModel;

	@Inject
	private MessageHelper helper;

	@Inject
	private Flash flash;

	@Inject
	private UsuarioLogadoController usuarioLogado;

	private List<Credenciado> credenciados;

	private String token;

	@PostConstruct
	private void onInit() {
		token = usuarioLogado.getToken();
		lazyModel = new GenericDataModel<>(service, token);
	}

	public String remover(Credenciado p) {
		service.delete(p, token);
		helper.onFlash().addMessage(new FacesMessage("Registro removido com sucesso"));
		return null;
	}

	public String alterar(Credenciado p) {
		flash.put("credenciado", p);
		return "/credenciado?faces-redirect=true";
	}

	public List<Credenciado> getCredenciados() {
		return credenciados;
	}

	public void setCredenciados(List<Credenciado> credenciados) {
		this.credenciados = credenciados;
	}

	public GenericDataModel<Credenciado> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(GenericDataModel<Credenciado> lazyModel) {
		this.lazyModel = lazyModel;
	}

}
