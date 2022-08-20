package mainMenu;

import menus.MenuView;
import printers.PrintHandler;

import java.util.List;

public class MainMenuView extends MenuView {
    public MainMenuView(List<String> menuOptions) {
        PrintHandler.clearConsole();
        PrintHandler.appTitle();
        System.out.println("Choose a user type:");
        PrintHandler.optionList(menuOptions);
        super.requestUserInput();
    }
}
