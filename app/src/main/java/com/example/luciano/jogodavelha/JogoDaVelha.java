package com.example.luciano.jogodavelha;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luciano on 13/09/2016.
 */
public class JogoDaVelha {

    private Jogadores jogadores;

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
        JogadasVencedoras.add(tabuleiro[0][2]+tabuleiro[1][1]+tabuleiro[0][2]);


        for(int i = 0; i < JogadasVencedoras.size(); i++){
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
            Save_Update(n);
            return "Jogador X venceu !";
        }else if(n == 1){
            Save_Update(n);
            return "Jogador O venceu !";
        }else{
            Save_Update(n);
            return "#Deu Velha#";
        }
    }

    public void Save_Update(int venc){

        if(venc == 0){
            int i = 1;
            jogadores = new Jogadores(i,0,0);
            jogadores.save();
            i++;
        }else if(venc == 1){
            int i = 1;
            jogadores = new Jogadores(0,i,0);
            jogadores.save();
            i++;
        }else{
            int i = 1;
            jogadores = new Jogadores(0,0,i);
            jogadores.save();
            i++;
        }
    }

    public int getVencedor() {
        return Vencedor;
    }

    public void setVencedor(int vencedor) {
        Vencedor = vencedor;
    }
}
