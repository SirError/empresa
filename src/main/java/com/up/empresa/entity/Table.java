package com.up.empresa.entity;

import java.util.ArrayList;
import java.util.List;

public class Table<T> {

	private int count;

	private List<T> rows = new ArrayList<>();

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}