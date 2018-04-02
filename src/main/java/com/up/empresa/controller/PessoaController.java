package com.up.empresa.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.up.empresa.entity.Pessoa;
import com.up.empresa.entity.Token;
import com.up.empresa.helper.MessageHelper;
import com.up.empresa.lazydatatable.LazyPessoaDataModel;
import com.up.empresa.service.PessoaService;
import com.up.empresa.service.TokenService;

@Named
@ViewScoped
public class PessoaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa = new Pessoa();

	private Pessoa selectedPessoa;

	@Inject
	private PessoaService service;

	@Inject
	private TokenService tokenService;

	@Inject
	private LazyPessoaDataModel lazyModel;

	@Inject
	private MessageHelper helper;

	@Inject
	private Flash flash;
	
	private List<Pessoa> pessoas;

	@PostConstruct
	private void onInit() {
		Object object = flash.get("pessoa");
		if (object != null)
			this.pessoa = (Pessoa) object;
	}
	
	public String salvar() {
		Token token = tokenService.getToken();

		if (pessoa.getId().equals(0l))
			service.save(pessoa, token.getToken());
		else
			service.update(pessoa, token.getToken());

		helper.onFlash().addMessage(new FacesMessage("Registro salvo com sucesso"));

		return "/pessoas.xhtml?faces-redirect=true";
	}
	
	public String remover(Pessoa p) {
		Token token = tokenService.getToken();
		service.delete(p, token.getToken());
		helper.onFlash().addMessage(new FacesMessage("Registro removido com sucesso"));
		return null;
	}

	public String alterar(Pessoa p) {
		flash.put("pessoa", p);
		return "/pessoa.xhtml?faces-redirect=true";
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public LazyPessoaDataModel getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyPessoaDataModel lazyPessoa) {
		this.lazyModel = lazyPessoa;
	}

	public Pessoa getSelectedPessoa() {
		return selectedPessoa;
	}

	public void setSelectedPessoa(Pessoa selectedPessoa) {
		this.selectedPessoa = selectedPessoa;
	}

}
