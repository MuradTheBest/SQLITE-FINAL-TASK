package com.example.sqlitefinaltask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn_start);
        db = openOrCreateDatabase(Utils.DB_name, MODE_PRIVATE, null);
        Utils.createTables(db);
        Utils.resetTables(db);

        Student i = new Student("Itai", "Maman", "yb8", 70);
        Utils.addStudent(i, db);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TableActivity.class));
            }
        });
    }
}