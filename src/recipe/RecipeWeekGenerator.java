package recipe;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.Collectors;


public class RecipeWeekGenerator {

    public static RecipeWeek generateRecipeWeek(RecipePool recipePool){

        List<Recipe> recipes = recipePool.getAllRecipes();
        Collections.shuffle(recipes);

        // For testing purposes
        recipes.get(0).setWeight(0);
        recipes.get(1).setWeight(0);
        recipes.get(2).setWeight(0);
        recipes.get(3).setWeight(20);
        recipes.get(4).setWeight(60);
        recipes.get(5).setWeight(70);
        recipes.get(6).setWeight(2);
        recipes.get(7).setWeight(30);
        recipes.get(8).setWeight(0);

        List<Recipe> recipesSortedByWeight =
        recipes.stream().sorted(Comparator.comparingInt(Recipe::getWeight)).collect(Collectors.toList());

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
