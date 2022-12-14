package userRoles;

import dietitianMenu.DietitianMenu;
import printers.RecipePrinter;
import recipe.Recipe;
import recipe.RecipeCreator;
import recipeMenu.RecipeMenu;


public class Dietitian extends Person {

    @Override
    public void printBanner() {
        System.out.println("You are singed in as dietitian.");
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

        RecipePrinter.waitForEnter();
    }

    public void editRecipe() {
        new RecipeMenu(recipePool, "edit");
    }
}
