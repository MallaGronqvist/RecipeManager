package userRoles;

import recipeMenu.RecipeMenu;
import fileHandlers.RecipePoolFileHandler;
import fileHandlers.RecipeWeekFileHandler;
import mainMenu.MainMenu;
import printers.MenuPrinter;
import printers.RecipePrinter;
import recipe.Recipe;
import recipe.RecipeWeek;
import recipe.RecipeWeekGenerator;
import recipeWeekListMenu.RecipeWeekListMenu;
import recipeWeekMenu.RecipeWeekMenu;
import userMenu.UserMenu;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Map;

public class User extends Person {
    private static Map<Integer, RecipeWeek> usersRecipeWeekMap;

    public User() {
        super();
        usersRecipeWeekMap = RecipeWeekFileHandler.getUsersRecipeWeekMap();
    }

    @Override
    public void printBanner() {
        System.out.println("You are signed in as user.");
        System.out.println();
    }

    @Override
    public void sessionLoop() {
        new UserMenu(this);
    }

    public void generateWeek() {
        int currentWeekNumber = RecipeWeekGenerator.generateWeekNumber();

        // If current week has already been generated show it.
        if (usersRecipeWeekMap.containsKey(currentWeekNumber)) {

            new RecipeWeekMenu(usersRecipeWeekMap.get(currentWeekNumber));

        } else {
            try {
                RecipeWeek recipeWeek = RecipeWeekGenerator.generateRecipeWeek(recipePool);

                usersRecipeWeekMap.put(recipeWeek.getWeekNumber(), recipeWeek);

                new RecipeWeekMenu(recipeWeek);
            } catch (IndexOutOfBoundsException e) {

                System.out.println("Recipe week can't be generated at the moment.");
            }
        }
    }

 //   public void viewRecipeList() { new RecipeMenu(recipePool, "view"); }

    public void viewTodaysRecipe() {
        LocalDate today = LocalDate.now();
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        int currentWeek = today.get(WeekFields.of(Locale.GERMANY).weekOfYear());
        Recipe todaysRecipe;

        try {
            todaysRecipe = usersRecipeWeekMap.get(currentWeek).getRecipeByDay(dayOfWeek);

            RecipePrinter.printRecipe(todaysRecipe);

        } catch (NullPointerException e) {
            MenuPrinter.clearConsole();
            System.out.println("No recipe for today was found in your recipe weeks.");
            System.out.println();
        }
    }

    @Override
    public void signOut() {
        RecipePoolFileHandler.saveToFile(recipePool);

        RecipeWeekFileHandler.saveUsersRecipeWeeks(usersRecipeWeekMap);

        new MainMenu();
    }

    public void viewAllRecipeWeeks() {
        if (usersRecipeWeekMap.isEmpty()) {
            MenuPrinter.clearConsole();
            System.out.println("You don't have any recipe weeks yet.");
            System.out.println();
        } else {
            new RecipeWeekListMenu(usersRecipeWeekMap);
        }
    }
}
