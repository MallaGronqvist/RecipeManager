package addRecipeMenu;

public class AddRecipeMenu {
    public AddRecipeMenu() {
        AddRecipeMenuModel model = new AddRecipeMenuModel();
        AddRecipeMenuView view = new AddRecipeMenuView(model.getInstructions());
        AddRecipeMenuController controller = new AddRecipeMenuController(model, view);
    }
}
