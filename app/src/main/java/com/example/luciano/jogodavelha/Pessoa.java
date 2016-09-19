package com.example.luciano.jogodavelha;

import com.orm.SugarRecord;

/**
 * Created by Luciano on 13/09/2016.
 */
public class Pessoa extends SugarRecord{

    private String Nome;

    public Pessoa(String nome) {
        Nome = nome;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }
}
