package recipe;

import fileHandlers.RecipePoolFileHandler;

import java.util.Iterator;
import java.util.List;

public class RecipePool {
    private static List<Recipe> allRecipes;

    public RecipePool() {
        allRecipes = RecipePoolFileHandler.readFile();
    }

    public Recipe getRecipe(int selectedOption) {
        return allRecipes.get(selectedOption - 1);
    }

    public Iterator<Recipe> getIterator() {
        return allRecipes.listIterator();
    }

    public void addRecipe(Recipe recipe) {

        allRecipes.add(recipe);

    }

    public List<Recipe> getAllRecipes() {
        return allRecipes;
    }
}
