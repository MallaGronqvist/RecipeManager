package mainMenu;

import userRoles.Dietitian;
import userRoles.Person;
import userRoles.User;
import recipe.RecipePool;

import java.util.List;

public class MainMenuModel {
    private final List<String> menuOptions = List.of("Log in as user", "Log in as dietitian");

    private Person inloggedUser;

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void processOption(int selectedOption) throws IndexOutOfBoundsException {
        switch (selectedOption) {
            case 1 -> inloggedUser = new User();
            case 2 -> inloggedUser = new Dietitian();
            default -> throw new IndexOutOfBoundsException();
        }

        inloggedUser.printBanner();
        inloggedUser.sessionLoop();
    }
}
