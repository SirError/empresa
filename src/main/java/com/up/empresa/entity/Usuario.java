package com.up.empresa.entity;

import org.hibernate.validator.constraints.NotBlank;

public class Usuario {
	@NotBlank(message = "Email não informado.")
	private String email;
	@NotBlank(message = "Senha não informada.")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
