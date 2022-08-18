package utils;

import java.util.List;

public class RecipePool {
    private static List<Recipe> allRecipes;

    public static void loadFromFile(){
        allRecipes = RecipeFileHandler.getRecipes();
    }

    public void saveToFile(){

    }

    public static void addRecipe(Recipe recipe){
        allRecipes.add(recipe);
    }

    public static List<Recipe> getAllRecipes() {
        return allRecipes;
    }
}
