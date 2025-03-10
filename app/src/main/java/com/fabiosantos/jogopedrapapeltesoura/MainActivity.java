package com.fabiosantos.jogopedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selecionarPedra(View view){
        verificarGanhador("pedra");
    }

    public void selecionarPapel(View view){
        verificarGanhador("papel");


    }

    public void selecionarTesoura(View view){
        verificarGanhador("tesoura");
    }

    private String gerarEscolhaAleatoriaApp() {

        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numeroAleatorio = new Random().nextInt(3);
        ImageView imagemApp = findViewById(R.id.image_app);

        String escolhaApp = opcoes[numeroAleatorio];

        if(escolhaApp == "pedra"){
            imagemApp.setImageResource(R.drawable.pedra);
        } else if (escolhaApp == "papel") {
            imagemApp.setImageResource(R.drawable.papel);
        } else{
            imagemApp.setImageResource(R.drawable.tesoura);
        }

        return escolhaApp;
    }

    private void verificarGanhador(String escolhausuario){
        String escolhaApp = gerarEscolhaAleatoriaApp();
        TextView textoResultado = findViewById(R.id.text_resultado);

        if(
                (escolhaApp == "pedra" && escolhausuario == "tesoura") ||
                (escolhaApp == "papel" && escolhausuario == "pedra") ||
                (escolhaApp == "tesoura" && escolhausuario == "papel")
        ){
            textoResultado.setText("Você perdeu 😔");
        } else if (
                (escolhausuario == "pedra" && escolhaApp == "tesoura") ||
                (escolhausuario == "papel" && escolhaApp == "pedra") ||
                (escolhausuario == "tesoura" && escolhaApp == "papel")
        ){
            textoResultado.setText("Voce ganhou! 🥳");
        } else{
            textoResultado.setText("Empate 🙄");
        }
    }


}