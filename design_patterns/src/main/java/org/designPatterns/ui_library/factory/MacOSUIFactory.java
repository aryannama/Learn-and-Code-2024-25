package org.designPatterns.ui_library.factory;

import org.designPatterns.ui_library.components.Button;
import org.designPatterns.ui_library.components.Checkbox;
import org.designPatterns.ui_library.components.TextField;
import org.designPatterns.ui_library.components.macos.MacOSButton;
import org.designPatterns.ui_library.components.macos.MacOSCheckbox;
import org.designPatterns.ui_library.components.macos.MacOSTextField;

public class MacOSUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }

    @Override
    public TextField createTextField() {
        return new MacOSTextField();
    }
}
