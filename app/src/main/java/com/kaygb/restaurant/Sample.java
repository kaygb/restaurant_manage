package com.kaygb.restaurant;

public class Sample {  // 留样表
    private int sid;
    private String sdate;
    private String sname;
    private String sname_p;
    private String smeal;

    public int getSid() {
        return sid;
    }

    public String getSdate() {
        return sdate;
    }

    public String getSmeal() {
        return smeal;
    }

    public String getSname() {
        return sname;
    }

    public String getSname_p() {
        return sname_p;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setSmeal(String smeal) {
        this.smeal = smeal;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSname_p(String sname_p) {
        this.sname_p = sname_p;
    }
}
