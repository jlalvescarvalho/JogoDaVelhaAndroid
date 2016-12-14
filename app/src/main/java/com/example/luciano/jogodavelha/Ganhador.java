package com.example.luciano.jogodavelha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ganhador extends AppCompatActivity {

    private TextView Vencedor;
    private String Venceu;
    private Button Novo;
    private Button Pontos;

    private int jogador1 = 0;
    private int jogador2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganhador);

        Vencedor = (TextView) findViewById(R.id.txtVencedor);
        Novo = (Button) findViewById(R.id.btNovo);
        Pontos = (Button) findViewById(R.id.btPontos);

        Venceu = getIntent().getExtras().getString("Vencedor");

        Vencedor.setText(Venceu);

        if(Venceu.equals("Jogador X venceu !")){
            jogador1++;
        }else if(Venceu.equals("Jogador O venceu !")){
            jogador2++;
        }


        Pontos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Ganhador.this, Pontuacao.class);
                it.putExtra("Vencedor1", jogador1);
                it.putExtra("Vencedor2", jogador2);
                startActivity(it);
            }
        });

        Novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Ganhador.this, MainActivity.class);
                startActivity(it);
            }
        });
    }

    public String getVenceu() {
        return Venceu;
    }

    public void setVenceu(String venceu) {
        Venceu = venceu;
    }
}
