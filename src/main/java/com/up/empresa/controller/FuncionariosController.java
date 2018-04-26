package com.up.empresa.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.up.empresa.entity.Funcionario;
import com.up.empresa.helper.MessageHelper;
import com.up.empresa.lazydatatable.GenericDataModel;
import com.up.empresa.service.FuncionarioService;

@Named
@ViewScoped
public class FuncionariosController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioService service;

	private GenericDataModel<Funcionario> lazyModel;

	@Inject
	private MessageHelper helper;

	@Inject
	private Flash flash;

	@Inject
	private UsuarioLogadoController usuarioLogado;

	private List<Funcionario> funcionarios;

	private String token;

	@PostConstruct
	private void onInit() {
		token = usuarioLogado.getToken();
		lazyModel = new GenericDataModel<>(service, token, null);
	}

	public String remover(Funcionario p) {
		service.delete(p, token);
		helper.onFlash().addMessage(new FacesMessage("Registro removido com sucesso"));
		return null;
	}

	public String alterar(Funcionario p) {
		flash.put("funcionario", p);
		return "/funcionario?faces-redirect=true";
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public GenericDataModel<Funcionario> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(GenericDataModel<Funcionario> lazyModel) {
		this.lazyModel = lazyModel;
	}

}
