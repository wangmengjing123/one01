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

    private void oneOption(String option) {
        switch (option){
            case "1":
                System.out.println("余额查询");
                doSelectMoney();
                goOneHome();
                break;
            case "2":

                goGetMoneyHome();
                goOneHome();
                break;
            case "3":
                doTruanMoney();
                System.out.println("转账");
                goOneHome();
                break;
            case "4":
                System.out.println("存款");
                doSaveMoney();
                goOneHome();
                break;
            case "5":
                System.out.println("退卡");
                doQuitCard(); 
                goOneHome();
                break;
        }
    }
     // 查询余额
        private void doSelectMoney() {
            double money = currenCustomer.getMoney();
            System.out.println(" 余额是 " +money);
        }
        private void goOneHome(){
            TextUtil.oneLeveOption();
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            System.out.println("option1 = " + option);
            oneOption(option); //递归算法
        }

 
    //存款
        private void doSaveMoney() {
        System.out.println("请输入您的存款金额：");
        Scanner scanner = new Scanner(System.in);
        String moneyIn = scanner.nextLine();
        Double monetInInt = Double.valueOf(moneyIn);
        double newMoney = currenCustomer.getMoney() + monetInInt;
        currenCustomer.setMoney(newMoney);
            System.out.println("您的账户余额是多少" + newMoney);
        
    }
    //转账
    private void doTruanMoney() {
      System.out.println("请输入您要转账的卡号：");
      Scanner scanner = new Scanner(System.in);
      String otherAccout = scanner.nextLine();
        System.out.println("otherAccout = " + otherAccout);
      System.out.println("请输入你转账的金额");
      String otherMoney = scanner.nextLine();
      Double otherMoneyInt = Double.parseDouble(otherMoney);
      double currentMoney = currenCustomer.getMoney()-otherMoneyInt;
       // System.out.println("customerList = " + customerList);
      Customer other = null;
        for (Customer customer : customerList) {
               if (customer.getAccount().equals(otherAccout)){
                       other = customer;
               }
        }
        double otherOneMoney = other.getMoney() +otherMoneyInt;
        currenCustomer.setMoney(currentMoney);
        other.setMoney(otherOneMoney);

    }
    //取款
    private void goGetMoneyHome() {
       TextUtil.getMoneyUI();
       Scanner scanner = new Scanner(System.in);
       String numIn = scanner.nextLine();
       if (numIn.equals("1")){
           double money = currenCustomer.getMoney();
           money = money-100;
           System.out.println("你的余额是："+money);
           currenCustomer.setMoney(money);
       }
    }
    //退卡
    private void doQuitCard(){
        System.out.println("您是否继续退卡yes /no[Y/N]");
         Scanner scanner = new Scanner(System.in);
         String s = scanner.nextLine();
         if(s.equalsIgnoreCase("y")){
                  TextUtil.welcome(); //结束
         }
         if(s.equalsIgnoreCase("n")){

         }
    }



}
