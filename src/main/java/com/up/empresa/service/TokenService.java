package com.up.empresa.service;

import java.io.Serializable;
import java.util.Properties;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import com.up.empresa.config.Configuration;
import com.up.empresa.entity.Token;
import com.up.empresa.entity.Usuario;

@Named
public class TokenService implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject    
    @Configuration
    private Properties properties;
    
	private Client client = ClientBuilder.newClient();

	public Token getToken(Usuario usuario) {
		return client.target(properties.getProperty("url") + "login")
				     .request(MediaType.APPLICATION_JSON)
				     .post(Entity.json(usuario), Token.class);
	}

	public String existe(Usuario usuario) {
		try {
			return getToken(usuario).getToken();
		} catch (Exception e) {
			return null;
		}
	}
}
