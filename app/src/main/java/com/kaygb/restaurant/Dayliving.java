package com.kaygb.restaurant;

public class Dayliving { //每日生活水平表
    private int lid;
    private String ldate;
    private String lcate;
    private char lvalue;

    public int getLid() {
        return lid;
    }

    public char getLvalue() {
        return lvalue;
    }

    public String getLcate() {
        return lcate;
    }

    public String getLdate() {
        return ldate;
    }

    public void setLcate(String lcate) {
        this.lcate = lcate;
    }

    public void setLdate(String ldate) {
        this.ldate = ldate;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public void setLvalue(char lvalue) {
        this.lvalue = lvalue;
    }
}
