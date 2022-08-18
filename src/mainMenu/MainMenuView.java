package mainMenu;

import utils.PrintHandler;

import java.util.List;

public class MainMenuView {
    public MainMenuView(List<String> menuOptions) {
        PrintHandler.clearScreen();
        PrintHandler.appTitle();
        System.out.println("Main menu options:");
        PrintHandler.optionList(menuOptions);
        requestUserInput();
    }

    public void printInvalidOption() {
        System.out.println("Invalid option");
    }

    public void requestUserInput() {
        System.out.print("Choose an option and press enter: ");
    }
}
