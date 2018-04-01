package com.up.empresa.entity;

public class Pessoa {

	// @JsonProperty(access = Access.WRITE_ONLY)
	private Long id = 0L;

	private String title;

	public Pessoa() {
	}

	public Pessoa(String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", title=" + title + "]";
	}

}
