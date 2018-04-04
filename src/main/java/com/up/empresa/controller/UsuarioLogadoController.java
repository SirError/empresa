package com.up.empresa.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.up.empresa.entity.Usuario;

@Named
@SessionScoped
public class UsuarioLogadoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	
	private String token;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void clear() {
		this.usuario = null;
		this.token = null;
	}

}
