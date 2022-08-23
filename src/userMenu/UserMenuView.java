package userMenu;


import menus.MenuView;
import printers.MenuPrinter;

import java.util.List;

public class UserMenuView extends MenuView {
    public UserMenuView(List<String> menuOptions){
        MenuPrinter.clearConsole();
        System.out.println("Choose an operation:");
        MenuPrinter.optionList(menuOptions);
        super.requestUserInput();
    }
}
