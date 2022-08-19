package addRecipe;

public class AddRecipe {
    public AddRecipe() {
        AddRecipeModel model = new AddRecipeModel();
        AddRecipeView view = new AddRecipeView(model.getInstructions());
        AddRecipeController controller = new AddRecipeController(model, view);
    }
}
