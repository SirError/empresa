package com.up.empresa.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.up.empresa.generics.Entidade;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "razao", "fantasia", "cnpj", "ie", "email", "telefone", "proprietario", "contato", "taxa",
		"data_fechamento" })
public class Empresa implements Entidade {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("razao")
	private String razao;

	@JsonProperty("fantasia")
	private String fantasia;

	@JsonProperty("cnpj")
	private String cnpj;

	@JsonProperty("ie")
	private String ie;

	@JsonProperty("email")
	private String email;

	@JsonProperty("telefone")
	private String telefone;

	@JsonProperty("proprietario")
	private String proprietario;

	@JsonProperty("contato")
	private String contato;

	@JsonProperty("taxa")
	private BigDecimal taxa;

	@JsonProperty("data_fechamento")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataFechamento;

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("razao")
	public String getRazao() {
		return razao;
	}

	@JsonProperty("razao")
	public void setRazao(String razao) {
		this.razao = razao;
	}

	@JsonProperty("fantasia")
	public String getFantasia() {
		return fantasia;
	}

	@JsonProperty("fantasia")
	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	@JsonProperty("cnpj")
	public String getCnpj() {
		return cnpj;
	}

	@JsonProperty("cnpj")
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@JsonProperty("ie")
	public String getIe() {
		return ie;
	}

	@JsonProperty("ie")
	public void setIe(String ie) {
		this.ie = ie;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("telefone")
	public String getTelefone() {
		return telefone;
	}

	@JsonProperty("telefone")
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@JsonProperty("proprietario")
	public String getProprietario() {
		return proprietario;
	}

	@JsonProperty("proprietario")
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	@JsonProperty("contato")
	public String getContato() {
		return contato;
	}

	@JsonProperty("contato")
	public void setContato(String contato) {
		this.contato = contato;
	}

	@JsonProperty("taxa")
	public BigDecimal  getTaxa() {
		return taxa;
	}

	@JsonProperty("taxa")
	public void setTaxa(BigDecimal  taxa) {
		this.taxa = taxa;
	}

	@JsonProperty("data_fechamento")
	public Date getDataFechamento() {
		return dataFechamento;
	}

	@JsonProperty("data_fechamento")
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

}
