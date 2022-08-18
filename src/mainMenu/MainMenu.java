package mainMenu;

import userRoles.User;
import java.util.List;

public class MainMenu {
    private static User user = new User();

    public MainMenu(){
        MainMenuModel model = new MainMenuModel();
        MainMenuView view = new MainMenuView(model.getMenuOptions());
        MainMenuController controller = new MainMenuController(model, view);

        controller.readUserInput();
    }
}
