package com.up.empresa.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.up.empresa.entity.Empresa;
import com.up.empresa.entity.Endereco;
import com.up.empresa.helper.MessageHelper;
import com.up.empresa.lazydatatable.GenericDataModel;
import com.up.empresa.service.EnderecoEmpresaService;

@Named
@ViewScoped
public class EnderecosEmpresaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EnderecoEmpresaService service;

	private GenericDataModel<Endereco> lazyModel;

	@Inject
	private MessageHelper helper;

	@Inject
	private Flash flash;

	@Inject
	private UsuarioLogadoController usuarioLogado;

	@Inject
	private EmpresaController empresaController;
	
	private List<Endereco> enderecos;

	private String token;

	private Empresa empresa;

	@PostConstruct
	private void onInit() {
		token = usuarioLogado.getToken();
		empresa = empresaController.getEmpresa();
		String url = "/empresa/" + empresa.getId() + "/";
		lazyModel = new GenericDataModel<>(service, token, url);
	}

	public String remover(Endereco p) {
		service.delete(empresa.getId(), p.getId(), token);
		helper.onFlash().addMessage(new FacesMessage("Registro removido com sucesso"));
		return null;
	}

	public String incluir() {
		flash.put("empresa", empresa);
		return "/enderecoempresa?faces-redirect=true";
	}
	
	public String alterar(Endereco p) {
		flash.put("empresa", empresa);
		flash.put("endereco", p);
		return "/enderecoempresa?faces-redirect=true";
	}

	public List<Endereco> getEnderecoEmpresas() {
		return enderecos;
	}

	public void setEnderecoEmpresas(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public GenericDataModel<Endereco> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(GenericDataModel<Endereco> lazyModel) {
		this.lazyModel = lazyModel;
	}

}
