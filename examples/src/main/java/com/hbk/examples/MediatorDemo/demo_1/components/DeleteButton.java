package com.hbk.examples.MediatorDemo.demo_1.components;

// import com.hbk.examples.MediatorDemo.demo_1.mediator.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeleteButton extends JButton implements Component {
    // private Mediator mediator;

    public DeleteButton() {
        super("Del");
    }

    @Override 
    protected void fireActionPerformed(ActionEvent event) {

    }

    // @Override
    // void setMediator(Mediator mediator) {
    //     this.mediator=mediator;
    // }

    @Override
    public String getName() {
        return "DelButton";
    }
}
