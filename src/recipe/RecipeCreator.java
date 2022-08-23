// Move some of the helper methods to another class.

package recipe;

import printers.MenuPrinter;
import java.util.List;
import java.util.Scanner;

public class RecipeCreator {

    public static Recipe enterRecipe() {
        Recipe recipe = new Recipe();
        addTitle(recipe);
        addIngredients(recipe);
        addSteps(recipe);
        return recipe;
    }

    public static void addTitle(Recipe recipe) {
        recipe.setTitle(requestTextInput("Enter recipe title and press enter:"));
    }

    public static void addSteps(Recipe recipe) {
        String step = requestTextInput("Enter a step and press enter:");

        recipe.addStep(step);

        MenuPrinter.optionList(recipe.getSteps());

        if (moreInput()) { addSteps(recipe);}
    }

    public static void addIngredients(Recipe recipe) {
        String ingredient = requestTextInput("Enter an ingredient and press enter: ");

        String measurement = requestMeasurementType();

        double quantity = requestQuantity();

        ingredient = quantity + " " + measurement + " " + ingredient;

        recipe.addIngredient(ingredient);

        MenuPrinter.optionList(recipe.getIngredients());

        if (moreInput()) { addIngredients(recipe);}
    }

    private static String requestMeasurementType() {
        List<String> measurements = List.of("Quantity (pc)", "Liters (l)", "Kilograms (kg)");
        MenuPrinter.optionList(measurements);

        String chosenMeasurement = "";

        try {
            int input = Integer.parseInt(requestTextInput("Choose a measurement: "));

            chosenMeasurement = switch (input) {
                case 1 -> "pc";
                case 2 -> "l";
                case 3 -> "kg";
                default -> throw new IndexOutOfBoundsException();
            };
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid option. Try again.");
            requestMeasurementType();
        }

        return chosenMeasurement;
    }

    private static double requestQuantity() {
        double quantity;

        try {
            String input = requestTextInput("Enter quantity: ");

            quantity = Double.parseDouble(input);

            if (quantity <= 0) { throw new NumberFormatException();}

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Try again.");

            quantity = requestQuantity();
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
            input = requestTextInput(request);
        }

        return input;
    }

    private static String readUserInput() {
        Scanner keyboard = new Scanner(System.in);

        return keyboard.nextLine();
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
