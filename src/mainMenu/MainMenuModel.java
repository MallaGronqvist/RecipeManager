package mainMenu;

import dieticianMenu.DieticianMenu;
import utils.Recipe;
import utils.RecipeFileHandler;
import utils.RecipePool;

import java.util.List;

public class MainMenuModel {
    private final List<String> menuOptions = List.of("Log in as user", "Log in as dietician");

    private static RecipePool recipePool = new RecipePool();

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) throws IndexOutOfBoundsException {
        switch (selectedOption) {
            case 1 -> System.out.println("Logged in as user.");
            case 2 -> new DieticianMenu();
            default -> throw new IndexOutOfBoundsException();
        }
    }
}
