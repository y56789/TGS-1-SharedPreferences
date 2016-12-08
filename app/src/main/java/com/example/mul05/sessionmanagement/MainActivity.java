package com.example.mul05.sessionmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText lblname,lblnim ;
    // Session Manager Class
    SessionManagement session;
    // Button Logout
    Button btnLogout,btnsend;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Session class instance
        session = new SessionManagement(getApplicationContext());
        TextView lblName = (TextView) findViewById(R.id.lblNama);
        TextView lblEmail = (TextView) findViewById(R.id.lblEmail);
        lblname = (EditText) findViewById(R.id.txtname);
        lblnim= (EditText) findViewById(R.id.txtnim);
        // Button Send
// Button logout
        btnLogout = (Button) findViewById(R.id.btnLogout);
        Toast.makeText(getApplicationContext(), "User Login Status: " +
                session.isLoggedIn(), Toast.LENGTH_LONG).show();
// Cek User apakah sudah login
        session.checkLogin();
// Mendapatkan data user dari session
        HashMap<String, String> user = session.getUserDetails();
// nama
        String name = user.get(SessionManagement.KEY_NAME);
// email
        String email = user.get(SessionManagement.KEY_EMAIL);
// menampilkan user data
        lblName.setText(Html.fromHtml("Name: <b>" + name + "</b>"));
        lblEmail.setText(Html.fromHtml("Email: <b>" + email + "</b>"));

        btnsend = (Button) findViewById(R.id.btnsend);
/**
 * Logout button click event
 * */
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
// menghapus session data
// dan mengarahakan ke LoginActivity
                session.logoutUser();
                finish();
            }
        });
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.viewTampilan(lblname.getText().toString(), lblnim.getText().toString());
                Intent i = new Intent(getApplicationContext(),send_data.class);
                startActivity(i);
            }
        });

    }
}