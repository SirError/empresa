package com.up.empresa.lazydatatable;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.up.empresa.entity.Table;
import com.up.empresa.generics.Entidade;
import com.up.empresa.generics.TableService;

public class GenericDataModel<T extends Entidade> extends LazyDataModel<T> {

	private static final long serialVersionUID = 1L;

	private TableService<T> datasource;

	private String token;

	private List<T> data;

	private String url;

	public GenericDataModel(TableService<T> datasource, String token, String url) {
		this.datasource = datasource;
		this.token = token;
		this.url = url != null ? url : "";
	}

	@Override
	public T getRowData(String rowKey) {
		for (T entidade : data) {
			if (entidade.getId().toString().equals(rowKey))
				return entidade;
		}

		return null;
	}

	@Override
	public Object getRowKey(T entidade) {
		return entidade.getId();
	}

	@Override
	public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		try {
			String filter = (String) filters.get("globalFilter");
			int p = first / pageSize;
			Table<T> page = datasource.getPage(++p, pageSize, filter, token, this.url);
			this.setRowCount(page.getCount());
			data = page.getRows();

			return data;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}