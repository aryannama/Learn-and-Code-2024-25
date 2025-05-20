package org.designPatterns.ui_library.components.windows;

import org.designPatterns.ui_library.components.TextField;

public class WindowsTextField implements TextField {
    @Override
    public void sendInput() {
        System.out.println("Filling Windows UI input");
    }
}
