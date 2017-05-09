package com.juego.charles.cuantos_puedes_pokeadivinar;


import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


public class AcercaDe extends ActionBarActivity {

    private MediaPlayer puebloPaleta;

    private boolean quiereMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        getSupportActionBar().hide();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Bundle param = getIntent().getExtras();

        if (param != null) {
            quiereMusica = param.getBoolean("musica");
        }

        puebloPaleta = MediaPlayer.create(this, R.raw.pueblo_paleta);

        if(quiereMusica) {
            puebloPaleta.setLooping(true);
            puebloPaleta.start();
        }
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

}
