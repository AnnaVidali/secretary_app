package com.example.ergasia;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MainActivity2 extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        ArrayList<Info> info = (ArrayList<Info>)intent.getSerializableExtra("info");
        final TableLayout tl = (TableLayout)findViewById(R.id.table);

        for(int i = 0; i < info.size(); i++) {

            int id = info.get(i).getId();
            String fname = info.get(i).getFname();
            String lname = info.get(i).getLname();
            int age = info.get(i).getAge();

            TableRow row = new TableRow(this);
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(layoutParams);

            TextView idvalue = new TextView(this);
            TextView fnamevalue = new TextView(this);
            TextView lnamevalue = new TextView(this);
            TextView agevalue = new TextView(this);

            String string = String.valueOf(id);
            idvalue.setText(string);
            row.addView(idvalue, 0);


            fnamevalue.setText(fname);
            row.addView(fnamevalue, 1);


            lnamevalue.setText(lname);
            row.addView(lnamevalue, 2);

            String stringage = String.valueOf(age);
            agevalue.setText(stringage);
            row.addView(agevalue, 3);

            tl.addView(row);

        }

    }


}
