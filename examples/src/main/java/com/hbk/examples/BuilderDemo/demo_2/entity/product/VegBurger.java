package com.hbk.examples.BuilderDemo.demo_2.entity.product;

import com.hbk.examples.BuilderDemo.demo_2.entity.Burger;

public class VegBurger extends Burger {
   @Override
   public String name() {
      return "Veg Burger";  
   }
   @Override
   public float price() {
      return 25.0f;
   }
}

