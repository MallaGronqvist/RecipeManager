package userRoles;

import RecipeMenu.RecipeMenu;
import mainMenu.MainMenu;
import printers.RecipePrinter;
import recipe.*;
import recipeWeekMenu.RecipeWeekMenu;
import userMenu.UserMenu;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.*;

public class User extends Person {
    Map<Integer, RecipeWeek> usersRecipeWeekMap;

    public User() {
        super();
        usersRecipeWeekMap = new LinkedHashMap<>();
    }

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

        RecipeWeek recipeWeek = RecipeWeekGenerator.generateWeek(recipePool);

        usersRecipeWeekMap.put(recipeWeek.getWeekNumber(), recipeWeek);

        new RecipeWeekMenu(recipeWeek);
    }

    public void viewRecipeList(){
        new RecipeMenu(recipePool);

        new UserMenu(this);
    }

    public void viewTodaysRecipe(){
        LocalDate today = LocalDate.now();
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();

        int weekOfYear = today.get(WeekFields.of(Locale.GERMANY).weekOfYear());

        Recipe todaysRecipe = usersRecipeWeekMap.get(weekOfYear).getRecipeByDay(dayOfWeek);

        RecipePrinter.printRecipe(todaysRecipe);
    }
}
