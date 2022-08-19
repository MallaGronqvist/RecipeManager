package recipe;

import recipe.Recipe;
import recipe.RecipeFileHandler;

import java.util.Iterator;
import java.util.List;

public class RecipePool {
    private static List<Recipe> allRecipes;

    public static void loadFromFile(){
        allRecipes = RecipeFileHandler.readFile();
    }

    public static Recipe getRecipe(int selectedOption) {
        return allRecipes.get(selectedOption-1);
    }

    Iterator<Recipe> getIterator(){
        return allRecipes.listIterator();
    }

    public static void addRecipe(Recipe recipe){
        allRecipes.add(recipe);
    }

    public static List<Recipe> getAllRecipes() {
        return allRecipes;
    }
}
