package dieticianMenu;

import java.util.Scanner;

public class DieticianMenuController {
    private final DieticianMenuModel model;
    private final DieticianMenuView view;

    public DieticianMenuController(DieticianMenuModel model, DieticianMenuView view) {
        this.model = model;
        this.view = view;
    }

    public void readUserInput() {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();

        try {
            int selectedOption = Integer.parseInt(input);

            model.handleOption(selectedOption);
        }
        catch (NumberFormatException | IndexOutOfBoundsException exception) {
            view.printInvalidOption();
            view.requestUserInput();
            readUserInput();
        }
    }
}
