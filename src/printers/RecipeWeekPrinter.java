package printers;

import recipe.Recipe;
import recipe.RecipeWeek;

import java.time.LocalDate;
import java.util.Map;

public class RecipeWeekPrinter {

    public static void printWeek(Map<LocalDate, Recipe> recipeMap){
        for (LocalDate date:
                recipeMap.keySet()) {
            System.out.println("date from recipeweek:");
            System.out.println(date.getDayOfWeek());
            System.out.println(recipeMap.get(date));
        }

        System.out.println("Today's recipe:");
        LocalDate today = LocalDate.now();

        RecipePrinter.printRecipe(recipeMap.get(today));
    }
}
