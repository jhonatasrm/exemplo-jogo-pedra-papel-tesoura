package com.example.jhonatasrm.pedrapapeloutesoura;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView resultado, resultadoVitorias, resultadoDerrotas, resultadoEmpates;
    int vitorias, derrotas, empates;
    ImageButton jogoMaquina;
    int valorRandom;
    Random random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();

        resultado = findViewById(R.id.resultado);
        jogoMaquina = findViewById(R.id.jogoMaquina);
        resultadoVitorias  = findViewById(R.id.vitorias);
        resultadoDerrotas = findViewById(R.id.derrotas);
        resultadoEmpates = findViewById(R.id.empates);
        resultado.setText("CLIQUE PARA COMEÇAR");

        //
        vitorias = 0;
        derrotas = 0;
        empates = 0;
    }

    public  void jogadaMaquina(){
        SystemClock.sleep(500);
        valorRandom = random.nextInt(3);
        if(valorRandom == 0){
            jogoMaquina.setImageResource(R.drawable.pedra);
        }else if (valorRandom == 1){
            jogoMaquina.setImageResource(R.drawable.papel);
        }else{
            jogoMaquina.setImageResource(R.drawable.tesoura);
        }
    }

    public  void jogaPapel(View view){
        jogadaMaquina();
        if(valorRandom == 0){
            resultado.setText("VOCÊ GANHOU !!!");
            vitorias = vitorias + 1;
        }else if(valorRandom == 1){
            resultado.setText("EMPATE !!!");
            empates = empates + 1;
        }else{
            resultado.setText("VOCÊ PERDEU !!!");
            derrotas = derrotas + 1;
        }
        mostraResultados();
    }
    public  void jogaPedra(View view){
        jogadaMaquina();
        if(valorRandom == 0){
            resultado.setText("EMPATE !!!");
            empates = empates + 1;
        }else if(valorRandom == 1){
            resultado.setText("VOCÊ PERDEU !!!");
            derrotas = derrotas + 1;
        }else{
            resultado.setText("VOCÊ VENCEU !!!");
            vitorias = vitorias + 1;
        }
        mostraResultados();
    }
    public  void jogaTesoura(View view){
        jogadaMaquina();
        if(valorRandom == 0){
            resultado.setText("VOCÊ PERDEU !!!");
            derrotas = derrotas + 1;
        }else if(valorRandom == 1){
            resultado.setText("VOCÊ VENCEU !!!");
            vitorias = vitorias + 1;
        }else{
            resultado.setText("EMPATE !!!");
            empates = empates + 1;
        }
        mostraResultados();
    }

    public void mostraResultados(){
        resultadoVitorias.setText("Vitórias = "+vitorias);
        resultadoDerrotas.setText("Derrotas = "+derrotas);
        resultadoEmpates.setText("Empates = "+empates);

    }

}
