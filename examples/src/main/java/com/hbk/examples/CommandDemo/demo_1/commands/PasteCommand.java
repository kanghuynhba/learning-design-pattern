package com.hbk.examples.CommandDemo.demo_1.commands;

import com.hbk.examples.CommandDemo.demo_1.editor.Editor;

public class PasteCommand extends Command {
    public PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if(editor.clipboard==null || editor.clipboard.isEmpty()) {
            return false;
        }
        backup();
        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
        return true;
    }
} 
