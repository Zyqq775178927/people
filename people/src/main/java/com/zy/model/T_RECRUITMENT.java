package com.zy.model;

/**
 * Created by Administrator on 2018/7/26.
 */
public class T_RECRUITMENT {
    private int re_id;
    private int re_pid;
    private String re_sal;
    private String re_address;
    private String re_phone;
    private int re_state;
    private String re_need;
    private String re_time;

    public T_RECRUITMENT() {
    }

    public int getRe_id() {
        return re_id;
    }

    public void setRe_id(int re_id) {
        this.re_id = re_id;
    }

    public int getRe_pid() {
        return re_pid;
    }

    public void setRe_pid(int re_pid) {
        this.re_pid = re_pid;
    }

    public String getRe_sal() {
        return re_sal;
    }

    public void setRe_sal(String re_sal) {
        this.re_sal = re_sal;
    }

    public String getRe_address() {
        return re_address;
    }

    public void setRe_address(String re_address) {
        this.re_address = re_address;
    }

    public String getRe_phone() {
        return re_phone;
    }

    public void setRe_phone(String re_phone) {
        this.re_phone = re_phone;
    }

    public int getRe_state() {
        return re_state;
    }

    public void setRe_state(int re_state) {
        this.re_state = re_state;
    }

    public String getRe_need() {
        return re_need;
    }

    public void setRe_need(String re_need) {
        this.re_need = re_need;
    }

    public String getRe_time() {
        return re_time;
    }

    public void setRe_time(String re_time) {
        this.re_time = re_time;
    }

    @Override
    public String toString() {
        return "T_RECRUITMENT{" +
                "re_id=" + re_id +
                ", re_pid=" + re_pid +
                ", re_sal='" + re_sal + '\'' +
                ", re_address='" + re_address + '\'' +
                ", re_phone='" + re_phone + '\'' +
                ", re_state=" + re_state +
                ", re_need='" + re_need + '\'' +
                ", re_time='" + re_time + '\'' +
                '}';
    }
}
