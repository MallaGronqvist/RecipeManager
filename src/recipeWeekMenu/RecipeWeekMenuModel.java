package recipeWeekMenu;

import menus.MenuModel;
import printers.RecipePrinter;
import recipe.Recipe;
import recipe.RecipeWeek;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class RecipeWeekMenuModel {

    RecipeWeek recipeWeek;

    public RecipeWeekMenuModel(RecipeWeek recipeWeek) {
        this.recipeWeek = recipeWeek;
    }

    public void processOption(String input) {
        Recipe requestedRecipe = new Recipe();
        switch (input){
            case "t" -> requestedRecipe = recipeWeek.getRecipeByDay(LocalDate.now().getDayOfWeek());
            case "1" -> requestedRecipe = recipeWeek.getRecipeByDay(DayOfWeek.MONDAY);
            case "2" -> requestedRecipe = recipeWeek.getRecipeByDay(DayOfWeek.TUESDAY);
            case "3" -> requestedRecipe = recipeWeek.getRecipeByDay(DayOfWeek.WEDNESDAY);
            case "4" -> requestedRecipe = recipeWeek.getRecipeByDay(DayOfWeek.THURSDAY);
            case "5" -> requestedRecipe = recipeWeek.getRecipeByDay(DayOfWeek.FRIDAY);
            case "6" -> requestedRecipe = recipeWeek.getRecipeByDay(DayOfWeek.SATURDAY);
            case "7" -> requestedRecipe = recipeWeek.getRecipeByDay(DayOfWeek.SUNDAY);
        }

        RecipePrinter.printRecipe(requestedRecipe);
    }

    public RecipeWeek getRecipeWeek() {
        return recipeWeek;
    }
    
    public boolean isCurrentRecipeWeek(){
        LocalDate today = LocalDate.now();

        int currentWeekOfYear = today.get(WeekFields.of(Locale.GERMANY).weekOfYear());
        
        return recipeWeek.getWeekNumber() == currentWeekOfYear;
    }
}
