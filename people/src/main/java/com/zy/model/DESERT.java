package com.zy.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/3.
 */
public class DESERT implements Serializable{
    private int de_id;
    private EMP emp;
    private double de_money;
    private String de_intro;
    private String de_time;
    private int de_state;

    public DESERT() {
    }

    public DESERT(EMP emp, double de_money, String de_intro, String de_time, int de_state) {
        this.emp = emp;
        this.de_money = de_money;
        this.de_intro = de_intro;
        this.de_time = de_time;
        this.de_state = de_state;
    }

    public int getDe_id() {
        return de_id;
    }

    public void setDe_id(int de_id) {
        this.de_id = de_id;
    }

    public EMP getEmp() {
        return emp;
    }

    public void setEmp(EMP emp) {
        this.emp = emp;
    }

    public double getDe_money() {
        return de_money;
    }

    public void setDe_money(double de_money) {
        this.de_money = de_money;
    }

    public String getDe_intro() {
        return de_intro;
    }

    public void setDe_intro(String de_intro) {
        this.de_intro = de_intro;
    }

    public String getDe_time() {
        return de_time;
    }

    public void setDe_time(String de_time) {
        this.de_time = de_time;
    }

    public int getDe_state() {
        return de_state;
    }

    public void setDe_state(int de_state) {
        this.de_state = de_state;
    }

    @Override
    public String toString() {
        return "DESERT{" +
                "de_id=" + de_id +
                ", emp=" + emp +
                ", de_money=" + de_money +
                ", de_intro='" + de_intro + '\'' +
                ", de_time='" + de_time + '\'' +
                ", de_state=" + de_state +
                '}';
    }
}
