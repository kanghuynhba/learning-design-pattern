package BuilderDemo.demo_2.entity;

import BuilderDemo.demo_2.Item;
import BuilderDemo.demo_2.Packing;
import BuilderDemo.demo_2.packing_material.Bottle;

public abstract class ColdDrink implements Item {
   @Override
   public Packing packing() {
       return new Bottle();
   }
   @Override
   public abstract float price();
}
