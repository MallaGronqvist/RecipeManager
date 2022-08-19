package dietitianMenu;

public class DietitianMenu {

    public DietitianMenu(){
        DietitianMenuModel model = new DietitianMenuModel();
        DietitianMenuView view = new DietitianMenuView(model.getMenuOptions());
        DietitianMenuController controller = new DietitianMenuController(model, view);

        controller.readUserInput();
    }
}
