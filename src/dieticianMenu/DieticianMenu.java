package dieticianMenu;

public class DieticianMenu {

    public DieticianMenu(){
        DieticianMenuModel model = new DieticianMenuModel();
        DieticianMenuView view = new DieticianMenuView(model.getMenuOptions());
        DieticianMenuController controller = new DieticianMenuController(model, view);

        controller.readUserInput();
    }
}
