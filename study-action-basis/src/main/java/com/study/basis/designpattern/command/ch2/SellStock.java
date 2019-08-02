package com.study.basis.designpattern.command.ch2;

/**
 * 创建实现了 Order 接口的实体类。交易指令-卖出
 * @author valiantzh
 * @version 1.0
 */
public class SellStock implements Order{
    private Stock abcStock;
    public SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }
    @Override
    public void execute() {
        abcStock.sell();
    }
}
