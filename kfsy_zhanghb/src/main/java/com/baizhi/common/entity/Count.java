package com.baizhi.common.entity;

import java.util.Arrays;

public class Count {

    private String [] a;
    private String [] b;

    public Count() {
    }

    public Count(String[] a, String[] b) {
        this.a = a;
        this.b = b;
    }

    public String[] getA() {

        return a;
    }

    public void setA(String[] a) {
        this.a = a;
    }

    public String[] getB() {
        return b;
    }

    public void setB(String[] b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Count{" +
                "a=" + Arrays.toString(a) +
                ", b=" + Arrays.toString(b) +
                '}';
    }
}
