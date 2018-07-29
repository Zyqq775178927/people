package com.zy.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/28.
 */
public class INVITED implements Serializable {
    private int i_id;
    private T_RECRUITMENT t_recruitment;
    private T_USER t_user;
    private String i_time;
    private int i_state;

    public INVITED() {
    }

    public int getI_id() {
        return i_id;
    }

    public void setI_id(int i_id) {
        this.i_id = i_id;
    }

    public T_RECRUITMENT getT_recruitment() {
        return t_recruitment;
    }

    public void setT_recruitment(T_RECRUITMENT t_recruitment) {
        this.t_recruitment = t_recruitment;
    }

    public T_USER getT_user() {
        return t_user;
    }

    public void setT_user(T_USER t_user) {
        this.t_user = t_user;
    }

    public String getI_time() {
        return i_time;
    }

    public void setI_time(String i_time) {
        this.i_time = i_time;
    }

    public int getI_state() {
        return i_state;
    }

    public void setI_state(int i_state) {
        this.i_state = i_state;
    }

    @Override
    public String toString() {
        return "INVITED{" +
                "i_id=" + i_id +
                ", t_recruitment=" + t_recruitment +
                ", t_user=" + t_user +
                ", i_time='" + i_time + '\'' +
                ", i_state=" + i_state +
                '}';
    }
}
