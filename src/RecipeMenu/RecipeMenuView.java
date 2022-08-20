package RecipeMenu;

import menus.MenuView;
import printers.PrintHandler;
import recipe.Recipe;

import java.util.List;

public class RecipeMenuView extends MenuView {

    public RecipeMenuView(List<String> recipes) {
        PrintHandler.clearConsole();
        System.out.println("Available recipes:");
        PrintHandler.optionList(recipes);
        super.requestUserInput();
    }
}
