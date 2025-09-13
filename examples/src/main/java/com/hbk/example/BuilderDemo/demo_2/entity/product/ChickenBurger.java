package com.hbk.example.BuilderDemo.demo_2.entity.product;

import com.hbk.example.BuilderDemo.demo_2.entity.Burger;

public class ChickenBurger extends Burger {
   @Override
   public String name() {
      return "Chicken Burger";  
   }
   @Override
   public float price() {
      return 50.5f;
   }
}
