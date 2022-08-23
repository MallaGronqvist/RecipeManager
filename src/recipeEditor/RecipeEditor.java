package recipeEditor;

import menus.MenuController;
import recipe.Recipe;

public class RecipeEditor {
    public RecipeEditor(Recipe recipe) {
        RecipeEditorModel model = new RecipeEditorModel(recipe);
        RecipeEditorView view = new RecipeEditorView(model.getRecipe(), model.getMenuOptions());
        MenuController controller = new MenuController(model, view);

        controller.readUserInput();
    }
}
