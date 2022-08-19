package dietitianMenu;

import addRecipe.AddRecipe;
import mainMenu.MainMenu;
import printers.PrintHandler;
import recipe.RecipeFileHandler;
import recipe.RecipePool;

import java.util.List;

public class DietitianMenuModel {
    private final List<String> menuOptions = List.of("List recipes", "Add a recipe", "Edit a recipe", "Log out");

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void processOption(int selectedOption) throws IndexOutOfBoundsException {
        switch (selectedOption) {
            case 1 -> PrintHandler.optionList(RecipePool.getAllRecipes());
            case 2 -> new AddRecipe();
            case 3 -> System.out.println("Edit a recipe");
            case 4 -> {
                new MainMenu();
                RecipeFileHandler.saveToFile(new RecipePool());
            }
            default -> throw new IndexOutOfBoundsException();
        }
    }
}
