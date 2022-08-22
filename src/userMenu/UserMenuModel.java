package userMenu;

import RecipeMenu.RecipeMenu;
import mainMenu.MainMenu;
import menus.MenuModel;
import recipe.RecipeFileHandler;
import userRoles.User;

import java.util.List;
import java.util.Scanner;

public class UserMenuModel implements MenuModel {
    private final List<String> menuOptions = List.of("List recipes", "Generate a new week",
            "List my weeks", "View recipe by id", "Log out");
    User user;

    public UserMenuModel(User user) {
        this.user = user;
    }

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void processOption(int selectedOption) throws IndexOutOfBoundsException {
        switch (selectedOption) {
            case 1 -> user.viewRecipeList();
            case 2 -> user.generateWeek();
            case 3 -> System.out.println("list of weeks");
            case 4 -> user.viewRecipe();
            case 5 -> user.signOut();
            default -> throw new IndexOutOfBoundsException();
        }
        new UserMenu(user);
    }



}
