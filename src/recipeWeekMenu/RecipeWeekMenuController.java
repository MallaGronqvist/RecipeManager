package recipeWeekMenu;

import menus.MenuModel;
import menus.MenuView;

import java.util.Scanner;

public class RecipeWeekMenuController {

    private final RecipeWeekMenuModel model;
    private final RecipeWeekMenuView view;

    public RecipeWeekMenuController(RecipeWeekMenuModel model, RecipeWeekMenuView view) {
        this.model = model;
        this.view = view;
    }

    public void readUserInput() {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();

        try {
            if (input.equalsIgnoreCase("t")){
                model.processOption(input);
            } else {
                int selectedOption = Integer.parseInt(input);

                model.processOption(String.valueOf(selectedOption));
            }
        }
        catch (NumberFormatException | IndexOutOfBoundsException exception) {
            view.printInvalidOption();
            view.requestUserInput();
            readUserInput();
        }
    }
}
