package dieticianMenu;

import addRecipeMenu.AddRecipeMenu;
import mainMenu.MainMenu;

import java.util.List;

public class DieticianMenuModel {
    private final List<String> menuOptions = List.of("List recipes", "Add a recipe", "Edit a recipe", "Log out");

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) throws IndexOutOfBoundsException {
        switch (selectedOption) {
            case 1 -> System.out.println("Showing recipe list");
            case 2 -> new AddRecipeMenu();
            case 3 -> System.out.println("Edit a recipe");
            case 4 -> new MainMenu();
            default -> throw new IndexOutOfBoundsException();
        }
    }
}
