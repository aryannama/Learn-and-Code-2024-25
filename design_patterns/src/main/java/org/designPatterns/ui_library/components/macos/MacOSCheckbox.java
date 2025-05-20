package org.designPatterns.ui_library.components.macos;

import org.designPatterns.ui_library.components.Checkbox;

public class MacOSCheckbox implements Checkbox {
    @Override
    public void check() {
        System.out.println("Checking macos UI checkbox");
    }
}
