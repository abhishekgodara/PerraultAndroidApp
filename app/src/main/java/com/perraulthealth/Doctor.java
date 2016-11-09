package com.perraulthealth;

/**
 * Created by sutu on 11/9/2016.
 */

public class Doctor {

    public Doctor() {}
/*
    private static Doctor objDoctor;
    public static Doctor getInstane(){

        if(null==objDoctor){
            objDoctor = new Doctor();
        }
        return objDoctor;
    }
*/
    private String name;
    private String regnum;
    private String degree;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegnum() {
        return regnum;
    }

    public void setRegnum(String regnum) {
        this.regnum = regnum;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
