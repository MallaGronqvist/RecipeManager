package recipeMenu;

import menuCommons.MenuView;
import printers.MenuPrinter;

import java.util.List;

public class RecipeMenuView extends MenuView {

    public RecipeMenuView(List<String> recipes) {
        MenuPrinter.clearConsole();
        System.out.println("Available recipes:");
        MenuPrinter.listOptions(recipes);
        requestUserInput();
    }
}
