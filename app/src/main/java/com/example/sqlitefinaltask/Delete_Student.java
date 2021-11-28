package com.example.sqlitefinaltask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Delete_Student extends AppCompatActivity {
    SQLiteDatabase db;

    EditText et_id;
    Button btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);

        getSupportActionBar().hide();

        db = openOrCreateDatabase(Utils.DATABASE_NAME, MODE_PRIVATE, null);

        et_id = findViewById(R.id.et_id);
        System.out.println("hello");
        btn_delete = findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(et_id.getText().toString());

                Utils.deleteStudent(id, db);
                Log.d("tag", "" + id);

                Intent intent = new Intent(Delete_Student.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}