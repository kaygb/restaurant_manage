package com.kaygb.restaurant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private final static String NAME = "st.db";
    private final static int VERSION = 1;
    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DbHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql1 = "CREATE TABLE nums( id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT NOT NULL, time TEXT NOT NULL,time1 TEXT NOT NULL,time2 TEXT NOT NULL," +
                "   meal1_p_num INTEGER," +
                "   meal2_p_num INTEGER," +
                "   meal3_p_num INTEGER" +
                ")";
//
        String sql2 ="CREATE TABLE dishs(" +
                "   did INTEGER PRIMARY KEY AUTOINCREMENT," +
                "   dish_name TEXT NOT NULL," +
                "   dish_category TEXT NOT NULL," +
                "   dish_count REAL NOT NULL," +
                "   dish_price REAL NOT NULL," +
                "   dish_amount REAL NOT NULL," +
                "   dish_surplus1 REAL," +
                "   dish_surplus2 REAL," +
                "   dish_surplus3 REAL" +
                ")";
        String sql3 = "CREATE TABLE category(" +
                "   cid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "   cate_name TEXT NOT NULL," +
                "   cate_slug TEXT NOT NULL" +
                ")";
        String sql4 = "CREATE TABLE sample(" +
                "   sid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "   sdate TEXT NOT NULL," +
                "   sname TEXT NOT NULL," +
                "   sname_p TEXT NOT NULL," +
                "   smeal TEXT NOT NULL" +
                ")";
        String sql5 = "CREATE TABLE dayliving(" +
                "   lid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "   ldate TEXT NOT NULL," +
                "   lcate TEXT NOT NULL," +
                "   lvalue REAL" +
                ")";
        String sql6 = "CREATE TABLE monliving(" +
                "   mid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "   mdate TEXT NOT NULL," +
                "   mcate TEXT NOT NULL," +
                "   mvalue REAL" +
                ")";
        String sql7 = "CREATE TABLE qianzi(" +
                "   qid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "   qdate TEXT NOT NULL," +
                "   qyijian TEXT," +
                "   qqingkuang TEXT," +
                "    qzhuguan TEXT," +
                "    qsiwuzhang TEXT," +
                "    qcsbz TEXT," +
                "    qzby TEXT" +
                ")";
        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);
        db.execSQL(sql5);
        db.execSQL(sql6);
        db.execSQL(sql7);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
