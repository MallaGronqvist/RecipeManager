package recipe;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.Collectors;


public class RecipeWeekGenerator {

    public static RecipeWeek generateWeek(RecipePool recipePool){
        /*
        RandomCollection<Recipe>recipes = new RandomCollection<>();
        for (Recipe recipe: recipePool.getAllRecipes()) {
            recipes.add(recipe.getWeight(), recipe);
        }

        Set<Recipe> recipeWeek = new HashSet<>();  // You need to implement the methods equals and hashcode?
        int daysOfWeek = 7;
        for (int i = 0; i <= daysOfWeek; i++){
            System.out.println(recipes.next());
        }
         */

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



        List<LocalDate> dates = generateDates();

        RecipeWeek recipeWeek = new RecipeWeek(dates, pickedRecipes);

        recipeWeek.setWeekId(generateWeekNumber());

        return recipeWeek;
    }

    public static List<LocalDate> generateDates() {

        int weekOfYear = generateWeekNumber();

        LocalDate mondayThisWeek = LocalDate.now().with(WeekFields.ISO.weekBasedYear(), 2022)
                .with(WeekFields.ISO.weekOfWeekBasedYear(), weekOfYear)
                .with(WeekFields.ISO.dayOfWeek(), DayOfWeek.MONDAY.getValue());

        LocalDate tuesday = mondayThisWeek.plusDays(1);
        LocalDate wednesday = mondayThisWeek.plusDays(2);
        LocalDate thursday = mondayThisWeek.plusDays(3);
        LocalDate friday = mondayThisWeek.plusDays(4);
        LocalDate saturday = mondayThisWeek.plusDays(5);
        LocalDate sunday = mondayThisWeek.plusDays(6);

        List<LocalDate> datesOfWeek = new ArrayList<>();
        datesOfWeek.add(mondayThisWeek);
        datesOfWeek.add(tuesday);
        datesOfWeek.add(wednesday);
        datesOfWeek.add(thursday);
        datesOfWeek.add(friday);
        datesOfWeek.add(saturday);
        datesOfWeek.add(sunday);

        return datesOfWeek;
    }

    public static int generateWeekNumber(){
        java.time.LocalDate today = LocalDate.now();

        int weekOfYear = today.get(WeekFields.of(Locale.GERMANY).weekOfYear());

        return weekOfYear;
    }
}
