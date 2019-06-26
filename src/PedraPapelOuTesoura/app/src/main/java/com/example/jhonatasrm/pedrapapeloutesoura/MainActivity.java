package com.example.jhonatasrm.pedrapapeloutesoura;

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

    // método onCreate que chama o layout em xml da Main Activity e o método que inicializa os findViewById
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configuracaoInicial();
        random = new Random();
    }

    // jogada da máquina onde um valor random é atribuido a uma imagem
    public void jogadaMaquina() {
        valorRandom = random.nextInt(3);
        if (valorRandom == 0) {
            jogoMaquina.setImageResource(R.drawable.pedra);
        } else if (valorRandom == 1) {
            jogoMaquina.setImageResource(R.drawable.papel);
        } else {
            jogoMaquina.setImageResource(R.drawable.tesoura);
        }
    }

    // caso clicado no papel compara com a jogada da máquina
    public void jogaPapel(View view) {
        jogadaMaquina();
        if (valorRandom == 0) {
            resultado.setText(R.string.voce_ganhou);
            vitorias = vitorias + 1;
        } else if (valorRandom == 1) {
            resultado.setText(R.string.empate);
            empates = empates + 1;
        } else {
            resultado.setText(R.string.voce_perdeu);
            derrotas = derrotas + 1;
        }
        mostraResultados();
    }

    // caso clicado na pedra compara com a jogada da máquina
    public void jogaPedra(View view) {
        jogadaMaquina();
        if (valorRandom == 0) {
            resultado.setText(R.string.empate);
            empates = empates + 1;
        } else if (valorRandom == 1) {
            resultado.setText(R.string.voce_perdeu);
            derrotas = derrotas + 1;
        } else {
            resultado.setText(R.string.voce_ganhou);
            vitorias = vitorias + 1;
        }
        mostraResultados();
    }

    // caso clicado na tesoura compara com a jogada da máquina
    public void jogaTesoura(View view) {
        jogadaMaquina();
        if (valorRandom == 0) {
            resultado.setText(R.string.voce_perdeu);
            derrotas = derrotas + 1;
        } else if (valorRandom == 1) {
            resultado.setText(R.string.voce_ganhou);
            vitorias = vitorias + 1;
        } else {
            resultado.setText(R.string.empate);
            empates = empates + 1;
        }
        mostraResultados();
    }

    // apresenta o resultado de cada jogada
    public void mostraResultados() {
        resultadoVitorias.setText(R.string.total_vitorias);
        resultadoVitorias.append(" " + Integer.toString(vitorias));
        resultadoDerrotas.setText(R.string.total_derrotas);
        resultadoDerrotas.append(" " + Integer.toString(derrotas));
        resultadoEmpates.setText(R.string.total_empates);
        resultadoEmpates.append(" " + Integer.toString(empates));
    }

    // prepara a tela para iniciar as jogadas
    public void configuracaoInicial() {
        resultado = findViewById(R.id.resultado);
        jogoMaquina = findViewById(R.id.jogoMaquina);
        resultadoVitorias = findViewById(R.id.vitorias);
        resultadoDerrotas = findViewById(R.id.derrotas);
        resultadoEmpates = findViewById(R.id.empates);
        resultado.setText(R.string.clique_para_comecar);

        vitorias = 0;
        derrotas = 0;
        empates = 0;
    }
}
