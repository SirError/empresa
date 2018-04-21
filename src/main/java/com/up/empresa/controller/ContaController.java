package com.up.empresa.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.up.empresa.entity.Conta;
import com.up.empresa.entity.Credenciado;
import com.up.empresa.helper.MessageHelper;
import com.up.empresa.service.ContaService;

@Named
@ViewScoped
public class ContaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Conta conta = new Conta();

	@Inject
	private ContaService service;

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
		Object object = flash.get("conta");
		token = usuarioLogado.getToken();
		if (object != null) {
			this.conta = (Conta) object;
			this.conta = service.get(credenciado.getId(), conta.getId(), token);
		}
	}

	public String salvar() {

		if (conta.getId() == null) 
			service.save(credenciado.getId(), conta, token);
	    else
			service.update(credenciado.getId(), conta, token);

		helper.onFlash().addMessage(new FacesMessage("Registro salvo com sucesso"));

		return sair();
	}
	
	public String sair() {
		flash.put("credenciado", credenciado);

		return "/credenciado?faces-redirect=true";
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

}
