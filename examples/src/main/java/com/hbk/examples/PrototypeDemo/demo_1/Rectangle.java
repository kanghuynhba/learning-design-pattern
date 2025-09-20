package com.hbk.examples.PrototypeDemo.demo_1;

public class Rectangle extends Shape {
    
    public Rectangle() {
        type="Rectangle";
    }

    @Override 
    public void draw() {
        System.out.println("Rectangle's draw method");
    }
}
