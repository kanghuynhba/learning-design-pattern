package BuilderDemo.demo_2.entity.product;

import BuilderDemo.demo_2.entity.Burger;

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

