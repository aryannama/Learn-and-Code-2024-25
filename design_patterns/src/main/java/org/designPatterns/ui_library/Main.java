package org.designPatterns.ui_library;

import org.designPatterns.ui_library.components.Button;
import org.designPatterns.ui_library.components.Checkbox;
import org.designPatterns.ui_library.components.TextField;
import org.designPatterns.ui_library.constants.OperatingSystem;
import org.designPatterns.ui_library.factory.UIFactory;
import org.designPatterns.ui_library.factory.UIFactoryProvider;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the operating system:");
        OperatingSystem operatingSystem = OperatingSystem.valueOf(scanner.nextLine().trim().toUpperCase());

        UIFactory uiFactory = UIFactoryProvider.getUIFactory(operatingSystem);

        Button button = uiFactory.createButton();
        Checkbox checkbox = uiFactory.createCheckbox();
        TextField textField = uiFactory.createTextField();

        button.click();
        checkbox.check();
        textField.sendInput();

        scanner.close();
    }
}

