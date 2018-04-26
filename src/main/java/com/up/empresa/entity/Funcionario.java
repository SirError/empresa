
package com.up.empresa.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.up.empresa.generics.Entidade;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "numero_registro", "nome", "cpf", "rg", "email", "data_nascimento", "telefone", "mae",
		"limite" })
public class Funcionario implements Entidade {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("numero_registro")
	private String numeroRegistro;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("cpf")
	private String cpf;

	@JsonProperty("rg")
	private String rg;

	@JsonProperty("email")
	private String email;

	@JsonProperty("data_nascimento")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataNascimento;

	@JsonProperty("telefone")
	private String telefone;

	@JsonProperty("mae")
	private String mae;

	@JsonProperty("limite")
	private BigDecimal limite;

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

	@JsonProperty("numero_registro")
	public String getNumeroRegistro() {
		return numeroRegistro;
	}

	@JsonProperty("numero_registro")
	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	@JsonProperty("nome")
	public String getNome() {
		return nome;
	}

	@JsonProperty("nome")
	public void setNome(String nome) {
		this.nome = nome;
	}

	@JsonProperty("cpf")
	public String getCpf() {
		return cpf;
	}

	@JsonProperty("cpf")
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@JsonProperty("rg")
	public String getRg() {
		return rg;
	}

	@JsonProperty("rg")
	public void setRg(String rg) {
		this.rg = rg;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("data_nascimento")
	public Date getDataNascimento() {
		return dataNascimento;
	}

	@JsonProperty("data_nascimento")
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@JsonProperty("telefone")
	public String getTelefone() {
		return telefone;
	}

	@JsonProperty("telefone")
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@JsonProperty("mae")
	public String getMae() {
		return mae;
	}

	@JsonProperty("mae")
	public void setMae(String mae) {
		this.mae = mae;
	}

	@JsonProperty("limite")
	public BigDecimal getLimite() {
		return limite;
	}

	@JsonProperty("limite")
	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
