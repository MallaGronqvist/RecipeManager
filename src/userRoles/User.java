package userRoles;

import printers.RecipeWeekPrinter;
import recipe.Recipe;
import recipe.RecipePool;
import recipe.RecipeWeek;
import recipe.RecipeWeekGenerator;
import recipeWeekMenu.RecipeWeekMenu;
import userMenu.UserMenu;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class User extends Person {
    RecipePool recipePool;
    List<RecipeWeek>usersRecipeWeeks;

    public User() {
        this.recipePool = new RecipePool();
        usersRecipeWeeks = new ArrayList<>();
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

        LocalDate testitoday = LocalDate.now();

        RecipeWeek recipeWeek = RecipeWeekGenerator.generateWeek(recipePool);

        usersRecipeWeeks.add(recipeWeek);

        new RecipeWeekMenu(recipeWeek);
    }
}
