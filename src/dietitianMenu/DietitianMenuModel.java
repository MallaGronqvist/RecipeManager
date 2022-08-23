package dietitianMenu;

import menus.MenuModel;
import userRoles.Dietitian;

import java.util.List;

public class DietitianMenuModel implements MenuModel {
    private final List<String> menuOptions = List.of("List recipes", "Add a recipe", "Edit a recipe", "View recipe", "Log out");
    Dietitian dietitian;

    public DietitianMenuModel(Dietitian dietitian) {
        this.dietitian = dietitian;
    }

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void processOption(int selectedOption) throws IndexOutOfBoundsException {

        switch (selectedOption) {
            case 1 -> dietitian.viewRecipeList();
            case 2 -> dietitian.createRecipe();
            case 3 -> dietitian.editRecipe();
            case 4 -> dietitian.viewRecipe();
            case 5 -> dietitian.signOut();
            default -> throw new IndexOutOfBoundsException();
        }
    }
}
