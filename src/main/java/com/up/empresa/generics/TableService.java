package com.up.empresa.generics;

import com.up.empresa.entity.Table;

public interface TableService<T> {
	Table<T> getPage(Integer page, Integer pageSize, String filter, String token, String url);
}
