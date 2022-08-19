package mainMenu;

import printers.PrintHandler;

import java.util.List;

public class MainMenuView {
    public MainMenuView(List<String> menuOptions) {
        PrintHandler.clearConsole();
        PrintHandler.appTitle();
        System.out.println("Choose a user type:");
        PrintHandler.optionList(menuOptions);
        requestUserInput();
    }

    public void printInvalidOption() {
        System.out.println("Invalid option");
    }

    public void requestUserInput() {
        System.out.print("Enter your choice and press enter: ");
    }
}
