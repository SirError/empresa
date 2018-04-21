package com.up.empresa.entity;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.up.empresa.generics.Entidade;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "numero", "banco", "agencia", "conta", "favorecido", "favorecido_documento" })
public class Conta implements Entidade {

	@JsonProperty("id")
	private Integer id;
	
	@JsonIgnore
	private Integer credenciadoId;

	@JsonProperty("numero")
	private String numero;

	@JsonProperty("banco")
	private String banco;

	@JsonProperty("agencia")
	private String agencia;

	@JsonProperty("conta")
	private String conta;

	@JsonProperty("favorecido")
	private String favorecido;

	@JsonProperty("favorecido_documento")
	private String favorecidoDocumento;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("numero")
	public String getNumero() {
		return numero;
	}

	@JsonProperty("numero")
	public void setNumero(String numero) {
		this.numero = numero;
	}

	@JsonProperty("banco")
	public String getBanco() {
		return banco;
	}

	@JsonProperty("banco")
	public void setBanco(String banco) {
		this.banco = banco;
	}

	@JsonProperty("agencia")
	public String getAgencia() {
		return agencia;
	}

	@JsonProperty("agencia")
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	@JsonProperty("conta")
	public String getConta() {
		return conta;
	}

	@JsonProperty("conta")
	public void setConta(String conta) {
		this.conta = conta;
	}

	@JsonProperty("favorecido")
	public String getFavorecido() {
		return favorecido;
	}

	@JsonProperty("favorecido")
	public void setFavorecido(String favorecido) {
		this.favorecido = favorecido;
	}

	@JsonProperty("favorecido_documento")
	public String getFavorecidoDocumento() {
		return favorecidoDocumento;
	}

	@JsonProperty("favorecido_documento")
	public void setFavorecidoDocumento(String favorecidoDocumento) {
		this.favorecidoDocumento = favorecidoDocumento;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", numero=" + numero + ", banco=" + banco + ", agencia=" + agencia + ", conta="
				+ conta + "]";
	}

	public Integer getCredenciadoId() {
		return credenciadoId;
	}

	public void setCredenciadoId(Integer credenciadoId) {
		this.credenciadoId = credenciadoId;
	}

}
