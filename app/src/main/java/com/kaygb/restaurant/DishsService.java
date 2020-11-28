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
}
