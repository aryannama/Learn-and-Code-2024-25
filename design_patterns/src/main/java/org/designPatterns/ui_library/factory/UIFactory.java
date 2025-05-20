package org.designPatterns.ui_library.factory;

import org.designPatterns.ui_library.components.Button;
import org.designPatterns.ui_library.components.Checkbox;
import org.designPatterns.ui_library.components.TextField;

public interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
    TextField createTextField();
}
