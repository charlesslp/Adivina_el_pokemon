package com.juego.charles.cuantos_puedes_pokeadivinar;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MenuPrincipal extends ActionBarActivity {

    private Button jugar, tutorial, pokedex;
    private int REQUEST_CODE = 1, monedas;
    private String lista_pokedex = "";
    private MediaPlayer opening;
    private SoundPool mySound;
    private int soundId;

    private Menu menu;
    private boolean quiereMusica;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        quiereMusica = true;

        Intent intt = new Intent(MenuPrincipal.this, Logotipo.class);
        startActivity(intt);


        mySound = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);
        soundId = mySound.load(this, R.raw.sonido_boton, 1);

        opening = MediaPlayer.create(this, R.raw.pokemon_rojo_fuego_opening);
        opening.setLooping(true);
        opening.start();

        jugar = (Button) findViewById(R.id.btnJugar);
        tutorial = (Button) findViewById(R.id.btnAcerca);
        pokedex = (Button) findViewById(R.id.btnLista);

        cargarPokedex();

        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId, 1, 1, 1, 0, 2);
                Intent in = new Intent(MenuPrincipal.this, ElegirJuego.class);
                in.putExtra("pokemon_pokedex", lista_pokedex);
                in.putExtra("monedas", monedas);
                in.putExtra("musica", quiereMusica);
                startActivityForResult(in, REQUEST_CODE);
            }
        });


        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId, 1, 1, 1, 0, 2);
                Intent in = new Intent(MenuPrincipal.this, Tutorial.class);
                in.putExtra("pokemon_pokedex", lista_pokedex);
                in.putExtra("musica", quiereMusica);
                startActivity(in);
            }
        });

        pokedex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId, 1, 1, 1, 0, 2);
                Intent in = new Intent(MenuPrincipal.this, Pokedex.class);
                in.putExtra("pokemon_pokedex", lista_pokedex);
                in.putExtra("musica", quiereMusica);
                startActivity(in);
            }
        });

    }

    protected void onDestroy() {
        super.onDestroy();
        if(quiereMusica) {
            if (opening.isPlaying()) {
                opening.stop();
                opening.release();
            }
        }
    }

    protected void onPause() {
        super.onPause();
        if(quiereMusica)
            opening.pause();
    }

    protected void onResume() {
        super.onResume();
        if(quiereMusica) {
            opening.seekTo(0);
            opening.start();
        }
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

    public void cargarPokedex(){
        SharedPreferences misPreferencias = getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
        lista_pokedex = (misPreferencias.getString("name", " "));
        monedas = (misPreferencias.getInt("monedas", 100));
    }

    public void guardarPokedex(){

        SharedPreferences misPreferencias = getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = misPreferencias.edit();
        editor.putString("name", lista_pokedex);
        editor.putInt("monedas", monedas);
        editor.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_principal, menu);

        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        switch(id){
            case R.id.info:
                mySound.play(soundId, 1, 1, 1, 0, 2);
                Intent in1 = new Intent(MenuPrincipal.this, AcercaDe.class);
                in1.putExtra("musica", quiereMusica);
                startActivity(in1);
                return true;
            case R.id.info2:
                Intent in4 = new Intent(MenuPrincipal.this, AcercaDe.class);
                in4.putExtra("musica", quiereMusica);
                startActivity(in4);
                return true;
            case R.id.audio:
                if(quiereMusica) {
                    menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.audio2));
                    opening.pause();
                    quiereMusica = false;
                }
                else {
                    menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.audio1));
                    opening.seekTo(0);
                    opening.start();
                    quiereMusica = true;
                }
                return true;
            case R.id.resetPok:
                builder.setMessage("¿Desea resetear la Pokedex? Esta opción no tiene vuelta a atras")
                        .setTitle("Advertencia")
                        .setCancelable(false)
                        .setNegativeButton("Cancelar",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                })
                        .setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        lista_pokedex = "";
                                        guardarPokedex();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
                return true;
            default: return super.onOptionsItemSelected(item);
        }

    }
}
