package dietitianMenu;

import menus.MenuView;
import printers.MenuPrinter;

import java.util.List;

public class DietitianMenuView extends MenuView {
    public DietitianMenuView(List<String> menuOptions){
        MenuPrinter.clearConsole();
        System.out.println("Choose an operation:");
        MenuPrinter.optionList(menuOptions);
        super.requestUserInput();
    }
}
