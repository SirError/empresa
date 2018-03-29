package com.up.empresa.service;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeopleServiceGenerator {

	private static final String BASE_URL = "https://dev-api-deploy.com/";

	private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL)
			.addConverterFactory(GsonConverterFactory.create());

	private static Retrofit retrofit = builder.build();

	private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
	
	public static <S> S createService(Class<S> serviceClass) {
		return retrofit.create(serviceClass);
	}
	
	public static <S> S createServiceToken(Class<S> serviceClass, String token) {
		return client(token).create(serviceClass);
	}
	
	public static Retrofit client(String token) {
		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
			@Override
			public Response intercept(Chain chain) throws IOException {
				Request newRequest  = chain.request().newBuilder()
						.addHeader("Authorization", "Bearer " + token)
						.build();
				return chain.proceed(newRequest);
			}
		}).build();
		
		return new Retrofit.Builder()
	    .client(client)
	    .baseUrl(BASE_URL)
	    .addConverterFactory(GsonConverterFactory.create())
	    .build();
	}
	
	
	

}