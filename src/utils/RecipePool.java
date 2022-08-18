package utils;

import java.util.List;

public class RecipePool {
    private static List<Recipe> allRecipes;

    public void loadFromFile(){
        allRecipes = RecipeFileHandler.getRecipes();
    }

    public static void addRecipe(Recipe recipe){
        allRecipes.add(recipe);
    }
}
