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
    Dietitian dietitian;

    public DietitianMenuModel(Dietitian dietitian) {
        this.dietitian = dietitian;
    }

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void processOption(int selectedOption) throws IndexOutOfBoundsException {
        Dietitian dietitian = new Dietitian();
        switch (selectedOption) {
            case 1 -> dietitian.viewRecipeList();
            case 2 -> dietitian.createRecipe();
            case 3 -> System.out.println("Edit a recipe");
            case 4 -> dietitian.viewRecipe();
            case 5 -> dietitian.signOut();
            default -> throw new IndexOutOfBoundsException();
        }
    }
}
