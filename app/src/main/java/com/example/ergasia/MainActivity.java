package com.example.ergasia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.ergasia.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        final Button submit = findViewById(R.id.submitbutton);
        final Button search = findViewById(R.id.searchbutton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                EditText nametext = findViewById(R.id.nametext);
                String username = nametext.getText().toString();

                EditText lastext = findViewById(R.id.lasttext);
                String userlast = lastext.getText().toString();

                EditText agetext = findViewById(R.id.agetext);
                int userage = Integer.parseInt(agetext.getText().toString());

                if(username.matches("") || userlast.matches("")){
                    Toast.makeText(MainActivity.this, "Please Fill The Form Correctly And Try Again!", Toast.LENGTH_SHORT).show();
                }else {
                    Dbhelper dbhelper = new Dbhelper(MainActivity.this);
                    Info student = new Info(username, userlast, userage);
                    dbhelper.insert(student);
                    Toast.makeText(MainActivity.this, "Your Info Have Been Submitted!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText searchfname = findViewById(R.id.searchnametext);
                String sfname = searchfname.getText().toString();
                ArrayList<Info> info = new ArrayList<Info>();
                Dbhelper dbhelper = new Dbhelper(MainActivity.this);
                info = dbhelper.search(sfname);
                Intent intent = new Intent();
                intent.setClassName("com.example.ergasia", "com.example.ergasia.MainActivity2");
                intent.putExtra("info", info);
                startActivity(intent);
            }
        });
    }
}
