package recipeEditorMenu.elementDeleter;

import menuCommons.MenuController;
import recipe.Recipe;

public class ElementDeleter {
    public ElementDeleter(Recipe recipe, String elementType) {

        ElementDeleterModel model = new ElementDeleterModel(recipe, elementType);
        ElementDeleterView view = new ElementDeleterView(model.getMenuOptions());
        MenuController controller = new MenuController(model, view);

        controller.readUserInput();
    }
}
