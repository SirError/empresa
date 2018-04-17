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
import com.up.empresa.lazydatatable.AdministradoresDataModel;
import com.up.empresa.service.AdministradorService;

@Named
@ViewScoped
public class AdministradoresController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Administrador selectedPessoa;

	@Inject
	private AdministradorService service;

	@Inject
	private AdministradoresDataModel lazyModel;

	@Inject
	private MessageHelper helper;

	@Inject
	private Flash flash;

	@Inject
	private UsuarioLogadoController usuarioLogado;

	private List<Administrador> pessoas;

	private String token;

	@PostConstruct
	private void onInit() {
		token = usuarioLogado.getToken();
	}

	public String remover(Administrador p) {
		service.delete(p, token);
		helper.onFlash().addMessage(new FacesMessage("Registro removido com sucesso"));
		return null;
	}

	public String alterar(Administrador p) {
		flash.put("pessoa", p);
		return "/pessoa.xhtml?faces-redirect=true";
	}

	public List<Administrador> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Administrador> pessoas) {
		this.pessoas = pessoas;
	}

	public AdministradoresDataModel getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(AdministradoresDataModel lazyPessoa) {
		this.lazyModel = lazyPessoa;
	}

	public Administrador getSelectedPessoa() {
		return selectedPessoa;
	}

	public void setSelectedPessoa(Administrador selectedPessoa) {
		this.selectedPessoa = selectedPessoa;
	}

}
