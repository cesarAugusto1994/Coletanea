package com.coletaneaicm.coletanea.coletanea.retrofit;

import com.coletaneaicm.coletanea.coletanea.Entities.Colecoes;
import com.coletaneaicm.coletanea.coletanea.services.ColecoesService;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cesar on 26/09/17.
 */
public class RetrofitInicializador {

    private final Retrofit retrofit;

    public RetrofitInicializador() {
        retrofit = new Retrofit.Builder().baseUrl("http://coletaneaicm.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public ColecoesService getColecoes() {
        return retrofit.create(ColecoesService.class);
    }



}
