package com.hbk.examples.MediatorDemo.demo_1.mediator;

import com.hbk.examples.MediatorDemo.demo_1.components.*;
import com.hbk.examples.MediatorDemo.demo_1.components.List;
import com.hbk.examples.MediatorDemo.demo_1.components.Component;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Editor implements Mediator {
    private AddButton add;
    private DeleteButton del;
    private SaveButton save;
    private Title title;
    private Filter filter;
    private TextBox textBox;
    private List list;

    private JLabel titleLabel=new JLabel("Title: ");
    private JLabel textLabel=new JLabel("Text: ");
    private JLabel label=new JLabel("Add or select existing note to proceed...");

    @Override
    public void registerComponent(Component component) {
        component.setMediator(this);
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
            case "Filter":
                filter=(Filter) component;
                break;
            case "List":
                list=(List) component;
                this.list.addListSelectionListener(listSelectionEvent -> {
                    Note note=(Note)list.getSelectedValue();
                    if(note!=null) {
                        getInfoFromList(note);
                    } else {
                        clear();
                    }
                });
                break;
            }
    }

    @Override
    public void addNewNote(Note note) {
        title.setText("");
        textBox.setText("");
        list.addElement(note);
    }

    @Override
    public void deleteNote() {
        list.deleteElement();
    }

    @Override
    public void getInfoFromList(Note note) {
        title.setText(note.getName().replace('*', ' '));        
        textBox.setText(note.getText());
    } 

    @Override
    public void saveChanges() { 
        try {
            Note note=(Note) list.getSelectedValue();
            note.setName(title.getText());
            note.setText(textBox.getText());
            list.repaint();
        } catch (NullPointerException ignored) {}
    
    }

    @Override
    public void markNote() {
        try {
            Note note=list.getCurrentElement();
            String name=note.getName();
            if(!name.endsWith("*")) {
                note.setName(note.getName()+ "*");
            }
            list.repaint();
        } catch (NullPointerException ignored) {}
    }

    @Override
    public void clear() {
        title.setText("");
        textBox.setText("");
    }

    @Override
    public void sendToFilter(ListModel listModel) {
        filter.setList(listModel); 
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setElementsList(ListModel list) {
        this.list.setModel(list);    
        this.list.repaint();
    }

    @Override
    public void hideElements(boolean flag) {
        titleLabel.setVisible(!flag);
        textLabel.setVisible(!flag);
        title.setVisible(!flag);
        textBox.setVisible(!flag);
        save.setVisible(!flag);
        label.setVisible(!flag);
    }

    @Override
    public void createGUI() {
        Font labelFont=new Font("Arial", Font.PLAIN, 40);
        Font buttonFont=new Font("Arial", Font.PLAIN, 32);
        Font textFieldFont=new Font("Arial", Font.PLAIN, 32);
        Font textAreaFont=new Font("Arial", Font.PLAIN, 42);
        Font listFont=new Font("Arial", Font.PLAIN, 42);
        UIManager.put("Label.font", labelFont);
        UIManager.put("Button.font", buttonFont);
        UIManager.put("TextField.font", textFieldFont);
        UIManager.put("TextArea.font", textAreaFont);
        UIManager.put("List.font", listFont);


        JFrame notes=new JFrame("Notes");
        notes.setSize(2880, 1800);
        notes.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel content=new JPanel(new BorderLayout());
        notes.setContentPane(content);

        JPanel left=new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setSize(960, 1800);
        left.setBorder(new LineBorder(Color.BLACK));

        // filterPanel
        JPanel filterPanel=new JPanel();
        filterPanel.setPreferredSize(new Dimension(840, 120));
        filterPanel.add(new JLabel("Filter"));
        filterPanel.add(filter);
        filter.setPreferredSize(new Dimension(640, 50));
        
        left.add(filterPanel);

        // listPanel
        JPanel listPanel=new JPanel();
        list.setFixedCellWidth(520);
        listPanel.setSize(640, 910);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(640, 910));
        listPanel.add(scrollPane);
        left.add(listPanel);

        // leftButtonPanel
        JPanel leftButtonPanel=new JPanel(new FlowLayout());
        add.setPreferredSize(new Dimension(150, 65));
        del.setPreferredSize(new Dimension(150, 65));
        leftButtonPanel.add(add); 
        leftButtonPanel.add(del); 
        left.add(leftButtonPanel);

        JPanel right=new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setSize(1920, 1800);
        right.setBorder(new LineBorder(Color.BLACK));

        // titlePanel
        JPanel titlePanel=new JPanel(new FlowLayout());
        titlePanel.add(titleLabel);
        titlePanel.add(title);
        title.setPreferredSize(new Dimension(1600, 50));
        right.add(titlePanel);
        
        // notePanel
        textBox.setBorder(new LineBorder(Color.DARK_GRAY));
        textBox.setBounds(20, 80, 595, 410);
        right.add(textLabel);
        right.add(textBox);

        // rightButtonPanel
        JPanel rightButtonPanel=new JPanel(new FlowLayout());
        save.setPreferredSize(new Dimension(150, 65));
        rightButtonPanel.add(save);
        right.add(rightButtonPanel);
        
        // notes.setLayout(null);
        content.add(left, BorderLayout.WEST);
        content.add(right, BorderLayout.CENTER);
        notes.setLocationRelativeTo(null);
        notes.setVisible(true);

        // Refresh UI
        SwingUtilities.updateComponentTreeUI(notes);
    }


}
