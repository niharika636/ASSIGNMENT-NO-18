package com.example.sahil.login;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    TextView Login;
    EditText username,password;
    Button register,login,reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login=(TextView)findViewById(R.id.Login);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        register=(Button)findViewById(R.id.register);
        reset = (Button)findViewById(R.id.reset);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();

                SharedPreferences sharedPreferences=getSharedPreferences("MySharedPrefs",MODE_PRIVATE);
                String data= sharedPreferences.getString(user + pass + "data"  ,"Username or Password is incorrect" );
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("display",data);
                editor.commit();
                Intent i=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(i2);
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username.setText("");
                password.setText("");
            }
        });
    }
}
