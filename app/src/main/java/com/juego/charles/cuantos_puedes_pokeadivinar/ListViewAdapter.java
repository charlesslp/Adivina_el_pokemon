package com.juego.charles.cuantos_puedes_pokeadivinar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Carlos on 26/03/2015.
 */
public class ListViewAdapter extends BaseAdapter {
    // Declare Variables
    Context context;
    String[] nombre_pokemon;
    int[] imagenes;
    LayoutInflater inflater;
    String pokemon_pokedex;
    boolean[] pokedex;

    public ListViewAdapter(Context context, String s_pokemon_pokedex, boolean[] p_pokedex, String[] p_nombre_pokemon, int[] imagenes) {
        this.context = context;
        this.pokemon_pokedex = s_pokemon_pokedex;
        this.pokedex = p_pokedex;
        this.nombre_pokemon = p_nombre_pokemon;
        this.imagenes = imagenes;
    }




    @Override
    public int getCount() {
        return nombre_pokemon.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Declare Variables
        TextView txtTitle;
        ImageView imgImg;


        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.list_view_adapter, parent, false);

        // Locate the TextViews in listview_item.xml
        txtTitle = (TextView) itemView.findViewById(R.id.textView6);
        imgImg = (ImageView) itemView.findViewById(R.id.listImage);



       if(pokedex[position]) {
            // Capture position and set to the TextViews
            txtTitle.setText(nombre_pokemon[position]);
            imgImg.setImageResource(imagenes[position]);
        }else{
            // Capture position and set to the TextViews
            txtTitle.setText("...");
            imgImg.setImageResource(R.drawable.cat0);
        }

        return itemView;
    }
}
