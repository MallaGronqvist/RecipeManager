package fileHandlers;

import recipe.Recipe;
import recipe.RecipePool;

import java.io.*;
import java.util.*;

public class RecipePoolFileHandler {

    public static List<Recipe> readFile(){
        List<Recipe> recipes = new ArrayList<>();

        try (FileReader fileReader = new FileReader("assets/recipes.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] parsedData = line.split(":");

                Recipe recipe = new Recipe(parsedData);

                recipes.add(recipe);
            }
        } catch (IOException e) {
            System.out.println("Recipes could not be loaded from file.");

            System.exit(0);
        }

        return recipes;
    }

    public static void saveToFile(RecipePool recipePool){
        Iterator<Recipe>iterator = recipePool.getIterator();

        try (Writer output = new BufferedWriter(new FileWriter("assets/recipes.txt"))){

            while(iterator.hasNext()) {
                Recipe recipe = iterator.next();

                output.write(recipe.printable());
            }

        } catch (IOException e) {
            System.out.println("Couldn't save recipes to file.");
        }
    }
}
