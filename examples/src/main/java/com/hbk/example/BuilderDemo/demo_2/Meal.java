package BuilderDemo.demo_2;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> items=new ArrayList<Item>();
    public void addItem(Item item) {
        items.add(item);
    }
    public float getCost() {
        float total=0.0f;
        for(int i=0; i<items.size(); i++) {
            total+=items.get(i).price();
        }
        return total;
    }
    public void showItems() {
        for(int i=0; i<items.size(); i++) {
            Item item=items.get(i);
            System.out.println("Item: " + item.name());
            System.out.println(", Packing: " + item.packing().pack());
            System.out.println(", Price: " + item.price());
        }
    }
}

