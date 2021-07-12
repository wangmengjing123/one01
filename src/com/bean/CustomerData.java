package com.bean;

import java.util.ArrayList;
import java.util.List;
//使用单例模式把客户初始化了
public class CustomerData {
    private static CustomerData ourInstance = new CustomerData();
    private List<Customer> customerList;

    public static CustomerData getInstance() {
        return ourInstance;
    }

    private CustomerData() {
        //在构造中 初始化 数据
        customerList = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            //每循环一次就诞生1哥customer对象
            Customer customer = new Customer();
            customer.setAccount("5201314"+i);
            customer.setPassword("123");
            customer.setCname("张三"+i+"号");
            customer.setMoney(10000.0);
            customer.setPhoneNum("123456"+i);
            customerList.add(customer);
        }
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
