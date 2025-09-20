package com.hbk.examples.BuilderDemo.demo_2.packing_material;

import com.hbk.examples.BuilderDemo.demo_2.Packing;

public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "Wrapper";
    }
}
