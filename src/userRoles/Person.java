package userRoles;

import RecipeMenu.RecipeMenu;
import userMenu.UserMenu;

import java.util.Scanner;

public abstract class Person {
    public abstract void printBanner();
    public abstract void sessionLoop();

    public void viewRecipePool(){
        new RecipeMenu();
    }
}
