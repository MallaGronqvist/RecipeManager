package userRoles;

import printers.RecipeWeekPrinter;
import recipe.Recipe;
import recipe.RecipePool;
import recipe.RecipeWeek;
import userMenu.UserMenu;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class User extends Person {
    @Override
    public void printBanner() {
        System.out.println("Logged in as user.");
        System.out.println();
    }

    @Override
    public void sessionLoop(){
        new UserMenu(this);
    }

    public void generateWeek(){
        java.time.LocalDate today = LocalDate.now();
        System.out.println(today);
        int weekOfYear = today.get(WeekFields.of(Locale.GERMANY).weekOfYear());
        System.out.println("Week nr: " + weekOfYear);

        LocalDate mondayThisweek = LocalDate.now().with(WeekFields.ISO.weekBasedYear(), 2022)
                .with(WeekFields.ISO.weekOfWeekBasedYear(), weekOfYear)
                .with(WeekFields.ISO.dayOfWeek(), DayOfWeek.MONDAY.getValue());
        System.out.println("Monday this week: " + mondayThisweek);

        LocalDate tuesday = mondayThisweek.plusDays(1);
        LocalDate wednesday = mondayThisweek.plusDays(2);
        LocalDate thursday = mondayThisweek.plusDays(3);
        LocalDate friday = mondayThisweek.plusDays(4);
        LocalDate saturday = mondayThisweek.plusDays(5);
        LocalDate sunday = mondayThisweek.plusDays(6);

        System.out.println(tuesday.getDayOfWeek());
        System.out.println(wednesday);
        System.out.println(thursday);
        System.out.println(friday);
        System.out.println(saturday);
        System.out.println(sunday);

        List<LocalDate> datesOfWeek = new ArrayList<>();
        datesOfWeek.add(mondayThisweek);
        datesOfWeek.add(tuesday);
        datesOfWeek.add(wednesday);
        datesOfWeek.add(thursday);
        datesOfWeek.add(friday);
        datesOfWeek.add(saturday);
        datesOfWeek.add(sunday);
        LocalDate testitoday = LocalDate.now();

        List<Recipe> recipes = new ArrayList<>();
        recipes.add(RecipePool.getRecipe(1));
        recipes.add(RecipePool.getRecipe(2));
        recipes.add(RecipePool.getRecipe(3));
        recipes.add(RecipePool.getRecipe(4));
        recipes.add(RecipePool.getRecipe(5));
        recipes.add(RecipePool.getRecipe(6));
        recipes.add(RecipePool.getRecipe(7));

        RecipeWeek recipeWeek = new RecipeWeek();
        // This would be in the constructor of the week.
        recipeWeek.makeWeek((ArrayList<LocalDate>) datesOfWeek, (ArrayList<Recipe>) recipes);

        RecipeWeekPrinter.printWeek(recipeWeek.getDayRecipeMapping());
    }
}
