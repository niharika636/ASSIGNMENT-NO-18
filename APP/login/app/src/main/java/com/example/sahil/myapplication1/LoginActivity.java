package com.example.sahil.login;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {


    TextView Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences sharedPreferences=getSharedPreferences("MySharedPrefs",MODE_PRIVATE);
        String displayText=sharedPreferences.getString("display","");
        Text=(TextView)findViewById(R.id.textView);

        Text.setText(displayText);
    }
}
