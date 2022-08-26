package recipe;

import printers.MenuPrinter;

import java.util.List;

public class RecipeCreator {

    public static Recipe enterRecipe() {
        Recipe recipe = new Recipe();
        addTitle(recipe);
        MenuPrinter.clearConsole();
        addIngredients(recipe);
        MenuPrinter.clearConsole();
        addSteps(recipe);
        return recipe;
    }

    public static void addTitle(Recipe recipe) {
        recipe.setTitle(InputHelper.requestTextInput("Enter recipe title and press enter:"));
    }

    public static void addSteps(Recipe recipe) {
        String step = InputHelper.requestTextInput("Enter a step and press enter:");

        recipe.addStep(step);

        MenuPrinter.clearConsole();

        MenuPrinter.listOptions(recipe.getSteps());

        if (InputHelper.moreInput()) {
            addSteps(recipe);
        }
    }

    public static void addIngredients(Recipe recipe) {
        String ingredient = InputHelper.requestTextInput("Enter an ingredient and press enter: ");

        String measurement = requestMeasurementType();

        double quantity = requestQuantity();

        ingredient = quantity + " " + measurement + " " + ingredient;

        recipe.addIngredient(ingredient);

        MenuPrinter.clearConsole();

        MenuPrinter.listOptions(recipe.getIngredients());

        if (InputHelper.moreInput()) {
            addIngredients(recipe);
        }
    }

    private static String requestMeasurementType() {
        List<String> measurements = List.of("Quantity (pc)", "Liters (l)", "Kilograms (kg)");

        MenuPrinter.listOptions(measurements);

        String chosenMeasurement;

        try {
            int input = Integer.parseInt(InputHelper.requestTextInput("Choose a measurement: "));

            chosenMeasurement = switch (input) {
                case 1 -> "pc";
                case 2 -> "l";
                case 3 -> "kg";
                default -> throw new IndexOutOfBoundsException();
            };
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid option. Try again.");
            return requestMeasurementType();
        }
        return chosenMeasurement;
    }

    private static double requestQuantity() {
        double quantity;

        try {
            String input = InputHelper.requestTextInput("Enter quantity: ");

            quantity = Double.parseDouble(input);

            if (quantity <= 0) {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Try again.");

            return requestQuantity();
        }
        return quantity;
    }
}
