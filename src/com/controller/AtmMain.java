package com.controller;

import com.bean.Customer;
import com.bean.CustomerData;
import com.com.service.CustomerService;
import com.util.TextUtil;

import java.util.List;
import java.util.Scanner;

public class AtmMain {

    private static String cardid;
    private static String cardPwd;
    private static CustomerService customerService;

    public static void main(String[] args){
        customerService = new CustomerService();
        //测试客户类数据
        //CustomerData customerData = CustomerData.getInstance();
        //List<Customer> customerList = customerData.getCustomerList();
        /*for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }*/

        //是一个阶段
        TextUtil.welcome();


        int i =0;
        while(i<6){
            //输入密码账户 一个阶段
            doWritePassword();
            //其他操作  校验身份  判断账户密码正确性
            doCheckPassword(cardid,cardPwd);
            i++;
        }

    }
    //判断角色和判断密码
    private static void doCheckPassword(String cardid,String cardPwd) {
        //1.先校验角色，判断cardid 的长度
        if (cardid.length()==8) { //客户
            //校验密码
            customerService.checkPwd(cardid,cardPwd);
        }
    }

    //输入账户名
    private static void doWritePassword() {
        System.out.println("请输入卡号");
        Scanner scanner = new Scanner(System.in);
        cardid = scanner.nextLine();
        System.out.println("cardid = " + cardid);
        System.out.println("请输入密码");
        cardPwd = scanner.nextLine();
        System.out.println("cardPwd = " + cardPwd);
    }


}
