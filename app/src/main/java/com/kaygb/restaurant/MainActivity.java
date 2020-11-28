package com.kaygb.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mDate;
    private EditText mTime1;
    private EditText mTime2;
    private EditText mTime3;
    private EditText mNum1;
    private EditText mNum2;
    private EditText mNum3;
    private Button mBtnAdd;
    private String today = "1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDate = findViewById(R.id.editdate);
        mTime1 = findViewById(R.id.edittime1);
        mTime2 = findViewById(R.id.edittime2);
        mTime3 = findViewById(R.id.edittime3);
        mNum1 = findViewById(R.id.editnum1);
        mNum2 = findViewById(R.id.editnum2);
        mNum3 = findViewById(R.id.editnum3);
        mBtnAdd = findViewById(R.id.btn_add);
        mBtnAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String date = mDate.getText().toString().trim();
                String time1 = mTime1.getText().toString().trim();
                String time2 = mTime2.getText().toString().trim();
                String time3 = mTime3.getText().toString().trim();
//                int num1 = (int)mTime1.getText().toString().trim();
//                String num2 = mTime2.getText().toString().trim();
//                String num3 = mTime3.getText().toString().trim();
                int num1 = Integer.parseInt(mNum1.getText().toString().trim());
                int num2 = Integer.parseInt(mNum2.getText().toString().trim());
                int num3 = Integer.parseInt(mNum3.getText().toString().trim());

                Log.e("NUM1",num1+"");
                Log.e("DATE",date+"");

                Nums nums = new Nums();
                nums.setDate(date);
                nums.setTime1(time1);
                nums.setTime2(time2);
                nums.setTime3(time3);
                nums.setMeal1_p_num(num1);
                nums.setMeal2_p_num(num2);
                nums.setMeal3_p_num(num3);

                NumsService numsService =new NumsService(getBaseContext());
                if(numsService.judgeDate(date)){
                    Log.e("DATE",date+"日期相等，升级操作");
                    numsService.ChangeNums1(nums);
                    numsService.ChangeNums2(nums);
                    numsService.ChangeNums3(nums);

                }else {
                    boolean flag = numsService.SetNums(nums);
                    if (flag) {
                        Toast.makeText(MainActivity.this, "写入成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "写入失败", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }
}