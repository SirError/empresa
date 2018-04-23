package com.up.empresa.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.up.empresa.entity.Endereco;
import com.up.empresa.entity.Credenciado;
import com.up.empresa.helper.MessageHelper;
import com.up.empresa.lazydatatable.GenericDataModel;
import com.up.empresa.service.EnderecoService;

@Named
@ViewScoped
public class EnderecosController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EnderecoService service;

	private GenericDataModel<Endereco> lazyModel;

	@Inject
	private MessageHelper helper;

	@Inject
	private Flash flash;

	@Inject
	private UsuarioLogadoController usuarioLogado;

	@Inject
	private CredenciadoController credenciadoController;
	
	private List<Endereco> enderecos;

	private String token;

	private Credenciado credenciado;

	@PostConstruct
	private void onInit() {
		token = usuarioLogado.getToken();
		credenciado = credenciadoController.getCredenciado();
		String url = "/credenciado/" + credenciado.getId() + "/";
		lazyModel = new GenericDataModel<>(service, token, url);
	}

	public String remover(Endereco p) {
		service.delete(credenciado.getId(), p.getId(), token);
		helper.onFlash().addMessage(new FacesMessage("Registro removido com sucesso"));
		return null;
	}

	public String incluir() {
		flash.put("credenciado", credenciado);
		return "/endereco?faces-redirect=true";
	}
	
	public String alterar(Endereco p) {
		flash.put("credenciado", credenciado);
		flash.put("endereco", p);
		return "/endereco?faces-redirect=true";
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public GenericDataModel<Endereco> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(GenericDataModel<Endereco> lazyModel) {
		this.lazyModel = lazyModel;
	}

}
