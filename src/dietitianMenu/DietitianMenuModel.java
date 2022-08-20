package dietitianMenu;

import mainMenu.MainMenu;
import menus.MenuModel;
import printers.PrintHandler;
import recipe.RecipeCreator;
import recipe.RecipeFileHandler;
import recipe.RecipePool;

import java.util.List;

public class DietitianMenuModel implements MenuModel {
    private final List<String> menuOptions = List.of("List recipes", "Add a recipe", "Edit a recipe", "Log out");

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void processOption(int selectedOption) throws IndexOutOfBoundsException {
        switch (selectedOption) {
            case 1 -> PrintHandler.optionList(RecipePool.getAllRecipes());
            case 2 -> RecipeCreator.enterRecipe();
            case 3 -> System.out.println("Edit a recipe");
            case 4 -> {
                new MainMenu();
                RecipeFileHandler.saveToFile(new RecipePool());
            }
            default -> throw new IndexOutOfBoundsException();
        }
    }
}
