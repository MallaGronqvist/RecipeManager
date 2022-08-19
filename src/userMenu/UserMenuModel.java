package userMenu;

import RecipeMenu.RecipeMenu;
import mainMenu.MainMenu;
import userRoles.User;

import java.util.List;
import java.util.Scanner;

public class UserMenuModel {
    private final List<String> menuOptions = List.of("List recipes", "Generate a new week",
            "List my weeks", "View recipe by id", "Log out");
    User user;

    public UserMenuModel(User user) {
        this.user = user;
    }

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void processOption(int selectedOption) throws IndexOutOfBoundsException {
        switch (selectedOption) {
            case 1 -> {
                new RecipeMenu();
                backToUserMenu(user);
            }
            case 2 -> System.out.println("Generate");
            case 3 -> System.out.println("list of weeks");
            case 4 -> System.out.println("view recipe");
            case 5 -> {
                System.out.println("log out");
                new MainMenu();
            }
            default -> throw new IndexOutOfBoundsException();
        }
    }

    public void backToUserMenu(User user){
        waitForEnter();
        new UserMenu(user);
    }

    private static void waitForEnter() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println();
        System.out.println("Press enter to continue...");

        keyboard.nextLine();
    }
}
