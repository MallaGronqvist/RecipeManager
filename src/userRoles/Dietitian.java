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
        new RecipeMenu(recipePool, "view");

        RecipePrinter.waitForEnter();

        new DietitianMenu(this);
    }

    public void editRecipe(){
        new RecipeMenu(recipePool, "edit");

        new DietitianMenu(this);
    }
}
