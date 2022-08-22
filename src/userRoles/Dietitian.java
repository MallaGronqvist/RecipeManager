package userRoles;

import RecipeMenu.RecipeMenu;
import dietitianMenu.DietitianMenu;
import recipe.RecipeCreator;
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
        RecipeCreator.enterRecipe();
        new DietitianMenu(this);
    }

    public void viewRecipeList(){
        new RecipeMenu(recipePool);

        new DietitianMenu(this);
    }
}
