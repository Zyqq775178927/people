package com.zy.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/3.
 */
public class ATTENDANCE implements Serializable{
    private int a_id;
    private EMP emp;
    private String a_starttime;
    private String a_endtime;
    private String a_data;
    private int a_state;

    public ATTENDANCE() {
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public EMP getEmp() {
        return emp;
    }

    public void setEmp(EMP emp) {
        this.emp = emp;
    }

    public String getA_starttime() {
        return a_starttime;
    }

    public void setA_starttime(String a_starttime) {
        this.a_starttime = a_starttime;
    }

    public String getA_endtime() {
        return a_endtime;
    }

    public void setA_endtime(String a_endtime) {
        this.a_endtime = a_endtime;
    }

    public String getA_data() {
        return a_data;
    }

    public void setA_data(String a_data) {
        this.a_data = a_data;
    }

    public int getA_state() {
        return a_state;
    }

    public void setA_state(int a_state) {
        this.a_state = a_state;
    }

    @Override
    public String toString() {
        return "ATTENDANCE{" +
                "a_id=" + a_id +
                ", emp=" + emp +
                ", a_starttime='" + a_starttime + '\'' +
                ", a_endtime='" + a_endtime + '\'' +
                ", a_data='" + a_data + '\'' +
                ", a_state=" + a_state +
                '}';
    }
}
