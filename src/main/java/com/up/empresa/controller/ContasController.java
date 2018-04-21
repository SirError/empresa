package com.up.empresa.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.up.empresa.entity.Conta;
import com.up.empresa.entity.Credenciado;
import com.up.empresa.helper.MessageHelper;
import com.up.empresa.lazydatatable.GenericDataModel;
import com.up.empresa.service.ContaService;

@Named
@ViewScoped
public class ContasController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ContaService service;

	private GenericDataModel<Conta> lazyModel;

	@Inject
	private MessageHelper helper;

	@Inject
	private Flash flash;

	@Inject
	private UsuarioLogadoController usuarioLogado;

	@Inject
	private CredenciadoController credenciadoController;
	
	private List<Conta> contas;

	private String token;

	private Credenciado credenciado;

	@PostConstruct
	private void onInit() {
		token = usuarioLogado.getToken();
		credenciado = credenciadoController.getCredenciado();
		String url = "/credenciado/" + credenciado.getId() + "/";
		lazyModel = new GenericDataModel<>(service, token, url);
	}

	public String remover(Conta p) {
		service.delete(credenciado.getId(), p.getId(), token);
		helper.onFlash().addMessage(new FacesMessage("Registro removido com sucesso"));
		return null;
	}

	public String incluir() {
		flash.put("credenciado", credenciado);
		return "/conta?faces-redirect=true";
	}
	
	public String alterar(Conta p) {
		flash.put("credenciado", credenciado);
		flash.put("conta", p);
		return "/conta?faces-redirect=true";
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public GenericDataModel<Conta> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(GenericDataModel<Conta> lazyModel) {
		this.lazyModel = lazyModel;
	}

}
