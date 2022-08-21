package recipeWeekMenu;

import recipe.RecipeWeek;

public class RecipeWeekMenu {

    public RecipeWeekMenu(RecipeWeek recipeWeek) {
        RecipeWeekMenuModel model = new RecipeWeekMenuModel(recipeWeek);
        RecipeWeekMenuView view = new RecipeWeekMenuView(model.getRecipeWeek());
        RecipeWeekMenuController controller = new RecipeWeekMenuController(model, view);

        controller.readUserInput();
    }


}
