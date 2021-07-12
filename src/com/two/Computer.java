package com.two;

public class Computer {
    private String name;
    private String typename;
    private String color;
    private String zhuren;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getZhuren() {
        return zhuren;
    }

    public void setZhuren(String zhuren) {
        this.zhuren = zhuren;
    }

    @Override
    public String toString() {
        return "Myjava{" +
                "name='" + name + '\'' +
                ", typename='" + typename + '\'' +
                ", color='" + color + '\'' +
                ", zhuren='" + zhuren + '\'' +
                '}';
    }
}
