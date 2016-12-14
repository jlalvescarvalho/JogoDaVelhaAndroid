package com.example.luciano.jogodavelha;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Luciano on 13/12/2016.
 */
public class JogoDaVelhaTest {

    JogoDaVelha jv = new JogoDaVelha();

    @Test//testa a vitoria do X em todas as posições (linha e coluna)
    public void TestarVitoriaX(){

        for(int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                jv.setJogador("X");
                jv.realizarJogada(j, i);
            }
            assertEquals(1, jv.VerificarVencedor());
        }
    }

    @Test//testa a vitoria do O em todas as posições (linha e coluna)
    public void TestarVitoriaO(){
        for(int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                jv.setJogador("O");
                jv.realizarJogada(j, i);
            }
            assertEquals(0, jv.VerificarVencedor());
        }
    }

    @Test//Testa uma diagonal com X
    public void TestaVitoriaDiagonalComX(){
        for(int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                if(j == i){
                    jv.setJogador("X");
                    jv.realizarJogada(j, i);
                }
            }
        }
        assertEquals(1, jv.VerificarVencedor());
    }

    @Test//Testa uma diagonal com O
    public void TestaVitoriaDiagonalComO(){
        for(int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                if(j == i){
                    jv.setJogador("O");
                    jv.realizarJogada(j, i);
                }
            }
        }
        assertEquals(0, jv.VerificarVencedor());
    }

    @Test//Testa a outra diagonal com O
    public void TestaDiagonaComO(){
        jv.setJogador("O");
        jv.realizarJogada(0,2);
        jv.setJogador("O");
        jv.realizarJogada(1,1);
        jv.setJogador("O");
        jv.realizarJogada(2, 0);
        assertEquals(0, jv.VerificarVencedor());

    }

    @Test//Testa a outra diagonal com X
    public void TestaDiagonaComX(){
        jv.setJogador("X");
        jv.realizarJogada(0,2);
        jv.setJogador("X");
        jv.realizarJogada(1,1);
        jv.setJogador("X");
        jv.realizarJogada(2, 0);
        assertEquals(1, jv.VerificarVencedor());

    }

    @Test//testa empate
    public void TestarEmpate(){
        jv.setJogador("O");
        jv.realizarJogada(0,0);
        jv.setJogador("X");
        jv.realizarJogada(0,1);
        jv.setJogador("X");
        jv.realizarJogada(0,2);
        jv.setJogador("X");
        jv.realizarJogada(1,0);
        jv.setJogador("O");
        jv.realizarJogada(1,1);
        jv.setJogador("O");
        jv.realizarJogada(1,2);
        jv.setJogador("O");
        jv.realizarJogada(2,0);
        jv.setJogador("O");
        jv.realizarJogada(2,1);
        jv.setJogador("X");
        jv.realizarJogada(2, 2);

        assertEquals(2, jv.VerificarVencedor());

    }
}