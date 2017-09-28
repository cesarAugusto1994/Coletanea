package com.coletaneaicm.coletanea.coletanea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;

public class CategoriasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        TextView nomeColecao = (TextView) findViewById(R.id.nome_colecao);
        nomeColecao.setText("Categorias");

        String[] categorias = { "Clamor", "Dedicacao", "Comunhao" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categorias);

        ListView listaCategorias = (ListView) findViewById(R.id.lista_categorias);
        listaCategorias.setAdapter(adapter);

    }
}
