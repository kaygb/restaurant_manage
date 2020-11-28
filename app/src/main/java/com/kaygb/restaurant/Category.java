package com.kaygb.restaurant;

public class Category {
    private int cid;
    private String cate_name;
    private String cate_slug;

    public int getCid() {
        return cid;
    }

    public String getCate_name() {
        return cate_name;
    }

    public String getCate_slug() {
        return cate_slug;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public void setCate_slug(String cate_slug) {
        this.cate_slug = cate_slug;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
