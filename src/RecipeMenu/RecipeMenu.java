package RecipeMenu;

import menus.MenuController;

public class RecipeMenu {
    public RecipeMenu() {
        RecipeMenuModel model = new RecipeMenuModel();
        RecipeMenuView view = new RecipeMenuView(model.getMenuOptions());
        MenuController controller = new MenuController(model, view);

        controller.readUserInput();
    }
}
