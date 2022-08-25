package recipeEditorMenu;

import menuCommons.MenuController;
import recipe.Recipe;

public class RecipeEditorMenu {
    public RecipeEditorMenu(Recipe recipe) {
        RecipeEditorMenuModel model = new RecipeEditorMenuModel(recipe);
        RecipeEditorMenuView view = new RecipeEditorMenuView(model.getRecipe(), model.getMenuOptions());
        MenuController controller = new MenuController(model, view);

        controller.readUserInput();
    }
}
