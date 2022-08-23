package RecipeMenu;

import menus.MenuView;
import printers.MenuPrinter;
import recipe.Recipe;

import java.util.List;

public class RecipeMenuView extends MenuView {

    public RecipeMenuView(List<String> recipes) {
        MenuPrinter.clearConsole();
        System.out.println("Available recipes:");
        MenuPrinter.optionList(recipes);
        super.requestUserInput();
    }
}
