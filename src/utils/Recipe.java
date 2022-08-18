package utils;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    public Recipe() {
        this.title = "No Name";
        this.ingredients = new ArrayList<>();
        this.steps = new ArrayList<>();
        this.id = 0;
    }

    private String title;
    List<String>ingredients;
    List<String> steps;
    int id;


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
}
