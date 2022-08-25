package RecipeMenu;

import menuCommons.MenuController;
import recipe.RecipePool;

public class RecipeMenu {
    public RecipeMenu(RecipePool recipePool, String mode) {

        RecipeMenuModel model = new RecipeMenuModel(recipePool, mode);
        RecipeMenuView view = new RecipeMenuView(model.getMenuOptions());
        MenuController controller = new MenuController(model, view);

        controller.readUserInput();
    }
}
