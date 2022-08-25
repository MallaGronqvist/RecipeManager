package recipeWeekListMenu;

import menuCommons.MenuController;
import recipe.RecipeWeek;

import java.util.Map;

public class RecipeWeekListMenu {
    public RecipeWeekListMenu(Map<Integer, RecipeWeek> usersRecipeWeekMap) {

        RecipeWeekListMenuModel model = new RecipeWeekListMenuModel(usersRecipeWeekMap);
        RecipeWeekListMenuView view = new RecipeWeekListMenuView(model.getMenuOptions());
        MenuController controller = new MenuController(model, view);

        controller.readUserInput();
    }
}
