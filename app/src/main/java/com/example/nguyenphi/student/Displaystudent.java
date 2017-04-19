package com.example.nguyenphi.student;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by nguyenphi on 19/04/2017.
 */

public class Displaystudent extends Activity {
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        listview = (ListView) findViewById(R.id.lblStudent);
        Database db = new Database(this);
        studentadapter stap = new studentadapter(this, db.getStudent());
        listview.setAdapter(stap);

    }

}
