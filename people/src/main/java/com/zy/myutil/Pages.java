package com.zy.myutil;

/**
 * Created by Administrator on 2018/6/23.
 */
public class Pages {
    private static final int PAGES=1;
    public static int getTotalPages(int totalRows){
        return totalRows%PAGES==0?totalRows/PAGES :totalRows/PAGES + 1;
    }
}
