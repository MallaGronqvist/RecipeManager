package printers;

import recipe.Recipe;
import recipe.RecipeWeek;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class RecipeWeekPrinter {

    public static void printWeek(RecipeWeek recipeWeek){

        System.out.println("Week " + recipeWeek.getWeekId() + " Meal Plan:");

        Map<LocalDate, Recipe> recipeMap = recipeWeek.getDayRecipeMapping();

        for (LocalDate date:
                recipeMap.keySet()) {
            System.out.println("date from recipeweek:");
            System.out.println(date.getDayOfWeek());
            System.out.println(recipeMap.get(date));
        }

    }
}
