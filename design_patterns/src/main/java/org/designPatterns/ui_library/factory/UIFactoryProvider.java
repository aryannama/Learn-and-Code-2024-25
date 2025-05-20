package org.designPatterns.ui_library.factory;

import org.designPatterns.ui_library.constants.OperatingSystem;

public class UIFactoryProvider {
    public static UIFactory getUIFactory(OperatingSystem operatingSystem) {
        switch (operatingSystem) {
            case MACOS:
                return new MacOSUIFactory();
            case WINDOWS:
                return new WindowsUIFactory();
            default:
                throw new IllegalArgumentException("Invalid Operating System");
        }

    }
}
