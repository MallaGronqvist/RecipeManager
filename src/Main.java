import mainMenu.MainMenu;
import recipe.RecipePool;


public class Main {

    public static void main(String[] args) {
        RecipePool.loadFromFile();
        new MainMenu();
    }
}
