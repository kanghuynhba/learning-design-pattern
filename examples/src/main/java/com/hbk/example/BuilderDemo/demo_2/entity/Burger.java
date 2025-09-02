package BuilderDemo.demo_2.entity;

import BuilderDemo.demo_2.Item;
import BuilderDemo.demo_2.Packing;
import BuilderDemo.demo_2.packing_material.Wrapper;

public abstract class Burger implements Item {
   @Override
   public Packing packing() {
       return new Wrapper();
   }
   @Override
   public abstract float price();
}
