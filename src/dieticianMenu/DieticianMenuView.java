package dieticianMenu;

import utils.PrintHandler;

import java.util.List;

public class DieticianMenuView {

    public DieticianMenuView(List<String> menuOptions){
        PrintHandler.optionList(menuOptions);
        requestUserInput();
    }

    public void printInvalidOption() {
        System.out.println("Invalid option");
    }

    public void requestUserInput() {
        System.out.print("Choose an option and press enter: ");
    }
}
