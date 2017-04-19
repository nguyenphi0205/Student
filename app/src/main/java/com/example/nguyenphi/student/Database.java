package com.example.nguyenphi.student;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nguyenphi on 19/04/2017.
 */

public class Database extends SQLiteOpenHelper {

    public Database(Context context) {
        super(context, "Student", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "Create table Student (id text primary key, name text,email text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists  Student");
        onCreate(db);
    }

    public void Insert(Student st) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("ID", st.getId());
        value.put("Name", st.getName());
        value.put("Email", st.getEmail());
        db.insert("Student", null, value);
    }

    public int Update(Student st) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("ID", st.getId());
        value.put("Name", st.getName());
        value.put("Email", st.getEmail());
        int result = 0;
        result = db.update("Student", value, "id=?", new String[]{st.getId()});
        db.close();
        return result;
    }

    public int Delete(Student st) {
        int result = 0;
        SQLiteDatabase db = getWritableDatabase();
        result = db.delete("Student", "id=?", new String[]{st.getId()});
        db.close();
        return result;
    }

    public Student getstudent(String id) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cur = db.query("Student", new String[]{"id", "name", "email"}, "id=?", new String[]{id}, null, null, null);
        if (cur.moveToNext()) {
            Student st = new Student(cur.getString(0), cur.getString(1), cur.getString(2));
            return st;
        }
        return null;
    }

    public List<Student> getStudent() {
        List<Student> list = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase()  ;
        String query = "Select *from Student";
        Cursor cur = db.rawQuery(query, null);
        while (cur.moveToNext()) {
            Student st = new Student(cur.getString(0), cur.getString(1), cur.getString(2));
            list.add(st);
        }
        return list;

    }


}
