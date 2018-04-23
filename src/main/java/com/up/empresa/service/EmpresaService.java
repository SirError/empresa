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
import com.up.empresa.entity.Empresa;
import com.up.empresa.entity.Table;
import com.up.empresa.generics.TableService;

@Named
@Default
public class EmpresaService implements Serializable, TableService<Empresa>{
    
	private static final long serialVersionUID = 1L;

	@Inject    
    @Configuration
    private Properties properties;
    
	private Client client = ClientBuilder.newClient();
	
	private String getUri() {
		return properties.getProperty("url");
	}
	
	public Empresa get(int id, String token) {
        return client
          .target(getUri() + "empresa")
          
          .path(String.valueOf(id))
          .request(MediaType.APPLICATION_JSON)
          .header("Authorization", "Bearer " + token)
          .get(Empresa.class);
    }
    
    public Empresa save(Empresa p, String token) {
    	return client
    	          .target(getUri() + "empresa")
    	          .request(MediaType.APPLICATION_JSON)
    	          .header("Authorization", "Bearer " + token)
    	         
    	          .post(Entity.json(p), Empresa.class);
    }
    
    public Empresa update(Empresa p, String token) {
    	return client
    	          .target(getUri() + "empresa/" + p.getId())
    	          .request(MediaType.APPLICATION_JSON)
    	          .header("Authorization", "Bearer " + token)
    	         
    	          .put(Entity.json(p), Empresa.class);
    }
    

    public Response delete(Empresa p, String token) {
    	  return client
    	          .target(getUri() + "empresa/" + p.getId())
    	          .request(MediaType.APPLICATION_JSON)
    	          .header("Authorization", "Bearer " + token)
    	         
    	          .delete();
    }

	@Override
	public Table<Empresa> getPage(Integer page, Integer pageSize, String filter, String token, String url) {
		WebTarget query = client.target(getUri() + "empresa")
				                .queryParam("page", page)
				                .queryParam("limit", pageSize);

		if (filter != null && !filter.isEmpty())
			query = query.queryParam("search", filter);

		return query.request(MediaType.APPLICATION_JSON)
				    .header("Authorization", "Bearer " + token)
				    .get(new GenericType<Table<Empresa>>() {});
	}

}
