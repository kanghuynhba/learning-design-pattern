package com.hbk.example.BuilderDemo.demo_2.entity;

import com.hbk.example.BuilderDemo.demo_2.Item;
import com.hbk.example.BuilderDemo.demo_2.Packing;
import com.hbk.example.BuilderDemo.demo_2.packing_material.Bottle;

public abstract class ColdDrink implements Item {
   @Override
   public Packing packing() {
       return new Bottle();
   }
   @Override
   public abstract float price();
}
