package recipeWeekMenu;

import menuCommons.MenuView;
import printers.MenuPrinter;
import printers.RecipeWeekPrinter;
import recipe.RecipeWeek;

public class RecipeWeekMenuView extends MenuView {
    public RecipeWeekMenuView(RecipeWeek recipeWeek) {

        MenuPrinter.clearConsole();
        RecipeWeekPrinter.printWeek(recipeWeek);
        requestUserInput();
    }
}
