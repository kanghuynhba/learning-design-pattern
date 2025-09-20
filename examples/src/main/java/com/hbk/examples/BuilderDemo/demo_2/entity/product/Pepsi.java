package com.hbk.examples.BuilderDemo.demo_2.entity.product;

import com.hbk.examples.BuilderDemo.demo_2.entity.ColdDrink;

public class Pepsi extends ColdDrink {
   @Override
   public String name() {
      return "Pepsi";  
   }
   @Override
   public float price() {
      return 35.0f;
   }
}
