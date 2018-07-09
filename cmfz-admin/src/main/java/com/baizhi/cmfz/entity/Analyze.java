package com.baizhi.cmfz.entity;

public class Analyze {

    private String name;

    private String value;

    public Analyze() {
    }

    public Analyze(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Analyze{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
