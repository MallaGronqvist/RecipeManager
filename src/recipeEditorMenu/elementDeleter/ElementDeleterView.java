package recipeEditorMenu.elementDeleter;

import menuCommons.MenuView;
import printers.MenuPrinter;

import java.util.List;

public class ElementDeleterView extends MenuView {
    public ElementDeleterView(List<String> elements) {
        MenuPrinter.clearConsole();

        System.out.println("Options for deleting:");
        System.out.println();

        MenuPrinter.listOptions(elements);

        requestUserInput();
    }

    @Override
    public void requestUserInput() {
        System.out.print("Enter number of the element to delete or enter '0' to go back: ");
    }
}
