package com.zy.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/1.
 */
public class EMP_TRAIN implements Serializable{
    private int mt_id;
    private EMP emp;
    private TRAIN train;

    public EMP_TRAIN() {
    }

    public int getMt_id() {
        return mt_id;
    }

    public void setMt_id(int mt_id) {
        this.mt_id = mt_id;
    }

    public EMP getEmp() {
        return emp;
    }

    public void setEmp(EMP emp) {
        this.emp = emp;
    }

    public TRAIN getTrain() {
        return train;
    }

    public void setTrain(TRAIN train) {
        this.train = train;
    }

    @Override
    public String toString() {
        return "EMP_TRAIN{" +
                "mt_id=" + mt_id +
                ", emp=" + emp +
                ", train=" + train +
                '}';
    }
}
