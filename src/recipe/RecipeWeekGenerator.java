package recipe;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.Collectors;


public class RecipeWeekGenerator {

    public static RecipeWeek generateRecipeWeek(RecipePool recipePool){
        List<Recipe> recipes = recipePool.getAllRecipes();

        // Shuffle recipes to randomize order.
        Collections.shuffle(recipes);

        // Put recipes with higher weight to the back of the list.
        List<Recipe> recipesSortedByWeight =
        recipes.stream().sorted(Comparator.comparingInt(Recipe::getWeight)).collect(Collectors.toList());

        // Pick seven random recipes from the beginning of the list.
        List<Recipe> pickedRecipes = recipesSortedByWeight.subList(0,7);

        // Add weight to picked recipes to make them go to the back of the
        // list of recipes sorted by weight next time.
        for (Recipe recipe: pickedRecipes) {
            recipe.addWeight();
        }

        RecipeWeek recipeWeek = new RecipeWeek(pickedRecipes);

        recipeWeek.setWeekNumber(generateWeekNumber());

        return recipeWeek;
    }

    public static int generateWeekNumber(){
        LocalDate today = LocalDate.now();

        int weekOfYear = today.get(WeekFields.of(Locale.GERMANY).weekOfYear());

        return weekOfYear;
    }
}
