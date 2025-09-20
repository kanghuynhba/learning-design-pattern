package com.hbk.examples.CommandDemo.demo_2;

public class Cook {
    private int mTimeCook;
    public Cook() {
        this(10);
    }
    public Cook(int time) {
        this.mTimeCook=time;
    }
    
    public void boil() {
        System.out.println("Boil in " + mTimeCook);
    }

    public void grill() {
        System.out.println("Grill in " + mTimeCook);
    }
}
