package com.up.empresa.lazydatatable;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.up.empresa.entity.Pessoa;
import com.up.empresa.entity.Table;
import com.up.empresa.service.PessoaService;

@Named
public class LazyPessoaDataModel extends LazyDataModel<Pessoa> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PessoaService datasource;
	private List<Pessoa> data;

	@Override
	public Pessoa getRowData(String rowKey) {
		for (Pessoa pessoa : data) {
			if (pessoa.getId().toString().equals(rowKey))
				return pessoa;
		}

		return null;
	}

	@Override
	public Object getRowKey(Pessoa pessoa) {
		return pessoa.getId();
	}

	@Override
	public List<Pessoa> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		try {
			String filter = (String) filters.get("globalFilter");
			int p =	first / pageSize;	
			Table<Pessoa> page = datasource.getPage(++p, pageSize, filter);
			this.setRowCount(page.getCount());
			data = page.getRows();
			
			return data;
			
		} catch (Exception e) {
			return null;
		}
	}
}