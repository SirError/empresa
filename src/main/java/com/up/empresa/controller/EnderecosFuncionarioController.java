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
import com.up.empresa.entity.Funcionario;
import com.up.empresa.helper.MessageHelper;
import com.up.empresa.lazydatatable.GenericDataModel;
import com.up.empresa.service.EnderecoFuncionarioService;

@Named
@ViewScoped
public class EnderecosFuncionarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EnderecoFuncionarioService service;

	private GenericDataModel<Endereco> lazyModel;

	@Inject
	private MessageHelper helper;

	@Inject
	private Flash flash;

	@Inject
	private UsuarioLogadoController usuarioLogado;

	@Inject
	private FuncionarioController funcionarioController;
	
	private List<Endereco> enderecos;

	private String token;

	private Funcionario funcionario;

	@PostConstruct
	private void onInit() {
		token = usuarioLogado.getToken();
		funcionario = funcionarioController.getFuncionario();
		String url = "/funcionario/" + funcionario.getId() + "/";
		lazyModel = new GenericDataModel<>(service, token, url);
	}

	public String remover(Endereco p) {
		service.delete(funcionario.getId(), p.getId(), token);
		helper.onFlash().addMessage(new FacesMessage("Registro removido com sucesso"));
		return null;
	}

	public String incluir() {
		flash.put("funcionario", funcionario);
		return "/enderecofuncionario?faces-redirect=true";
	}
	
	public String alterar(Endereco p) {
		flash.put("funcionario", funcionario);
		flash.put("endereco", p);
		return "/enderecofuncionario?faces-redirect=true";
	}

	public List<Endereco> getEnderecoFuncionarios() {
		return enderecos;
	}

	public void setEnderecoFuncionarios(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public GenericDataModel<Endereco> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(GenericDataModel<Endereco> lazyModel) {
		this.lazyModel = lazyModel;
	}

}
