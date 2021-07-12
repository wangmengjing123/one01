package com.util;

public class TextUtil {
    public static void welcome(){
        System.out.println("*****************");
        System.out.println("欢迎使用ATM取款机");
        System.out.println("*****************");
    }
    //客户的一级选择
    public static void oneLeveOption(){
        System.out.println("******************************************");
        System.out.println("************请输入你想要的操作************");
        System.out.println("********1.余额查询          2.取款*********");
        System.out.println("********3.转账              4.存款*********");
        System.out.println("********5.退卡                    *********");
        System.out.println("*******************************************");
    }

//static 方法带有static关键字的方法是静态方法 可以直接 类名.方法名 调用
    public static  void getMoneyUI(){
        System.out.println("************************************************");
        System.out.println("********请输入您想取款的数目：*********");
        System.out.println("********1.100           2.200 *********");
        System.out.println("********3.300           4.500 *********");
        System.out.println("********5.800           6.1000*********");
        System.out.println("********7.2000          8.其他*********");
        System.out.println("************************************************");
    }

}
