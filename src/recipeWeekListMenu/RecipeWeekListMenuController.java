
package recipeWeekListMenu;

import recipeWeekMenu.RecipeWeekMenuModel;
import recipeWeekMenu.RecipeWeekMenuView;

import java.util.Scanner;

public class RecipeWeekListMenuController {
    private final RecipeWeekListMenuModel model;
    private final RecipeWeekListMenuView view;

    public RecipeWeekListMenuController(RecipeWeekListMenuModel model, RecipeWeekListMenuView view) {
        this.model = model;
        this.view = view;
    }

    public void readUserInput() {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();

        try {
            int selectedOption = Integer.parseInt(input);

            model.processOption(selectedOption);
        }
        catch (NumberFormatException | NullPointerException exception) {
            view.printInvalidOption();
            view.requestUserInput();
            readUserInput();
        }
    }
}
