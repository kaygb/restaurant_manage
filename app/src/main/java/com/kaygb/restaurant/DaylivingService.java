package com.kaygb.restaurant;

import android.content.Context;

public class DaylivingService {
    private DbHelper dbHelper;

    public DaylivingService(Context context) {
        dbHelper = new DbHelper(context);
    }
    

}
