package org.designPatterns.ui_library.factory;

import org.designPatterns.ui_library.components.Button;
import org.designPatterns.ui_library.components.Checkbox;
import org.designPatterns.ui_library.components.TextField;
import org.designPatterns.ui_library.components.windows.WindowsButton;
import org.designPatterns.ui_library.components.windows.WindowsCheckbox;
import org.designPatterns.ui_library.components.windows.WindowsTextField;

public class WindowsUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }

    @Override
    public TextField createTextField() {
        return new WindowsTextField();
    }
}
