package com.up.empresa.entity;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

	@SerializedName("rows")
	@Expose
	private List<Pessoa> rows = new ArrayList<>();

	public List<Pessoa> getRows() {
		return rows;
	}

	public void setRows(List<Pessoa> rows) {
		this.rows = rows;
	}

}