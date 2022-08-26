package userRoles;

import fileHandlers.RecipePoolFileHandler;
import mainMenu.MainMenu;
import recipe.RecipePool;
import recipeMenu.RecipeMenu;

public abstract class Person {
    protected RecipePool recipePool;

    Person() {
        recipePool = new RecipePool();
    }

    public abstract void printBanner();

    public abstract void sessionLoop();

    public RecipePool getRecipePool() {
        return recipePool;
    }

    public void viewRecipeList() {
        new RecipeMenu(recipePool, "view");
    }

    public void signOut() {
        RecipePoolFileHandler.saveToFile(recipePool);

        new MainMenu();
    }

}
