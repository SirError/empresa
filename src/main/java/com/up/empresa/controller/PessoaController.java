package com.up.empresa.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.up.empresa.entity.Pessoa;
import com.up.empresa.helper.MessageHelper;
import com.up.empresa.service.PessoaService;

@Named
@ViewScoped
public class PessoaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa = new Pessoa();


	@Inject
	private PessoaService service;

	@Inject
	private MessageHelper helper;

	@Inject
	private Flash flash;
	
	@Inject 
	private UsuarioLogadoController usuarioLogado;	

	private String token;

	@PostConstruct
	private void onInit() {
		Object object = flash.get("pessoa");
		if (object != null)
			this.pessoa = (Pessoa) object;
		
		token = usuarioLogado.getToken();
	}
	
	public String salvar() {

		if (pessoa.getId().equals(0l))
			service.save(pessoa, token);
		else
			service.update(pessoa, token);

		helper.onFlash().addMessage(new FacesMessage("Registro salvo com sucesso"));

		return "/pessoas.xhtml?faces-redirect=true";
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
