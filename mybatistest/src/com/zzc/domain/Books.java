package com.zzc.domain;

public class Books {
    private int uid;
    private String name;
    private Double sal;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Books{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                '}';
    }
}
