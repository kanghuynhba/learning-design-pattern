package BuilderDemo.demo_2.entity.product;

import BuilderDemo.demo_2.entity.ColdDrink;

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
