package com.up.empresa.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.up.empresa.entity.Pessoa;
import com.up.empresa.entity.Token;
import com.up.empresa.service.PessoaService;
import com.up.empresa.service.TokenService;

@Named
@ViewScoped
public class PessoaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa = new Pessoa();

	@Inject
	private PessoaService service;

	@Inject
	private TokenService tokenService;
	
	private List<Pessoa> pessoas;

	public String salvar() {
		Token token = tokenService.getToken();
		service.save(pessoa, token.getToken());
		return null;
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

}
