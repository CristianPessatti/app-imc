package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ImcActivicty extends AppCompatActivity {

    String nome;
    Double peso, altura;
    TextView tvNome, tvPeso, tvAltura, tvImc, tvSituacao;
    DecimalFormat decimalFormat = new DecimalFormat("##,###,###,##0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc_activicty);

        Bundle bundle = getIntent().getExtras();

        nome = bundle.getString("nome");
        peso = bundle.getDouble("peso");
        altura = bundle.getDouble("altura");

        tvNome = findViewById(R.id.tvNome);
        tvPeso = findViewById(R.id.tvPeso);
        tvAltura = findViewById(R.id.tvAltura);
        tvImc = findViewById(R.id.tvImc);
        tvSituacao = findViewById(R.id.tvSituacao);
    }

    @Override
    protected void onStart() {
        super.onStart();
        tvNome.setText(nome);
        tvPeso.setText(decimalFormat.format(peso));
        tvAltura.setText(decimalFormat.format(altura));
        tvImc.setText(decimalFormat.format(calculaImc(peso, altura)));
        tvSituacao.setText(calculaSituacao(calculaImc(peso, altura)));
    }

    public Double calculaImc(double peso, double altura) {
        return (peso / (altura * altura));
    }

    public String calculaSituacao(double imc) {
        if(imc < 18.5)
            return "Abaixo do peso";
        else if(imc < 24.9)
            return "Peso ideal";
        else if(imc < 29.9)
            return "Levemente acima do peso";
        else if(imc < 34.9)
            return "Obesidade grau I";
        else if(imc < 39.9)
            return "Obesidade grau II";
        else
            return "Obesidade grau III";
    }
}