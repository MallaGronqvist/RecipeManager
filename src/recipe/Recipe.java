package recipe;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private List<String> ingredients;
    private List<String> steps;
    private String title;
    private int weight;

    public Recipe() {
        this.title = "No Name";
        this.ingredients = new ArrayList<>();
        this.steps = new ArrayList<>();
        this.weight = 0;
    }

    public Recipe(String[] recipeDetails) {
        this.title = recipeDetails[0];
        String ingredients = recipeDetails[1];
        String[] parsedIngredients = ingredients.split(";");
        setIngredients(new ArrayList<>(List.of(parsedIngredients)));
        String steps = recipeDetails[2];
        String[] parsedSteps = steps.split(";");
        setSteps(new ArrayList<>(List.of(parsedSteps)));
        this.weight = Integer.parseInt(recipeDetails[3]);
    }

    @Override
    public String toString() {
        return title;
    }

    public String ingredientsToString() {
        StringBuilder ingredientsString = new StringBuilder();

        for (String ingredient : ingredients) {
            ingredientsString.append(ingredient).append(";");
        }
        ingredientsString = new StringBuilder(ingredientsString.substring(0, ingredientsString.length() - 1));
        return ingredientsString.toString();
    }

    public String stepsToString() {
        StringBuilder stepsString = new StringBuilder();

        for (String step : steps) {
            stepsString.append(step).append(";");
        }
        stepsString = new StringBuilder(stepsString.substring(0, stepsString.length() - 1));
        return stepsString.toString();
    }

    public String printable() {
        final String delimiter = ":";
        return title + delimiter + ingredientsToString() + delimiter +
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

    public void addWeight() {
        this.weight += 1;
    }
}
