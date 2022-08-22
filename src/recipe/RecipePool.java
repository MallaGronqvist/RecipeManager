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

        System.out.println("Now adding the recipe");
        allRecipes.add(recipe);

        for (Recipe recipeX: allRecipes) {
            System.out.println(recipeX);

        }
    }

    public List<Recipe> getAllRecipes() {
        return allRecipes;
    }
}
