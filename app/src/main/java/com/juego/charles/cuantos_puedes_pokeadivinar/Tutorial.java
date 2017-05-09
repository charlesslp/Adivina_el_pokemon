package com.juego.charles.cuantos_puedes_pokeadivinar;

import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Tutorial extends ActionBarActivity {

    private MediaPlayer puebloPaleta;
    private Button btnAtras, btnSiguiente;
    private int[] imagenes = {R.drawable.aaa1a, R.drawable.aaa1b, R.drawable.aaa1c
            , R.drawable.aaa1d, R.drawable.aaa1e, R.drawable.aaa1f
            , R.drawable.aaa1g, R.drawable.aaa1gg, R.drawable.aaa1h, R.drawable.aaa1i
            , R.drawable.aaa1j, R.drawable.aaa1k, R.drawable.aaa1l, R.drawable.aaa1m
            , R.drawable.aaa1n, R.drawable.aaa1o, R.drawable.aaa1p
            , R.drawable.aaa1q, R.drawable.aaa1r, R.drawable.aaa1s, R.drawable.aaa1t, R.drawable.aaa1u
            , R.drawable.aaa1v, R.drawable.aaa1w
            , R.drawable.aaa1x, R.drawable.aaa1y, R.drawable.aaa1z, R.drawable.aaa2a
            , R.drawable.aaa2b, R.drawable.aaa2c, R.drawable.aaa2d, R.drawable.aaa2e
            , R.drawable.aaa2f, R.drawable.aaa2h, R.drawable.aaa2i
            , R.drawable.aaa2j, R.drawable.aaa2k, R.drawable.aaa22collage3
    };

    private String[] tutorial = {
            "Bienvenido a este Tutorial donde en unos minutos aprenderás a usar y a jugar a esta app. ¡Disfruta!",
            "Lo primero es la opción de Jugar. Es la principal funcionalidad de este juego.",
            "Ahora te saldrán varios modos de juego. Cada modo tiene una serie de pokemons agrupados por tipos. El modo ¡Hazte con todos! tiene todos los pokemons del juego.",
            "Ahora solo tienes que elegir el que más te guste.",
            "Este es un ejemplo del modo Jugar de los tipos Lucha, Psiquico y Electrico. Vamos a intentar adivinar cuál es este pokemon.",
            "Para probar suerte escribe el nombre del Pokemon pulsando sobre las letras que aparecen.",
            "En este caso, vamos a poner un nombre incorrecto.",
            "Si quieres cambiar alguna letra solo tienes que pinchar sobre ella y volverá a donde estaba.",
            "Cuando estés listo y creas que has acertado pulsa el boton 'Aceptar'.",
            "Como el nombre era incorrecto nos salta un mensaje de error ¡Vaya! :S",
            "Pero no te preocupes, tienes 3 intentos asi que aun te quedan 2.",
            "¡Si te quedas sin intentos perderás la oportunidad de descubrir que pokemon era! Asi que ¡Piénsatelo bien!",
            "En este caso aparecerá un nuevo pokemon diferente y tendrás que esperar a que te vuelva a salir ese Pokemon para poder descubrirlo",
            "¡Pero esto es un tutorial! Asi que pondremos al mismo para seguir con el ejemplo",
            "Cuando acertamos el nombre nos recompensarán con 10 monedas :D",
            "¡Genial! ¡Hemos descubierto un nuevo Pokemon que aun no teniamos! Este Pokemon ahora lo tendremos archivado en la pokedex para siempre.",
            "Ahora el Pokemon que acabamos de adivinar se mostrará ante nosotros durante unos segundos.",
            "¡Si te fijas ahora tenemos 10 monedas mas que antes!",
            "Ahora se paciente, la sombra de un nuevo Pokemon salvaje esta a punto de aparecer...",
            "Pero nosotros seguiremos poniendo el mismo ya que seguimos en el tutorial :P",
            "Arriba a la izquierda puedes usar las monedas que has ganado para ayudarte si no te acuerdas del nombre del Pokemon.",
            "Nos saldra un menú con las opciones disponibles, en este caso vamos a usar una pista.",
            "Aparecerá la primera letra del nombre del Pokemon. Si seguimos pidiendo pistas irán apareciendo el resto de letras.",
            "La opción de solución nos rellenará el nombre al completo y solo tendremos que pulsar aceptar para descubrirlo.",
            "Si te quedas sin dinero, puedes conseguir más viendo un video o pinchando sobre la imagen de la publicidad",
            "¡Vaya! ¡Ahora nos ha aparecido un nuevo Pokemon! Este nos lo sabemos ¿Verdad?",
            "Pero... ¡Hay un problema! Este Pokemon es una evolución de otro Pokemon que aun no hemos descubierto. Deberemos encontrar a su anterior evolución primero.",
            "Como bien sabrás, existen varios Pokemons legendarios. Estos Pokemons no se encuentran en los modos por tipos asi que tendrás que buscarlos en el modo ¡Hazte con todos!",
            "Lo siguiente más importante después de la opción de Jugar es la Pokedex.",
            "Aqui se irán guardando los Pokemons que vayamos descubriendo. ¡Mira! ¡Tenemos a Pikachu! :D",
            "Podemos pinchar encima suyo para saber más acerca de este Pokemon.",
            "Seguro que encuentras cosas curiosas que no sabias de muchos Pokemons.",
            "Ya estamos acabando. Si te apetece volver a jugar desde 0 y borrar los datos que tienes puedes resetear la Pokedex. Para ello pincha en los puntos de arriba a la derecha.",
            "Se te abrirá un menu desplegable con la opcion 'Resetear Pokedex'. Ten en cuenta que las monedas no te desaparecerán",
            "Se te mostrará una ventana de Advertencia. Si te arrepientes de tu decisión aún estás a tiempo de cancelar el reseteo.",
            "Una vez reseteada la Pokedex volverás a tenerla vacia y sin ningún Pokemon. No podrás deshacer esta opcion asi que piénsatelo bien.",
            "Por último, he creado un pequeño espacio de 'información' con nada mas que una anotación mia para que sepas que aspecto tengo :).",
            "¡¡Y eso es todo!! ¡Ahora te toca a ti! 151 Pokemons esperan a ser descubiertos, suerte y... ¡HAZTE CON TODOS!"

    };
    private int pos = 0;
    private SoundPool mySound;
    private int soundId;

    private boolean quiereMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        getSupportActionBar().hide();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mySound = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);
        soundId = mySound.load(this, R.raw.sonido_boton, 1);

        Bundle param = getIntent().getExtras();
        if( param!= null) {
            quiereMusica = param.getBoolean("musica");
        }

        btnAtras = (Button) findViewById(R.id.button);
        btnSiguiente = (Button) findViewById(R.id.button15);

        btnAtras.setEnabled(false);

        findViewById(R.id.imageView22).setBackgroundResource(imagenes[pos]);
        ((TextView) findViewById(R.id.textView7)).setText(tutorial[pos]);


        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId, 1, 1, 1, 0, 2);
                if(pos > 0) {
                    pos--;
                    ((TextView) findViewById(R.id.textView7)).setText(tutorial[pos]);
                    findViewById(R.id.imageView22).setBackgroundResource(imagenes[pos]);
                    if(pos==0){
                        btnAtras.setEnabled(false);
                    }

                    if(!btnSiguiente.isEnabled()){
                        btnSiguiente.setEnabled(true);
                    }
                }
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId, 1, 1, 1, 0, 2);
                if(pos < (imagenes.length - 1)) {
                    pos++;
                    ((TextView) findViewById(R.id.textView7)).setText(tutorial[pos]);
                    findViewById(R.id.imageView22).setBackgroundResource(imagenes[pos]);
                    if(pos==(imagenes.length - 1)){
                        btnSiguiente.setEnabled(false);
                    }

                    if(!btnAtras.isEnabled()){
                        btnAtras.setEnabled(true);
                    }
                }
            }
        });

        puebloPaleta = MediaPlayer.create(this, R.raw.pueblo_paleta);
        if(quiereMusica) {
            puebloPaleta.setLooping(true);
            puebloPaleta.start();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if(puebloPaleta.isPlaying()) {
            puebloPaleta.stop();
            puebloPaleta.release();
        }
    }

    protected void onPause() {
        super.onPause();
        puebloPaleta.pause();
    }

    protected void onResume() {
        super.onResume();
        if (quiereMusica) {
            puebloPaleta.seekTo(0);
            puebloPaleta.start();
        }
    }

}
