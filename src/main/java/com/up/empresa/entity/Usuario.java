package com.up.empresa.entity;

import org.hibernate.validator.constraints.NotBlank;

public class Usuario {
	@NotBlank(message = "Login não informado.")
	private String login;
	@NotBlank(message = "Senha não informada.")
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
