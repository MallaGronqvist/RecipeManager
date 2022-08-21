package recipeWeekMenu;

import menus.MenuView;
import printers.PrintHandler;
import printers.RecipeWeekPrinter;
import recipe.RecipeWeek;

public class RecipeWeekMenuView extends MenuView {
    public RecipeWeekMenuView(RecipeWeek recipeWeek) {
        PrintHandler.clearConsole();
        RecipeWeekPrinter.printWeek(recipeWeek);
        requestUserInput();
    }

    @Override
    public void requestUserInput() {
        System.out.print("Enter 't' to see the recipe of today. ");
        System.out.println("Or enter number of the recipe:");
    }
}
