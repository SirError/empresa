package com.up.empresa.service;

import java.io.IOException;
import java.util.List;

import com.up.empresa.entity.Example;
import com.up.empresa.entity.Pessoa;
import com.up.empresa.repository.PessoaRepository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PessoaService {
	public Example getPessoas() throws IOException {
		Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dev-api-deploy.com/").addConverterFactory(GsonConverterFactory.create()).build();

		PessoaRepository service = retrofit.create(PessoaRepository.class);

		return service.listPessoas().execute().body();
	}

	public Pessoa getPessoa() throws IOException {
		Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dev-api-deploy.com/")
				.addConverterFactory(GsonConverterFactory.create()).build();

		PessoaRepository service = retrofit.create(PessoaRepository.class);

		return service.getPessoa(1).execute().body();
	}

	public static void main(String[] args) {
		try {
//			System.out.println(new PessoaService().getPessoa());
			
			new PessoaService().getPessoas().getRows().forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
