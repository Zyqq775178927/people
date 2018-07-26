package com.zy.model;

/**
 * Created by Administrator on 2018/7/26.
 */
public class R_R {
    private int r_id;
    private int r_rbid;
    private int r_reid;
    private int r_state;

    public R_R() {
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public int getR_rbid() {
        return r_rbid;
    }

    public void setR_rbid(int r_rbid) {
        this.r_rbid = r_rbid;
    }

    public int getR_reid() {
        return r_reid;
    }

    public void setR_reid(int r_reid) {
        this.r_reid = r_reid;
    }

    public int getR_state() {
        return r_state;
    }

    public void setR_state(int r_state) {
        this.r_state = r_state;
    }

    @Override
    public String toString() {
        return "R_R{" +
                "r_id=" + r_id +
                ", r_rbid=" + r_rbid +
                ", r_reid=" + r_reid +
                ", r_state=" + r_state +
                '}';
    }
}
