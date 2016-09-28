package com.example.luciano.jogodavelha;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luciano on 13/09/2016.
 */
public class JogoDaVelha {

    private  String[][] tabuleiro = new String[3][3];
    private String Jogador = "X";
    private int Jogadas = 0;
    private int Vencedor = -1;


    public String realizarJogada(int p1, int p2){

        if(Jogador.equals("X")){
            if(tabuleiro[p1][p2] == null && tabuleiro[p1][p2] == null) {
                tabuleiro[p1][p2] = "X";
                Jogador = "O";
                Jogadas++;
                return "X";
            }else{
                return tabuleiro[p1][p2];
            }

        }else if(Jogador.equals("O")){
            if(tabuleiro[p1][p2] == null && tabuleiro[p1][p2] == null) {
                tabuleiro[p1][p2] = "O";
                Jogador = "X";
                Jogadas++;
                return "O";
            }else{
                return tabuleiro[p1][p2];
            }
        }

        return "#";
    }

    public int VerificarVencedor(){

        if(Jogadas == 9){
            Vencedor = 2;
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
                Vencedor = 0;
            }else if(JogadasVencedoras.get(i).equals("OOO")){
                Vencedor = 1;
            }
        }

        return Vencedor;
    }

    public String Ganhou(int n){
        if(n == 0){
            return "Jogador X venceu !";
        }else if(n == 1){
            return "Jogador O venceu !";
        }else{
            return "#Deu Velha#";
        }
    }

    public int getVencedor() {
        return Vencedor;
    }

    public void setVencedor(int vencedor) {
        Vencedor = vencedor;
    }
}
