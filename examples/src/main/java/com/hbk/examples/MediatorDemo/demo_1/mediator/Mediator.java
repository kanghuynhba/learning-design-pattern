package com.hbk.examples.MediatorDemo.demo_1.mediator;

import com.hbk.examples.MediatorDemo.demo_1.components.Component;

import javax.swing.*;

public interface Mediator {
    // void addNewNote(Note note)
    // void sendToFilter(ListModel listModel);
    void registerComponent(Component component);
    void createGUI();
}
