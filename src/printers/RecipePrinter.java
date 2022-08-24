package printers;

import recipe.Recipe;

import java.util.Scanner;

public class RecipePrinter {
    public static void printRecipe(Recipe recipe) {
        MenuPrinter.clearConsole();

        System.out.println("Title: " + recipe.getTitle());
        System.out.println();
        System.out.println("Ingredients: \n");

        MenuPrinter.listOptions(recipe.getIngredients());

        System.out.println();
        System.out.println("Steps: \n");

        MenuPrinter.listOptions(recipe.getSteps());

        System.out.println();
        System.out.println("************************* Enjoy your meal ******************************");
        System.out.println();
    }

    public static void waitForEnter() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println();
        System.out.println("Press enter to continue...");

        keyboard.nextLine();
    }
}
