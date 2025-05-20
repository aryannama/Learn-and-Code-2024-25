package org.designPatterns.ui_library.components.macos;

import org.designPatterns.ui_library.components.TextField;

public class MacOSTextField implements TextField {
    @Override
    public void sendInput() {
        System.out.println("Filling macos UI input");
    }
}
