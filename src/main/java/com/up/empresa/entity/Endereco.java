package com.up.empresa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.up.empresa.generics.Entidade;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "endereco", "numero", "bairro", "cidade", "uf", "cep" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class Endereco implements Entidade{

	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("endereco")
	private String endereco;
	
	@JsonProperty("numero")
	private String numero;
	
	@JsonProperty("bairro")
	private String bairro;
	
	@JsonProperty("cidade")
	private String cidade;
	
	@JsonProperty("uf")
	private String uf;
	
	@JsonProperty("cep")
	private String cep;

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("endereco")
	public String getEndereco() {
		return endereco;
	}

	@JsonProperty("endereco")
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@JsonProperty("numero")
	public String getNumero() {
		return numero;
	}

	@JsonProperty("numero")
	public void setNumero(String numero) {
		this.numero = numero;
	}

	@JsonProperty("bairro")
	public String getBairro() {
		return bairro;
	}

	@JsonProperty("bairro")
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@JsonProperty("cidade")
	public String getCidade() {
		return cidade;
	}

	@JsonProperty("cidade")
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@JsonProperty("uf")
	public String getUf() {
		return uf;
	}

	@JsonProperty("uf")
	public void setUf(String uf) {
		this.uf = uf;
	}

	@JsonProperty("cep")
	public String getCep() {
		return cep;
	}

	@JsonProperty("cep")
	public void setCep(String cep) {
		this.cep = cep;
	}
}
