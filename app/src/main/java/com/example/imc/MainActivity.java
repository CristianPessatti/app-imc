package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edNome, edPeso, edAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edNome = findViewById(R.id.edNome);
        edPeso = findViewById(R.id.edPeso);
        edAltura = findViewById(R.id.edAltura);
    }

    public void calculaImc(View view) {
        Intent i = new Intent(this, ImcActivicty.class);
        String nome = edNome.getText().toString();
        double peso = Double.parseDouble(edPeso.getText().toString());
        double altura = Double.parseDouble(edAltura.getText().toString());

        i.putExtra("nome", nome);
        i.putExtra("peso", peso);
        i.putExtra("altura", altura);

        startActivity(i);
    }
}