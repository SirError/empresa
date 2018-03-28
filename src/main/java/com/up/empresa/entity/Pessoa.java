package com.up.empresa.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pessoa {

	@SerializedName("id")
	@Expose
	private Long id;
	@SerializedName("title")
	@Expose
	private String title;

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
