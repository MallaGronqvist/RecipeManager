package utils;

import java.io.IOException;
import java.util.List;

public class PrintHandler {
    public static void appTitle() {
        System.out.println("Recipe Manager");
    }

    public static void clearScreen() {
        String operatingSystem = System.getProperty("os.name");

        if (operatingSystem.equals("Windows")) {
            clearScreenWindows();
        }
        else {
            clearScreenUnix();
        }
    }

    public static void optionBackToMainMenu() {
        System.out.println("[0] Back to main menu");
    }

    public static void optionList(List<?> options) {
        for (int index = 0; index < options.size(); index++) {
            int number = index + 1;
       //     String label = options.get(index);

            System.out.println("[" + number + "] " + options.get(index));
        }
    }

    private static void clearScreenUnix() {
        String clearScreenASCIICode = "\033[H\033[2J";

        System.out.print(clearScreenASCIICode);
        System.out.flush();
    }

    private static void clearScreenWindows() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException error) {
            System.out.println("A minor problem happened with the app. It will work but may not display correctly");
        }
    }

    public static void printRecipe(Recipe recipe){
        System.out.println("Title: " + recipe.getTitle());
        System.out.println("Ingredients: \n");
        PrintHandler.optionList(recipe.getIngredients());
        System.out.println("Steps: \n");
        PrintHandler.optionList(recipe.getSteps());
    }
}
