package userMenu;
import userRoles.User;

public class UserMenu {

    public UserMenu(User user) {
        UserMenuModel model = new UserMenuModel(user);
        UserMenuView view = new UserMenuView(model.getMenuOptions());
        UserMenuController controller = new UserMenuController(model, view);

        controller.readUserInput();
    }


}
