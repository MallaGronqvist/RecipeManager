package userMenu;

import menus.MenuModel;
import userRoles.User;

import java.util.List;

public class UserMenuModel implements MenuModel {
    private final List<String> menuOptions = List.of("List recipes", "Generate a new week", "View today's recipe",
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
            case 3 -> user.viewTodaysRecipe();
            case 4 -> user.viewAllRecipeWeeks();
            case 5 -> user.viewRecipe();
            case 6 -> user.signOut();
            default -> throw new IndexOutOfBoundsException();
        }
        new UserMenu(user);
    }
}
