package com.hbk.examples.PrototypeDemo.demo_1;

public class Square extends Shape {

    public Square() {
        type="Square";
    }


    @Override 
    public void draw() {
        System.out.println("Square's draw method");
    }
}
