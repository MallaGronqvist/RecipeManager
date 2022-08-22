package userRoles;

import RecipeMenu.RecipeMenu;
import dietitianMenu.DietitianMenu;
import mainMenu.MainMenu;
import printers.RecipePrinter;
import recipe.Recipe;
import recipe.RecipeCreator;
import recipe.RecipeFileHandler;
import recipe.RecipePool;

public class Dietitian extends Person {
/*
    RecipePool recipePool;

    public Dietitian() {
        this.recipePool = new RecipePool();;
    }
*/
    @Override
    public void printBanner() {
        System.out.println("Logged in as dietitian.");
        System.out.println();
    }

    @Override
    public void sessionLoop() {

        new DietitianMenu(this);
    }


    public void createRecipe() {
        Recipe newRecipe = RecipeCreator.enterRecipe();
        RecipePrinter.printRecipe(newRecipe);
        recipePool.addRecipe(newRecipe);
        new DietitianMenu(this);
    }

    public void viewRecipeList(){
        new RecipeMenu(recipePool);

        new DietitianMenu(this);
    }
/*
    public RecipePool getRecipePool() {
        return recipePool;
    }

    public void signOut(){
        RecipeFileHandler.saveToFile(recipePool);
        new MainMenu();
    }

 */
}
