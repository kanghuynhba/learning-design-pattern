package com.hbk.example.BuilderDemo.demo_2.entity.product;

import com.hbk.example.BuilderDemo.demo_2.entity.ColdDrink;

public class Coke extends ColdDrink {
   @Override
   public String name() {
      return "Coke";  
   }
   @Override
   public float price() {
      return 30.0f;
   }
}
