package com.up.empresa.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.up.empresa.entity.Endereco;
import com.up.empresa.entity.Credenciado;
import com.up.empresa.helper.MessageHelper;
import com.up.empresa.service.EnderecoService;

@Named
@ViewScoped
public class EnderecoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Endereco endereco = new Endereco();

	@Inject
	private EnderecoService service;

	@Inject
	private MessageHelper helper;

	@Inject
	private Flash flash;

	@Inject
	private UsuarioLogadoController usuarioLogado;

	private String token;

	private Credenciado credenciado;

	@PostConstruct
	private void onInit() {
		credenciado = (Credenciado) flash.get("credenciado");
		Object object = flash.get("endereco");
		token = usuarioLogado.getToken();
		if (object != null) {
			this.endereco = (Endereco) object;
			this.endereco = service.get(credenciado.getId(), endereco.getId(), token);
		}
	}

	public String salvar() {

		if (endereco.getId() == null) 
			service.save(credenciado.getId(), endereco, token);
	    else
			service.update(credenciado.getId(), endereco, token);

		helper.onFlash().addMessage(new FacesMessage("Registro salvo com sucesso"));

		return sair();
	}
	
	public String sair() {
		flash.put("credenciado", credenciado);

		return "/credenciado?faces-redirect=true";
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
