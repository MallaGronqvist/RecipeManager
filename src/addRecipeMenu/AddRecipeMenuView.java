package addRecipeMenu;

import dieticianMenu.DieticianMenu;
import mainMenu.MainMenu;
import mainMenu.MainMenuModel;
import utils.Recipe;
import utils.RecipeHandler;
import utils.RecipePool;

public class AddRecipeMenuView {
    AddRecipeMenuView(String instructions){
        System.out.println(instructions);
        Recipe recipe = new Recipe();
        RecipeHandler.enterRecipe(recipe);
        RecipePool.addRecipe(recipe);
        new DieticianMenu();
    }
}
