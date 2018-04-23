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
import com.up.empresa.helper.MessageHelper;
import com.up.empresa.lazydatatable.GenericDataModel;
import com.up.empresa.service.EmpresaService;

@Named
@ViewScoped
public class EmpresasController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmpresaService service;

	private GenericDataModel<Empresa> lazyModel;

	@Inject
	private MessageHelper helper;

	@Inject
	private Flash flash;

	@Inject
	private UsuarioLogadoController usuarioLogado;

	private List<Empresa> empresas;

	private String token;

	@PostConstruct
	private void onInit() {
		token = usuarioLogado.getToken();
		lazyModel = new GenericDataModel<>(service, token, null);
	}

	public String remover(Empresa p) {
		service.delete(p, token);
		helper.onFlash().addMessage(new FacesMessage("Registro removido com sucesso"));
		return null;
	}

	public String alterar(Empresa p) {
		flash.put("empresa", p);
		return "/empresa?faces-redirect=true";
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public GenericDataModel<Empresa> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(GenericDataModel<Empresa> lazyModel) {
		this.lazyModel = lazyModel;
	}

}
