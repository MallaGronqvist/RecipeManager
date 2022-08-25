package userMenu;


import menuCommons.MenuView;
import printers.MenuPrinter;

import java.util.List;

public class UserMenuView extends MenuView {
    public UserMenuView(List<String> menuOptions) {

        System.out.println("Choose an operation:");
        MenuPrinter.listOptions(menuOptions);
        requestUserInput();
    }
}
