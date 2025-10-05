package com.hbk.examples.MediatorDemo.demo_1.components;

// import com.hbk.examples.MediatorDemo.demo_1.mediator.Mediator;

import javax.swing.*;

public class TextBox extends JTextArea implements Component {
    // private Mediator mediator;

    public TextBox() {}

    // @Override
    // void setMediator(Mediator mediator) {
    //     this.mediator=mediator;
    // }

    @Override
    public String getName() {
        return "TextBox";
    }
}
