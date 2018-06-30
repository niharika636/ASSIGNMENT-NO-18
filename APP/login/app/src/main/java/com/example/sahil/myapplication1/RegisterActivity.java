package com.example.sahil.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    TextView regText;
    EditText username,password,email;
    Button register;

    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        register=(Button)findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences=getSharedPreferences("MySharedPrefs",MODE_PRIVATE);
                String newUser=username.getText().toString();
                String newPass=password.getText().toString();


                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString(newUser + newPass + "data","Username : "+newUser + "\n" + "Password : "+newPass);

                editor.commit();


                Toast.makeText(getApplicationContext(),"Successfully Registered.",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
