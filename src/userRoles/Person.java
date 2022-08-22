package userRoles;

import RecipeMenu.RecipeMenu;
import mainMenu.MainMenu;
import recipe.RecipeFileHandler;
import recipe.RecipePool;
import userMenu.UserMenu;

import java.util.Scanner;

public abstract class Person {

    RecipePool recipePool = new RecipePool();
    public abstract void printBanner();
    public abstract void sessionLoop();

    public RecipePool getRecipePool() {
        return recipePool;
    }

    public void viewRecipe(){
        System.out.println("We will view the recipe here.");
    }

    public void signOut(){
        RecipeFileHandler.saveToFile(recipePool);
        new MainMenu();
    }
}
