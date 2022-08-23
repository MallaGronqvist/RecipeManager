package recipeWeekListMenu;

import menus.MenuView;
import printers.MenuPrinter;
import recipe.RecipeWeek;

import java.util.Map;

public class RecipeWeekListMenuView extends MenuView {
    public RecipeWeekListMenuView(Map<Integer, RecipeWeek> usersRecipeWeekMap) {
        MenuPrinter.clearConsole();

            for (Integer weekNumber: usersRecipeWeekMap.keySet()) {
                System.out.println("[" + weekNumber + "] " + "Week " + weekNumber);
            }

            super.requestUserInput();

    }
}
