package com.zy.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/1.
 */
public class TRAIN implements Serializable{
    private int t_id;
    private String t_name;
    private String t_content;
    private String t_starttime;
    private String t_endtime;
    private String t_time;
    private String t_address;
    private int t_state;

    public TRAIN() {
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_content() {
        return t_content;
    }

    public void setT_content(String t_content) {
        this.t_content = t_content;
    }

    public String getT_starttime() {
        return t_starttime;
    }

    public void setT_starttime(String t_starttime) {
        this.t_starttime = t_starttime;
    }

    public String getT_endtime() {
        return t_endtime;
    }

    public void setT_endtime(String t_endtime) {
        this.t_endtime = t_endtime;
    }

    public String getT_time() {
        return t_time;
    }

    public void setT_time(String t_time) {
        this.t_time = t_time;
    }

    public String getT_address() {
        return t_address;
    }

    public void setT_address(String t_address) {
        this.t_address = t_address;
    }

    public int getT_state() {
        return t_state;
    }

    public void setT_state(int t_state) {
        this.t_state = t_state;
    }

    @Override
    public String toString() {
        return "TRAIN{" +
                "t_id=" + t_id +
                ", t_name='" + t_name + '\'' +
                ", t_content='" + t_content + '\'' +
                ", t_starttime='" + t_starttime + '\'' +
                ", t_endtime='" + t_endtime + '\'' +
                ", t_time='" + t_time + '\'' +
                ", t_address='" + t_address + '\'' +
                ", t_state=" + t_state +
                '}';
    }
}
