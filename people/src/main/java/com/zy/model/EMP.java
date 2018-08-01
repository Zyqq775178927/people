package com.zy.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/30.
 */
public class EMP implements Serializable{
    private int e_id;
    private T_POSITON t_positon;
    private String e_name;
    private String e_pass;
    private String e_username;
    private String e_age;
    private String e_phone;
    private String e_address;
    private String e_emain;
    private int e_state;
    private T_DEPARTMENT t_department;
    private String e_time;
    public EMP() {
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public T_POSITON getT_positon() {
        return t_positon;
    }

    public void setT_positon(T_POSITON t_positon) {
        this.t_positon = t_positon;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_pass() {
        return e_pass;
    }

    public void setE_pass(String e_pass) {
        this.e_pass = e_pass;
    }

    public String getE_username() {
        return e_username;
    }

    public void setE_username(String e_username) {
        this.e_username = e_username;
    }

    public String getE_age() {
        return e_age;
    }

    public void setE_age(String e_age) {
        this.e_age = e_age;
    }

    public String getE_phone() {
        return e_phone;
    }

    public void setE_phone(String e_phone) {
        this.e_phone = e_phone;
    }

    public String getE_address() {
        return e_address;
    }

    public void setE_address(String e_address) {
        this.e_address = e_address;
    }

    public String getE_emain() {
        return e_emain;
    }

    public void setE_emain(String e_emain) {
        this.e_emain = e_emain;
    }

    public int getE_state() {
        return e_state;
    }

    public void setE_state(int e_state) {
        this.e_state = e_state;
    }

    public T_DEPARTMENT getT_department() {
        return t_department;
    }

    public void setT_department(T_DEPARTMENT t_department) {
        this.t_department = t_department;
    }

    public String getE_time() {
        return e_time;
    }

    public void setE_time(String e_time) {
        this.e_time = e_time;
    }

    @Override
    public String toString() {
        return "EMP{" +
                "e_id=" + e_id +
                ", t_positon=" + t_positon +
                ", e_name='" + e_name + '\'' +
                ", e_pass='" + e_pass + '\'' +
                ", e_username='" + e_username + '\'' +
                ", e_age='" + e_age + '\'' +
                ", e_phone='" + e_phone + '\'' +
                ", e_address='" + e_address + '\'' +
                ", e_emain='" + e_emain + '\'' +
                ", e_state=" + e_state +
                ", t_department=" + t_department +
                ", e_time='" + e_time + '\'' +
                '}';
    }
}
