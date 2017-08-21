package com.example.laptopmaarten.examenmaarten2108;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**********************************************
 * GEDANE UITBREIDINGEN
 * - E-mail button
 * - Notification
 * - Fouten opslagen in preferences (werkt niet helemaal)
 *
 */
public class MainActivity extends AppCompatActivity {
    int getal1, getal2, getal3;
    public int fout;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = getSharedPreferences("key", MODE_PRIVATE);
        //Uitbreding storage werkt niet helemaal
        /*SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(getString(R.string.saved_fout), newSavedFout);
        editor.commit();

        int def = getResources().getInteger(R.string_.saved_fout_default);
        int fout = preferences.getInt(getString(R.string.saved_fout), def);
        */

        final Intent wallet = new Intent(getApplicationContext(), wallet.class);

        final TextView txtGetal1 = (TextView) findViewById(R.id.txtgetal1);
        final TextView txtGetal2 = (TextView) findViewById(R.id.txtgetal2);
        final TextView txtGetal3 = (TextView) findViewById(R.id.txtgetal3);
        Button button1p = (Button) findViewById(R.id.btn1plus);
        Button button1m = (Button) findViewById(R.id.btn1min);
        Button button2p = (Button) findViewById(R.id.btn2plus);
        Button button2m = (Button) findViewById(R.id.btn2min);
        Button button3p = (Button) findViewById(R.id.btn3plus);
        Button button3m = (Button) findViewById(R.id.btn3min);
        final Button recover = (Button) findViewById(R.id.btnrecover);
        Button buttonCheck = (Button) findViewById(R.id.btncheck);



       button1p.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                getal1 = getal1 + 1;
               if (getal1 > 9)
                   getal1 = 0;
                txtGetal1.setText("" + getal1);

           }
       });

        button1m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getal1 = getal1 - 1;
                if (getal1 < 0)
                    getal1 = 9;
                txtGetal1.setText("" + getal1);
            }
        });

        button2p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getal2 = getal2 + 1;
                if (getal2 > 9)
                    getal2 = 0;
                txtGetal2.setText("" + getal2);
            }
        });

        button2m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getal2 = getal2 - 1;
                if (getal2 < 0)
                    getal2 = 9;
                txtGetal2.setText("" + getal2);
            }
        });
        button3p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getal3 = getal3 + 1;
                if (getal3 > 9)
                    getal3 = 0;
                txtGetal3.setText("" + getal3);
            }
        });
        button3m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getal3 = getal3 - 1;
                if (getal3 < 0)
                    getal3 = 9;
                txtGetal3.setText("" + getal3);
            }
        });

        recover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","kristof.overdulve@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Forgot vault code");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "I forgot my vault code. Please send it by email");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((getal1 == 8)&&(getal2 == 1)&&(getal3 == 8)){
                    Toast toast = Toast.makeText(getApplicationContext(),"Code correct.",Toast.LENGTH_LONG);
                    toast.show();
                    wallet.putExtra("key", "" +  fout);
                    startActivity(wallet);
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),"Code incorrect. Try again.", Toast.LENGTH_LONG);
                    toast.show();
                    fout = fout + 1;
                    getal1 = 0;
                    txtGetal1.setText("" + getal1);
                    getal2 = 0;
                    txtGetal2.setText("" + getal2);
                    getal3 = 0;
                    txtGetal3.setText("" + getal3);
                    recover.setVisibility(View.VISIBLE);
                    if (fout >= 5)
                        sendNotification(v);
                }
            }

            //Notification uitbreding
            public void sendNotification(View v){
                NotificationCompat.Builder mBuilder =
                        (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                                .setContentTitle("Intruder Alert")
                                .setContentText("We suspect malious behaviour on your account and have notified you via email");

                NotificationManager mnotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mnotificationManager.notify(001, mBuilder.build());
            }
        });


}}
