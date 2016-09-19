package com.example.luciano.jogodavelha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Jogo extends AppCompatActivity {

    private Button btInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        btInicio = (Button) findViewById(R.id.btInicio);

        btInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Jogo.this, MainActivity.class);
                startActivity(it);
            }
        });
    }
}
