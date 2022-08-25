package recipeWeekMenu;

import menuCommons.MenuModel;
import printers.RecipePrinter;
import recipe.Recipe;
import recipe.RecipeWeek;

import java.time.DayOfWeek;
import java.util.List;

public class RecipeWeekMenuModel implements MenuModel {

    RecipeWeek recipeWeek;

    public RecipeWeekMenuModel(RecipeWeek recipeWeek) {
        this.recipeWeek = recipeWeek;
    }


    public RecipeWeek getRecipeWeek() {
        return recipeWeek;
    }

    // This is here only for the sake of implementing MenuModel -interface.
    @Override
    public List<String> getMenuOptions() {
        return null;
    }

    public void processOption(int input) {
        Recipe requestedRecipe;

        switch (input) {
            case 1 -> requestedRecipe = recipeWeek.getRecipeByDay(DayOfWeek.MONDAY);
            case 2 -> requestedRecipe = recipeWeek.getRecipeByDay(DayOfWeek.TUESDAY);
            case 3 -> requestedRecipe = recipeWeek.getRecipeByDay(DayOfWeek.WEDNESDAY);
            case 4 -> requestedRecipe = recipeWeek.getRecipeByDay(DayOfWeek.THURSDAY);
            case 5 -> requestedRecipe = recipeWeek.getRecipeByDay(DayOfWeek.FRIDAY);
            case 6 -> requestedRecipe = recipeWeek.getRecipeByDay(DayOfWeek.SATURDAY);
            case 7 -> requestedRecipe = recipeWeek.getRecipeByDay(DayOfWeek.SUNDAY);
            default -> throw new IndexOutOfBoundsException();
        }

        RecipePrinter.printRecipe(requestedRecipe);
    }
}
