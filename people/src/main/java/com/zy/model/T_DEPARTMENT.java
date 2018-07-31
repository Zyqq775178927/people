package com.zy.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/28.
 */
public class T_DEPARTMENT implements Serializable {
    private int d_id;
    private String d_name;
    private String d_time;
    public T_DEPARTMENT() {
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_time() {
        return d_time;
    }

    public void setD_time(String d_time) {
        this.d_time = d_time;
    }

    @Override
    public String toString() {
        return "T_DEPARTMENT{" +
                "d_id=" + d_id +
                ", d_name='" + d_name + '\'' +
                ", d_time='" + d_time + '\'' +
                '}';
    }
}
