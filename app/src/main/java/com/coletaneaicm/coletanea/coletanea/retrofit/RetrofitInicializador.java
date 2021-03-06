package com.coletaneaicm.coletanea.coletanea.retrofit;

import com.coletaneaicm.coletanea.coletanea.Entities.Colecoes;
import com.coletaneaicm.coletanea.coletanea.services.CategoriasService;
import com.coletaneaicm.coletanea.coletanea.services.ColecoesService;
import com.coletaneaicm.coletanea.coletanea.services.MusicaService;
import com.coletaneaicm.coletanea.coletanea.services.MusicasService;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cesar on 26/09/17.
 */
public class RetrofitInicializador {

    private final Retrofit retrofit;

    public RetrofitInicializador() {
        retrofit = new Retrofit.Builder().baseUrl("https://coletaneaicm.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public ColecoesService getColecoes() {
        return retrofit.create(ColecoesService.class);
    }

    public CategoriasService getCategorias() {
        return retrofit.create(CategoriasService.class);
    }

    public MusicasService getMusicas() {
        return retrofit.create(MusicasService.class);
    }

    public MusicaService getMusica() {
        return retrofit.create(MusicaService.class);
    }


}
