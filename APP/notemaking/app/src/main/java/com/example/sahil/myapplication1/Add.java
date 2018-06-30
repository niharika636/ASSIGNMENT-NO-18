package com.example.sahil.notemaking;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add extends AppCompatActivity {

    EditText notes;
    Button add,reset;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add);


        notes=(EditText)findViewById(R.id.noteText);
        add=(Button)findViewById(R.id.add);
        reset=(Button)findViewById(R.id.reset);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Note=notes.getText().toString();

                NoteAdd(Note);
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notes.setText("");
            }
        });
    }

    void NoteAdd(String notes){

        try {
            SQLiteDatabase db = this.openOrCreateDatabase("notesDB", MODE_PRIVATE, null);
            db.execSQL("create table if not exists list (notetext VARCHAR)");


            db.execSQL("insert into list values('" + notes + "')");
            Log.i("notes", "Success");
            Toast.makeText(getApplicationContext(), "Notes added successfully", Toast.LENGTH_SHORT).show();


        }catch (Exception e){
            e.printStackTrace();
        }



    }
}

