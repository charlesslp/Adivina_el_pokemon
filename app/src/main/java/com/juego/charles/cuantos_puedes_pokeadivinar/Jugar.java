package com.juego.charles.cuantos_puedes_pokeadivinar;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class Jugar extends ActionBarActivity {


    private int[] imagen = {
            R.drawable.bulbasaur, R.drawable.ivysaur, R.drawable.venusaur, R.drawable.charmander, R.drawable.charmeleon,
            R.drawable.charizard, R.drawable.squirtle, R.drawable.wartortle, R.drawable.blastoise, R.drawable.caterpie,
            R.drawable.metapod, R.drawable.butterfree, R.drawable.weedle, R.drawable.kakuna, R.drawable.beedrill,
            R.drawable.pidgey, R.drawable.pidgeotto, R.drawable.pidgeot, R.drawable.rattata, R.drawable.raticate,
            R.drawable.spearow, R.drawable.fearow, R.drawable.ekans, R.drawable.arbok, R.drawable.pikachu, R.drawable.raichu,
            R.drawable.sandshrew, R.drawable.sandslash, R.drawable.nidorann, R.drawable.nidorina, R.drawable.nidoqueen,
            R.drawable.nidoran, R.drawable.nidorino, R.drawable.nidoking, R.drawable.clefairy, R.drawable.clefable,
            R.drawable.vulpix, R.drawable.ninetales, R.drawable.jigglypuff, R.drawable.wigglytuff, R.drawable.zubat,
            R.drawable.golbat, R.drawable.oddish, R.drawable.gloom, R.drawable.vileplume, R.drawable.paras, R.drawable.parasect,
            R.drawable.venonat, R.drawable.venomoth, R.drawable.diglett, R.drawable.dugtrio, R.drawable.meowth, R.drawable.persian,
            R.drawable.psyduck, R.drawable.golduck, R.drawable.mankey, R.drawable.primeape, R.drawable.growlithe, R.drawable.arcanine,
            R.drawable.poliwag, R.drawable.poliwhirl, R.drawable.poliwrath, R.drawable.abra, R.drawable.kadabra, R.drawable.alakazam,
            R.drawable.machop, R.drawable.machoke, R.drawable.machamp, R.drawable.bellsprout, R.drawable.weepinbell,
            R.drawable.victreebel, R.drawable.tentacool, R.drawable.tentacruel, R.drawable.geodude, R.drawable.graveler, R.drawable.golem,
            R.drawable.ponyta, R.drawable.rapidash, R.drawable.slowpoke, R.drawable.slowbro, R.drawable.magnemite, R.drawable.magneton,
            R.drawable.farfetchd, R.drawable.doduo, R.drawable.dodrio, R.drawable.seel, R.drawable.dewgong, R.drawable.grimer,
            R.drawable.muk, R.drawable.shellder, R.drawable.cloyster, R.drawable.gastly, R.drawable.haunter, R.drawable.gengar,
            R.drawable.onix, R.drawable.drowzee, R.drawable.hypno, R.drawable.krabby, R.drawable.kingler, R.drawable.voltorb,
            R.drawable.electrode, R.drawable.exeggcute, R.drawable.exeggutor, R.drawable.cubone, R.drawable.marowak, R.drawable.hitmonlee,
            R.drawable.hitmonchan, R.drawable.lickitung, R.drawable.koffing, R.drawable.weezing, R.drawable.rhyhorn, R.drawable.rhydon,
            R.drawable.chansey, R.drawable.tangela, R.drawable.kangaskhan, R.drawable.horsea, R.drawable.seadra, R.drawable.goldeen,
            R.drawable.seaking, R.drawable.staryu, R.drawable.starmie, R.drawable.mr_mime, R.drawable.scyther, R.drawable.jynx,
            R.drawable.electabuzz, R.drawable.magmar, R.drawable.pinsir, R.drawable.tauros, R.drawable.magikarp, R.drawable.gyarados,
            R.drawable.lapras, R.drawable.ditto, R.drawable.eevee, R.drawable.vaporeon, R.drawable.jolteon, R.drawable.flareon,
            R.drawable.porygon, R.drawable.omanyte, R.drawable.omastar, R.drawable.kabuto, R.drawable.kabutops, R.drawable.aerodactyl,
            R.drawable.snorlax, R.drawable.articuno, R.drawable.zapdos, R.drawable.moltres, R.drawable.dratini, R.drawable.dragonair,
            R.drawable.dragonite, R.drawable.mewtwo, R.drawable.mew
    };

    private int[] sombra = {
            R.drawable.s_bulbasaur, R.drawable.s_ivysaur, R.drawable.s_venusaur, R.drawable.s_charmander, R.drawable.s_charmeleon,
            R.drawable.s_charizard, R.drawable.s_squirtle, R.drawable.s_wartortle, R.drawable.s_blastoise, R.drawable.s_caterpie,
            R.drawable.s_metapod, R.drawable.s_butterfree, R.drawable.s_weedle, R.drawable.s_kakuna, R.drawable.s_beedrill,
            R.drawable.s_pidgey, R.drawable.s_pidgeotto, R.drawable.s_pidgeot, R.drawable.s_rattata, R.drawable.s_raticate,
            R.drawable.s_spearow, R.drawable.s_fearow, R.drawable.s_ekans, R.drawable.s_arbok, R.drawable.s_pikachu,
            R.drawable.s_raichu, R.drawable.s_sandshrew, R.drawable.s_sandslash, R.drawable.s_nidorann, R.drawable.s_nidorina,
            R.drawable.s_nidoqueen, R.drawable.s_nidoran, R.drawable.s_nidorino, R.drawable.s_nidoking, R.drawable.s_clefairy,
            R.drawable.s_clefable, R.drawable.s_vulpix, R.drawable.s_ninetales, R.drawable.s_jigglypuff, R.drawable.s_wigglytuff,
            R.drawable.s_zubat, R.drawable.s_golbat, R.drawable.s_oddish, R.drawable.s_gloom, R.drawable.s_vileplume,
            R.drawable.s_paras, R.drawable.s_parasect, R.drawable.s_venonat, R.drawable.s_venomoth, R.drawable.s_diglett,
            R.drawable.s_dugtrio, R.drawable.s_meowth, R.drawable.s_persian, R.drawable.s_psyduck, R.drawable.s_golduck,
            R.drawable.s_mankey, R.drawable.s_primeape, R.drawable.s_growlithe, R.drawable.s_arcanine, R.drawable.s_poliwag,
            R.drawable.s_poliwhirl, R.drawable.s_poliwrath, R.drawable.s_abra, R.drawable.s_kadabra, R.drawable.s_alakazam,
            R.drawable.s_machop, R.drawable.s_machoke, R.drawable.s_machamp, R.drawable.s_bellsprout, R.drawable.s_weepinbell,
            R.drawable.s_victreebel, R.drawable.s_tentacool, R.drawable.s_tentacruel, R.drawable.s_geodude, R.drawable.s_graveler,
            R.drawable.s_golem, R.drawable.s_ponyta, R.drawable.s_rapidash, R.drawable.s_slowpoke, R.drawable.s_slowbro,
            R.drawable.s_magnemite, R.drawable.s_magneton, R.drawable.s_farfetchd, R.drawable.s_doduo, R.drawable.s_dodrio,
            R.drawable.s_seel, R.drawable.s_dewgong, R.drawable.s_grimer, R.drawable.s_muk, R.drawable.s_shellder,
            R.drawable.s_cloyster, R.drawable.s_gastly, R.drawable.s_haunter, R.drawable.s_gengar, R.drawable.s_onix,
            R.drawable.s_drowzee, R.drawable.s_hypno, R.drawable.s_krabby, R.drawable.s_kingler, R.drawable.s_voltorb,
            R.drawable.s_electrode, R.drawable.s_exeggcute, R.drawable.s_exeggutor, R.drawable.s_cubone, R.drawable.s_marowak,
            R.drawable.s_hitmonlee, R.drawable.s_hitmonchan, R.drawable.s_lickitung, R.drawable.s_koffing, R.drawable.s_weezing,
            R.drawable.s_rhyhorn, R.drawable.s_rhydon, R.drawable.s_chansey, R.drawable.s_tangela, R.drawable.s_kangaskhan,
            R.drawable.s_horsea, R.drawable.s_seadra, R.drawable.s_goldeen, R.drawable.s_seaking, R.drawable.s_staryu,
            R.drawable.s_starmie, R.drawable.s_mr_mime, R.drawable.s_scyther, R.drawable.s_jynx, R.drawable.s_electabuzz,
            R.drawable.s_magmar, R.drawable.s_pinsir, R.drawable.s_tauros, R.drawable.s_magikarp, R.drawable.s_gyarados,
            R.drawable.s_lapras, R.drawable.s_ditto, R.drawable.s_eevee, R.drawable.s_vaporeon, R.drawable.s_jolteon,
            R.drawable.s_flareon, R.drawable.s_porygon, R.drawable.s_omanyte, R.drawable.s_omastar, R.drawable.s_kabuto,
            R.drawable.s_kabutops, R.drawable.s_aerodactyl, R.drawable.s_snorlax, R.drawable.s_articuno, R.drawable.s_zapdos,
            R.drawable.s_moltres, R.drawable.s_dratini, R.drawable.s_dragonair, R.drawable.s_dragonite, R.drawable.s_mewtwo,
            R.drawable.s_mew
    };



    private Button boton00, boton01, boton02, boton03, boton04, boton05;
    private Button boton10, boton11, boton12, boton13, boton14, boton15;
    private Button boton20, boton21, boton22;

    private Button boton_sol0, boton_sol1, boton_sol2, boton_sol3, boton_sol4, boton_sol5;
    private Button boton_sol6, boton_sol7, boton_sol8, boton_sol9, boton_sol10;


    private char arrayChar[] = new char[20];
    private char arrayCharSol[] = new char[20];
    private int arrayIdSol[] = new int[20];




    private int intentos = 3, num = 0, categoria = 0;
    private Button aceptar, help;
    private TextView mensajePokemon, mostrarMonedas, mensajeNegrita;
    private String pokemonUsuario;
    private ImageView imagenPokemon, imagenIntentos;
    private int  numeroPistas = 0, monedas = 0, REQUEST_CODE=1, numeroAleat=-1;
    private String pokemonsYaConseguidos;
    private Pokemon pokemon;
    private MediaPlayer pelea;
    private SoundPool mySound;
    private int soundId1, soundId2, soundId3;

    private InterstitialAd mInterstitialAd;
    private int contPubli;

    private Toast toastFallo;

    private boolean quiereMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        getSupportActionBar().hide();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3689011140113990/6735804265");
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);

        contPubli = (int) (Math.random()*5);


        Bundle param = getIntent().getExtras();

        if (param != null) {
            pokemonsYaConseguidos = param.getString("pokemon_pokedex");
            monedas = param.getInt("monedas");
            categoria = param.getInt("categoria");
            quiereMusica = param.getBoolean("musica");
        }


        pelea = MediaPlayer.create(this, R.raw.pelea_theme);
        if(quiereMusica) {
            pelea.setVolume(150, 150);
            pelea.setLooping(true);
            pelea.start();
        }

        mySound = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);
        soundId1 = mySound.load(this, R.raw.sonido_boton, 1);
        soundId2 = mySound.load(this, R.raw.button_10, 1);
        soundId3 = mySound.load(this, R.raw.success_sound, 1);

        aceptar = (Button) findViewById(R.id.btnAceptar);
        help = (Button) findViewById(R.id.btnPista);
        mensajePokemon = (TextView) findViewById(R.id.txtMensaje);
        imagenPokemon = (ImageView) findViewById(R.id.imgPokemon);
        imagenIntentos = (ImageView) findViewById(R.id.imgIntentos);
        mostrarMonedas = (TextView) findViewById(R.id.textView11);
        mensajeNegrita = (TextView) findViewById(R.id.textView3);


        mensajeNegrita.setText("¿Cuál es este Pokemon?");


        pokemon = new Pokemon(0);


        numeroAleat = getAleatorio(); //no solo trae el numero aleatorio, es el encargado de rellenar los datos del pokemon

        imagenIntentos.setImageResource(R.drawable.tres_pokeball);

        mostrarMonedas.setText("" + monedas);

        for (int i = 0; i < 20; i++){
            arrayCharSol[i] = '.';
        }
        for (int i = 0; i < 20; i++){
            arrayIdSol[i] = -1;
        }


        for(int i = 0; i < 15; i++){
            arrayChar[i] = '.';
        }

        char [] temp = stringToArrayChar(pokemon.getNombre_pokemon());

        if(pokemon.getNombre_pokemon().equalsIgnoreCase("Farfetch'd"))
            temp[8] = '.';

        for(int i = 0; i < temp.length;){

            int aleat = (int) (Math.random()*17);
            if(arrayChar[aleat] == '.') {
                arrayChar[aleat] = temp[i];
                i++;
            }
        }

        for(int i = 0; i < 15; i++){
            int aleat = (int) (Math.random()*25);
            if(arrayChar[i] == '.')
                arrayChar[i] = intToChar(aleat);
        }



        setSombra();

        botonesSolucion();


        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pokemonUsuario = arrayCharToStrign(arrayCharSol);

                if (pokemonUsuario.equalsIgnoreCase(pokemon.getNombre_pokemon())) {
                    mySound.play(soundId3, 1, 1, 1, 0, 1);
                    setPokemon();
                    if(numeroPistas <= 0)
                        mostrarDialog(0);
                    else
                        descubierto();
                } else {

                    mySound.play(soundId2, 1, 1, 1, 0, 1);
                        intentos--;
                        if (intentos == 2) {
                            imagenIntentos.setImageResource(R.drawable.dos_pokeball);
                            toastFallo = Toast.makeText(getApplicationContext(), "Has fallado!! prueba otra vez!!", Toast.LENGTH_SHORT);
                            toastFallo.show();
                        } else {
                            if (intentos == 1) {
                                imagenIntentos.setImageResource(R.drawable.una_pokeball);
                                toastFallo.cancel();
                                toastFallo = Toast.makeText(getApplicationContext(), "Has fallado!! prueba otra vez!!", Toast.LENGTH_SHORT);
                                toastFallo.show();
                            } else {
                                imagenIntentos.setImageResource(R.drawable.cero_pokeball);
                                toastFallo.cancel();
                                toastFallo = Toast.makeText(getApplicationContext(), "Has fallado!! No te quedan intentos!!", Toast.LENGTH_SHORT);
                                toastFallo.show();
                                pausaMal();
                                mensajePokemon.setText("");
                            }
                        }
                    }
                }

        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mySound.play(soundId1, 1, 1, 1, 0, 2);

                Intent in = new Intent(Jugar.this, ayuda.class);
                in.putExtra("monedas", monedas);
                startActivityForResult(in, REQUEST_CODE);
            }

        });

    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().build();

        mInterstitialAd.loadAd(adRequest);
    }

    protected void onDestroy() {
        super.onDestroy();
        if(pelea.isPlaying()) {
            pelea.stop();
            pelea.release();
        }
    }

    protected void onPause() {
        super.onPause();
        pelea.pause();
    }

    protected void onResume() {
        super.onResume();
        if(quiereMusica) {
            pelea.seekTo(0);
            pelea.start();
        }
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        int n = 0;
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("monedas")) {
                monedas = data.getExtras().getInt("monedas");
            }
            if (data.hasExtra("accion")) {
                n = data.getExtras().getInt("accion");
            }
        }



        guardarPokedex();

        mostrarMonedas.setText("" + monedas);

        switch (n){
            case 0: break;
            case 1:
                    if(numeroPistas < pokemon.getNombre_pokemon().length()) {
                        pista(numeroPistas);
                        numeroPistas++;
                    }
                    else {
                        monedas += 20;
                        mostrarMonedas.setText("" + monedas);
                        Toast.makeText(getApplicationContext(), "Ya has obtenido el nombre completo!!!", Toast.LENGTH_SHORT).show();
                    }
                    break;
            case 2: solucion();
                    numeroPistas++;
                    break;
            default: break;
        }


    }

    public void guardarPokedex(){

        SharedPreferences misPreferencias = getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = misPreferencias.edit();
        editor.putString("name", pokemonsYaConseguidos);
        editor.putInt("monedas", monedas);
        editor.commit();
    }

    public void pausaMal(){

        aceptar.setEnabled(false);
        help.setEnabled(false);
        mostrarMonedas.setText("" + monedas);

        new CountDownTimer(2000,1000){

            public void onTick(long millisUntilFinished){
                mensajePokemon.setText("No te quedan más intentos!!!");
            }

            public void onFinish(){
                siguientePokemon();
            }
        }.start();
    }

    public void pausaBien(){

        aceptar.setEnabled(false);
        help.setEnabled(false);
        mostrarMonedas.setText("" + monedas);

        new CountDownTimer(5000,1000){

            public void onTick(long millisUntilFinished){
                if(millisUntilFinished > 4000)
                    mensajePokemon.setText("Muy bien!! era " + pokemon.getNombre_pokemon() + "!!");
                else {
                    mensajePokemon.setText("Pokemon salvaje aparecerá en:");
                    mensajeNegrita.setText("" + (millisUntilFinished / 1000));
                }
                
            }

            public void onFinish(){
               siguientePokemon();
            }

        }.start();
    }

    public void descubierto(){


        if(!noConseguido(numeroAleat)){
            if(!pokemon.getEvolucion()) {
                if(numeroAleat == 31){
                    pokemonsYaConseguidos = pokemonsYaConseguidos + "Nidoran2 ";
                } else
                    pokemonsYaConseguidos = pokemonsYaConseguidos + pokemon.getNombre_pokemon() + " ";
                guardarPokedex();

                if(pokemon.getNombre_pokemon().equalsIgnoreCase("articuno") || pokemon.getNombre_pokemon().equalsIgnoreCase("zapdos") ||
                        pokemon.getNombre_pokemon().equalsIgnoreCase("moltres") || pokemon.getNombre_pokemon().equalsIgnoreCase("mewtwo") ||
                        pokemon.getNombre_pokemon().equalsIgnoreCase("mew"))
                    mostrarDialog(5);
                else
                    mostrarDialog(1);
            }
            else{
                if(pokemon.getNombre_pokemon().equalsIgnoreCase("jolteon")) {
                    comprobarEvolucion(2);
                } else{
                    if(pokemon.getNombre_pokemon().equalsIgnoreCase("flareon")){
                        comprobarEvolucion(3);
                    } else {
                        comprobarEvolucion(1);
                    }
                }
            }
        }
        else
            pausaBien();
    }

    public void comprobarEvolucion(int num){

        if (noConseguido(numeroAleat - num)) {
            pokemonsYaConseguidos = pokemonsYaConseguidos + pokemon.getNombre_pokemon() + " ";
            mostrarDialog(1);
        } else {
            mostrarDialog(2);
        }

    }

    public void siguientePokemon(){

        if (mInterstitialAd.isLoaded() && contPubli%5 == 0) {
            mInterstitialAd.show();
        } else {

            if(contPubli%5 == 0){
                requestNewInterstitial();
            }

            llamarSiguiente();
        }

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                llamarSiguiente();
            }
        });
    }

    public void llamarSiguiente(){

        contPubli++;
        numeroAleat = getAleatorio();
        pokemon.ActualizarPokemon(numeroAleat);
        setSombra();
        intentos = 3;
        numeroPistas = 0;
        imagenIntentos.setImageResource(R.drawable.tres_pokeball);
        mostrarMonedas.setText("" + monedas);
        mensajeNegrita.setText("¿Cuál es este Pokemon?");
        pokemonUsuario = "";

        for (int i = 0; i < 20; i++){
            arrayCharSol[i] = '.';
        }
        for (int i = 0; i < 20; i++){
            arrayIdSol[i] = -1;
        }


        for(int i = 0; i < 15; i++){
            arrayChar[i] = '.';
        }

        char [] temp = stringToArrayChar(pokemon.getNombre_pokemon());

        if(pokemon.getNombre_pokemon().equalsIgnoreCase("Farfetch'd"))
            temp[8] = '.';

        for(int i = 0; i < temp.length;){

            int aleat = (int) (Math.random()*17);
            if(arrayChar[aleat] == '.') {
                arrayChar[aleat] = temp[i];
                i++;
            }
        }

        for(int i = 0; i < 15; i++){
            int aleat = (int) (Math.random()*25);
            if(arrayChar[i] == '.')
                arrayChar[i] = intToChar(aleat);
        }



        actualizaBotones();

        aceptar.setEnabled(true);
        help.setEnabled(true);

    }

    public void setSombra(){
        imagenPokemon.setImageResource(sombra[numeroAleat]);
    }

    public void setPokemon(){
        imagenPokemon.setImageResource(imagen[numeroAleat]);
    }

    private int getAleatorio(){

        /*
    Categorias:

    1 - Tierra y Roca = 14+11 = 25
    2 - volador, fuego y dragon = 14+12+3 = 29
    3 - planta, bicho = 14+13 = 27
    4 - agua y hielo = 32+5 = 37
    5 - normal y Acero = 23+2 = 25
    6 - veneno y fantasma = 33+3 = 36
    7 - lucha, psiquico y electrico = 8+14+9 = 31

     */

        int aleatorio;
        boolean valido = false;

        switch (categoria){
            case 0: do{
                aleatorio = (int) (Math.random()*pokemon.getLength());
            }while(aleatorio == this.numeroAleat);

                pokemon.ActualizarPokemon(aleatorio);
                mensajePokemon.setText("Modo ¡hazte con todos!");
                break;

            case 1:

                mensajePokemon.setText("Tipos: Tierra y Roca");

                do{
                    aleatorio = (int) (Math.random()*pokemon.getLength());

                    if(aleatorio != this.numeroAleat) {

                        pokemon.ActualizarPokemon(aleatorio);

                        if (pokemon.getTipo1().equalsIgnoreCase("tierra") || pokemon.getTipo1().equalsIgnoreCase("roca"))
                            valido = true;
                        else {
                            if (pokemon.getTipo2().equalsIgnoreCase("tierra") || pokemon.getTipo2().equalsIgnoreCase("roca"))
                                valido = true;
                        }
                    }
                }while(!valido);

             break;

            case 2:

                mensajePokemon.setText("Tipos: Volador, Fuego y Dragon");

                do{
                    aleatorio = (int) (Math.random()*pokemon.getLength());
                    if(aleatorio != this.numeroAleat) {

                        pokemon.ActualizarPokemon(aleatorio);

                        if (pokemon.getTipo1().equalsIgnoreCase("volador") || pokemon.getTipo1().equalsIgnoreCase("fuego") || pokemon.getTipo1().equalsIgnoreCase("dragon")) {
                            if (!pokemon.getNombre_pokemon().equalsIgnoreCase("moltres"))
                                valido = true;
                        } else {
                            if (pokemon.getTipo2().equalsIgnoreCase("volador") || pokemon.getTipo2().equalsIgnoreCase("fuego") || pokemon.getTipo2().equalsIgnoreCase("dragon"))
                                if (!pokemon.getNombre_pokemon().equalsIgnoreCase("articuno") && !pokemon.getNombre_pokemon().equalsIgnoreCase("zapdos") && !pokemon.getNombre_pokemon().equalsIgnoreCase("moltres"))
                                    valido = true;
                        }
                    }
                }while(!valido);

             break;

            case 3:

                mensajePokemon.setText("Tipos: Planta y Bicho");

                do{
                    aleatorio = (int) (Math.random()*pokemon.getLength());

                    if(aleatorio != this.numeroAleat) {

                        pokemon.ActualizarPokemon(aleatorio);

                        if (pokemon.getTipo1().equalsIgnoreCase("planta") || pokemon.getTipo1().equalsIgnoreCase("bicho"))
                            valido = true;
                        else {
                            if (pokemon.getTipo2().equalsIgnoreCase("planta") || pokemon.getTipo2().equalsIgnoreCase("bicho"))
                                valido = true;
                        }
                    }

                }while(!valido);

             break;
            case 4:

                mensajePokemon.setText("Tipos: Agua y Hielo");

                do{
                    aleatorio = (int) (Math.random()*pokemon.getLength());

                    if(aleatorio != this.numeroAleat) {

                        pokemon.ActualizarPokemon(aleatorio);

                        if (pokemon.getTipo1().equalsIgnoreCase("agua") || pokemon.getTipo1().equalsIgnoreCase("hielo")) {
                            if (!pokemon.getNombre_pokemon().equalsIgnoreCase("articuno"))
                                valido = true;
                        } else {
                            if (pokemon.getTipo2().equalsIgnoreCase("agua") || pokemon.getTipo2().equalsIgnoreCase("hielo"))
                                valido = true;
                        }
                    }
                }while(!valido);

             break;

            case 5:

                mensajePokemon.setText("Tipos: Normal y Acero");

                do{
                    aleatorio = (int) (Math.random()*pokemon.getLength());

                    if(aleatorio != this.numeroAleat) {

                        pokemon.ActualizarPokemon(aleatorio);

                        if (pokemon.getTipo1().equalsIgnoreCase("normal") || pokemon.getTipo1().equalsIgnoreCase("acero"))
                            valido = true;
                        else {
                            if (pokemon.getTipo2().equalsIgnoreCase("normal") || pokemon.getTipo2().equalsIgnoreCase("acero"))
                                valido = true;
                        }
                    }
                }while(!valido);

             break;

            case 6:

                mensajePokemon.setText("Tipos: Veneno y Fantasma");

                do{
                    aleatorio = (int) (Math.random()*pokemon.getLength());

                    if(aleatorio != this.numeroAleat) {

                        pokemon.ActualizarPokemon(aleatorio);

                        if (pokemon.getTipo1().equalsIgnoreCase("veneno") || pokemon.getTipo1().equalsIgnoreCase("fantasma"))
                            valido = true;
                        else {
                            if (pokemon.getTipo2().equalsIgnoreCase("veneno") || pokemon.getTipo2().equalsIgnoreCase("fantasma"))
                                valido = true;
                        }
                    }
                }while(!valido);

             break;

            case 7:

                mensajePokemon.setText("Lucha, Psiquico y Electrico");

                do{
                    aleatorio = (int) (Math.random()*pokemon.getLength());

                    if(aleatorio != this.numeroAleat) {
                        pokemon.ActualizarPokemon(aleatorio);

                        if (pokemon.getTipo1().equalsIgnoreCase("lucha") || pokemon.getTipo1().equalsIgnoreCase("psiquico") || pokemon.getTipo1().equalsIgnoreCase("electrico")) {
                            if (!pokemon.getNombre_pokemon().equalsIgnoreCase("mewtwo") && !pokemon.getNombre_pokemon().equalsIgnoreCase("mew") && !pokemon.getNombre_pokemon().equalsIgnoreCase("zapdos"))
                                valido = true;
                        } else {
                            if (pokemon.getTipo2().equalsIgnoreCase("lucha") || pokemon.getTipo2().equalsIgnoreCase("psiquico") || pokemon.getTipo2().equalsIgnoreCase("electrico"))
                                valido = true;
                        }
                    }
                }while(!valido);

             break;

            default:

                aleatorio = (int) (Math.random()*pokemon.getLength());

                pokemon.ActualizarPokemon(aleatorio);

                break;
        }

        return aleatorio;
    }

    public void finish() {
        Intent data = new Intent();

        data.putExtra("returnString1", pokemonsYaConseguidos);
        data.putExtra("monedas", monedas);
        setResult(RESULT_OK, data);
        super.finish();
    }

    public boolean noConseguido(int numero){

        boolean encontrado = false;
        int i = 0;

        String [] campos = pokemonsYaConseguidos.split("\\s+");

        if(numero == 31) {
            while(!encontrado && i < campos.length){

                if(campos[i].equalsIgnoreCase("nidoran2"))
                    encontrado = true;

                i++;
            }

        } else {
            while (!encontrado && i < campos.length) {

                if (campos[i].equalsIgnoreCase(pokemon.getNombre_pokemon(numero)))
                    encontrado = true;

                i++;
            }
        }

        return encontrado;
    }


    public void mostrarDialog(final int numero)
    {
        final Dialog customDialog = new Dialog(this);
        //deshabilitamos el título por defecto
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //obligamos al usuario a pulsar los botones para cerrarlo
        customDialog.setCancelable(false);
        //establecemos el contenido de nuestro dialog
        customDialog.setContentView(R.layout.dialog);

        num = numero;

        if(num == 0) {
            ((TextView) customDialog.findViewById(R.id.titulo)).setText("¡Enhorabuena!");
            ((TextView) customDialog.findViewById(R.id.textView12)).setText("Has conseguido: 10 ");
            ((ImageView) customDialog.findViewById(R.id.imageView7)).setImageResource(R.drawable.monedas);
        }
        else {
            if(num == 1){
                ((TextView) customDialog.findViewById(R.id.titulo)).setText("¡Enhorabuena!");
                ((TextView) customDialog.findViewById(R.id.textView12)).setText("¡¡Has descubierto un nuevo Pokemon!!");
                ((ImageView) customDialog.findViewById(R.id.imageView7)).setImageResource(0);
            }
            else {
                if(num == 5){
                    ((TextView) customDialog.findViewById(R.id.titulo)).setText("¡¡Increible!!");
                    ((TextView) customDialog.findViewById(R.id.textView12)).setText("¡¡¡Has descubierto un Pokemon Legendario!!!");
                    ((ImageView) customDialog.findViewById(R.id.imageView7)).setImageResource(0);
                }
                else {
                    if(num == 6){
                        ((TextView) customDialog.findViewById(R.id.titulo)).setText("¡Lo siento!");
                        ((TextView) customDialog.findViewById(R.id.textView12)).setText("No tienes suficientes ");
                        ((ImageView) customDialog.findViewById(R.id.imageView7)).setImageResource(R.drawable.monedas);
                    }
                    else {
                        if(num == 2) {
                            ((TextView) customDialog.findViewById(R.id.titulo)).setText("¡Que lastima!");
                            ((TextView) customDialog.findViewById(R.id.textView12)).setText("¡¡Necesitas la anterior evolucion para conseguir este pokemon!!");
                            ((ImageView) customDialog.findViewById(R.id.imageView7)).setImageResource(0);
                        }
                        else
                        {
                            if(num == 7){
                                ((TextView) customDialog.findViewById(R.id.titulo)).setText("¡¡No puedes poner mas letras!!");
                                ((TextView) customDialog.findViewById(R.id.textView12)).setText("Prueba otra combinacion o mira a ver si has acertado");
                                ((ImageView) customDialog.findViewById(R.id.imageView7)).setImageResource(0);
                            }
                        }
                    }
                }
            }
        }
        (customDialog.findViewById(R.id.btnAceptar)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {

                mySound.play(soundId1, 1, 1, 1, 0, 2);

                customDialog.dismiss();

                if(numero < 6) {

                    if (num == 0) {
                        monedas = monedas + 10;
                        descubierto();
                    } else
                        pausaBien();
                }

            }
        });

        customDialog.show();
    }

    private void cambiarBotonSol(int hueco, char c){
        switch (hueco){
            case 0: boton_sol0.setEnabled(true); boton_sol0.setBackgroundResource(charToDrawable(c)); break;
            case 1: boton_sol1.setEnabled(true); boton_sol1.setBackgroundResource(charToDrawable(c)); break;
            case 2: boton_sol2.setEnabled(true); boton_sol2.setBackgroundResource(charToDrawable(c)); break;
            case 3: boton_sol3.setEnabled(true); boton_sol3.setBackgroundResource(charToDrawable(c)); break;
            case 4: boton_sol4.setEnabled(true); boton_sol4.setBackgroundResource(charToDrawable(c)); break;
            case 5: boton_sol5.setEnabled(true); boton_sol5.setBackgroundResource(charToDrawable(c)); break;
            case 6: boton_sol6.setEnabled(true); boton_sol6.setBackgroundResource(charToDrawable(c)); break;
            case 7: boton_sol7.setEnabled(true); boton_sol7.setBackgroundResource(charToDrawable(c)); break;
            case 8: boton_sol8.setEnabled(true); boton_sol8.setBackgroundResource(charToDrawable(c)); break;
            case 9: boton_sol9.setEnabled(true); boton_sol9.setBackgroundResource(charToDrawable(c)); break;
            case 10: boton_sol10.setEnabled(true); boton_sol10.setBackgroundResource(charToDrawable(c)); break;
        }
    }

    private void cambiarBotonRes(int id, char c){
        switch (id){
            case 0: boton00.setEnabled(true); boton00.setBackgroundResource(charToDrawable(c)); break;
            case 1: boton01.setEnabled(true); boton01.setBackgroundResource(charToDrawable(c)); break;
            case 2: boton02.setEnabled(true); boton02.setBackgroundResource(charToDrawable(c)); break;
            case 3: boton03.setEnabled(true); boton03.setBackgroundResource(charToDrawable(c)); break;
            case 4: boton04.setEnabled(true); boton04.setBackgroundResource(charToDrawable(c)); break;
            case 5: boton05.setEnabled(true); boton05.setBackgroundResource(charToDrawable(c)); break;
            case 6: boton10.setEnabled(true); boton10.setBackgroundResource(charToDrawable(c)); break;
            case 7: boton11.setEnabled(true); boton11.setBackgroundResource(charToDrawable(c)); break;
            case 8: boton12.setEnabled(true); boton12.setBackgroundResource(charToDrawable(c)); break;
            case 9: boton13.setEnabled(true); boton13.setBackgroundResource(charToDrawable(c)); break;
            case 10: boton14.setEnabled(true); boton14.setBackgroundResource(charToDrawable(c)); break;
            case 11: boton15.setEnabled(true); boton15.setBackgroundResource(charToDrawable(c)); break;
            case 12: boton20.setEnabled(true); boton20.setBackgroundResource(charToDrawable(c)); break;
            case 13: boton21.setEnabled(true); boton21.setBackgroundResource(charToDrawable(c)); break;
            case 14: boton22.setEnabled(true); boton22.setBackgroundResource(charToDrawable(c)); break;
        }
    }

    private int buscarHueco(){

        int hueco = -1;
        boolean encontrado = false;

        for (int i = 0; i < pokemon.getNombre_pokemon().length() && !encontrado; i++){
            if(arrayCharSol[i] == '.') {
                encontrado = true;
                hueco = i;
            }
        }


        return hueco;
    }

    private char intToChar(int x){
        char c = '.';

        switch (x){
            case 0: c = 'a'; break;
            case 1: c = 'b'; break;
            case 2: c = 'c'; break;
            case 3: c = 'd'; break;
            case 4: c = 'e'; break;
            case 5: c = 'f'; break;
            case 6: c = 'g'; break;
            case 7: c = 'h'; break;
            case 8: c = 'i'; break;
            case 9: c = 'j'; break;
            case 10: c = 'k'; break;
            case 11: c = 'l'; break;
            case 12: c = 'm'; break;
            case 13: c = 'n'; break;
            case 14: c = 'o'; break;
            case 15: c = 'p'; break;
            case 16: c = 'q'; break;
            case 17: c = 'r'; break;
            case 18: c = 's'; break;
            case 19: c = 't'; break;
            case 20: c = 'u'; break;
            case 21: c = 'v'; break;
            case 22: c = 'w'; break;
            case 23: c = 'x'; break;
            case 24: c = 'y'; break;
            case 25: c = 'z'; break;

        }

        return c;
    }

    private int charToDrawable(char c){

        int idDrawable = R.drawable.punto;

        switch (c){
            case 'a': idDrawable = R.drawable.a; break;
            case 'A': idDrawable = R.drawable.a; break;
            case 'b': idDrawable = R.drawable.b; break;
            case 'B': idDrawable = R.drawable.b; break;
            case 'c': idDrawable = R.drawable.c; break;
            case 'C': idDrawable = R.drawable.c; break;
            case 'd': idDrawable = R.drawable.d; break;
            case 'D': idDrawable = R.drawable.d; break;
            case 'e': idDrawable = R.drawable.e; break;
            case 'E': idDrawable = R.drawable.e; break;
            case 'f': idDrawable = R.drawable.f; break;
            case 'F': idDrawable = R.drawable.f; break;
            case 'g': idDrawable = R.drawable.g; break;
            case 'G': idDrawable = R.drawable.g; break;
            case 'h': idDrawable = R.drawable.h; break;
            case 'H': idDrawable = R.drawable.h; break;
            case 'i': idDrawable = R.drawable.i; break;
            case 'I': idDrawable = R.drawable.i; break;
            case 'j': idDrawable = R.drawable.j; break;
            case 'J': idDrawable = R.drawable.j; break;
            case 'k': idDrawable = R.drawable.k; break;
            case 'K': idDrawable = R.drawable.k; break;
            case 'l': idDrawable = R.drawable.l; break;
            case 'L': idDrawable = R.drawable.l; break;
            case 'm': idDrawable = R.drawable.m; break;
            case 'M': idDrawable = R.drawable.m; break;
            case 'n': idDrawable = R.drawable.n; break;
            case 'N': idDrawable = R.drawable.n; break;
            case 'o': idDrawable = R.drawable.o; break;
            case 'O': idDrawable = R.drawable.o; break;
            case 'p': idDrawable = R.drawable.p; break;
            case 'P': idDrawable = R.drawable.p; break;
            case 'q': idDrawable = R.drawable.q; break;
            case 'Q': idDrawable = R.drawable.q; break;
            case 'r': idDrawable = R.drawable.r; break;
            case 'R': idDrawable = R.drawable.r; break;
            case 's': idDrawable = R.drawable.s; break;
            case 'S': idDrawable = R.drawable.s; break;
            case 't': idDrawable = R.drawable.t; break;
            case 'T': idDrawable = R.drawable.t; break;
            case 'u': idDrawable = R.drawable.u; break;
            case 'U': idDrawable = R.drawable.u; break;
            case 'v': idDrawable = R.drawable.v; break;
            case 'V': idDrawable = R.drawable.v; break;
            case 'w': idDrawable = R.drawable.w; break;
            case 'W': idDrawable = R.drawable.w; break;
            case 'x': idDrawable = R.drawable.x; break;
            case 'X': idDrawable = R.drawable.x; break;
            case 'y': idDrawable = R.drawable.y; break;
            case 'Y': idDrawable = R.drawable.y; break;
            case 'z': idDrawable = R.drawable.z; break;
            case 'Z': idDrawable = R.drawable.z; break;
            case '.': idDrawable = R.drawable.punto; break;
        }

        return idDrawable;
    }

    private char[] stringToArrayChar(String s){
        return s.toCharArray();
    }

    private String arrayCharToStrign(char[] cc){
        String s = "";

        for(int i = 0; i < cc.length; i++) {
            if (cc[i] != '.')
                s += cc[i];
        }

        if(s.equalsIgnoreCase("mrmime"))
            s = "mr.mime";
        else
            if(s.equalsIgnoreCase("Farfetchd"))
                s = "Farfetch'd";

        return s;
    }



    //PISTAS
    //PISTAS


    private void pista(int m){

        if (boton_sol0.isEnabled())
            boton_sol0.callOnClick();
        if (boton_sol1.isEnabled())
            boton_sol1.callOnClick();
        if (boton_sol2.isEnabled())
            boton_sol2.callOnClick();
        if (boton_sol3.isEnabled())
            boton_sol3.callOnClick();
        if (boton_sol4.isEnabled())
            boton_sol4.callOnClick();
        if (boton_sol5.isEnabled())
            boton_sol5.callOnClick();
        if (boton_sol6.isEnabled())
            boton_sol6.callOnClick();
        if (boton_sol7.isEnabled())
            boton_sol7.callOnClick();
        if (boton_sol8.isEnabled())
            boton_sol8.callOnClick();
        if (boton_sol9.isEnabled())
            boton_sol9.callOnClick();
        if (boton_sol10.isEnabled())
            boton_sol10.callOnClick();

        switch (m) {
            case 0:
                    if (boton_sol0.isEnabled())
                        boton_sol0.callOnClick();

                    pulsarBoton(m);

                    boton_sol0.setEnabled(false);
                break;
            case 1:
                if (boton_sol1.isEnabled())
                    boton_sol1.callOnClick();
                pulsarBoton(m);
                boton_sol1.setEnabled(false);

                break;
            case 2:
                if (boton_sol2.isEnabled())
                    boton_sol2.callOnClick();
                pulsarBoton(m);
                boton_sol2.setEnabled(false);

                break;
            case 3:
                if (boton_sol3.isEnabled())
                    boton_sol3.callOnClick();
                pulsarBoton(m);
                boton_sol3.setEnabled(false);

                break;
            case 4:
                if (boton_sol4.isEnabled())
                    boton_sol4.callOnClick();
                pulsarBoton(m);
                boton_sol4.setEnabled(false);

                break;
            case 5:
                if (boton_sol5.isEnabled())
                    boton_sol5.callOnClick();
                pulsarBoton(m);
                boton_sol5.setEnabled(false);

                break;
            case 6:
                if (boton_sol6.isEnabled())
                    boton_sol6.callOnClick();
                pulsarBoton(m);
                boton_sol6.setEnabled(false);

                break;
            case 7:
                if (boton_sol7.isEnabled())
                    boton_sol7.callOnClick();
                pulsarBoton(m);
                boton_sol7.setEnabled(false);

                break;
            case 8:
                if (boton_sol8.isEnabled())
                    boton_sol8.callOnClick();
                pulsarBoton(m);
                boton_sol8.setEnabled(false);

                break;
            case 9:
                if (boton_sol9.isEnabled())
                    boton_sol9.callOnClick();
                pulsarBoton(m);
                boton_sol9.setEnabled(false);

                break;
            case 10:
                if (boton_sol10.isEnabled())
                    boton_sol10.callOnClick();
                pulsarBoton(m);
                boton_sol10.setEnabled(false);

                break;

        }

    }

    private void solucion(){

        if (arrayCharSol[0] != '.')
            boton_sol0.callOnClick();
        if (arrayCharSol[1] != '.')
            boton_sol1.callOnClick();
        if (arrayCharSol[2] != '.')
            boton_sol2.callOnClick();
        if (arrayCharSol[3] != '.')
            boton_sol3.callOnClick();
        if (arrayCharSol[4] != '.')
            boton_sol4.callOnClick();
        if (arrayCharSol[5] != '.')
            boton_sol5.callOnClick();
        if (arrayCharSol[6] != '.')
            boton_sol6.callOnClick();
        if (arrayCharSol[7] != '.')
            boton_sol7.callOnClick();
        if (arrayCharSol[8] != '.')
            boton_sol8.callOnClick();
        if (arrayCharSol[9] != '.')
            boton_sol9.callOnClick();
        if (arrayCharSol[10] != '.')
            boton_sol10.callOnClick();

        for (int i = 0; i < pokemon.getNombre_pokemon().length(); i++){
            pulsarBoton(i);
            numeroPistas++;
        }

        boton_sol0.setEnabled(false);
        boton_sol1.setEnabled(false);
        boton_sol2.setEnabled(false);
        boton_sol3.setEnabled(false);
        boton_sol4.setEnabled(false);
        boton_sol5.setEnabled(false);
        boton_sol6.setEnabled(false);
        boton_sol7.setEnabled(false);
        boton_sol8.setEnabled(false);
        boton_sol9.setEnabled(false);
        boton_sol10.setEnabled(false);
    }

    private void pulsarBoton(int n){

        boolean encontrado = false;
        int i = 0;

        while (!encontrado && i < 15){
            if(arrayChar[i] == pokemon.getNombre_pokemon().charAt(n))
                encontrado = true;
            else
                i++;
        }

        switch (i){
            case 0: boton00.callOnClick();break;
            case 1: boton01.callOnClick();break;
            case 2: boton02.callOnClick();break;
            case 3: boton03.callOnClick();break;
            case 4: boton04.callOnClick();break;
            case 5: boton05.callOnClick();break;
            case 6: boton10.callOnClick();break;
            case 7: boton11.callOnClick();break;
            case 8: boton12.callOnClick();break;
            case 9: boton13.callOnClick();break;
            case 10: boton14.callOnClick();break;
            case 11: boton15.callOnClick();break;
            case 12: boton20.callOnClick();break;
            case 13: boton21.callOnClick();break;
            case 14: boton22.callOnClick();break;
            default:
                Toast.makeText(getApplicationContext(), "Algo ha fallado y te hemos devuelto las monedas", Toast.LENGTH_SHORT).show();
                monedas += 20;
                break;
        }


    }

    //PISTAS
    //PISTAS






    private void actualizaBotones(){

        boton_sol0.setEnabled(false);
        boton_sol1.setEnabled(false);
        boton_sol2.setEnabled(false);
        boton_sol3.setEnabled(false);
        boton_sol4.setEnabled(false);
        boton_sol5.setEnabled(false);
        boton_sol6.setEnabled(false);
        boton_sol7.setEnabled(false);
        boton_sol8.setEnabled(false);
        boton_sol9.setEnabled(false);
        boton_sol10.setEnabled(false);

        boton00.setEnabled(true);
        boton01.setEnabled(true);
        boton02.setEnabled(true);
        boton03.setEnabled(true);
        boton04.setEnabled(true);
        boton05.setEnabled(true);
        boton10.setEnabled(true);
        boton11.setEnabled(true);
        boton12.setEnabled(true);
        boton13.setEnabled(true);
        boton14.setEnabled(true);
        boton15.setEnabled(true);
        boton20.setEnabled(true);
        boton21.setEnabled(true);
        boton22.setEnabled(true);

        int longitud = pokemon.getNombre_pokemon().length();

        if(pokemon.getNombre_pokemon().equalsIgnoreCase("Farfetch'd") || pokemon.getNombre_pokemon().equalsIgnoreCase("Mr.mime") )
            longitud--;

        if(longitud > 0)
            boton_sol0.setBackgroundResource(R.drawable.punto);
        else
            boton_sol0.setBackgroundResource(R.drawable.punto_blanco);
        if(longitud > 1)
            boton_sol1.setBackgroundResource(R.drawable.punto);
        else
            boton_sol1.setBackgroundResource(R.drawable.punto_blanco);
        if(longitud > 2)
            boton_sol2.setBackgroundResource(R.drawable.punto);
        else
            boton_sol2.setBackgroundResource(R.drawable.punto_blanco);
        if(longitud > 3)
            boton_sol3.setBackgroundResource(R.drawable.punto);
        else
            boton_sol3.setBackgroundResource(R.drawable.punto_blanco);
        if(longitud > 4)
            boton_sol4.setBackgroundResource(R.drawable.punto);
        else
            boton_sol4.setBackgroundResource(R.drawable.punto_blanco);
        if(longitud > 5)
            boton_sol5.setBackgroundResource(R.drawable.punto);
        else
            boton_sol5.setBackgroundResource(R.drawable.punto_blanco);
        if(longitud > 6)
            boton_sol6.setBackgroundResource(R.drawable.punto);
        else
            boton_sol6.setBackgroundResource(R.drawable.punto_blanco);
        if(longitud > 7)
            boton_sol7.setBackgroundResource(R.drawable.punto);
        else
            boton_sol7.setBackgroundResource(R.drawable.punto_blanco);
        if(longitud > 8)
            boton_sol8.setBackgroundResource(R.drawable.punto);
        else
            boton_sol8.setBackgroundResource(R.drawable.punto_blanco);
        if(longitud > 9)
            boton_sol9.setBackgroundResource(R.drawable.punto);
        else
            boton_sol9.setBackgroundResource(R.drawable.punto_blanco);
        if(longitud > 10)
            boton_sol10.setBackgroundResource(R.drawable.punto);
        else
            boton_sol10.setBackgroundResource(R.drawable.punto_blanco);

        boton00.setBackgroundResource(charToDrawable(arrayChar[0]));
        boton01.setBackgroundResource(charToDrawable(arrayChar[1]));
        boton02.setBackgroundResource(charToDrawable(arrayChar[2]));
        boton03.setBackgroundResource(charToDrawable(arrayChar[3]));
        boton04.setBackgroundResource(charToDrawable(arrayChar[4]));
        boton05.setBackgroundResource(charToDrawable(arrayChar[5]));
        boton10.setBackgroundResource(charToDrawable(arrayChar[6]));
        boton11.setBackgroundResource(charToDrawable(arrayChar[7]));
        boton12.setBackgroundResource(charToDrawable(arrayChar[8]));
        boton13.setBackgroundResource(charToDrawable(arrayChar[9]));
        boton14.setBackgroundResource(charToDrawable(arrayChar[10]));
        boton15.setBackgroundResource(charToDrawable(arrayChar[11]));
        boton20.setBackgroundResource(charToDrawable(arrayChar[12]));
        boton21.setBackgroundResource(charToDrawable(arrayChar[13]));
        boton22.setBackgroundResource(charToDrawable(arrayChar[14]));
    }



    private void botonesSolucion(){

        boton00 = (Button) findViewById(R.id.boton00);
        boton01 = (Button) findViewById(R.id.boton01);
        boton02 = (Button) findViewById(R.id.boton02);
        boton03 = (Button) findViewById(R.id.boton03);
        boton04 = (Button) findViewById(R.id.boton04);
        boton05 = (Button) findViewById(R.id.boton05);
        boton10 = (Button) findViewById(R.id.boton10);
        boton11 = (Button) findViewById(R.id.boton11);
        boton12 = (Button) findViewById(R.id.boton12);
        boton13 = (Button) findViewById(R.id.boton13);
        boton14 = (Button) findViewById(R.id.boton14);
        boton15 = (Button) findViewById(R.id.boton15);
        boton20 = (Button) findViewById(R.id.boton20);
        boton21 = (Button) findViewById(R.id.boton21);
        boton22 = (Button) findViewById(R.id.boton22);


        boton_sol0 = (Button) findViewById(R.id.boton_sol0);
        boton_sol1 = (Button) findViewById(R.id.boton_sol1);
        boton_sol2 = (Button) findViewById(R.id.boton_sol2);
        boton_sol3 = (Button) findViewById(R.id.boton_sol3);
        boton_sol4 = (Button) findViewById(R.id.boton_sol4);
        boton_sol5 = (Button) findViewById(R.id.boton_sol5);
        boton_sol6 = (Button) findViewById(R.id.boton_sol6);
        boton_sol7 = (Button) findViewById(R.id.boton_sol7);
        boton_sol8 = (Button) findViewById(R.id.boton_sol8);
        boton_sol9 = (Button) findViewById(R.id.boton_sol9);
        boton_sol10 = (Button) findViewById(R.id.boton_sol10);



        actualizaBotones();


        boton00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                char c = arrayChar[0];
                int hueco = buscarHueco();

                if(hueco != -1) {
                    arrayCharSol[hueco] = c;
                    arrayIdSol[hueco] = 0;
                    cambiarBotonSol(hueco, c);
                    boton00.setBackgroundResource(R.drawable.punto);
                    boton00.setEnabled(false);
                }
                else {
                    mostrarDialog(7);
                }


            }
        });

        boton01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                char c = arrayChar[1];
                int hueco = buscarHueco();

                if(hueco != -1) {
                    arrayCharSol[hueco] = c;
                    arrayIdSol[hueco] = 1;
                    cambiarBotonSol(hueco, c);
                    boton01.setBackgroundResource(R.drawable.punto);
                    boton01.setEnabled(false);
                }
                else {
                    mostrarDialog(7);
                }

            }
        });

        boton02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                char c = arrayChar[2];
                int hueco = buscarHueco();

                if(hueco != -1) {
                    arrayCharSol[hueco] = c;
                    arrayIdSol[hueco] = 2;
                    cambiarBotonSol(hueco, c);
                    boton02.setBackgroundResource(R.drawable.punto);
                    boton02.setEnabled(false);
                }
                else {
                    mostrarDialog(7);
                }

            }
        });

        boton03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                char c = arrayChar[3];
                int hueco = buscarHueco();

                if(hueco != -1) {
                    arrayCharSol[hueco] = c;
                    arrayIdSol[hueco] = 3;
                    cambiarBotonSol(hueco, c);
                    boton03.setBackgroundResource(R.drawable.punto);
                    boton03.setEnabled(false);
                }
                else {
                    mostrarDialog(7);
                }

            }
        });

        boton04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                char c = arrayChar[4];
                int hueco = buscarHueco();

                if(hueco != -1) {
                    arrayCharSol[hueco] = c;
                    arrayIdSol[hueco] = 4;
                    cambiarBotonSol(hueco, c);
                    boton04.setBackgroundResource(R.drawable.punto);
                    boton04.setEnabled(false);
                }
                else {
                    mostrarDialog(7);
                }

            }
        });

        boton05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                char c = arrayChar[5];
                int hueco = buscarHueco();

                if(hueco != -1) {
                    arrayCharSol[hueco] = c;
                    arrayIdSol[hueco] = 5;
                    cambiarBotonSol(hueco, c);
                    boton05.setBackgroundResource(R.drawable.punto);
                    boton05.setEnabled(false);
                }
                else {
                    mostrarDialog(7);
                }

            }
        });

        boton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                char c = arrayChar[6];
                int hueco = buscarHueco();

                if(hueco != -1) {
                    arrayCharSol[hueco] = c;
                    arrayIdSol[hueco] = 6;
                    cambiarBotonSol(hueco, c);
                    boton10.setBackgroundResource(R.drawable.punto);
                    boton10.setEnabled(false);
                }
                else {
                    mostrarDialog(7);
                }

            }
        });

        boton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                char c = arrayChar[7];
                int hueco = buscarHueco();

                if(hueco != -1) {
                    arrayCharSol[hueco] = c;
                    arrayIdSol[hueco] = 7;
                    cambiarBotonSol(hueco, c);
                    boton11.setBackgroundResource(R.drawable.punto);
                    boton11.setEnabled(false);
                }
                else {
                    mostrarDialog(7);
                }

            }
        });

        boton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                char c = arrayChar[8];
                int hueco = buscarHueco();

                if(hueco != -1) {
                    arrayCharSol[hueco] = c;
                    arrayIdSol[hueco] = 8;
                    cambiarBotonSol(hueco, c);
                    boton12.setBackgroundResource(R.drawable.punto);
                    boton12.setEnabled(false);
                }
                else {
                    mostrarDialog(7);
                }

            }
        });

        boton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                char c = arrayChar[9];
                int hueco = buscarHueco();

                if(hueco != -1) {
                    arrayCharSol[hueco] = c;
                    arrayIdSol[hueco] = 9;
                    cambiarBotonSol(hueco, c);
                    boton13.setBackgroundResource(R.drawable.punto);
                    boton13.setEnabled(false);
                }
                else {
                    mostrarDialog(7);
                }

            }
        });

        boton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                char c = arrayChar[10];
                int hueco = buscarHueco();

                if(hueco != -1) {
                    arrayCharSol[hueco] = c;
                    arrayIdSol[hueco] = 10;
                    cambiarBotonSol(hueco, c);
                    boton14.setBackgroundResource(R.drawable.punto);
                    boton14.setEnabled(false);
                }
                else {
                    mostrarDialog(7);
                }

            }
        });

        boton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                char c = arrayChar[11];
                int hueco = buscarHueco();

                if(hueco != -1) {
                    arrayCharSol[hueco] = c;
                    arrayIdSol[hueco] = 11;
                    cambiarBotonSol(hueco, c);
                    boton15.setBackgroundResource(R.drawable.punto);
                    boton15.setEnabled(false);
                }
                else {
                    mostrarDialog(7);
                }

            }
        });

        boton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                char c = arrayChar[12];
                int hueco = buscarHueco();

                if(hueco != -1) {
                    arrayCharSol[hueco] = c;
                    arrayIdSol[hueco] = 12;
                    cambiarBotonSol(hueco, c);
                    boton20.setBackgroundResource(R.drawable.punto);
                    boton20.setEnabled(false);
                }
                else {
                    mostrarDialog(7);
                }

            }
        });

        boton21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                char c = arrayChar[13];
                int hueco = buscarHueco();

                if(hueco != -1) {
                    arrayCharSol[hueco] = c;
                    arrayIdSol[hueco] = 13;
                    cambiarBotonSol(hueco, c);
                    boton21.setBackgroundResource(R.drawable.punto);
                    boton21.setEnabled(false);
                }
                else {
                    mostrarDialog(7);
                }

            }
        });

        boton22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                char c = arrayChar[14];
                int hueco = buscarHueco();

                if(hueco != -1) {
                    arrayCharSol[hueco] = c;
                    arrayIdSol[hueco] = 14;
                    cambiarBotonSol(hueco, c);
                    boton22.setBackgroundResource(R.drawable.punto);
                    boton22.setEnabled(false);
                }
                else {
                    mostrarDialog(7);
                }

            }
        });











        boton_sol0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                int id = arrayIdSol[0];
                char c = arrayCharSol[0];

                arrayCharSol[0] = '.';
                arrayIdSol[0] = -1;
                cambiarBotonRes(id, c);
                boton_sol0.setBackgroundResource(R.drawable.punto);
                boton_sol0.setEnabled(false);

            }
        });

        boton_sol1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                int id = arrayIdSol[1];
                char c = arrayCharSol[1];

                arrayCharSol[1] = '.';
                arrayIdSol[1] = -1;
                cambiarBotonRes(id, c);
                boton_sol1.setBackgroundResource(R.drawable.punto);
                boton_sol1.setEnabled(false);

            }
        });

        boton_sol2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                int id = arrayIdSol[2];
                char c = arrayCharSol[2];

                arrayCharSol[2] = '.';
                arrayIdSol[2] = -1;
                cambiarBotonRes(id, c);
                boton_sol2.setBackgroundResource(R.drawable.punto);
                boton_sol2.setEnabled(false);

            }
        });

        boton_sol3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                int id = arrayIdSol[3];
                char c = arrayCharSol[3];

                arrayCharSol[3] = '.';
                arrayIdSol[3] = -1;
                cambiarBotonRes(id, c);
                boton_sol3.setBackgroundResource(R.drawable.punto);
                boton_sol3.setEnabled(false);

            }
        });

        boton_sol4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                int id = arrayIdSol[4];
                char c = arrayCharSol[4];

                arrayCharSol[4] = '.';
                arrayIdSol[4] = -1;
                cambiarBotonRes(id, c);
                boton_sol4.setBackgroundResource(R.drawable.punto);
                boton_sol4.setEnabled(false);

            }
        });

        boton_sol5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                int id = arrayIdSol[5];
                char c = arrayCharSol[5];

                arrayCharSol[5] = '.';
                arrayIdSol[5] = -1;
                cambiarBotonRes(id, c);
                boton_sol5.setBackgroundResource(R.drawable.punto);
                boton_sol5.setEnabled(false);

            }
        });

        boton_sol6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                int id = arrayIdSol[6];
                char c = arrayCharSol[6];

                arrayCharSol[6] = '.';
                arrayIdSol[6] = -1;
                cambiarBotonRes(id, c);
                boton_sol6.setBackgroundResource(R.drawable.punto);
                boton_sol6.setEnabled(false);

            }
        });

        boton_sol7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                int id = arrayIdSol[7];
                char c = arrayCharSol[7];

                arrayCharSol[7] = '.';
                arrayIdSol[7] = -1;
                cambiarBotonRes(id, c);
                boton_sol7.setBackgroundResource(R.drawable.punto);
                boton_sol7.setEnabled(false);

            }
        });

        boton_sol8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                int id = arrayIdSol[8];
                char c = arrayCharSol[8];

                arrayCharSol[8] = '.';
                arrayIdSol[8] = -1;
                cambiarBotonRes(id, c);
                boton_sol8.setBackgroundResource(R.drawable.punto);
                boton_sol8.setEnabled(false);

            }
        });

        boton_sol9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                int id = arrayIdSol[9];
                char c = arrayCharSol[9];

                arrayCharSol[9] = '.';
                arrayIdSol[9] = -1;
                cambiarBotonRes(id, c);
                boton_sol9.setBackgroundResource(R.drawable.punto);
                boton_sol9.setEnabled(false);

            }
        });

        boton_sol10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.play(soundId1, 1, 1, 1, 0, 2);

                int id = arrayIdSol[10];
                char c = arrayCharSol[10];

                arrayCharSol[10] = '.';
                arrayIdSol[10] = -1;
                cambiarBotonRes(id, c);
                boton_sol10.setBackgroundResource(R.drawable.punto);
                boton_sol10.setEnabled(false);

            }
        });




    }

}
