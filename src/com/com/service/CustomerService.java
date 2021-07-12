package com.com.service;

import com.bean.Customer;
import com.bean.CustomerData;
import com.sun.istack.internal.NotNull;
import com.util.TextUtil;

import java.util.List;
import java.util.Scanner;

//完成客户的所有业务（增删改查）
public class CustomerService {
    //CustomerData customerData = CustomerData.getInstance();
    // List<Customer> customerList = customerData.getCustomerList();
    //1.查，登录 判断账户是否正确
    private List<Customer> customerList;
    private Customer currenCustomer;
    public void checkPwd(String cardid,String cardPwd){
        CustomerData customerData = CustomerData.getInstance();
        customerList = customerData.getCustomerList();
        //1.拿到cardid中用户名和cardPwd 对 list数据作对比
        System.out.println("cardid = " + cardid);
        System.out.println("cardPwd = " + cardPwd);

        for (Customer customer : customerList){
            if (customer.getAccount().equals(cardid) || customer.getPassword().equals(cardPwd)) {
                currenCustomer = customer;
                //账户正确
                System.out.println("欢迎" + customer.getCname() + "顾客登录！请注意安全");
                TextUtil.oneLeveOption();
                Scanner scanner = new Scanner(System.in);
                String option = scanner.nextLine();
                oneOption(option);
                //如何 保证 135 让她再次回到次页面
            }
        }
    }

    private void oneOption(@NotNull String option) {
        switch (option){
            case "1":
                System.out.println("余额查询");
                doSelectMoney();
                goOneHome();
                break;
            case "2":
                System.out.println("取款");
                withdrawMoney();
                goOneHome();
                break;
            case "3":
                System.out.println("转账");
                Money();
                goOneHome();
                break;
            case "4":
                System.out.println("存款");
                saveMoney();
                goOneHome();
                break;
            case "5":
                System.out.println("退卡");
                System.exit(0);
                goOneHome();
                break;
        }
    }
    //存款
    private void saveMoney() {
        System.out.println("请输入您的存款金额：");
        Scanner input = new Scanner(System.in);
        int money = input.nextInt();
        if (currenCustomer!=null){
            if (money>0){
                currenCustomer.setMoney(currenCustomer.getMoney()+money);
                System.out.println("存款成功");
                System.out.println("你的当前余额为："+currenCustomer.getMoney());
            }else{
                System.out.println("输入错误");
            }

        }
    }
    //转账
    private void Money() {
        System.out.println("请输入您要转账的卡号：");
        Scanner account = new Scanner(System.in);
        int money = account.nextInt();
        Customer nuser = null;
        boolean IsExit = false;
    }
    //取款
    private void withdrawMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的取款金额：");
        int money = sc.nextInt();
        if (money>0&&money<=currenCustomer.getMoney()){
            currenCustomer.setMoney(currenCustomer.getMoney()-money);
            System.out.println("取款成功");
            System.out.println("你的当前余额为："+currenCustomer.getMoney());
        }else {
            System.out.println("输入错误");
        }
    }

    //查余额
    private void doSelectMoney() {
    double money = currenCustomer.getMoney();
        System.out.println("余额是"+money);
    }

    private void goOneHome(){
        //oneOption(option);
        TextUtil.oneLeveOption();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        System.out.println("option1 = " + option);
        oneOption(option);
    }
}
