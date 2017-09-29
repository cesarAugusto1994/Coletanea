package com.coletaneaicm.coletanea.coletanea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.coletaneaicm.coletanea.coletanea.Entities.Categorias;
import com.coletaneaicm.coletanea.coletanea.Entities.Musica;
import com.coletaneaicm.coletanea.coletanea.Entities.Musicas;
import com.coletaneaicm.coletanea.coletanea.retrofit.RetrofitInicializador;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MusicasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicas);

        Categorias categoria = (Categorias) getIntent().getSerializableExtra("categoria");

        Call call = new RetrofitInicializador().getMusicas().getMusicas(categoria.getId());

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

                ListView listaMusicas = (ListView) findViewById(R.id.lista_musicas);

                ArrayList<Musicas> res = (ArrayList<Musicas>) response.body();

                final ArrayAdapter<Musicas> adapter = new ArrayAdapter<Musicas>(MusicasActivity.this, android.R.layout.simple_list_item_1, res);

                listaMusicas.setAdapter(adapter);

                listaMusicas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Musicas musica = (Musicas) adapterView.getItemAtPosition(i);

                        Intent irParaMusica = new Intent(MusicasActivity.this, MusicaActivity.class);
                        irParaMusica.putExtra("musica", musica);
                        startActivity(irParaMusica);
                    }
                });

                Log.i("OnResponse", "Sucesso "  + call.request().url());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("onFailure", "Requisicao Falhou. " + call.request().url());
            }
        });
    }
}
