package RecipeMenu;

import printers.RecipePrinter;
import recipe.Recipe;
import recipe.RecipePool;
import userRoles.Dietitian;
import userRoles.User;

import java.util.List;

public class RecipeMenuModel {

    public void processOption(int selectedOption) throws IndexOutOfBoundsException {
        Recipe recipe = RecipePool.getRecipe(selectedOption);
        RecipePrinter.printRecipe(recipe);
    }

    public List<Recipe> getRecipes() {
       return RecipePool.getAllRecipes();
    }
}
