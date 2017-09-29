package com.coletaneaicm.coletanea.coletanea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.coletaneaicm.coletanea.coletanea.Entities.Categorias;
import com.coletaneaicm.coletanea.coletanea.Entities.Colecoes;
import com.coletaneaicm.coletanea.coletanea.retrofit.RetrofitInicializador;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        TextView nomeColecao = (TextView) findViewById(R.id.nome_colecao);
        nomeColecao.setText("Categorias");

        Colecoes colecao = (Colecoes) getIntent().getSerializableExtra("colecao");

        Call call = new RetrofitInicializador().getCategorias().getCategorias(colecao.getId());

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

            ArrayList<Categorias> res = (ArrayList<Categorias>) response.body();
            ListView listacategorias = (ListView) findViewById(R.id.lista_categorias);
            ArrayAdapter<Categorias> adapter = new ArrayAdapter<Categorias>(CategoriasActivity.this, android.R.layout.simple_list_item_1, res);
            listacategorias.setAdapter(adapter);

                Log.i("OnResponse", "Sucesso");

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                //Log.e("onFailure", "Requisicao Falhou. " + t.getMessage());
                Log.e("onFailure", "Requisicao Falhou. " + call.request().url());

                //Toast.makeText(CategoriasActivity.this, "Requisicao Falhou. " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
