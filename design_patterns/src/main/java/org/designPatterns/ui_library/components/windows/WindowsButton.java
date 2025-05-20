package org.designPatterns.ui_library.components.windows;

import org.designPatterns.ui_library.components.Button;

public class WindowsButton implements Button {

    @Override
    public void click() {
        System.out.println("Clicking windows UI button");
    }
}
