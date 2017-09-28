package com.coletaneaicm.coletanea.coletanea.services;

import com.coletaneaicm.coletanea.coletanea.Entities.Colecoes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by cesar on 26/09/17.
 */
public interface ColecoesService {

    @GET("colecoes")
    Call<List<Colecoes>> getColecoes();
}
