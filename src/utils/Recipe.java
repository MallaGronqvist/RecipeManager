package utils;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String title;
    List<String>ingredients;
    List<String> steps;
    int id;

    public Recipe() {
        this.title = "No Name";
        this.ingredients = new ArrayList<>();
        this.steps = new ArrayList<>();
        this.id = 0;
    }

    @Override
    public String toString() {
        return title;
    }

    public  String ingredientsToString(){
        String ingredientsString ="";
        int index = 1;

        for (String ingredient: ingredients) {
            ingredientsString = ingredientsString + (new StringBuilder()).append(index).append(". ").append(ingredient).append("\n").toString();
            index++;
        }
        return ingredientsString;
    }

    public String stepsToString() {
        String stepsString = "";
        int index = 1;

        for (String step : steps) {
            stepsString = stepsString + (new StringBuilder()).append(index).append(". ").append(step).append("\n").toString();
            index++;
        }
        return stepsString;
    }

    public String printable(){
        return "Recipe title:\n" + title + "\n\n" +
                "Ingredients:\n" + ingredientsToString() +
                "Steps:\n " + stepsToString() + "\n";
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

    public void addStep(String step){
        steps.add(step);
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
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
}
