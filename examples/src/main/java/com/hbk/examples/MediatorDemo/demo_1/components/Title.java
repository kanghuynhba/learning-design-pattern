package com.hbk.examples.MediatorDemo.demo_1.components;

import com.hbk.examples.MediatorDemo.demo_1.mediator.Mediator;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Title extends JTextField implements Component {
    private Mediator mediator;

    public Title() {}

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator=mediator;
    }

    @Override 
    protected void processComponentKeyEvent(KeyEvent keyEvent) {
        mediator.markNote();
    }

    @Override
    public String getName() {
        return "Title";
    }
}
