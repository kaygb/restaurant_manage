package com.kaygb.restaurant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DishsService {
    private DbHelper dbHelper;

    public DishsService(Context context) {
        dbHelper = new DbHelper(context);
    }

    public boolean AddDishs(Dishs dishs) { // 无今日数据时调用,创建新数据

        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql = "insert into dishs (dish_name,dish_date,dish_category,dish_count,dish_price," +
                "dish_amount,dish_surplus1,dish_surplus2,dish_surplus3) values (?,?,?,?,?,?,?,?,?)";
        Object obj[] = {dishs.getDish_name(),dishs.getDish_date(),dishs.getDish_category(),
                dishs.getDish_count(),
                dishs.getDish_price(),dishs.getDish_amount(),dishs.getDish_surplus1(),
                dishs.getDish_surplus2(),dishs.getDish_surplus3()};
        sqLiteDatabase.execSQL(sql, obj);
        return true;
    }
    /*
    根据菜品的名称和菜品日期，更新每餐结余，在更新时，需指定当前要修改的菜品名
     */

    public boolean updateSurplus1(Dishs dishs){ // 更新菜品早餐之后的结余
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql =
                "update dishs set dish_surplus1 = '"+ dishs.getDish_surplus1() +"' where " +
                        "dish_name='"+dishs.getDish_name()+
                        "' and dish_date = '"
                        +dishs.getDish_date()+"'";
        sqLiteDatabase.execSQL(sql);
        return true;
    }
    public boolean updateSurplus2(Dishs dishs){ // 更新菜品午餐之后的结余
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql =
                "update dishs set dish_surplus2 = '"+ dishs.getDish_surplus2() +"' where " +
                        "dish_name='"+dishs.getDish_name()+
                        "' and dish_date = '"
                        +dishs.getDish_date()+"'";
        sqLiteDatabase.execSQL(sql);
        return true;
    }
    public boolean updateSurplus3(Dishs dishs){ // 更新菜品晚餐之后的结余
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql =
                "update dishs set dish_surplus3 = '"+ dishs.getDish_surplus3() +"' where " +
                        "dish_name='"+dishs.getDish_name()+
                        "' and dish_date = '"
                        +dishs.getDish_date()+"'";
        sqLiteDatabase.execSQL(sql);
        return true;
    }
}
