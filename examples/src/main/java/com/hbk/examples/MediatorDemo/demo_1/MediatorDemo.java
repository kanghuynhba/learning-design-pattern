package com.hbk.examples.MediatorDemo.demo_1;

import com.hbk.examples.MediatorDemo.demo_1.components.*;
import com.hbk.examples.MediatorDemo.demo_1.mediator.*;

public class MediatorDemo {
    public static void main(String []args) {
        Mediator mediator=new Editor();
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.createGUI();
    }
}
