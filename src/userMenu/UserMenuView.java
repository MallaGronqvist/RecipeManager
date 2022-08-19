package userMenu;


import menus.MenuView;
import printers.PrintHandler;

import java.util.List;

public class UserMenuView extends MenuView {
    public UserMenuView(List<String> menuOptions){
        PrintHandler.clearConsole();
        System.out.println("Choose an operation:");
        PrintHandler.optionList(menuOptions);
        super.requestUserInput();
    }
}
