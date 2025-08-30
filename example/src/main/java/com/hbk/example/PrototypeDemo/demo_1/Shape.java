package PrototypeDemo.demo_1;

import lombok.Data; 

@Data
public abstract class Shape implements Cloneable {

    private String id;
    public String type;

    abstract void draw();

    public Object clone() {
        Object clone = null;
        try {
            clone=super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
