package com.example.laptopmaarten.examenmaarten2108;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by LaptopMaarten on 21/08/2017.
 */


public class wallet extends AppCompatActivity {
    Integer[] images = {
            R.drawable.zcash,
            R.drawable.siacoin,
            R.drawable.litecoin,
            R.drawable.ripple,
            R.drawable.bitcoin,
            R.drawable.bitcoin_cash,
            R.drawable.bitconnect,
            R.drawable.bytecoin,
            R.drawable.dogecoin,
            R.drawable.dash,
            R.drawable.ethereum,
            R.drawable.ethereum_classic
    };
    String[] naamLijst;
    String[] valueLijst;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wallet);
        SharedPreferences preferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
        TextView pogingen = (TextView) findViewById(R.id.txtgetal2);
        ListView mainlist = (ListView) findViewById(R.id.listMain);
        Context context = this;

        naamLijst = new String[12];
        naamLijst[0] = "zcash";
        naamLijst[1] = "siacoin";
        naamLijst[2] = "litecoin";
        naamLijst[3] = "ripple";
        naamLijst[4] = "bitcoin";
        naamLijst[5] = "bitcoin_cash";
        naamLijst[6] = "bitconnect";
        naamLijst[7] = "bytecoin";
        naamLijst[8] = "dogecoin";
        naamLijst[9] = "dash";
        naamLijst[10] = "ethereum";
        naamLijst[11] = "ethereum_classic";

        valueLijst = new String[12];
        valueLijst[0] = "120.86";
        valueLijst[1] = "985.00";
        valueLijst[2] = "22.00";
        valueLijst[3] = "451.55";
        valueLijst[4] = "66.00";
        valueLijst[5] = "78.00";
        valueLijst[6] = "2015.00";
        valueLijst[7] = "98566.56";
        valueLijst[8] = "2.66";
        valueLijst[9] = "214.65";
        valueLijst[10] = "54.68";
        valueLijst[11] = "65.00";



        CustomList adapter = new CustomList(wallet.this,valueLijst,images,naamLijst);
        mainlist.setAdapter(adapter);




    }
}
