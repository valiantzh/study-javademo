package com.study.basis.designpattern.command.ch2;

/**
 * 创建一个请求类- 股票交易执行类:买入,卖出
 * @author valiantzh
 * @version 1.0
 */
public class Stock {
    private String name = "ABC";
    private int quantity = 10;
    public Stock(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }
    public void buy(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
    }
    public void sell(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
    }
}
