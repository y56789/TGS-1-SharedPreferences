package com.example.mul05.sessionmanagement;

/**
 * Created by Mursyid on 20/10/2016.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

//Created by Fathur (okedroid.com)

public class send_data extends AppCompatActivity {   // Session Manager Class
    SessionManagement session;
    // Button Send
    Button btnsend  ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output);
        // Session class instance
        session = new SessionManagement(getApplicationContext());
        TextView lblname = (TextView) findViewById(R.id.lblname);
        TextView lblnim = (TextView) findViewById(R.id.lblnim);
        // Button submit
        btnsend = (Button) findViewById(R.id.btnsend );
        HashMap<String, String> user = session.getTampilan();
        // nama
        String name = user.get(SessionManagement.KEY_NAMA);
        // email
        String nim = user.get(SessionManagement.KEY_NIM);
        // menampilkan user data
        lblname.setText(Html.fromHtml("Nama: <b>" + name + "</b>"));
        lblnim.setText(Html.fromHtml("NIM: <b>" + nim + "</b>"));
    }
}
