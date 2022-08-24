package printers;

import recipe.Recipe;
import recipe.RecipeWeek;

import java.time.DayOfWeek;
import java.util.Map;

public class RecipeWeekPrinter {

    public static void printWeek(RecipeWeek recipeWeek) {

        System.out.println("Week " + recipeWeek.getWeekNumber() + " Meal Plan:");
        System.out.println();

        Map<DayOfWeek, Recipe> recipeMap = recipeWeek.getDayRecipeMapping();

        int index = 1;

        for (DayOfWeek day : recipeMap.keySet()) {
            System.out.print("[" + index + "] ");
            System.out.println(day);
            System.out.println(recipeMap.get(day));
            System.out.println();

            index++;
        }
    }
}
