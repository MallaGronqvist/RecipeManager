package recipeEditor;

import menus.MenuView;
import printers.MenuPrinter;
import printers.RecipePrinter;
import recipe.Recipe;

import java.util.List;

public class RecipeEditorView extends MenuView {
    public RecipeEditorView(Recipe recipe, List<String>options) {
        MenuPrinter.clearConsole();
        System.out.println("Editing recipe:");
        System.out.println();
        RecipePrinter.printRecipe(recipe);
        System.out.println();
        System.out.println("Available operations:");
        MenuPrinter.listOptions(options);
        super.requestUserInput();
    }
}
