package com.hbk.examples.BuilderDemo.demo_2.entity;

import com.hbk.examples.BuilderDemo.demo_2.Item;
import com.hbk.examples.BuilderDemo.demo_2.Packing;
import com.hbk.examples.BuilderDemo.demo_2.packing_material.Bottle;

public abstract class ColdDrink implements Item {
   @Override
   public Packing packing() {
       return new Bottle();
   }
   @Override
   public abstract float price();
}
