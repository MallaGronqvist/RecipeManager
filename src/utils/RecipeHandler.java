package utils;

import java.util.List;
import java.util.Scanner;

public class RecipeHandler {

    public static void enterRecipe(Recipe recipe){
        addTitle(recipe);
        PrintHandler.printRecipe(recipe);
        addIngredients(recipe);
        PrintHandler.printRecipe(recipe);
        addSteps(recipe);
    }

    public static void addTitle(Recipe recipe){
        String title = requestTextInput("Enter recipe title and press enter:");

        recipe.setTitle(title);
    }

    public static void addSteps(Recipe recipe){
            String step = requestTextInput("Enter a step and press enter or enter 'q' for no more steps:");

            if(step.equalsIgnoreCase("q")){
                return;
            }

            recipe.addStep(step);

            PrintHandler.printRecipe(recipe);

            addSteps(recipe);
    }

    public static void addIngredients(Recipe recipe){
        String ingredient = requestTextInput("Enter an ingredient and press enter or enter q for no more ingredients:");

        if(ingredient.equalsIgnoreCase("q")){
            return;
        }

        String measurement = "";
        int quantity = 0;

        try {
            measurement = requestMeasurementType();
            quantity = requestQuantity();
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Invalid option. Try again.");
            addIngredients(recipe);
        }

        ingredient = quantity + " " + measurement + " " + ingredient;
        recipe.addIngredient(ingredient);

        PrintHandler.printRecipe(recipe);

        addIngredients(recipe);
    }

    private static String requestMeasurementType() throws IndexOutOfBoundsException, NumberFormatException{
        System.out.println("Measurements:");
        List<String> measurements = List.of("Quantity (pc)", "Liters (l)", "Kilograms (kg)");
        PrintHandler.optionList(measurements);
        int input = Integer.parseInt(requestTextInput("Choose a measurement: "));

        String chosenMeasurement = "";

        switch (input){
            case 1 : chosenMeasurement = "pc";
            break;
            case 2 : chosenMeasurement = "l";
            break;
            case 3 : chosenMeasurement = "kg";
            break;
            default: throw new IndexOutOfBoundsException();
        }

        return  chosenMeasurement;
    }

    private static int requestQuantity() throws NumberFormatException{
        int quantity = Integer.parseInt(requestTextInput("Enter quantity: "));
        if(quantity <= 0 ){
            System.out.println("Invalid quantity. Try again.");
            requestQuantity();
        }
        return quantity;
    }

    private static boolean startsWithSpace(String input){
        if (input.startsWith(" ")){
            System.out.println("Your input starts with a space. This is not allowed. Try again.");
            return true;
        }
        return false;
    }

    private static String requestTextInput(String request){
        System.out.println(request);
        String input = readInUserInput();
        if(startsWithSpace(input)){
            requestTextInput(request);
        }
        return input;
    }

    private static String readInUserInput(){
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        return input;
    }

}
