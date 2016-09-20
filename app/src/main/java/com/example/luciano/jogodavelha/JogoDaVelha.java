package com.example.luciano.jogodavelha;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luciano on 13/09/2016.
 */
public class JogoDaVelha {

    private  String[][] tabuleiro = new String[3][3];
    private String Jogador = " ";
    private int Jogadas = 0;


    public void realizarJogada(int p1, int p2){
        if(Jogadas == 0){
            tabuleiro[p1][p2] = "X";
            Jogador = "O";
        }else if(Jogador.equals("X")){
            tabuleiro[p1][p2] = "X";
        }
    }

    public String VerificarVencedor(int Jogadas){

        String Vencedor = "";
        if(Jogadas == 9){
            Vencedor = "#Deu Velha#";
        }


        List<String> JogadasVencedoras = new ArrayList<>();

        JogadasVencedoras.add(tabuleiro[0][0]+tabuleiro[0][1]+tabuleiro[0][2]);
        JogadasVencedoras.add(tabuleiro[1][0]+tabuleiro[1][1]+tabuleiro[1][2]);
        JogadasVencedoras.add(tabuleiro[2][0]+tabuleiro[2][1]+tabuleiro[2][2]);
        JogadasVencedoras.add(tabuleiro[0][0]+tabuleiro[1][0]+tabuleiro[2][0]);
        JogadasVencedoras.add(tabuleiro[0][1]+tabuleiro[1][1]+tabuleiro[2][1]);
        JogadasVencedoras.add(tabuleiro[0][2]+tabuleiro[1][2]+tabuleiro[2][2]);
        JogadasVencedoras.add(tabuleiro[0][0]+tabuleiro[1][1]+tabuleiro[2][2]);
        JogadasVencedoras.add(tabuleiro[0][2]+tabuleiro[1][1]+tabuleiro[2][2]);


        for(int i = 0; i < tabuleiro.length; i++){
            if(JogadasVencedoras.get(i).equals("XXX")){
                Vencedor = "Jogador X Venceu";
            }else if(JogadasVencedoras.get(i).equals("OOO")){
                Vencedor = "Jogador O Venceu";
            }
        }

        return Vencedor;
    }

 }
