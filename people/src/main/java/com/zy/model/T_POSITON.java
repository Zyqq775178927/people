package com.zy.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/28.
 */
public class T_POSITON implements Serializable {
    private int p_id;
    private String p_name;
    private double p_sal;
    private int p_state;
    private T_DEPARTMENT t_department;

    public T_POSITON() {
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public double getP_sal() {
        return p_sal;
    }

    public void setP_sal(double p_sal) {
        this.p_sal = p_sal;
    }

    public int getP_state() {
        return p_state;
    }

    public void setP_state(int p_state) {
        this.p_state = p_state;
    }

    public T_DEPARTMENT getT_department() {
        return t_department;
    }

    public void setT_department(T_DEPARTMENT t_department) {
        this.t_department = t_department;
    }

    @Override
    public String toString() {
        return "T_POSITON{" +
                "p_id=" + p_id +
                ", p_name='" + p_name + '\'' +
                ", p_sal=" + p_sal +
                ", p_state=" + p_state +
                ", t_department=" + t_department +
                '}';
    }
}
