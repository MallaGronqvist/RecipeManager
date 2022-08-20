package dietitianMenu;

import menus.MenuController;

public class DietitianMenu {

    public DietitianMenu(){
        DietitianMenuModel model = new DietitianMenuModel();
        DietitianMenuView view = new DietitianMenuView(model.getMenuOptions());
        MenuController controller = new MenuController(model, view);

        controller.readUserInput();
    }
}
