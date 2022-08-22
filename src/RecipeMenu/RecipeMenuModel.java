package RecipeMenu;

import menus.MenuModel;
import printers.RecipePrinter;
import recipe.Recipe;
import recipe.RecipePool;


import java.util.ArrayList;
import java.util.List;

public class RecipeMenuModel implements MenuModel {
    RecipePool recipePool;

    public RecipeMenuModel(RecipePool recipePool) {
        this.recipePool = recipePool;
    }

    @Override
    public List<String> getMenuOptions() {
        List<String>recipeTitles = new ArrayList<>();

        // Make this a stream trick?
        for (Recipe recipe: recipePool.getAllRecipes()) {
            String title = recipe.getTitle();
            recipeTitles.add(title);
        }
        return recipeTitles;
    }

    public void processOption(int selectedOption) throws IndexOutOfBoundsException {
        Recipe recipe = recipePool.getRecipe(selectedOption);
        RecipePrinter.printRecipe(recipe);
        RecipePrinter.waitForEnter();
    }

    public List<Recipe> getRecipes() {
       return RecipePool.getAllRecipes();
    }
}
