package com.up.empresa.repository;

import com.up.empresa.entity.Example;
import com.up.empresa.entity.Pessoa;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PessoaRepository {
	@GET("people")
	Call<Example> listPessoas();

	@GET("people/{id}")
	Call<Pessoa> getPessoa(@Path("id") int groupId);
}
