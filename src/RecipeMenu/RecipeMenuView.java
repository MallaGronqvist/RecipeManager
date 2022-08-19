package RecipeMenu;

import printers.PrintHandler;
import recipe.Recipe;

import java.util.List;

public class RecipeMenuView {

    public RecipeMenuView(List<Recipe> recipes) {
        PrintHandler.clearConsole();
        System.out.println("Available recipes:");
        PrintHandler.optionList(recipes);
        requestUserInput();
    }

    public void printInvalidOption() {
        System.out.println("Invalid option");
    }

    public void requestUserInput() {
        System.out.print("Enter your choice and press enter: ");
    }
}
