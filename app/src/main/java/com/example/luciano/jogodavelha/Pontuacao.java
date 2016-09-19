package com.example.luciano.jogodavelha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Pontuacao extends AppCompatActivity {

    private TextView Jogador1;
    private TextView Jogador2;

    private int pontuacao1;
    private int pontuacao2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao);

        Jogador1 = (TextView) findViewById(R.id.txwJog1);
        Jogador2 = (TextView) findViewById(R.id.txwJog2);

        pontuacao1 = getIntent().getExtras().getInt("Vencedor1");
        pontuacao2 = getIntent().getExtras().getInt("Vencedor2");

        Jogador1.setText(""+pontuacao1);
        Jogador2.setText(""+pontuacao2);
    }
}
