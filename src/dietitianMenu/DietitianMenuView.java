package dietitianMenu;

import printers.PrintHandler;

import java.util.List;

public class DietitianMenuView {
    public DietitianMenuView(List<String> menuOptions){
        PrintHandler.optionList(menuOptions);
        requestUserInput();
    }

    public void printInvalidOption() {
        System.out.println("Invalid option");
    }

    public void requestUserInput() {
        System.out.print("Enter your choice and press enter: ");
    }
}
