import mainMenu.MainMenu;
import utils.RecipePool;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RecipePool.loadFromFile();
        MainMenu mainMenu = new MainMenu();
    }
}
