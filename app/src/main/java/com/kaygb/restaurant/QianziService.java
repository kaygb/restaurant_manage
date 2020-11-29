package com.kaygb.restaurant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class QianziService {

    /*
    * 需根据日期确定是否当前是否是同一天的签字情况，写入日期相同的同一行数据
    * 需要先setQdate
    * */

    private DbHelper dbHelper;
    public QianziService(Context context){
        dbHelper = new DbHelper(context);
    }

    public boolean initQianzi(Qianzi qianzi){       // 初始化签字表，创建今日签字行,签字前调用
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql = "insert into qianzi (qdate) values (?)";
        Object obj[] = {qianzi.getQdate()};
        sqLiteDatabase.execSQL(sql, obj);
        return  true;
    }

    public boolean addQyijian(Qianzi qianzi){  // 意见签字路径
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql =
                "update qianzi set qyijian = '"+ qianzi.getQyijian()+"' where date ='"+qianzi.getQdate()+"'";
        sqLiteDatabase.execSQL(sql);

        return true;

    }
    public boolean addZhuguanqz(Qianzi qianzi){  // 主管签字，qianzi.getQzhuguan()应为路径
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql =
                "update qianzi set qzhuguan = '"+ qianzi.getQzhuguan()+"' where date ='"+qianzi.getQdate()+"'";
        sqLiteDatabase.execSQL(sql);

        return true;

    }
    public boolean addQqingkuang(Qianzi qianzi){  // 帮厨情况
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql =
                "update qianzi set qqingkuang = '"+ qianzi.getQqingkuang()+"' where date ='"+qianzi.getQdate()+
                        "'";
        sqLiteDatabase.execSQL(sql);

        return true;

    }
    public boolean addQsiwuzhang(Qianzi qianzi){  // 写入司务长签字图片路径
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql =
                "update qianzi set qsiwuzhang = '"+ qianzi.getQsiwuzhang()+"' where date ='"+qianzi.getQdate()+
                        "'";
        sqLiteDatabase.execSQL(sql);

        return true;

    }
    public boolean addQcsbz(Qianzi qianzi){  // 写入炊事班长签字路径
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql =
                "update qianzi set qcsbz = '"+ qianzi.getQcsbz()+"' where date ='"+qianzi.getQdate()+
                        "'";
        sqLiteDatabase.execSQL(sql);

        return true;

    }
    public boolean addQzby(Qianzi qianzi){ // 值班长签字路径
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql =
                "update qianzi set qzby = '"+ qianzi.getQzby()+"' where date ='"+qianzi.getQdate()+
                        "'";
        sqLiteDatabase.execSQL(sql);

        return true;
    }
}
