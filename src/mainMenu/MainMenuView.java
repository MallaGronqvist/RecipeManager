package mainMenu;

import menus.MenuView;
import printers.MenuPrinter;

import java.util.List;

public class MainMenuView extends MenuView {
    public MainMenuView(List<String> menuOptions) {
        MenuPrinter.clearConsole();
        System.out.println("Welcome to Recipe Manager!");
        System.out.println();
        System.out.println("Choose a user type:");
        MenuPrinter.optionList(menuOptions);
        super.requestUserInput();
    }
}
