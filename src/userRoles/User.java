package userRoles;

import RecipeMenu.RecipeMenu;
import mainMenu.MainMenu;
import printers.RecipePrinter;
import printers.RecipeWeekPrinter;
import recipe.*;
import recipeWeekListMenu.RecipeWeekListMenu;
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
        usersRecipeWeekMap = RecipeWeekDatabase.getUsersRecipeWeeks();
    }

    @Override
    public void printBanner() {
        System.out.println("You are signed in as user.");
        System.out.println();
    }

    @Override
    public void sessionLoop(){
        new UserMenu(this);
    }

    public void generateWeek(){
        int currentWeekNumber = RecipeWeekGenerator.generateWeekNumber();

        if(usersRecipeWeekMap.containsKey(currentWeekNumber)){
            System.out.println("You have already generated a meal plan for the current week:");
            System.out.println();

            RecipeWeekPrinter.printWeek(usersRecipeWeekMap.get(currentWeekNumber));

        } else{
            RecipeWeek recipeWeek = RecipeWeekGenerator.generateRecipeWeek(recipePool);

            usersRecipeWeekMap.put(recipeWeek.getWeekNumber(), recipeWeek);

            new RecipeWeekMenu(recipeWeek);

        }
    }

    public void viewRecipeList(){
        new RecipeMenu(recipePool, "view");
    }

    public void viewTodaysRecipe(){
        LocalDate today = LocalDate.now();
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        int currentWeek = today.get(WeekFields.of(Locale.GERMANY).weekOfYear());
        Recipe todaysRecipe = null;

        try {
            todaysRecipe = usersRecipeWeekMap.get(currentWeek).getRecipeByDay(dayOfWeek);

        } catch (NullPointerException e) {
            System.out.println("No recipe for today was found in your recipe weeks.");

            RecipePrinter.waitForEnter();
        }

        RecipePrinter.printRecipe(todaysRecipe);
    }

    @Override
    public void signOut(){
        RecipeFileHandler.saveToFile(recipePool);

        RecipeWeekDatabase.saveUsersRecipeWeeks(usersRecipeWeekMap);

        new MainMenu();
    }

    public void viewAllRecipeWeeks() {
        if(usersRecipeWeekMap.isEmpty()){
            System.out.println("You don't have any recipe weeks yet.");
            System.out.println();
        }

        new RecipeWeekListMenu(usersRecipeWeekMap);
    }
}
