package recipeWeekListMenu;

import menuCommons.MenuView;
import printers.MenuPrinter;

import java.util.List;


public class RecipeWeekListMenuView extends MenuView {
    public RecipeWeekListMenuView(List<String> weekNumbers) {
        MenuPrinter.clearConsole();

        for (String weekNumber : weekNumbers) {
            System.out.println("[" + weekNumber + "] " + "Week " + weekNumber);
        }

        requestUserInput();
    }
}
