package dietitianMenu;

import menus.MenuController;
import userRoles.Dietitian;

public class DietitianMenu {

    public DietitianMenu(Dietitian dietitian){

        DietitianMenuModel model = new DietitianMenuModel(dietitian);
        DietitianMenuView view = new DietitianMenuView(model.getMenuOptions());
        MenuController controller = new MenuController(model, view);

        controller.readUserInput();
    }
}
