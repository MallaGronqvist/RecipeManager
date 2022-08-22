package printers;

import recipe.Recipe;
import recipe.RecipeWeek;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class RecipeWeekPrinter {

    public static void printWeek(RecipeWeek recipeWeek){

        System.out.println("Week " + recipeWeek.getWeekId() + " Meal Plan:");

        Map<DayOfWeek, Recipe> recipeMap = recipeWeek.getDayRecipeMapping();

        for (DayOfWeek day:
                recipeMap.keySet()) {
            System.out.println("Day from recipe week:");
            System.out.println(day);
            System.out.println(recipeMap.get(day));
        }

    }
}
