package userMenu;

import menus.MenuModel;
import userRoles.User;

import java.util.List;

public class UserMenuModel implements MenuModel {
    private final List<String> menuOptions = List.of("List recipes", "Generate / View current week", "View today's recipe",
            "List my weeks", "Log out");
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
            case 5 -> user.signOut();
            default -> throw new IndexOutOfBoundsException();
        }
        new UserMenu(user);
    }
}
