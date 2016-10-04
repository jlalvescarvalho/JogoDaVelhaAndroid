package com.example.luciano.jogodavelha;

import com.orm.SugarRecord;

/**
 * Created by Luciano on 04/10/2016.
 */
public class Jogadores extends SugarRecord{

    private int Jogador1;
    private int Jogador2;

    public Jogadores() {
    }

    public int getJogador1() {
        return Jogador1;
    }

    public void setJogador1(int jogador1) {
        Jogador1 = jogador1;
    }

    public int getJogador2() {
        return Jogador2;
    }

    public void setJogador2(int jogador2) {
        Jogador2 = jogador2;
    }
}
