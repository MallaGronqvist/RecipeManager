package userMenu;

import menuCommons.MenuController;
import userRoles.User;

public class UserMenu {

    public UserMenu(User user) {

        UserMenuModel model = new UserMenuModel(user);
        UserMenuView view = new UserMenuView(model.getMenuOptions());
        MenuController controller = new MenuController(model, view);

        controller.readUserInput();
    }
}
