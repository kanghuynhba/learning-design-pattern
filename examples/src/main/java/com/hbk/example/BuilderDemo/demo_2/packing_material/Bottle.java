package com.hbk.example.BuilderDemo.demo_2.packing_material;

import com.hbk.example.BuilderDemo.demo_2.Packing;

public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
