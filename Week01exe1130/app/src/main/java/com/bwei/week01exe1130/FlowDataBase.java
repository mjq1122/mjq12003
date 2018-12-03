package com.bwei.week01exe1130;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2018/11/30.
 */

public class FlowDataBase extends SQLiteOpenHelper {

    private final SQLiteDatabase db;

    public FlowDataBase(Context context) {
        super(context, "flow.db", null, 1);
         db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table search (id integer primary key autoincrement,keys text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insert(String keys){
        ContentValues values = new ContentValues();
        values.put("keys",keys);
        db.insert("search",null,values);
    }
    public void delete(){
        db.delete("search",null,null);
    }
    public List<String> query(){
        Cursor cursor = db.query("search", null, null, null, null, null, null);
        List<String> list=new ArrayList<>();
        while (cursor.moveToNext()){
            String keys = cursor.getString(cursor.getColumnIndex("keys"));
            list.add(keys);
        }
        return list;
    }
}
