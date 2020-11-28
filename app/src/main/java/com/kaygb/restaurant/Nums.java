package com.kaygb.restaurant;

public class Nums {

    private int id; //id
    private String date; //日期
    private String time1; // 时间
    private String time2; // 时间
    private String time3; // 时间
    private int meal1_p_num; // 早中晚人数
    private int meal2_p_num;
    private int meal3_p_num;

    public int getId() {  //获取id
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//    设置日期时间和早中晚人数
//    获取日期时间和早中晚人数
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getTime3() {
        return time3;
    }

    public void setTime3(String time3) {
        this.time3 = time3;
    }

    public int getMeal1_p_num() {
        return meal1_p_num;
    }
    public void setMeal1_p_num(int meal1_p_num) {
        this.meal1_p_num = meal1_p_num;
    }

    public int getMeal2_p_num() {
        return meal2_p_num;
    }

    public void setMeal2_p_num(int meal2_p_num) {
        this.meal2_p_num = meal2_p_num;
    }

    public int getMeal3_p_num() {
        return meal3_p_num;
    }

    public void setMeal3_p_num(int meal3_p_num) {
        this.meal3_p_num = meal3_p_num;
    }


}
