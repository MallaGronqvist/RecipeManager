package addRecipeMenu;

import dieticianMenu.DieticianMenu;
import utils.Recipe;
import utils.RecipeCreator;
import utils.RecipeFileHandler;
import utils.RecipePool;

public class AddRecipeMenuView {
    AddRecipeMenuView(String instructions){
        System.out.println(instructions);
        Recipe recipe = new Recipe();
        RecipeCreator.enterRecipe(recipe);
        RecipePool.addRecipe(recipe);
        new DieticianMenu();
    }
}
