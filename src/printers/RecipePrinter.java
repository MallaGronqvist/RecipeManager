package printers;

import recipe.Recipe;

import java.util.Scanner;

public class RecipePrinter {
    public static void printRecipe(Recipe recipe){
        PrintHandler.clearConsole();
        System.out.println("Title: " + recipe.getTitle());
        System.out.println();
        System.out.println("Ingredients: \n");
        PrintHandler.optionList(recipe.getIngredients());
        System.out.println();
        System.out.println("Steps: \n");
        PrintHandler.optionList(recipe.getSteps());

        waitForEnter();
    }

    public static void waitForEnter() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println();
        System.out.println("Press enter to continue...");

        keyboard.nextLine();
    }
}
