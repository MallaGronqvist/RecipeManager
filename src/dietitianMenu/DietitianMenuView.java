package dietitianMenu;

import menus.MenuView;
import printers.PrintHandler;

import java.awt.*;
import java.util.List;

public class DietitianMenuView extends MenuView {
    public DietitianMenuView(List<String> menuOptions){
        PrintHandler.optionList(menuOptions);
        super.requestUserInput();
    }
}
