package com.example.luciano.jogodavelha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pontuacao extends AppCompatActivity {

    private TextView txtviewJog1;
    private TextView txtviewJog2;

    private int pontuacaoX = 0;
    private int pontuacaoO = 0;
    private int pontuacaoVelha = 0;

    private List<Jogadores> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao);

        txtviewJog1 = (TextView) findViewById(R.id.txwJog1);
        txtviewJog2 = (TextView) findViewById(R.id.txwJog2);

        list = new ArrayList<Jogadores>();

        Iterator<Jogadores> jogadoresIterator = Jogadores.findAll(Jogadores.class);

        while (jogadoresIterator.hasNext()){
            Jogadores jogador = jogadoresIterator.next();
            list.add(jogador);
        }

        for (int i=0; i < list.size(); i++){
            pontuacaoX += list.get(i).getJogador1();
            pontuacaoO += list.get(i).getJogador2();
            pontuacaoVelha += list.get(i).getVelha();
        }

        txtviewJog1.setText(" "+pontuacaoX);
        txtviewJog2.setText(" "+pontuacaoO);

    }
}
