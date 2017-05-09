package com.juego.charles.cuantos_puedes_pokeadivinar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ElegirJuego extends ActionBarActivity {


    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    private String lista_pokedex;
    private int monedas, REQUEST_CODE = 1;
    private MediaPlayer puebloPaleta;
    private SoundPool mySound;
    private int soundId;

    private boolean quiereMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_juego);

        getSupportActionBar().hide();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        Bundle param = getIntent().getExtras();

        if( param!= null) {
            lista_pokedex = param.getString("pokemon_pokedex");
            monedas = param.getInt("monedas");
            quiereMusica = param.getBoolean("musica");
        }


        mySound = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);
        soundId = mySound.load(this, R.raw.sonido_boton, 1);

        puebloPaleta = MediaPlayer.create(this, R.raw.pueblo_paleta);
        if(quiereMusica) {
            puebloPaleta.setLooping(true);
            puebloPaleta.start();
        }

        btn0 = (Button) findViewById(R.id.button2);
        btn1 = (Button) findViewById(R.id.button3);
        btn2 = (Button) findViewById(R.id.button9);
        btn3 = (Button) findViewById(R.id.button10);
        btn4 = (Button) findViewById(R.id.button11);
        btn5 = (Button) findViewById(R.id.button12);
        btn6 = (Button) findViewById(R.id.button13);
        btn7 = (Button) findViewById(R.id.button14);



        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId, 1, 1, 1, 0, 2);
                Intent in = new Intent(ElegirJuego.this, Jugar.class);
                in.putExtra("pokemon_pokedex", lista_pokedex);
                in.putExtra("monedas", monedas);
                in.putExtra("musica", quiereMusica);
                in.putExtra("categoria", 0);
                startActivityForResult(in, REQUEST_CODE);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId, 1, 1, 1, 0, 2);
                Intent in = new Intent(ElegirJuego.this, Jugar.class);
                in.putExtra("pokemon_pokedex", lista_pokedex);
                in.putExtra("monedas", monedas);
                in.putExtra("musica", quiereMusica);
                in.putExtra("categoria", 1);
                startActivityForResult(in, REQUEST_CODE);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId, 1, 1, 1, 0, 2);
                Intent in = new Intent(ElegirJuego.this, Jugar.class);
                in.putExtra("pokemon_pokedex", lista_pokedex);
                in.putExtra("monedas", monedas);
                in.putExtra("musica", quiereMusica);
                in.putExtra("categoria", 2);
                startActivityForResult(in, REQUEST_CODE);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId, 1, 1, 1, 0, 2);
                Intent in = new Intent(ElegirJuego.this, Jugar.class);
                in.putExtra("pokemon_pokedex", lista_pokedex);
                in.putExtra("monedas", monedas);
                in.putExtra("musica", quiereMusica);
                in.putExtra("categoria", 3);
                startActivityForResult(in, REQUEST_CODE);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId, 1, 1, 1, 0, 2);
                Intent in = new Intent(ElegirJuego.this, Jugar.class);
                in.putExtra("pokemon_pokedex", lista_pokedex);
                in.putExtra("monedas", monedas);
                in.putExtra("musica", quiereMusica);
                in.putExtra("categoria", 4);
                startActivityForResult(in, REQUEST_CODE);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId, 1, 1, 1, 0, 2);
                Intent in = new Intent(ElegirJuego.this, Jugar.class);
                in.putExtra("pokemon_pokedex", lista_pokedex);
                in.putExtra("monedas", monedas);
                in.putExtra("musica", quiereMusica);
                in.putExtra("categoria", 5);
                startActivityForResult(in, REQUEST_CODE);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId, 1, 1, 1, 0, 2);
                Intent in = new Intent(ElegirJuego.this, Jugar.class);
                in.putExtra("pokemon_pokedex", lista_pokedex);
                in.putExtra("monedas", monedas);
                in.putExtra("musica", quiereMusica);
                in.putExtra("categoria", 6);
                startActivityForResult(in, REQUEST_CODE);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId, 1, 1, 1, 0, 2);
                Intent in = new Intent(ElegirJuego.this, Jugar.class);
                in.putExtra("pokemon_pokedex", lista_pokedex);
                in.putExtra("monedas", monedas);
                in.putExtra("musica", quiereMusica);
                in.putExtra("categoria", 7);
                startActivityForResult(in, REQUEST_CODE);
            }
        });



    }

    protected void onDestroy() {
        super.onDestroy();
        if(quiereMusica) {
            if (puebloPaleta.isPlaying()) {
                puebloPaleta.stop();
                puebloPaleta.release();
            }
        }
    }

    protected void onPause() {
        super.onPause();
        if(quiereMusica)
            puebloPaleta.pause();
    }

    protected void onResume() {
        super.onResume();
        if(quiereMusica) {
            puebloPaleta.seekTo(0);
            puebloPaleta.start();
        }
    }

    public void finish() {
        Intent data = new Intent();

        //posicion_musica = musica.getCurrentPosition();

        data.putExtra("returnString1", lista_pokedex);
        data.putExtra("monedas", monedas);
        setResult(RESULT_OK, data);
        super.finish();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("returnString1")) {
                lista_pokedex = data.getExtras().getString("returnString1");
            }
            if (data.hasExtra("monedas")) {
                monedas = data.getExtras().getInt("monedas");
            }
        }

        guardarPokedex();

    }

    public void guardarPokedex(){

        SharedPreferences misPreferencias = getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = misPreferencias.edit();
        editor.putString("name", lista_pokedex);
        editor.putInt("monedas", monedas);
        editor.commit();
    }

}
