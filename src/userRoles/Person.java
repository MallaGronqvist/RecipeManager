package userRoles;

import mainMenu.MainMenu;
import recipe.RecipeFileHandler;
import recipe.RecipePool;

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

    public void signOut() {
        RecipeFileHandler.saveToFile(recipePool);

        new MainMenu();
    }

}
