package recipeEditorMenu;

import menuCommons.MenuModel;
import recipe.Recipe;
import recipe.RecipeCreator;
import recipeEditorMenu.elementDeleter.ElementDeleter;

import java.util.List;

public class RecipeEditorMenuModel implements MenuModel {
    List<String>options = List.of("delete a step", "delete an ingredient", "add a step", "add an ingredient");
    Recipe recipe;

    public RecipeEditorMenuModel(Recipe recipe) {
        this.recipe = recipe;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public List<String> getMenuOptions() {
        return options;
    }

    @Override
    public void processOption(int selectedOption) throws IndexOutOfBoundsException {
        switch (selectedOption){
            case 1 -> new ElementDeleter(recipe, "step");
            case 2 -> new ElementDeleter(recipe, "ingredient");
            case 3 -> RecipeCreator.addSteps(recipe);
            case 4 -> RecipeCreator.addIngredients(recipe);
            default -> throw new IndexOutOfBoundsException();
        }
    }
}
