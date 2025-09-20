package com.hbk.examples.CommandDemo.demo_2;

import  com.hbk.examples.CommandDemo.demo_2.orders.IOrder;

import java.util.LinkedList;
import java.util.Queue;

public class Waiter {
    private Queue<IOrder> mOrders;
    public Waiter() {
        mOrders=new LinkedList<>();
    }

    public void takeOrder(IOrder order) {
        mOrders.add(order);
    }

    public void processOrders() {
        for(IOrder order:mOrders) {
            order.execute();
        }
        mOrders.clear();
    }
}
