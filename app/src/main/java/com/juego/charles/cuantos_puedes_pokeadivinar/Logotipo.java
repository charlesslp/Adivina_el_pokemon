package com.juego.charles.cuantos_puedes_pokeadivinar;


import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ImageView;


public class Logotipo extends ActionBarActivity {



    private int logos[] = {R.drawable.logo_gif50, R.drawable.logo_gif50, R.drawable.logo_gif50,
            R.drawable.logo_gif49, R.drawable.logo_gif48, R.drawable.logo_gif47, R.drawable.logo_gif46,
            R.drawable.logo_gif45, R.drawable.logo_gif44, R.drawable.logo_gif43, R.drawable.logo_gif42,
            R.drawable.logo_gif41, R.drawable.logo_gif40, R.drawable.logo_gif1, R.drawable.logo_gif3,
            R.drawable.logo_gif5, R.drawable.logo_gif7, R.drawable.logo_gif9,
            R.drawable.logo_gif11, R.drawable.logo_gif13,
            R.drawable.logo_gif15,R.drawable.logo_gif17, R.drawable.logo_gif19,
            R.drawable.logo_gif21, R.drawable.logo_gif23,
            R.drawable.logo_gif25, R.drawable.logo_gif27, R.drawable.logo_gif29,
            R.drawable.logo_gif31, R.drawable.logo_gif33
    };

    private int cont = 0, contFin = logos.length - 1;
    private ImageView gif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logotipo);

        getSupportActionBar().hide();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        gif = (ImageView) findViewById(R.id.imageView9);

        new CountDownTimer(6500,50){

            public void onTick(long millisUntilFinished){
                if (cont < logos.length - 1) {
                    gif.setImageResource(logos[cont]);
                    cont++;
                } else{
                    if(contFin > 0) {
                        gif.setImageResource(logos[contFin]);
                        contFin--;
                    }
                }

            }

            public void onFinish(){
                finish();
            }
        }.start();
    }

    public void finish() {
        super.finish();
    }


}
