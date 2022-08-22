package printers;

import recipe.Recipe;
import recipe.RecipeWeek;

import java.time.DayOfWeek;
import java.util.Map;

public class RecipeWeekPrinter {

    public static void printWeek(RecipeWeek recipeWeek){

        System.out.println("Week " + recipeWeek.getWeekNumber() + " Meal Plan:");

        Map<DayOfWeek, Recipe> recipeMap = recipeWeek.getDayRecipeMapping();

        for (DayOfWeek day:
                recipeMap.keySet()) {
            System.out.println("Day from recipe week:");
            System.out.println(day);
            System.out.println(recipeMap.get(day));
        }

    }
}
