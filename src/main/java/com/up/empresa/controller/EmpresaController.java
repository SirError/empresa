package com.up.empresa.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.up.empresa.entity.Empresa;
import com.up.empresa.helper.MessageHelper;
import com.up.empresa.service.EmpresaService;

@Named
@ViewScoped
public class EmpresaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Empresa empresa = new Empresa();

	@Inject
	private EmpresaService service;

	@Inject
	private MessageHelper helper;

	@Inject
	private Flash flash;

	@Inject
	private UsuarioLogadoController usuarioLogado;

	private String token;

	@PostConstruct
	private void onInit() {
		Object object = flash.get("empresa");
		token = usuarioLogado.getToken();
		if (object != null) {
			this.empresa = (Empresa) object;
			this.empresa = service.get(empresa.getId(), token);
		}
	}

	public String salvar() {

		if (empresa.getId() == null)
			service.save(empresa, token);
		else
			service.update(empresa, token);

		helper.onFlash().addMessage(new FacesMessage("Registro salvo com sucesso"));

		return "/empresas?faces-redirect=true";
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
