package recipeEditorMenu.ElementDeleter;

import menuCommons.MenuModel;
import printers.RecipePrinter;
import recipe.Recipe;

import java.util.ArrayList;
import java.util.List;

public class ElementDeleterModel implements MenuModel {
    Recipe recipe;
    List<String> elements;
    String elementType;

    public ElementDeleterModel(Recipe recipe, String elementType) {
        this.recipe = recipe;
        this.elementType = elementType;

        switch (elementType){
            case "step"-> this.elements = new ArrayList<>(recipe.getSteps());
            case "ingredient" -> this.elements = new ArrayList<>(recipe.getIngredients());
        }
    }

    @Override
    public List<String> getMenuOptions() {
        return elements;
    }

    @Override
    public void processOption(int selectedOption) throws IndexOutOfBoundsException {
        if (selectedOption != 0){
            elements.remove(selectedOption-1);

            switch (elementType){
                case "step" -> recipe.setSteps(elements);
                case "ingredient" -> recipe.setIngredients(elements);
                default -> throw new IndexOutOfBoundsException();
            }
        }
        RecipePrinter.printRecipe(recipe);
    }
}
