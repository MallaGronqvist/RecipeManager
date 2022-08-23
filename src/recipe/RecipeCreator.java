// Move some of the helper methods to another class.

package recipe;

import printers.MenuPrinter;
import printers.RecipePrinter;

import java.util.List;
import java.util.Scanner;

public class RecipeCreator {

    public static Recipe enterRecipe() {
        Recipe recipe = new Recipe();
        addTitle(recipe);
        RecipePrinter.printRecipe(recipe);
        addIngredients(recipe);
        RecipePrinter.printRecipe(recipe);
        addSteps(recipe);
        return recipe;
    }

    public static void addTitle(Recipe recipe) {
        recipe.setTitle(requestTextInput("Enter recipe title and press enter:"));
    }

    public static void addSteps(Recipe recipe) {
        String step = requestTextInput("Enter a step and press enter:");

        recipe.addStep(step);

        RecipePrinter.printRecipe(recipe);

        if (moreInput()) {
            addSteps(recipe);
        }
    }

    public static void addIngredients(Recipe recipe) {
        String ingredient = requestTextInput("Enter an ingredient and press enter: ");

        String measurement = requestMeasurementType();

        double quantity = requestQuantity();

        ingredient = quantity + " " + measurement + " " + ingredient;

        recipe.addIngredient(ingredient);

        RecipePrinter.printRecipe(recipe);

        if (moreInput()) { addIngredients(recipe);}
    }

    private static String requestMeasurementType() {
        List<String> measurements = List.of("Quantity (pc)", "Liters (l)", "Kilograms (kg)");
        MenuPrinter.optionList(measurements);

        String chosenMeasurement = "";

        try {
            int input = Integer.parseInt(requestTextInput("Choose a measurement: "));

            switch (input) {
                case 1: chosenMeasurement = "pc";
                    break;
                case 2: chosenMeasurement = "l";
                    break;
                case 3: chosenMeasurement = "kg";
                    break;
                default:
                    throw new IndexOutOfBoundsException();
            }
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid option. Try again.");
            requestMeasurementType();
        }

        return chosenMeasurement;
    }

    private static double requestQuantity() {
        double quantity = 0;

        try {
            quantity = Double.parseDouble(requestTextInput("Enter quantity: "));

            if (quantity <= 0) { throw new NumberFormatException();}

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Try again.");

            requestQuantity();
        }

        return quantity;
    }

    private static boolean startsWithSpace(String input) {
        if (input.startsWith(" ")) {
            System.out.println("Your input starts with a space. This is not allowed. Try again.");
            return true;
        }

        return false;
    }

    private static String requestTextInput(String request) {
        System.out.println(request);

        String input = readUserInput();

        if (startsWithSpace(input)) {
            requestTextInput(request);
        }

        return input;
    }

    private static String readUserInput() {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();

        return input;
    }

    private static boolean moreInput() {
        String answer = requestTextInput("Add more? Type 'Y' for yes or 'N' for no.");

        if (answer.equalsIgnoreCase("y")) {
            return true;
        } else if (answer.equalsIgnoreCase("n")) {
            return false;
        } else {
            System.out.println("Invalid input. Try again");

            return moreInput();
        }
    }
}
