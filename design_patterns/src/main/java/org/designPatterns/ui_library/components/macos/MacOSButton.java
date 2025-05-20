package org.designPatterns.ui_library.components.macos;

import org.designPatterns.ui_library.components.Button;

public class MacOSButton implements Button {
    @Override
    public void click() {
        System.out.println("Clicking macos UI button");
    }
}
