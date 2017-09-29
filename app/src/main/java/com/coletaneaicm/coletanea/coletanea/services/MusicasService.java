package com.coletaneaicm.coletanea.coletanea.services;

import com.coletaneaicm.coletanea.coletanea.Entities.Musicas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by cesar on 28/09/17.
 */
public interface MusicasService {

    @GET("category/{id}")
    Call<List<Musicas>> getMusicas(@Path("id") int id);
}
