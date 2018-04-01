package com.up.empresa.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.up.empresa.entity.Pessoa;
import com.up.empresa.entity.Table;
import com.up.empresa.entity.Token;

public class RestClient {
  
    private static final String REST_URI 
      = "https://dev-api-deploy.com/";
  
    private Client client = ClientBuilder.newClient();
 
    public Pessoa getJsonEmployee(int id) {
        return client
          .target(REST_URI + "people")
          
          .path(String.valueOf(id))
          .request(MediaType.APPLICATION_JSON)
          .get(Pessoa.class);
    }
    
    public Table<Pessoa> getPessoas() {
        return client
          .target(REST_URI + "people")
          .queryParam("page", 10)
          .queryParam("limit", 5)
          .request(MediaType.APPLICATION_JSON)
          .get(new GenericType<Table<Pessoa>>(){});
        
        
    }
    
    public Token getToken() {
        return client
          .target(REST_URI + "login")
          .request(MediaType.APPLICATION_JSON)
          .post(null, Token.class);
    }
    
    public Pessoa postPessoa(Pessoa p, String token) {
    	return client
    	          .target(REST_URI + "people")
    	          .request(MediaType.APPLICATION_JSON)
    	          .header("Authorization", "Bearer " + token)
    	         
    	          .post(Entity.json(p), Pessoa.class);
    }
    
    public Pessoa putPessoa(Pessoa p, String token) {
    	return client
    	          .target(REST_URI + "people/" + p.getId())
    	          .request(MediaType.APPLICATION_JSON)
    	          .header("Authorization", "Bearer " + token)
    	         
    	          .put(Entity.json(p), Pessoa.class);
    }
    

    public Response deletePessoa(Pessoa p, String token) {
    	  return client
    	          .target(REST_URI + "people/" + p.getId())
    	          .request(MediaType.APPLICATION_JSON)
    	          .header("Authorization", "Bearer " + token)
    	         
    	          .delete();
    }
    
    public static void main(String[] args) {
    	RestClient restClient = new RestClient();
    	
//    	Token token = restClient.getToken();
//    	System.out.println(token.getToken());
//    	
//    	Pessoa p = new Pessoa("Novo Registro");
//    	
//    	p = restClient.postPessoa(p, token.getToken());
//    	System.out.println("salvou");
//    	p.setTitle("Put Jersey");
//    	p = restClient.putPessoa(p, token.getToken());
//    	System.out.println(p.getTitle());
//    	
//		Pessoa jsonEmployee = restClient.getJsonEmployee(33);
//		System.out.println(jsonEmployee);
//		
//		restClient.deletePessoa(p, token.getToken());
//		
		
		restClient.getPessoas().getRows().forEach(System.out::println);
	}
    
}