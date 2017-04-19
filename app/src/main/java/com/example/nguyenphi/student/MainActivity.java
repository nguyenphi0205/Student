package com.example.nguyenphi.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtid, txtname, txtemail;
    Button btnadd, btnshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtid=(EditText) findViewById(R.id.txtID);
        txtname=(EditText) findViewById(R.id.txtName);
        txtemail=(EditText) findViewById(R.id.txtEmail);
        btnadd=(Button) findViewById(R.id.btnAdd);
        btnshow=(Button) findViewById(R.id.btnDisplay);
      final   Database db=new Database(this);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Student st=new Student(txtid.getText().toString(),txtname.getText().toString(),txtemail.getText().toString());
                db.Insert(st);
                txtid.setText("");
                txtname.setText("");
                txtemail.setText("");
                txtid.requestFocus();
            }
        });

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Displaystudent.class);
                startActivity(intent);
            }
        });
    }
}
