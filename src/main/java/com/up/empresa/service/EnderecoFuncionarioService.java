package com.up.empresa.service;

import java.io.Serializable;
import java.util.Properties;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.up.empresa.config.Configuration;
import com.up.empresa.entity.Endereco;
import com.up.empresa.entity.Table;
import com.up.empresa.generics.TableService;

@Named
@Default
public class EnderecoFuncionarioService implements Serializable, TableService<Endereco>{
    
	private static final long serialVersionUID = 1L;

	@Inject    
    @Configuration
    private Properties properties;
    
	private Client client = ClientBuilder.newClient();
	
	private String getUri() {
		return properties.getProperty("url");
	}
	
	public Endereco get(int funcionarioId, int id, String token) {
        return client
          .target(getUri() + "funcionario/"+ funcionarioId +"/endereco")
          
          .path(String.valueOf(id))
          .request(MediaType.APPLICATION_JSON)
          .header("Authorization", "Bearer " + token)
          .get(Endereco.class);
    }
    
    public Endereco save(int funcionarioId, Endereco p, String token) {
    	return client
    	          .target(getUri() + "funcionario/"+ funcionarioId +"/endereco")
    	          .request(MediaType.APPLICATION_JSON)
    	          .header("Authorization", "Bearer " + token)
    	          .post(Entity.json(p), Endereco.class);
    }
    
    public Endereco update(int funcionarioId, Endereco p, String token) {
    	return client
    	          .target(getUri() + "funcionario/"+ funcionarioId +"/endereco/" + p.getId())
    	          .request(MediaType.APPLICATION_JSON)
    	          .header("Authorization", "Bearer " + token) 	         
    	          .put(Entity.json(p), Endereco.class);
    }
    

    public Response delete(int funcionarioId, int id, String token) {
    	  return client
    	          .target(getUri() + "funcionario/"+ funcionarioId +"/endereco/" + id)
    	          .request(MediaType.APPLICATION_JSON)
    	          .header("Authorization", "Bearer " + token)
    	         
    	          .delete();
    }

	@Override
	public Table<Endereco> getPage(Integer page, Integer pageSize, String filter, String token, String url) {
		WebTarget query = client.target(getUri() + url + "endereco")
				                .queryParam("page", page)
				                .queryParam("limit", pageSize);

		if (filter != null && !filter.isEmpty())
			query = query.queryParam("search", filter);

		return query.request(MediaType.APPLICATION_JSON)
				    .header("Authorization", "Bearer " + token)
				    .get(new GenericType<Table<Endereco>>() {});
	}

}
