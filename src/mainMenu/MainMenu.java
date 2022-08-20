package mainMenu;

import menus.MenuController;
import userRoles.User;
import java.util.List;

public class MainMenu {

    public MainMenu(){
        MainMenuModel model = new MainMenuModel();
        MainMenuView view = new MainMenuView(model.getMenuOptions());
        MenuController controller = new MenuController(model, view);

        controller.readUserInput();
    }
}
