package com.example.luciano.jogodavelha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

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
        Jogador.setTextColor(getResources().getColor(R.color.colorPrimary));
        Ganhador = (TextView) findViewById(R.id.txtGanhador);

        bt11.setOnClickListener(this);
        bt12.setOnClickListener(this);
        bt13.setOnClickListener(this);
        bt21.setOnClickListener(this);
        bt22.setOnClickListener(this);
        bt23.setOnClickListener(this);
        bt31.setOnClickListener(this);
        bt32.setOnClickListener(this);
        bt33.setOnClickListener(this);

        Pessoa pessoa = new Pessoa("Luciano Alves");
        pessoa.save();
    }

    public String Ganhou(int Njogadas){


        String Vencedor = "";
        if(Njogadas == 9){
            Vencedor = "#Deu Velha#";
        }

        List<String> Jogadas = new ArrayList<>();
        Jogadas.add(bt11.getText().toString() + bt12.getText().toString() + bt13.getText().toString());
        Jogadas.add(bt21.getText().toString() + bt22.getText().toString() + bt23.getText().toString());
        Jogadas.add(bt31.getText().toString() + bt32.getText().toString() + bt33.getText().toString());
        Jogadas.add(bt11.getText().toString() + bt21.getText().toString() + bt31.getText().toString());
        Jogadas.add(bt12.getText().toString() + bt22.getText().toString() + bt32.getText().toString());
        Jogadas.add(bt13.getText().toString() + bt23.getText().toString() + bt33.getText().toString());
        Jogadas.add(bt11.getText().toString() + bt22.getText().toString() + bt33.getText().toString());
        Jogadas.add(bt13.getText().toString() + bt22.getText().toString() + bt31.getText().toString());


        for(int i=0; i < Jogadas.size(); i++){
            if(Jogadas.get(i).equals("XXX")){
                Vencedor = "Jogador X Venceu";
            }else if(Jogadas.get(i).equals("OOO")){
                Vencedor = "Jogador O Venceu";
            }
        }
        return Vencedor;
    }

    @Override
    public void onClick(View view) {
            jogadas++;
        if(Jogador.getText().equals("Jogador 1")) {
            if(((Button) view).getText().equals("X") || ((Button) view).getText().equals("O")){}else {
                ((Button) view).setText("X");
                Ganhador.setText(jogoDaVelha.VerificarVencedor(jogadas));
                Jogador.setText(Jogador2);
                Jogador.setTextColor(getResources().getColor(R.color.colorAccent));

            }
        }else if(Jogador.getText().equals("Jogador 2")){
            if(((Button) view).getText().equals("X") || ((Button) view).getText().equals("O")){}else {
                ((Button) view).setText("O");
                ((Button) view).setTextColor(getResources().getColor(R.color.colorAccent));
                Ganhador.setText(jogoDaVelha.VerificarVencedor(jogadas));
                Jogador.setText(Jogador1);
                JogoDaVelha.tabuleiro[0][0] = "X";
                Jogador.setTextColor(getResources().getColor(R.color.colorPrimary));

            }
        }
        if(Ganhador.getText().equals("Jogador X Venceu") || Ganhador.getText().equals("Jogador O Venceu") || Ganhador.getText().equals("#Deu Velha#")){

            Intent it = new Intent(this, Ganhador.class);
            it.putExtra("Vencedor", Ganhador.getText().toString());
            startActivity(it);

        }

    }
}
