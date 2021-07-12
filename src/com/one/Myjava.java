package com.one;

public class Myjava {
    public static void main(String[] args) {
        System.out.println("wang");
        String a = "张三";
        System.out.println("a = " + a);
        System.out.println("Myjava.main");
        System.out.println("args = [" + args + "]");

        int age=20;
        if (age < 18) {
            System.out.println("你20了");
        }

        //创建电脑
        Computer c1 = new Computer();
            c1.setPrice(555.0);
            c1.setColor("白色");
            c1.setTypeName("联想");
        System.out.println("c1=" + c1);

    }
}
