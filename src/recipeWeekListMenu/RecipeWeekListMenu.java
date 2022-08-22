package recipeWeekListMenu;

import recipe.RecipeWeek;

import java.util.Map;

public class RecipeWeekListMenu {
    public RecipeWeekListMenu(Map<Integer, RecipeWeek> usersRecipeWeekMap) {
        RecipeWeekListMenuModel model = new RecipeWeekListMenuModel(usersRecipeWeekMap);
        RecipeWeekListMenuView view = new RecipeWeekListMenuView(model.getUsersRecipeWeekMap());
        RecipeWeekListMenuController controller = new RecipeWeekListMenuController(model, view);

        controller.readUserInput();
    }
}
