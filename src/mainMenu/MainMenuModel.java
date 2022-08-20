package mainMenu;

import menus.MenuModel;
import userRoles.Dietitian;
import userRoles.Person;
import userRoles.User;

import java.util.List;

public class MainMenuModel implements MenuModel {
    private final List<String> menuOptions = List.of("Log in as user", "Log in as dietitian");
    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void processOption(int selectedOption) throws IndexOutOfBoundsException {
        Person loggedInUser;

        switch (selectedOption) {
            case 1 -> loggedInUser = new User();
            case 2 -> loggedInUser = new Dietitian();
            default -> throw new IndexOutOfBoundsException();
        }

        loggedInUser.printBanner();
        loggedInUser.sessionLoop();
    }
}
