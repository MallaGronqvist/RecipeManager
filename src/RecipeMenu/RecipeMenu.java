package RecipeMenu;

public class RecipeMenu {
    public RecipeMenu() {
        RecipeMenuModel model = new RecipeMenuModel();
        RecipeMenuView view = new RecipeMenuView(model.getRecipes());
        RecipeMenuController controller = new RecipeMenuController(model, view);

        controller.readUserInput();
    }
}
