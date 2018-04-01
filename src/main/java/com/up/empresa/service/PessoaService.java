package com.up.empresa.service;

import java.io.Serializable;
import java.util.Properties;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.up.empresa.config.Configuration;
import com.up.empresa.entity.Pessoa;
import com.up.empresa.entity.Table;

@Named
public class PessoaService implements Serializable{
    
	private static final long serialVersionUID = 1L;

	@Inject    
    @Configuration
    private Properties properties;
    
	private Client client = ClientBuilder.newClient();
	
	private String getUri() {
		return properties.getProperty("url");
	}
	
	public Pessoa get(int id) {
        return client
          .target(getUri() + "people")
          
          .path(String.valueOf(id))
          .request(MediaType.APPLICATION_JSON)
          .get(Pessoa.class);
    }
    
    public Table<Pessoa> getPage(int page, int limit) {
        return client
          .target(getUri() + "people")
          .queryParam("page", page)
          .queryParam("limit", limit)
          .request(MediaType.APPLICATION_JSON)
          .get(new GenericType<Table<Pessoa>>(){});        
    }
    

    public Pessoa save(Pessoa p, String token) {
    	return client
    	          .target(getUri() + "people")
    	          .request(MediaType.APPLICATION_JSON)
    	          .header("Authorization", "Bearer " + token)
    	         
    	          .post(Entity.json(p), Pessoa.class);
    }
    
    public Pessoa update(Pessoa p, String token) {
    	return client
    	          .target(getUri() + "people/" + p.getId())
    	          .request(MediaType.APPLICATION_JSON)
    	          .header("Authorization", "Bearer " + token)
    	         
    	          .put(Entity.json(p), Pessoa.class);
    }
    

    public Response delete(Pessoa p, String token) {
    	  return client
    	          .target(getUri() + "people/" + p.getId())
    	          .request(MediaType.APPLICATION_JSON)
    	          .header("Authorization", "Bearer " + token)
    	         
    	          .delete();
    }

}
