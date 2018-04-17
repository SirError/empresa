package com.up.empresa.lazydatatable;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.up.empresa.entity.Administrador;
import com.up.empresa.entity.Table;
import com.up.empresa.service.AdministradorService;

@Named
public class AdministradoresDataModel extends LazyDataModel<Administrador> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AdministradorService datasource;
	private List<Administrador> data;

	@Override
	public Administrador getRowData(String rowKey) {
		for (Administrador pessoa : data) {
			if (pessoa.getId().toString().equals(rowKey))
				return pessoa;
		}

		return null;
	}

	@Override
	public Object getRowKey(Administrador pessoa) {
		return pessoa.getId();
	}

	@Override
	public List<Administrador> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		try {
			String filter = (String) filters.get("globalFilter");
			int p = first / pageSize;
			Table<Administrador> page = datasource.getPage(++p, pageSize, filter);
			this.setRowCount(page.getCount());
			data = page.getRows();

			return data;

		} catch (Exception e) {
			return null;
		}
	}
}