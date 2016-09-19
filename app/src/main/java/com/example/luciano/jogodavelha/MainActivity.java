package com.example.luciano.jogodavelha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private Button bt11;
    private Button bt12;
    private Button bt13;

    private Button bt21;
    private Button bt22;
    private Button bt23;

    private Button bt31;
    private Button bt32;
    private Button bt33;

    private TextView Jogador;
    private TextView Ganhador;

    private String Jogador1 = "Jogador 1";
    private String Jogador2 = "Jogador 2";

    private int jogadas=0;

    private JogoDaVelha jogoDaVelha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt11 = (Button) findViewById(R.id.bt11);
        bt12 = (Button) findViewById(R.id.bt12);
        bt13 = (Button) findViewById(R.id.bt13);

        bt21 = (Button) findViewById(R.id.bt21);
        bt22 = (Button) findViewById(R.id.bt22);
        bt23 = (Button) findViewById(R.id.bt23);

        bt31 = (Button) findViewById(R.id.bt31);
        bt32 = (Button) findViewById(R.id.bt32);
        bt33 = (Button) findViewById(R.id.bt33);

        Jogador = (TextView) findViewById(R.id.txtJogador);
        Jogador.setText(Jogador1);
        Ganhador = (TextView) findViewById(R.id.txtGanhador);

        bt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt11.setText("X");
                JogoDaVelha.tabuleiro[0][0] = "X";
            }
        });
        Pessoa pessoa = new Pessoa("Luciano Alves");
        pessoa.save();
    }



}
