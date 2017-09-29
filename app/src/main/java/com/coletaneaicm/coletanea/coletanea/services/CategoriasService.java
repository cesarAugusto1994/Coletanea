package com.coletaneaicm.coletanea.coletanea.services;

import com.coletaneaicm.coletanea.coletanea.Entities.Categorias;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by cesar on 28/09/17.
 */
public interface CategoriasService {

    @GET("collection/{id}")
    Call<List<Categorias>> getCategorias(@Path("id") int id);
}
