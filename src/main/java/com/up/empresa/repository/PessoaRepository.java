package com.up.empresa.repository;

import com.up.empresa.entity.Pessoa;
import com.up.empresa.entity.Table;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PessoaRepository {

	@GET("people")
	Call<Table> listPessoas();

	@GET("people/{id}")
	Call<Pessoa> getPessoa(@Path("id") int groupId);

	@POST("people")
	public void salvaPessoa(@Body Pessoa order);

}
