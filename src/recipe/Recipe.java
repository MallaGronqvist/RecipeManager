package recipe;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    List<String> ingredients;
    List<String> steps;
    int id;
    private String title;
    private int weight;

    public Recipe() {
        this.title = "No Name";
        this.ingredients = new ArrayList<>();
        this.steps = new ArrayList<>();
        this.id = 0;
        this.weight = 1;
    }

    public Recipe(String[] recipeDetails) {
        this.id = Integer.parseInt(recipeDetails[0]);
        this.title = recipeDetails[1];
        String ingredients = recipeDetails[2];
        String[] parsedIngredients = ingredients.split(";");
        setIngredients(List.of(parsedIngredients));
        String steps = recipeDetails[3];
        String[] parsedSteps = steps.split(";");
        setSteps(List.of(parsedSteps));
        this.weight = Integer.parseInt(recipeDetails[4]);
    }

    @Override
    public String toString() {
        return title;
    }

    public String ingredientsToString() {
        String ingredientsString = "";

        for (String ingredient : ingredients) {
            ingredientsString = ingredientsString + (new StringBuilder()).append(ingredient).append(";");
        }
        ingredientsString = ingredientsString.substring(0, ingredientsString.length() - 1);
        return ingredientsString;
    }

    public String stepsToString() {
        String stepsString = "";

        for (String step : steps) {
            stepsString = stepsString + (new StringBuilder()).append(step).append(";");
        }
        stepsString = stepsString.substring(0, stepsString.length() - 1);
        return stepsString;
    }

    public String printable() {
        final String delimiter = ":";
        return id + delimiter + title + delimiter +
                ingredientsToString() + delimiter +
                stepsToString() + delimiter + weight + "\n";
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public void addStep(String step) {
        steps.add(step);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addIngredient(String ingredient) {
        ingredients.add(ingredient);
    }

    public int getWeight() {
        return weight;
    }
     public void setWeight(int weight){
        this.weight = weight;
     }

    public void addWeight() {
        this.weight += 1;
    }
}
