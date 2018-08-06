package com.zy.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/5.
 */
public class SAL implements Serializable{
    private int s_id;
    private EMP emp;
    private double s_basesalary;
    private double s_rewards;
    private double s_soctal;
    private String s_time;
    private double s_realsal;

    public SAL() {
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public EMP getEmp() {
        return emp;
    }

    public void setEmp(EMP emp) {
        this.emp = emp;
    }

    public double getS_basesalary() {
        return s_basesalary;
    }

    public void setS_basesalary(double s_basesalary) {
        this.s_basesalary = s_basesalary;
    }

    public double getS_rewards() {
        return s_rewards;
    }

    public void setS_rewards(double s_rewards) {
        this.s_rewards = s_rewards;
    }

    public double getS_soctal() {
        return s_soctal;
    }

    public void setS_soctal(double s_soctal) {
        this.s_soctal = s_soctal;
    }

    public String getS_time() {
        return s_time;
    }

    public void setS_time(String s_time) {
        this.s_time = s_time;
    }

    public double getS_realsal() {
        return s_realsal;
    }

    public void setS_realsal(double s_realsal) {
        this.s_realsal = s_realsal;
    }

    @Override
    public String toString() {
        return "SAL{" +
                "s_id=" + s_id +
                ", emp=" + emp +
                ", s_basesalary=" + s_basesalary +
                ", s_rewards=" + s_rewards +
                ", s_soctal=" + s_soctal +
                ", s_time='" + s_time + '\'' +
                ", s_realsal=" + s_realsal +
                '}';
    }
}
