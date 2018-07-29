package com.zy.model;

/**
 * Created by Administrator on 2018/7/26.
 */
public class R_R {
    private int r_id;
    private T_RESUME t_resume;
    private T_RECRUITMENT t_recruitment;
    private int r_state;
    private String r_time;
    private String r_time2;
    public R_R() {
    }

    public String getR_time() {
        return r_time;
    }

    public void setR_time(String r_time) {
        this.r_time = r_time;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public T_RESUME getT_resume() {
        return t_resume;
    }

    public void setT_resume(T_RESUME t_resume) {
        this.t_resume = t_resume;
    }

    public T_RECRUITMENT getT_recruitment() {
        return t_recruitment;
    }

    public void setT_recruitment(T_RECRUITMENT t_recruitment) {
        this.t_recruitment = t_recruitment;
    }

    public int getR_state() {
        return r_state;
    }

    public void setR_state(int r_state) {
        this.r_state = r_state;
    }

    public String getR_time2() {
        return r_time2;
    }

    public void setR_time2(String r_time2) {
        this.r_time2 = r_time2;
    }

    @Override
    public String toString() {
        return "R_R{" +
                "r_id=" + r_id +
                ", t_resume=" + t_resume +
                ", t_recruitment=" + t_recruitment +
                ", r_state=" + r_state +
                ", r_time='" + r_time + '\'' +
                ", r_time2='" + r_time2 + '\'' +
                '}';
    }
}
