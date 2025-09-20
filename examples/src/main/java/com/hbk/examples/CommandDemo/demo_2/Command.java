package com.hbk.examples.CommandDemo.demo_2;

import com.hbk.examples.CommandDemo.demo_2.orders.*;

public class Command {
    public static void main(String []args) {
        SoupOrder soupOrder=new SoupOrder(new Cook(100));
        GrillOrder grillOrder=new GrillOrder(new Cook(200));

        Waiter waiter=new Waiter();
        waiter.takeOrder(soupOrder);
        waiter.takeOrder(grillOrder);

        waiter.processOrders();
    }
}
