package com.up.empresa.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.up.empresa.entity.Funcionario;
import com.up.empresa.helper.MessageHelper;
import com.up.empresa.service.FuncionarioService;

@Named
@ViewScoped
public class FuncionarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Funcionario funcionario = new Funcionario();

	@Inject
	private FuncionarioService service;

	@Inject
	private MessageHelper helper;

	@Inject
	private Flash flash;

	@Inject
	private UsuarioLogadoController usuarioLogado;

	private String token;

	@PostConstruct
	private void onInit() {
		Object object = flash.get("funcionario");
		token = usuarioLogado.getToken();
		if (object != null) {
			this.funcionario = (Funcionario) object;
			this.funcionario = service.get(funcionario.getId(), token);
		}
	}

	public String salvar() {

		if (funcionario.getId() == null)
			service.save(funcionario, token);
		else
			service.update(funcionario, token);

		helper.onFlash().addMessage(new FacesMessage("Registro salvo com sucesso"));

		return "/funcionarios?faces-redirect=true";
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
