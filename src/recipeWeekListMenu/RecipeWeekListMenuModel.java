package recipeWeekListMenu;

import menus.MenuModel;
import recipe.RecipeWeek;
import recipeWeekMenu.RecipeWeekMenu;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecipeWeekListMenuModel implements MenuModel {
    Map<Integer, RecipeWeek> usersRecipeWeekMap;

    public RecipeWeekListMenuModel(Map<Integer, RecipeWeek> usersRecipeWeekMap) {
        this.usersRecipeWeekMap = usersRecipeWeekMap;
    }

    @Override
    public List<String> getMenuOptions() {
        List<String> weekNumbers = usersRecipeWeekMap.keySet().stream().map(Object::toString).collect(Collectors.toList());
        return weekNumbers;
    }

    public void processOption(int selectedOption) throws NullPointerException {

        if (usersRecipeWeekMap.containsKey(selectedOption)) {
            RecipeWeek recipeWeek = usersRecipeWeekMap.get(selectedOption);
            new RecipeWeekMenu(recipeWeek);
        } else {
            throw new NullPointerException();
        }

    }
}
