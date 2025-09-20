package com.hbk.examples.CommandDemo.demo_2.orders;

import com.hbk.examples.CommandDemo.demo_2.Cook;

public class SoupOrder implements IOrder {
    private Cook mCook;
    public SoupOrder(Cook cook) {
        this.mCook=cook;
    }

    public void execute() {
        mCook.boil();
    }
}
