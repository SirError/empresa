package com.up.empresa.controller;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import com.up.empresa.entity.Usuario;
import com.up.empresa.helper.MessageHelper;
import com.up.empresa.service.TokenService;

@Model
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();

	private TokenService tokenService;

	private MessageHelper helper;

	private UsuarioLogadoController usuarioLogado;

	@Inject
	public LoginController(TokenService usuarioDao, UsuarioLogadoController usuarioLogado, MessageHelper helper) {
		this.tokenService = usuarioDao;
		this.usuarioLogado = usuarioLogado;
		this.helper = helper;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String efetuaLogin() {
		String token = tokenService.existe(this.usuario);
		if (token != null) {
			usuarioLogado.setToken(token);
			usuarioLogado.setUsuario(usuario);
			return "index?faces-redirect=true";
		}

		helper.onFlash().addMessage(new FacesMessage("Usuário não encontrado"));

		return "login?faces-redirect=true";
	}

	public String deslogar() {
		usuarioLogado.clear();
		return "login?faces-redirect=true";
	}
}
