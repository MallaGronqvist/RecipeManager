package recipeWeekMenu;

import menuCommons.MenuController;
import recipe.RecipeWeek;

public class RecipeWeekMenu {

    public RecipeWeekMenu(RecipeWeek recipeWeek) {

        RecipeWeekMenuModel model = new RecipeWeekMenuModel(recipeWeek);
        RecipeWeekMenuView view = new RecipeWeekMenuView(model.getRecipeWeek());
        MenuController controller = new MenuController(model, view);

        controller.readUserInput();
    }


}
