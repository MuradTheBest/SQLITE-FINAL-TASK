package com.example.sqlitefinaltask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Show_Students_By_Class extends AppCompatActivity {

    TextView tv_students_list_by_class;
    ListView lv_students_by_class;
    Button button;

    Intent intent;
    SQLiteDatabase db;
    ArrayList<Student> students;
    StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_students_by_class);

        getSupportActionBar().hide();

        db = openOrCreateDatabase(Utils.DATABASE_NAME, MODE_PRIVATE, null);

        Utils.addDefaultSubjects(db);

        intent = getIntent();

        tv_students_list_by_class = findViewById(R.id.tv_students_list_by_class);
        lv_students_by_class = findViewById(R.id.lv_students_by_class);
        button = findViewById(R.id.button);


        String class_name = intent.getStringExtra(Utils.INTENT_KEY_STUDENT_CLASS_NAME);
        students = Utils.showStudentsByClass(class_name, db);

        studentAdapter = new StudentAdapter(students, Show_Students_By_Class.this);
        lv_students_by_class.setAdapter(studentAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Student> sortedList = Utils.sortStudentsBySubject(students, db);

                ArrayList<Integer> ids = new ArrayList<>();
                ArrayList<String> first_names = new ArrayList<>();
                ArrayList<String> last_names = new ArrayList<>();
                ArrayList<String> class_names = new ArrayList<>();
                ArrayList<Integer> avgs = new ArrayList<>();
                ArrayList<String> subjects = new ArrayList<>();

                for (int i=0; i<sortedList.size(); i++){

                    ids.add(sortedList.get(i).getId());
                    first_names.add(sortedList.get(i).getFirst_name());
                    last_names.add(sortedList.get(i).getLast_name());
                    class_names.add(sortedList.get(i).getClass_name());
                    avgs.add(sortedList.get(i).getAvg());
                    subjects.add(sortedList.get(i).getSubject());
                }

                Intent i = new Intent(getApplicationContext(), Sorted_Students.class);
                i.putExtra(Utils.INTENT_KEY_SORTED_STUDENT_IDS, ids);
                i.putExtra(Utils.INTENT_KEY_SORTED_STUDENT_FIRST_NAMES, first_names);
                i.putExtra(Utils.INTENT_KEY_SORTED_STUDENT_LAST_NAMES, last_names);
                i.putExtra(Utils.INTENT_KEY_SORTED_STUDENT_CLASS_NAMES, class_names);
                i.putExtra(Utils.INTENT_KEY_SORTED_STUDENT_AVGS, avgs);
                i.putExtra(Utils.INTENT_KEY_SORTED_STUDENT_SUBJECTS, subjects);

                startActivity(i);
            }
        });
    }
}