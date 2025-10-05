package com.hbk.examples.MediatorDemo.demo_1.mediator;

import com.hbk.examples.MediatorDemo.demo_1.components.*;
import com.hbk.examples.MediatorDemo.demo_1.components.Component;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Editor implements Mediator {
    // title, textBox, add, del, save, list, filter 
    private AddButton add;
    private DeleteButton del;
    private SaveButton save;
    private Title title;
    private TextBox textBox;

    private JLabel filterLabel=new JLabel("Filter: ");
    private JLabel titleLabel=new JLabel("Title: ");
    private JLabel textLabel=new JLabel("Text: ");
    private JLabel label=new JLabel("Add or select existing note to proceed...");

    @Override
    public void registerComponent(Component component) {
        switch(component.getName()) {
            case "AddButton":
                add=(AddButton) component;
                break;
            case "DelButton":
                del=(DeleteButton) component;
                break;
            case "SaveButton":
                save=(SaveButton) component;
                break;
            case "Title":
                title=(Title) component;
                break;
            case "TextBox":
                textBox=(TextBox) component;
                break;
            }
    }

    @Override
    public void createGUI() {
        Font labelFont=new Font("Arial", Font.PLAIN, 40);
        Font buttonFont=new Font("Arial", Font.PLAIN, 32);
        Font textFieldFont=new Font("Arial", Font.PLAIN, 32);
        UIManager.put("Label.font", labelFont);
        UIManager.put("Button.font", buttonFont);
        UIManager.put("TextField.font", buttonFont);


        JFrame notes=new JFrame("Notes");
        notes.setSize(2880, 1800);
        notes.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel left=new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setSize(960, 1800);
        left.setBorder(new LineBorder(Color.BLACK));

        // filterPanel
        JPanel filterPanel=new JPanel();
        filterPanel.setPreferredSize(new Dimension(840, 120));
        filterPanel.add(filterLabel);

        // listPanel
        JPanel listPanel=new JPanel();

        // leftButtonPanel
        JPanel leftButtonPanel=new JPanel(new FlowLayout());
        add.setPreferredSize(new Dimension(150, 65));
        del.setPreferredSize(new Dimension(150, 65));
        leftButtonPanel.add(add); 
        leftButtonPanel.add(del); 

        left.add(filterPanel);
        left.add(leftButtonPanel);

        JPanel right=new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setSize(1920, 1800);
        right.setLocation(960, 0);
        right.setBorder(new LineBorder(Color.BLACK));

        // titlePanel
        JPanel titlePanel=new JPanel(new FlowLayout());
        title.setPreferredSize(new Dimension(1600, 50));
        titlePanel.add(titleLabel);
        titlePanel.add(title);
        
        // notePanel
        JPanel notePanel=new JPanel();
        notePanel.setLayout(new BoxLayout(notePanel, BoxLayout.Y_AXIS));
        textBox.setColumns(10);
        notePanel.add(textLabel);
        notePanel.add(textBox);

        // rightButtonPanel
        JPanel rightButtonPanel=new JPanel(new FlowLayout());
        save.setPreferredSize(new Dimension(150, 65));
        rightButtonPanel.add(save);
        
        right.add(titlePanel);
        right.add(notePanel);
        right.add(rightButtonPanel);
         
        notes.setLayout(null);
        notes.getContentPane().add(left);
        notes.getContentPane().add(right);
        //notes.setResizable(false);
        notes.setLocationRelativeTo(null);
        notes.setVisible(true);

        // Refresh UI
        SwingUtilities.updateComponentTreeUI(notes);
    }
}
