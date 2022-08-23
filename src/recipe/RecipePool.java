package recipe;

import java.util.Iterator;
import java.util.List;

public class RecipePool {
    private List<Recipe> allRecipes;

    public RecipePool(){
        allRecipes = RecipeFileHandler.readFile();
    }

    public Recipe getRecipe(int selectedOption) {
        return allRecipes.get(selectedOption-1);
    }

    Iterator<Recipe> getIterator(){
        return allRecipes.listIterator();
    }

    public void addRecipe(Recipe recipe){

        allRecipes.add(recipe);

    }

    public List<Recipe> getAllRecipes() {
        return allRecipes;
    }
}
