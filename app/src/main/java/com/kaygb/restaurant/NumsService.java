package com.kaygb.restaurant;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

// 人数表 服务类
public class NumsService {

    private DbHelper dbHelper;
    public NumsService(Context context){
        dbHelper = new DbHelper(context);
    }

    /*  写入当天时间及每餐人数
        @param
        @return 写入成功返回 true
        可通过验证是否相同的日期，来判断是新写入数据还是修改数据
     */
    public boolean SetNums(Nums nums){ // 无今日数据时调用,创建新数据

        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
//        String sql = "insert into nums (date,time,time1,time2,meal1_p_num,meal2_p_num,meal3_p_num) values (1,2,3,4,5,6,7);";
        String sql = "insert into nums (date,time,time1,time2,meal1_p_num,meal2_p_num,meal3_p_num) values (?,?,?,?,?,?,?)";
        Object obj[] = {nums.getDate(), nums.getTime1(),nums.getTime2(),nums.getTime3(),nums.getMeal1_p_num(),nums.getMeal2_p_num(), nums.getMeal3_p_num()};
        sqLiteDatabase.execSQL(sql, obj);
//        sqLiteDatabase.execSQL(sql);
        return true;
    }

    public boolean ChangeNums1(Nums nums){ //修改早餐人数
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql = "update nums set time = '"+ nums.getTime1() +"' ,meal1_p_num ='"+nums.getMeal1_p_num()+"' where date ='"+nums.getDate()+"'";
        sqLiteDatabase.execSQL(sql);
        return true;
    }
    public boolean ChangeNums2(Nums nums){//修改午餐人数
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql = "update nums set time1 = '"+ nums.getTime2() +"' ,meal2_p_num ='"+nums.getMeal2_p_num()+"' where date ='"+nums.getDate()+"'";
        sqLiteDatabase.execSQL(sql);
        return true;
    }
    public boolean ChangeNums3(Nums nums){//修改晚餐人数
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql = "update nums set time2 = '"+ nums.getTime3() +"' ,meal3_p_num ='"+nums.getMeal3_p_num()+"' where date ='"+nums.getDate()+"'";
        sqLiteDatabase.execSQL(sql);
        return true;
    }

    public boolean judgeDate(String date){  // 判断日期是否存在,返回bool
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        String sql = "select * from nums where date = ? ";
        Cursor rawQuery = sqLiteDatabase.rawQuery(sql, new String[] { date});
        if (rawQuery.moveToFirst() == true) {
            rawQuery.close();
            return true;
        }
        return false;
    }
    public int[] getNums(String date){  // 根据日期读取数据表，返回传入日期的int数组(早餐人数，午餐人数，晚餐人数)
        int meal1_p_num = 0;
        int meal2_p_num = 0;
        int meal3_p_num = 0;
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        String sql = "select * from nums where date = ? ";
        Cursor rawQuery = sqLiteDatabase.rawQuery(sql, new String[] {date});
        if (rawQuery.moveToFirst()) {
            do {
                meal1_p_num = rawQuery.getInt(rawQuery
                        .getColumnIndex("meal1_p_num"));
                meal2_p_num = rawQuery.getInt(rawQuery
                        .getColumnIndex("meal2_p_num"));
                meal3_p_num = rawQuery.getInt(rawQuery
                        .getColumnIndex("meal3_p_num"));
            } while (rawQuery.moveToNext());
        }
        int[] nu = new int[]{meal1_p_num,meal2_p_num,meal3_p_num};
        Log.e("MEALNUM","m1:"+meal1_p_num+" m2:"+meal2_p_num+" m3:"+meal3_p_num);
        rawQuery.close();
        return  nu;
    }

}
