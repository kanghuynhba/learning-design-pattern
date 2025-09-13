package com.hbk.example.CommandDemo.demo_2.orders;

import com.hbk.example.CommandDemo.demo_2.Cook;

public class GrillOrder implements IOrder {
    private Cook mCook;
    public GrillOrder(Cook cook) {
        this.mCook=cook;
    }

    public void execute() {
        mCook.grill();
    }
}
