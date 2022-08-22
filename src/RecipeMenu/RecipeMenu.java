package RecipeMenu;

import menus.MenuController;
import recipe.RecipePool;

public class RecipeMenu {
    public RecipeMenu(RecipePool recipePool) {
        RecipeMenuModel model = new RecipeMenuModel(recipePool);
        RecipeMenuView view = new RecipeMenuView(model.getMenuOptions());
        MenuController controller = new MenuController(model, view);

        controller.readUserInput();
    }
}
