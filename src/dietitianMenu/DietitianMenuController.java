package dietitianMenu;

import java.util.Scanner;

public class DietitianMenuController {
    private final DietitianMenuModel model;
    private final DietitianMenuView view;

    public DietitianMenuController(DietitianMenuModel model, DietitianMenuView view) {
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
        catch (NumberFormatException | IndexOutOfBoundsException exception) {
            view.printInvalidOption();
            view.requestUserInput();
            readUserInput();
        }
    }
}
