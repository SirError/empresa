package com.up.empresa.repository;

import com.up.empresa.entity.Token;

import retrofit2.Call;
import retrofit2.http.POST;

public interface LoginRepository {

	@POST("login")
	Call<Token> login();

}
