package com.example.laptopmaarten.examenmaarten2108;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by LaptopMaarten on 21/08/2017.
 */

class CustomList extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] pokemonarray;
    private final String[] naamarray;
    private final Integer[] images;

    public CustomList(Activity context, String[] pokemonarray, Integer[] images, String[] naamarray){
        super(context, R.layout.list_single, pokemonarray);
        this.context = context;
        this.pokemonarray = pokemonarray;
        this.naamarray = naamarray;
        this.images = images;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        //Layout inflater maken voor de list
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        TextView txtNaam = (TextView) rowView.findViewById(R.id.txtnaam);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(pokemonarray[position]);
        txtNaam.setText(naamarray[position]);
        imageView.setImageResource(images[position]);
        return rowView;
    }
}
