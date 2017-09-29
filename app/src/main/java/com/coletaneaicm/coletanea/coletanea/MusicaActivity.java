package com.coletaneaicm.coletanea.coletanea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.coletaneaicm.coletanea.coletanea.Entities.Categorias;
import com.coletaneaicm.coletanea.coletanea.Entities.Musica;
import com.coletaneaicm.coletanea.coletanea.Entities.Musicas;
import com.coletaneaicm.coletanea.coletanea.retrofit.RetrofitInicializador;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MusicaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);

        Musicas musicas = (Musicas) getIntent().getSerializableExtra("musica");

        Call call = new RetrofitInicializador().getMusica().getMusica(musicas.getId());

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

                TextView nome = (TextView) findViewById(R.id.musica_nome);
                TextView letra = (TextView) findViewById(R.id.musica_letra);

                Musica musica = (Musica) response.body();

                nome.setText(musica.getNome());
                letra.setText(musica.getLetra());

                Log.i("OnResponse", "Sucesso "  + musica.getNome());

                //Log.i("OnResponse", "Sucesso "  + call.request().url());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("onFailure", "Requisicao Falhou. " + t.getMessage());
                Log.e("onFailure", "Requisicao Falhou. " + call.request().url());
            }
        });


    }
}
