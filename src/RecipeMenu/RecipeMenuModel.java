package RecipeMenu;

import menuCommons.MenuModel;
import printers.RecipePrinter;
import recipe.Recipe;
import recipe.RecipePool;
import recipeEditorMenu.RecipeEditorMenu;

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
        List<String> recipeTitles = new ArrayList<>();

        for (Recipe recipe : recipePool.getAllRecipes()) {
            String title = recipe.getTitle();
            recipeTitles.add(title);
        }

        return recipeTitles;
    }

    public void processOption(int selectedOption) throws IndexOutOfBoundsException {
        Recipe recipe = recipePool.getRecipe(selectedOption);

        switch (mode) {
            case "view" -> RecipePrinter.printRecipe(recipe);
            case "edit" -> new RecipeEditorMenu(recipe);
            default -> throw new IndexOutOfBoundsException();
        }
    }
}
