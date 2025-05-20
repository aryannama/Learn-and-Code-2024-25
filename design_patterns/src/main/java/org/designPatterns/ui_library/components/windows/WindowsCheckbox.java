package org.designPatterns.ui_library.components.windows;

import org.designPatterns.ui_library.components.Checkbox;

public class WindowsCheckbox implements Checkbox {

    @Override
    public void check() {
        System.out.println("Checking windows UI checkbox");
    }
}
