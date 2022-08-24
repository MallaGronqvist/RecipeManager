package RecipeMenu;

import menus.MenuModel;
import printers.RecipePrinter;
import recipe.Recipe;
import recipe.RecipePool;
import recipeEditor.RecipeEditor;


import java.util.ArrayList;
import java.util.List;

public class RecipeMenuModel implements MenuModel {
    RecipePool recipePool;
    String mode;

    public RecipeMenuModel(RecipePool recipePool, String mode) {

        this.recipePool = recipePool;
        this.mode = mode;
    }

    @Override
    public List<String> getMenuOptions() {
        List<String>recipeTitles = new ArrayList<>();

        // Make this a stream trick?
        for (Recipe recipe: recipePool.getAllRecipes()) {
            String title = recipe.getTitle();
            recipeTitles.add(title);
        }
        return recipeTitles;

    }

    public void processOption(int selectedOption) throws IndexOutOfBoundsException {
        Recipe recipe = recipePool.getRecipe(selectedOption);

        switch(mode){
            case "view" -> RecipePrinter.printRecipe(recipe);
            case "edit" -> new RecipeEditor(recipe);
            default -> throw new IndexOutOfBoundsException();
        }
    }

    public List<Recipe> getRecipes() {
       return recipePool.getAllRecipes();
    }
}
