package RecipeMenu;

import java.util.Scanner;

public class RecipeMenuController {
    private final RecipeMenuModel model;
    private final RecipeMenuView view;

    public RecipeMenuController(RecipeMenuModel model, RecipeMenuView view) {
        this.model = model;
        this.view = view;
    }

    public void readUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            int selectedOption = Integer.parseInt(input);

            model.processOption(selectedOption);
        }
        catch (NumberFormatException | IndexOutOfBoundsException exception) {
            view.printInvalidOption();
            view.requestUserInput();
            readUserInput();
        }
    }
}
