package com.up.empresa.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.up.empresa.entity.Empresa;
import com.up.empresa.entity.EnderecoEmpresa;
import com.up.empresa.helper.MessageHelper;
import com.up.empresa.service.EnderecoEmpresaService;

@Named
@ViewScoped
public class EnderecoEmpresaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private EnderecoEmpresa endereco = new EnderecoEmpresa();

	@Inject
	private EnderecoEmpresaService service;

	@Inject
	private MessageHelper helper;

	@Inject
	private Flash flash;

	@Inject
	private UsuarioLogadoController usuarioLogado;

	private String token;

	private Empresa empresa;

	@PostConstruct
	private void onInit() {
		empresa = (Empresa) flash.get("empresa");
		Object object = flash.get("endereco");
		token = usuarioLogado.getToken();
		if (object != null) {
			this.endereco = (EnderecoEmpresa) object;
			this.endereco = service.get(empresa.getId(), endereco.getId(), token);
		}
	}

	public String salvar() {

		if (endereco.getId() == null) 
			service.save(empresa.getId(), endereco, token);
	    else
			service.update(empresa.getId(), endereco, token);

		helper.onFlash().addMessage(new FacesMessage("Registro salvo com sucesso"));

		return sair();
	}
	
	public String sair() {
		flash.put("empresa", empresa);

		return "/empresa?faces-redirect=true";
	}

	public EnderecoEmpresa getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoEmpresa endereco) {
		this.endereco = endereco;
	}

}
