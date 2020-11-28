package com.kaygb.restaurant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class CategoryService {
    private DbHelper dbHelper;
    public CategoryService(Context context) {
        dbHelper = new DbHelper(context);
    }
    public void InitCategory(){ // 初始化分类,需要填写分类和对应的slug，这里一般只执行一次
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql = "insert into category (cate_name,cate_slug) values ('','');";
        sqLiteDatabase.execSQL(sql);
        String sql1 = "insert into category (cate_name,cate_slug) values ('','');";
        sqLiteDatabase.execSQL(sql1);
        String sql2 = "insert into category (cate_name,cate_slug) values ('','');";
        sqLiteDatabase.execSQL(sql2);
        String sql3 = "insert into category (cate_name,cate_slug) values ('','');";
        sqLiteDatabase.execSQL(sql3);
    }
}
