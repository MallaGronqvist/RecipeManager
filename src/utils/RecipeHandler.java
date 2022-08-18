package utils;

import java.util.Scanner;

public class RecipeHandler {

    public static void enterRecipe(Recipe recipe){
        addTitle(recipe);
        PrintHandler.printRecipe(recipe);
        addSteps(recipe);
        PrintHandler.printRecipe(recipe);
    }

    public static void addTitle(Recipe recipe){
        System.out.println("Enter recipe title and press enter:");
        String title = readInUserInput();

        if(startsWithSpace(title)){
            addTitle(recipe);
        }

        recipe.setTitle(title);
    }

    public static void addSteps(Recipe recipe){
        boolean again = true;

        while(again){
            System.out.println("Enter a step and press enter or enter 'q' for no more steps:");

            String step = readInUserInput();

            if(step.equalsIgnoreCase("q")){
                again = false;
                return;
            }

            if(startsWithSpace(step)){
                addSteps(recipe);
            }

            recipe.addStep(step);
            PrintHandler.printRecipe(recipe);
        }


    }

    public Recipe addIngredients(Recipe recipe){
        return recipe;
    }

    private static boolean startsWithSpace(String input){
        if (input.startsWith(" ")){
            System.out.println("Your input starts with a space. This is not allowed. Try again.");
            return true;
        }
        return false;
    }

    private static String readInUserInput(){
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        return input;
    }

}
