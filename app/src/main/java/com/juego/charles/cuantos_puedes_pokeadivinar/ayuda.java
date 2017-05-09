package com.juego.charles.cuantos_puedes_pokeadivinar;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.jirbo.adcolony.AdColony;
import com.jirbo.adcolony.AdColonyAd;
import com.jirbo.adcolony.AdColonyAdAvailabilityListener;
import com.jirbo.adcolony.AdColonyAdListener;
import com.jirbo.adcolony.AdColonyV4VCAd;
import com.jirbo.adcolony.AdColonyV4VCListener;
import com.jirbo.adcolony.AdColonyV4VCReward;


public class ayuda extends ActionBarActivity implements RewardedVideoAdListener, AdColonyAdAvailabilityListener, AdColonyV4VCListener, AdColonyAdListener{


    private int monedas;
    private Button pista, solucion, video, publi;
    private int soundId1;
    private SoundPool mySound;
    int num;
    private TextView monedero;


    final private String APP_ID  = "app9f2bc466fe974c6ca8";
    final private String ZONE_ID = "vz18062602a5844d4bae";


    private static final String AD_UNIT_ID = "ca-app-pub-3689011140113990/4170992663";
    private final Object mLock = new Object();

    private RewardedVideoAd mRewardedVideoAd;
    private boolean mIsRewardedVideoLoading;


    private InterstitialAd mInterstitialAd2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        getSupportActionBar().hide();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        AdColony.configure(this, "version:1.0,store:google", APP_ID, ZONE_ID);

        AdColony.addAdAvailabilityListener( this );

        AdColony.addV4VCListener( this );

        mInterstitialAd2 = new InterstitialAd(this);
        mInterstitialAd2.setAdUnitId("ca-app-pub-3689011140113990/8828191464");
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd2.loadAd(adRequest);
        requestNewInterstitial();

        //mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        //mRewardedVideoAd.setRewardedVideoAdListener(this);
        //loadRewardedVideoAd();

        Bundle param = getIntent().getExtras();

        if (param != null) {
            monedas = param.getInt("monedas");
        }

        mySound = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);
        soundId1 = mySound.load(this, R.raw.sonido_boton, 1);


        monedero = (TextView) findViewById(R.id.textViewmonedero);
        pista = (Button) findViewById(R.id.btnAyudaPista);
        solucion = (Button) findViewById(R.id.btnAyudaSol);
        video = (Button) findViewById(R.id.btnAyudaVideo);
        publi = (Button) findViewById(R.id.btnAyudaPubli);

        monedero.setText("" + monedas);

        pista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mySound.play(soundId1, 1, 1, 1, 0, 2);

                if((monedas - 20) < 0){
                    mostrarDialog();
                } else
                    mostrarDialog2();
            }

        });

        solucion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mySound.play(soundId1, 1, 1, 1, 0, 2);

                if((monedas - 100) < 0){
                    mostrarDialog();
                } else
                    mostrarDialog3();

            }

        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mySound.play(soundId1, 1, 1, 1, 0, 2);

                mostrarDialog4();

            }

        });

        if (AdColony.statusForZone( ZONE_ID ).equals( "active" ))
        {
            video.setEnabled( true );
        }

        publi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mySound.play(soundId1, 1, 1, 1, 0, 2);

                mostrarDialog5();
            }

        });

    }



    public void mostrarDialog()
    {

        final Dialog customDialog = new Dialog(this);
        //deshabilitamos el título por defecto
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //obligamos al usuario a pulsar los botones para cerrarlo
        customDialog.setCancelable(false);
        //establecemos el contenido de nuestro dialog
        customDialog.setContentView(R.layout.dialog2);

        ((TextView) customDialog.findViewById(R.id.textView13)).setText(R.string.No_tienes_suficientes);
        ((TextView) customDialog.findViewById(R.id.textView14)).setText(R.string.Quieresverunvideo);


        (customDialog.findViewById(R.id.btnAceptar2)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {

                mySound.play(soundId1, 1, 1, 1, 0, 2);

                customDialog.dismiss();


                //VER VIDEO
                //VER VIDEO
                //VER VIDEO

                showRewardedVideo();

                num = 0;
            }
        });

        (customDialog.findViewById(R.id.btnCancelar2)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                mySound.play(soundId1, 1, 1, 1, 0, 2);
                customDialog.dismiss();
                num = 0;
            }
        });

        customDialog.show();
    }

    public void mostrarDialog2()
    {
        final Dialog customDialog = new Dialog(this);
        //deshabilitamos el título por defecto
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //obligamos al usuario a pulsar los botones para cerrarlo
        customDialog.setCancelable(false);
        //establecemos el contenido de nuestro dialog
        customDialog.setContentView(R.layout.dialog2);

        ((TextView) customDialog.findViewById(R.id.textView13)).setText(R.string.Estassegurodegastar20);
        ((TextView) customDialog.findViewById(R.id.textView14)).setText(R.string.paradescubrirunaletra);


        (customDialog.findViewById(R.id.btnAceptar2)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {

                mySound.play(soundId1, 1, 1, 1, 0, 2);

                customDialog.dismiss();
                monedas = monedas - 20;
                num = 1;
                finish();
            }
        });

        (customDialog.findViewById(R.id.btnCancelar2)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                mySound.play(soundId1, 1, 1, 1, 0, 2);
                customDialog.dismiss();
                num = 0;
            }
        });

        customDialog.show();
    }


    public void mostrarDialog3()
    {
        final Dialog customDialog = new Dialog(this);
        //deshabilitamos el título por defecto
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //obligamos al usuario a pulsar los botones para cerrarlo
        customDialog.setCancelable(false);
        //establecemos el contenido de nuestro dialog
        customDialog.setContentView(R.layout.dialog2);

        ((TextView) customDialog.findViewById(R.id.textView13)).setText("¿Estas seguro de gastar 100 ");
        ((TextView) customDialog.findViewById(R.id.textView14)).setText(" para obtener la solucion?");


        (customDialog.findViewById(R.id.btnAceptar2)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mySound.play(soundId1, 1, 1, 1, 0, 2);

                customDialog.dismiss();
                monedas = monedas - 100;
                num = 2;
                finish();
            }
        });

        (customDialog.findViewById(R.id.btnCancelar2)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {

                mySound.play(soundId1, 1, 1, 1, 0, 2);
                customDialog.dismiss();
                num = 0;
            }
        });

        customDialog.show();
    }

    public void mostrarDialog4()
    {
        final Dialog customDialog = new Dialog(this);
        //deshabilitamos el título por defecto
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //obligamos al usuario a pulsar los botones para cerrarlo
        customDialog.setCancelable(false);
        //establecemos el contenido de nuestro dialog
        customDialog.setContentView(R.layout.dialog2);

        ((TextView) customDialog.findViewById(R.id.textView13)).setText("¿Quieres conseguir ");
        ((TextView) customDialog.findViewById(R.id.textView14)).setText(" gratis viendo un video?");


        (customDialog.findViewById(R.id.btnAceptar2)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mySound.play(soundId1, 1, 1, 1, 0, 2);

                customDialog.dismiss();

                AdColonyV4VCAd ad = new AdColonyV4VCAd().withListener(ayuda.this);
                ad.show();

                //showRewardedVideo();

                num = 0;
            }
        });

        (customDialog.findViewById(R.id.btnCancelar2)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {

                mySound.play(soundId1, 1, 1, 1, 0, 2);
                customDialog.dismiss();
                num = 0;
            }
        });

        customDialog.show();
    }

    public void mostrarDialog5()
    {

        //MOSTRAR PUBLI
        //MOSTRAR PUBLI
        //MOSTRAR PUBLI
        num = 0;

        if (mInterstitialAd2.isLoaded()) {
            mInterstitialAd2.show();
            monedas += 10;
            monedero.setText("" + monedas);
            mostrarDialogRecompensa(1);
        }
        else
            Toast.makeText(getApplicationContext(), "Se paciente, la publicidad está cargando", Toast.LENGTH_SHORT).show();

        requestNewInterstitial();
    }

    public void mostrarDialogRecompensa(int numero)
    {
        final Dialog customDialog = new Dialog(this);
        //deshabilitamos el título por defecto
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //obligamos al usuario a pulsar los botones para cerrarlo
        customDialog.setCancelable(false);
        //establecemos el contenido de nuestro dialog
        customDialog.setContentView(R.layout.dialog);

        if(numero == 0) {
            ((TextView) customDialog.findViewById(R.id.titulo)).setText("¡Enhorabuena!");
            ((TextView) customDialog.findViewById(R.id.textView12)).setText("Has conseguido: 30 ");
            ((ImageView) customDialog.findViewById(R.id.imageView7)).setImageResource(R.drawable.monedas);
        }
        else {
            if(numero == 1) {
                ((TextView) customDialog.findViewById(R.id.titulo)).setText("¡Enhorabuena!");
                ((TextView) customDialog.findViewById(R.id.textView12)).setText("Has conseguido: 10 ");
                ((ImageView) customDialog.findViewById(R.id.imageView7)).setImageResource(R.drawable.monedas);
            }
            else {
                ((TextView) customDialog.findViewById(R.id.titulo)).setText("¡Ha habido un problema!");
                ((TextView) customDialog.findViewById(R.id.textView12)).setText("¡Para ganar las monedas debes ver el video al completo!");
                ((ImageView) customDialog.findViewById(R.id.imageView7)).setImageResource(0);
            }
        }
        (customDialog.findViewById(R.id.btnAceptar)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {

                mySound.play(soundId1, 1, 1, 1, 0, 2);

                customDialog.dismiss();

            }
        });

        customDialog.show();
    }


    public void finish() {
        Intent data = new Intent();

        data.putExtra("monedas", monedas);
        data.putExtra("accion", num);
        setResult(RESULT_OK, data);
        super.finish();
    }





    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().build();

        mInterstitialAd2.loadAd(adRequest);
    }






    private void loadRewardedVideoAd() {
        synchronized (mLock) {
            if (!mIsRewardedVideoLoading && !mRewardedVideoAd.isLoaded()) {
                mIsRewardedVideoLoading = true;
                Bundle extras = new Bundle();
                extras.putBoolean("_noRefresh", true);
                AdRequest adRequest = new AdRequest.Builder()
                        .addNetworkExtrasBundle(AdMobAdapter.class, extras)
                        .build();
                mRewardedVideoAd.loadAd(AD_UNIT_ID, adRequest);
            }
        }
    }

    private void showRewardedVideo() {
        if (mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.show();
        }
    }


    private void addCoins(int coins) {
        monedas += coins;
        monedero.setText("" + monedas);
    }


    @Override
    public void onRewardedVideoAdLoaded() {
        synchronized (mLock) {
            mIsRewardedVideoLoading = false;
        }
        Toast.makeText(this, "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {
        synchronized (mLock) {
            mIsRewardedVideoLoading = false;
        }
        Toast.makeText(this, "onRewardedVideoAdFailedToLoad", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoStarted() {
        Toast.makeText(this, "onRewardedVideoStarted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdClosed() {
        Toast.makeText(this, "onRewardedVideoAdClosed", Toast.LENGTH_SHORT).show();
        // Preload the next video ad.
        loadRewardedVideoAd();
        mostrarDialogRecompensa(0);
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        Toast.makeText(this, "onRewardedVideoAdLeftApplication", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onRewardedVideoAdOpened() {
        Toast.makeText(this, "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onRewarded(RewardItem reward) {
        Toast.makeText(this, "HAS SIDO RECOMPENSADO!! " + reward.getAmount(), Toast.LENGTH_SHORT).show();
        addCoins(reward.getAmount());
        mostrarDialogRecompensa(0);
    }









    @Override
    public void onAdColonyAdAvailabilityChange( final boolean available, String zone_id )
    {
        runOnUiThread( new Runnable()
        {
            @Override
            public void run()
            {
                //If zone has ads available, enable the button
                if (available)
                {
                    video.setEnabled( true );
                }
                else
                {
                    video.setEnabled( false );
                }
            }
        } );
    }

    @Override
    public void onAdColonyV4VCReward( AdColonyV4VCReward reward )
    {
        if (reward.success())
        {

            //Reward was successful, reward your user here
            int amount  = reward.amount();
            addCoins(amount);
            mostrarDialogRecompensa(0);
        }
    }

    @Override
    public void onAdColonyAdAttemptFinished( AdColonyAd ad )
    {
        //Can use the ad object to determine information about the ad attempt:
        //ad.shown();
        //ad.notShown();
        //ad.canceled();
        //ad.noFill();
        //ad.skipped();
    }

    @Override
    public void onAdColonyAdStarted( AdColonyAd ad )
    {
        //Called when the ad has started playing
    }

    @Override
    public void onResume()
    {
        super.onResume();
        AdColony.resume(this);
    }

    @Override
    public void onPause()
    {
        super.onPause();
        AdColony.pause();
    }


}
