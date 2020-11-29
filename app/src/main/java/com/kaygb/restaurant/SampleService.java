package com.kaygb.restaurant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class SampleService {
    private DbHelper dbHelper;

    public SampleService(Context context) {
        dbHelper = new DbHelper(context);
    }
    public boolean AddSample(Sample sample){ //添加留样
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql = "insert into sample (sdate,sname,sname_p,smeal) values (?,?,?,?)";
        Object obj[] = {sample.getSdate(),sample.getSname(),sample.getSname_p(),sample.getSmeal()};
        sqLiteDatabase.execSQL(sql, obj);
        return true;
    }
    public String[] getSamples(){



        String[] str = {};
        return str;
    }
}
