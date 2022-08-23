package recipeWeekListMenu;

import menus.MenuModel;
import printers.RecipePrinter;
import recipe.RecipeWeek;
import recipeWeekMenu.RecipeWeekMenu;

import java.util.List;
import java.util.Map;

public class RecipeWeekListMenuModel {
    Map<Integer, RecipeWeek> usersRecipeWeekMap;

    public RecipeWeekListMenuModel(Map<Integer, RecipeWeek> usersRecipeWeekMap) {
        this.usersRecipeWeekMap = usersRecipeWeekMap;
    }

    public Map<Integer, RecipeWeek> getUsersRecipeWeekMap() {
        return usersRecipeWeekMap;
    }

    public void processOption(int selectedOption) throws NullPointerException {

        new RecipeWeekMenu(usersRecipeWeekMap.get(selectedOption));
    }
}
