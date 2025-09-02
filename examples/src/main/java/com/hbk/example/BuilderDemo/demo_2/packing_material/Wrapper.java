package BuilderDemo.demo_2.packing_material;

import BuilderDemo.demo_2.Packing;

public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "Wrapper";
    }
}
