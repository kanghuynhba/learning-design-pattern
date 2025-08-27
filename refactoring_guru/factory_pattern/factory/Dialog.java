package refactoring_guru.factory_pattern.factory;

import refactoring_guru.factory_pattern.buttons.Button;

public abstract class Dialog {
    public void renderWindow() {
        Button okButton=createButton();
        okButton.render();
    }
    public abstract Button createButton();
}
