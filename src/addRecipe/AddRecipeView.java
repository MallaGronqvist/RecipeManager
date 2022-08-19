package addRecipe;

import dietitianMenu.DietitianMenu;
import recipe.Recipe;
import recipe.RecipeCreator;
import recipe.RecipePool;

public class AddRecipeView {
    AddRecipeView(String instructions){
        System.out.println(instructions);
        Recipe recipe = new Recipe();
        RecipeCreator.enterRecipe(recipe);
        RecipePool.addRecipe(recipe);
        new DietitianMenu();
    }
}
