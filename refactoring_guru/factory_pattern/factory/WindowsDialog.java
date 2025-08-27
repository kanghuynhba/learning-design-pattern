package refactoring_guru.factory_pattern.factory;

import refactoring_guru.factory_pattern.buttons.Button;
import refactoring_guru.factory_pattern.buttons.WindowsButton;

public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}


