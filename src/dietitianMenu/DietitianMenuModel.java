package dietitianMenu;

import RecipeMenu.RecipeMenu;
import mainMenu.MainMenu;
import menus.MenuModel;
import recipe.RecipeCreator;
import recipe.RecipeFileHandler;
import recipe.RecipePool;
import userRoles.Dietitian;

import java.util.List;

public class DietitianMenuModel implements MenuModel {
    private final List<String> menuOptions = List.of("List recipes", "Add a recipe", "Edit a recipe", "Log out");

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void processOption(int selectedOption) throws IndexOutOfBoundsException {
        Dietitian dietitian = new Dietitian();
        switch (selectedOption) {
            case 1 -> new RecipeMenu();
            case 2 -> RecipeCreator.enterRecipe();
            case 3 -> System.out.println("Edit a recipe");
            case 4 -> dietitian.viewRecipe();
            case 5 -> logOutDietitian();
            default -> throw new IndexOutOfBoundsException();
        }
    }

    private static void logOutDietitian(){
        RecipeFileHandler.saveToFile(new RecipePool());
        new MainMenu();
    }
}
