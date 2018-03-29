package com.up.empresa.service;

import java.io.IOException;

import com.up.empresa.entity.Table;
import com.up.empresa.entity.Token;
import com.up.empresa.entity.Pessoa;
import com.up.empresa.repository.LoginRepository;
import com.up.empresa.repository.PessoaRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PessoaService {
	public Table getPessoas() throws IOException {
		PessoaRepository repository = PeopleServiceGenerator.createService(PessoaRepository.class);

		return repository.listPessoas().execute().body();
	}

	public Pessoa getPessoa() throws IOException {

		PessoaRepository repository = PeopleServiceGenerator.createService(PessoaRepository.class);

		return repository.getPessoa(1).execute().body();

	}

	public static void main(String[] args) {
		try {
			LoginRepository loginRepository = PeopleServiceGenerator.createService(LoginRepository.class);
			
			Token body = loginRepository.login().execute().body();
			System.out.println(body.getToken());
			
			Pessoa pessoa = new Pessoa();
			pessoa.setTitle("Hello World");
			
			PessoaRepository repository = PeopleServiceGenerator.createServiceToken(PessoaRepository.class, body.getToken());
			repository.salvaPessoa(pessoa);
			new PessoaService().getPessoas().getRows().forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
